CREATE USER 'appathon'@'localhost' IDENTIFIED BY 'appathon';

GRANT SELECT ON Appathon.* TO 'appathon'@'localhost';

FLUSH PRIVILEGES;