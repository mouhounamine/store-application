exit

# Tagger l'image Docker
docker tag backend:latest aminedatabases/backend:latest

# Push l'image Docker dans le Dockerhub
docker push aminedatabases/backend:latest

------------------------

# Lancer minikube
minikube start

# Appliquer les configurations kube (se positionner dans kubernetes-config/backend)
kubectl apply -f .

# Supprimer toutes les configurations crées
kubectl delete all --all

# Afficher l'adresse IP du service
minikube ip