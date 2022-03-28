# TheMusicApp V0.1
Code challenge to exercise and consolidate knowledge

## Getting Started

### Prerequisites

You need:
```
* Java 1.8 (jdk)
* Lombok Plugin
```

### Installing

Clone the repo and build

## Running the application locally

Run ```docker-compose up``` to deploy the database

Then run the application

### Bulk the data

Using ```POSTMAN``` you can open and hit the endpoints to populate the database:
Please be sure to manually select the proper file for each endpoint (```...src/main/resoruces/input```)


```http://localhost:8082/data/load/users```

```http://localhost:8082/data/load/artist```

```http://localhost:8082/data/load/songs```

### Like a song 

To like a song use the next endpoint:

```http://localhost:8082/like/song/{songId}/{userId}```

A quick tip, go to ```http://localhost:8080/``` to use a GUI for getting this data easily
- System: ```MySQL```
- Sever: ```db```
- username: ```root```
- Password: ```sa```
- Database: ```the_music_app``` 

### Get Top Songs

```http://localhost:8082/song/get/top/five```

```http://localhost:8082/song/get/top/ten```

```http://localhost:8082/song/get/top/fifteen```

### Get Top Artist

```http://localhost:8082/artist/get/top/three```

```http://localhost:8082/artist/get/top/five```

### Get Top Users with most liked songs

```http://localhost:8082/user/get/top/three```

Enjoy!