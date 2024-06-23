# Utiliser une image de base pour Node.js pour le frontend
FROM node:14 AS frontend

# Définir le répertoire de travail pour le frontend
WORKDIR /app/front

# Copier le package.json et installer les dépendances du frontend
COPY front/package*.json ./
RUN npm install

# Copier le reste du code du frontend et le construire
COPY front/ ./
RUN npm run build

# Utiliser une image de base pour Maven pour construire le backend
FROM maven:3.8.1-openjdk-11-slim AS build

# Définir le répertoire de travail pour le build
WORKDIR /app

# Copier le code source du backend
COPY Studi2024-Back-v7/ .

# Construire le backend sans exécuter les tests
RUN mvn clean install -DskipTests

# Utiliser une image de base pour Java pour le backend
FROM eclipse-temurin:17-jre-focal AS backend

# Définir le répertoire de travail pour le backend
WORKDIR /app

# Copier le fichier JAR du backend depuis l'image de build vers l'image finale
COPY --from=build /app/target/studi-exam-2024-back-end-SpringBoot-0.0.1-SNAPSHOT.jar /app/app.jar

# Copier le frontend build dans le backend resources
COPY --from=frontend /app/front/build /app/public

# Exposer le port que votre backend utilise
EXPOSE 8080

# Démarrer l'application backend avec le profil 'docker'
CMD ["java", "-jar", "/app/app.jar", "--spring.profiles.active=docker"]