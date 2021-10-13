# Brico Tuto

le site adriansameron est un site vitrine professionnel et personnel permettant d aider à la rénovation

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

