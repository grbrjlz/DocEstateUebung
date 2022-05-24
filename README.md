# DocEstateUebung
Spring Rest API mit UI

####
INFO

immobilienService -> Spring Boot Application 
ui -> Vue Application

- das Vue Frontend liegt bereits gebuildet in den ressourcen der Spring Boot Application, also reicht zum starten der Anwendung der immobilienService
- fuer die Persistenz habe ich eine MYSQL-Datenbank verwendet -> immobilienService
- MYSQL local starten
- die SQL Befehle zum verwenden der Datenbank:

mysql>
CREATE DATABASE immobilienService;
USE immobilienService;
CREATE USER 'hello'@'localhost' IDENTIFIED BY 'julez';
FLUSH PRIVILEGES;
"GRANT ALL PRIVILEGES ON `immobilienService` . * TO 'hello'@'localhost';   ==== backticks immobilienService
FLUSH PRIVILEGES;
exit

####

####
Anwendung starten

cd DocEstateUebung
cd immobilienService
./gradlew bootrun

####
