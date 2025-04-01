# 1. 빌드용 이미지
FROM eclipse-temurin:17-jdk as builder

WORKDIR /app
COPY . .

# 의존성 캐시
RUN ./gradlew build --no-daemon

# 2. 실행용 이미지
FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]