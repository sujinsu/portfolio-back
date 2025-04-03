package com.portfolio.backend.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("포트폴리오 API 문서")
                        .version("1.0")
                        .description("메뉴 관리 등 API를 확인할 수 있는 문서입니다."));
    }
}
