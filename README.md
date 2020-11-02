#Методология разработки ПО

##Лабораторная работа №1: создание микросервиса на Spring Boot с базой данных

#####Сафонов Егор Игоревич, Группа 3mac2001

####Цель лабороторной работы
 
 Знакомство с проектированием многослойной архитектурой и  создание 
 простого Rest Api приложения, используя технологии Java и Spring boot.
 
 Для сборки потребуется 
 * Запущенная и развернутая база данных
 * Среда разработки(IDE)
 * Установленный GIT
 * Установленный docker
 
 #####Инструкция по сборке и запуску:
 
 1.Склонировать репозиторий, используя команду `git clone https://github.com/GenKG/simpleapi` или скопировав ссылку с github. 
 
 2.Использовать комманду `mvn package -Dmaven.test.skip=true` (без покрытия тестов) в корневой директории для сборки проекта.
 
 3.Собрать docker образ, используя команду `docker build . -t myfirstapi:1.0` из текущей директории проекта
     
 **где**
  * **.** - (точка) являтся текущей директорией проекта 
  * myfirstapi - название образа (можно указать любое)
  * 1.0 - версия проекта(можно указать любую)
  
 4.Для запуска контейнера использовать `docker run myfirstapi:1.0`
 
 
 #####Команады к проекту
 Приложение является простейшим отражением базы настольных игр с использованием JSON.
 Формат JSON `{name:"String",publisher:"String, price:integer,quantity: "integer"}`
 
 `curl -X GET <http://localhost:8080/api/v1/boardGames>` - получение всех данных из базы
 
 `curl -X GET <http://localhost:8080/api/v1/boardGames/{id}>` - получение информации из базы по id 
 
 `curl -X POST <http://127.0.0.1:8080/api/v1/> -d ‘{«name»: «Мафия″, "publisher": "Мосигра", "price": 7000, "quantity": 3}’ -H «Content-Type:application/json»` - добавление новой записи в базу
 
 `curl -X POST <http://localhost:8080/api/v1/boardGames/{id}>`-удаление по id
 
 `curl -X GET <http://localhost:8080/api/v1/status>` - возвращает hostname
 