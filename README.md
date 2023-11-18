# Adrian SALMERON FELIZ V0 Fulstackk


## Environnement de développement

## Pré-requis
* Java 
* Docker
* Docker-compose

## Initier l'environnement de développement

 1) Initier le projet 
```bash
mvn clean install -DskipTests
```
 2) Deployer environnement
```bash
deploy.sh
```
 3) Initier les données de la base de BricoTuto

* Ouvrir phpMyAdmin( http://localhost:8080/ ) en root/root
* Se connecter à la base bricotuto et lancer le script InitBdBricoTuto.sql

````Si probleme de dependance librairie :
mvn dependency:purge-local-repository clean install -U
````

## Environnement VPS

## préparation serveur
apt-get update
apt upgrade

* Java
sudo apt install default-jre
apt-get install default-jdk
java -version

* Docker
sudo apt-get install  curl apt-transport-https ca-certificates software-properties-common
 --ajout clé GPG
 curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
 -- ajout depots
 sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
 -- update et install
 sudo apt update
 sudo apt install docker-ce
 sudo systemctl status docker

* Docker-compose
  sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
  sudo chmod +x /usr/local/bin/docker-compose
  docker-compose --version

* nginx
  apt-get install nginx
  sudo ufw allow 'Nginx Full'
  systemctl status nginx


## préparation bdd et configuration lancement application
-->Creation de l'user  admin
adduser adrian-website
usermod -a -G sudo adrian-website

1) Initier Docker bdd
 docker-compose build
 docker-compose up -d
 docker ps

2) Crée la base 
aller sur le PhpAdmin dockerisé et lancer le script ./Vps/InitBddAdriansalmeron.sql (adressevps:8080)

3) Créé et lancer le service App
  -->  Copié le fichier ./vps/adriansalmeron-webapp.service dans /etc/systemd/system/ 
  systemctl start adriansalmeron-webapp

4) Configurer nginx
   -->  Copié le fichier ./vps/adriansalmeron-webapp dans  /etc/nginx/sites-available/
   sudo ln -s /etc/nginx/sites-available/adriansalmeron-webapp /etc/nginx/sites-enabled/
  --> commande pour tester config sudo nginx -t
   systemctl restart nginx

5) SSL/HTTPS
   apt-get update
   apt-get install software-properties-common
   apt-get install certbot
   apt-get update
   apt-get install python-certbot-nginx
   certbot --nginx





