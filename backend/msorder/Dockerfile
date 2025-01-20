FROM openjdk:17-slim

# Copie du fichier jar dans le conteneur
COPY target/msorder-0.0.1-SNAPSHOT.jar /app/msorder-0.0.1-SNAPSHOT.jar

# Exposer le port sur lequel l'application écoute
EXPOSE 8082

# Commande pour démarrer l'application
CMD ["java", "-jar", "/app/msorder-0.0.1-SNAPSHOT.jar"]
