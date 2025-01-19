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

# Lancer le tunnel pour attribuer une adresse IP publique au service qui est de type Load Balancer
minikube tunnel
# Ensuite on prend l'external-ip :
kubectl get services
NAME              TYPE           CLUSTER-IP      EXTERNAL-IP   PORT(S)          AGE
backend-service   LoadBalancer   10.98.106.198   127.0.0.1     8082:31694/TCP   2m47s