[![build-deploy-app](https://github.com/GenKG/simpleapi/actions/workflows/build-deplout-app.yml/badge.svg)](https://github.com/GenKG/simpleapi/actions/workflows/build-deplout-app.yml)
<h1>Simple CRUD Api</h1>

<h4>Simple CRUD(create,read,update,delete) API with board games domain area</h4>

Tech-stack:  
- Java v.11
- Maven
- Postgres for database
- Spring boot v.2.3
- Spring data
- Docker
- Github-actions(CI process)
- AWS EC-2 for deploy(CD process)

---
<h4>Instruction for build and run app:</h4>

1. Clone the repository `git clone https://github.com/GenKG/simpleapi`

2. Use command `mvn package -Dmaven.test.skip=true` (without tests) in root project directory for building.

3. Build docker images, uses the command `docker build . -t board-games:1.0` from current project directory

**where**

* **.** - (dot) your current project directory
* board-games - images name (you can specify any)
* 1.0 - project version(you can specify any)

4.For run container: `docker run -p 8080:8080 board-games:1.0`  

---
<h4>Api commands</h4>
Is the simplest CRUD api for managing your board games with uses JSON format.

JSON example:

```JSON
{
"name":"Arkham Horror",
"publisher":"Fantasy Flight Games",
"price":300,
"quantity":2
}
```
Get all board games  
```
curl -X GET http://localhost:8080/api/v1/boardGames
``` 
Get board game by id
```
curl -X GET http://localhost:8080/api/v1/boardGames/{id}
``` 
Create new record in database about board game

```
curl -X POST http://127.0.0.1:8080/api/v1/ -d {«name»: "Mafia", "publisher": "Mosigra", "price": 7000, "quantity": 3} -H «Content-Type:application/json»
```
Delete board game by id

```
curl -X POST http://localhost:8080/api/v1/boardGames/{id}
```  

Check status api
```
curl -X GET http://localhost:8080/api/v1/status
```  

Api uses full CI/CD conveyor with ``Github actions``  and  ``AWS EC-2``.  
App build and push repo on ``Dockerhub`` after app is deployed on AWS instance in docker container and connect to AWS
Erc Postgres database.  

---
You can see the example app with this link on swagger:  
[Swagger link.](http://ec2-16-171-110-253.eu-north-1.compute.amazonaws.com/swagger-ui/index.html#/)

