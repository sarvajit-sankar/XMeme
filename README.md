# XMeme
## Backend for a simple Meme posting platform in Java

- Type some Markdown on the left
- See HTML in the right
- ✨Magic ✨

## Features
1. OOPs concepts implemented using Springboot
2. Spring Data JPA for MongoDB implementation
3. MVCS code structure

## Installation

Install the dependencies like Docker

```sh
<Steps to install docker>
```

## APIs

| API | HTTP Method | Response |
| ------ | ------ | ------ |
| /memes | GET |Returns list of 100 latest memes
| /memes/{id} | GET |Returns meme containing the unique ID or 404 if not found
| /memes | GET |Posts the meme with the passed payload or 409 for duplicate meme

### Build (To be updated)


### Steps to run the code
```sh
docker run <command to be updated>
```
### Steps to utilize the API
```sh
curl -i --location "localhost:8081/memes/{id}"
```

### Next Steps
1. Add API documentation for APIs using Swagger
2. Creating working Dockerfile
