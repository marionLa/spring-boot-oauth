# Mini-projet : authentification oAuth2 avec Spring Boot

Projet en cours pour appréhender l'authentification multi-sources 
avec Spring Boot. 
D'après [ce tuto Spring Boot](https://spring.io/guides/tutorials/spring-boot-oauth2). J'ai dû prendre aussi d'autres ressources (stackoverflow, Baeldung) parce que le tuto n'est pas actualisé pour Spring Security 6 et beaucoup d'outils sont dépréciés. 

## Objectifs : 
- comprendre et mettre en place l'authentification avec Github
- ajouter d'autres services tiers d'authentification
- ajouter un authentification par BDD locale
- tester l'authentification
- mettre en place des Github actions avec un scan Sonar
- 
## Ce qui est en place : 
- ✅ une première méthode de login/logout avec Github 
- ✅ l'affichage du lien pour se logguer ou se déconnecter selon le statut et le nom de l'utilisateur connecté s'il y en a un
- ✅ quelques tests d'intégration avec un profil Spring @Test
- ✅ le lien avec un [un projet Sonar Cloud](https://sonarcloud.io/project/overview?id=marionLa_spring-boot-oauth) et un rapport de coverage Jacoco

## Récupérer ce projet : 
- clôner le dépot
- renommer changeme.application.properties en application.properties
- renseigner le client-id et client-password Github dans application.properties
- lancer le projet avec Docker
