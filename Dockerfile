# Build Frontend
FROM node:14 AS frontend-build
WORKDIR /app/front
COPY front/package*.json ./
RUN npm install
COPY front/ ./
RUN npm run build

# Build Backend
FROM eclipse-temurin:17-jre-focal AS backend-build
WORKDIR /app/back
COPY Studi2024-Back-v7/target/studi-exam-2024-back-end-SpringBoot-0.0.1-SNAPSHOT.jar ./app.jar
COPY --from=frontend-build /app/front/build ./public

# Run Backend
FROM eclipse-temurin:17-jre-focal
WORKDIR /app
COPY --from=backend-build /app/back/app.jar ./app.jar
COPY --from=backend-build /app/back/public ./public
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]