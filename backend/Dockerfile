# 1. Java 17 기반 이미지 사용 (필요에 따라 변경 가능)
FROM eclipse-temurin:17-jdk

# 2. 작업 디렉토리 설정
WORKDIR /app

# 3. JAR 파일 복사
COPY build/libs/portfolio-back-0.0.1-SNAPSHOT.jar app.jar

# 4. 앱이 사용할 포트 (application.yml에 설정된 포트)
EXPOSE 8080

# 5. 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]