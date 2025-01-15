FROM openjdk:17-slim

# Copie du fichier jar dans le conteneur
COPY target/store-0.0.1-SNAPSHOT.jar /app/store-0.0.1-SNAPSHOT.jar

# Exposer le port sur lequel l'application écoute
EXPOSE 8081

# Commande pour démarrer l'application
CMD ["java", "-jar", "/app/store-0.0.1-SNAPSHOT.jar"]
