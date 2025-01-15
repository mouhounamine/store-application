# Kubernetes Store Application

Ce projet est une application backend déployée sur Kubernetes utilisant **Spring Boot** pour exposer une API REST. L'application est conteneurisée à l'aide de Docker et déployée dans un cluster Kubernetes géré par **Minikube**.

## Structure du projet
1. **Backend Service (Kubernetes Service)** : Expose le backend sur le port `8082` via un service de type **NodePort**, redirigeant les requêtes vers le port interne `8081` du conteneur.
2. **Backend Deployment (Kubernetes Deployment)** : Déploie une instance de l'application backend dans un pod Kubernetes. Le conteneur utilise l'image Docker `aminedatabases/backend:latest`.
3. **Minikube** : Utilisé pour simuler un environnement Kubernetes local. Les ports sont exposés via **kubectl port-forward** ou par des services de type **NodePort** pour l'accès externe.
4. **Application Spring Boot** : L'application écoute sur le port `8081` à l'intérieur du conteneur et expose une simple API.

## Commandes utiles
1. **Créer le déploiement et le service :**
   ```bash
   kubectl apply -f backend-deployment.yaml
   kubectl apply -f backend-service.yaml
   ```
**Vérifier les services et les pods :**
```bash
    kubectl get services
    kubectl get pods
   ```
**Port Forwarding pour accéder à l'application :**
```bash
    kubectl port-forward service/backend-service 8082:8082
   ```

**Vérifier les logs du pod :**
```bash
       kubectl logs <pod-name> 
   ```

## Technologies utilisées
   Spring Boot pour l'application backend. 
   Docker pour la conteneurisation de l'application. 
   Kubernetes (Minikube) pour le déploiement et la gestion des ressources. 
   kubectl pour la gestion des ressources Kubernetes. 

## Remarques
    
Assurez-vous que Minikube et kubectl sont correctement installés avant de déployer l'application.
Le port exposé à l'extérieur est 8082 via le service NodePort, redirigeant vers le port 8081 à l'intérieur du conteneur.