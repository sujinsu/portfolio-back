# 1단계: 빌드 스테이지
FROM eclipse-temurin:17-jdk as builder

WORKDIR /app
COPY . .

# gradlew 실행 권한 부여
RUN chmod +x gradlew

# build 실행
RUN ./gradlew build --no-daemon

# 2단계: 실행 스테이지
FROM eclipse-temurin:17-jdk

WORKDIR /app

# 빌드 결과물 복사
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
