package com.portfolio.backend.common.exception;

import com.portfolio.backend.common.vo.ExceptionMessageVo;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import javax.security.auth.login.LoginException;

@Controller
@Slf4j
public class PortfolioException {

    /**
     * 관리되지 않은 예상치 않은 에러
     */
    @ExceptionHandler(Exception.class)
    public ExceptionMessageVo handleError(Exception e) {
        String code = e.getClass().getSimpleName();
        String message = e.getMessage();
        HttpStatus httpStatus = getResponseCode(e);
        if (httpStatus.is4xxClientError()) {
            log.debug("ClientException : {}", e.getMessage());

        } else if (httpStatus.is5xxServerError()) {
            log.error("ServerException : {}", e.getMessage());
        }
        return new ExceptionMessageVo(httpStatus.value(), code, message);
    }

    /**
     * 익셉션을 통해 httpStatusCode 를 취득한다.
     */
    private HttpStatus getResponseCode(Exception e) {
        int responseCode;
        // 400
        if (e instanceof BindException || e instanceof HttpMessageNotReadableException
                || e instanceof MissingServletRequestParameterException
                || e instanceof MissingServletRequestPartException || e instanceof TypeMismatchException
                || e instanceof IllegalArgumentException) {
            responseCode = HttpServletResponse.SC_BAD_REQUEST;
        }
        // 405
        else if (e instanceof HttpRequestMethodNotSupportedException || e instanceof LoginException) {
            responseCode = HttpServletResponse.SC_METHOD_NOT_ALLOWED;
        }
        // 406
        else if (e instanceof HttpMediaTypeNotAcceptableException) {
            responseCode = HttpServletResponse.SC_NOT_ACCEPTABLE;
        }
        // 415
        else if (e instanceof HttpMediaTypeNotSupportedException) {
            responseCode = HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE;
        }
        // 500
        else if (e instanceof HttpMessageNotWritableException) {
            responseCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
        }
        // 그외 모든 에러도 500
        else {
            responseCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(responseCode);
    }
}
