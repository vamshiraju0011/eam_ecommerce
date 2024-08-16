
#### 5. **`image-service.md`**
This file will detail the Image Service.

```markdown
# Image Service

## Overview
The Image Service retrieves product images based on image IDs.

## Setup
- **Database**: MySQL (`image_db`)
- **Port**: 8084

## Docker Setup
The Dockerfile for the Image Service is located in `docker/image-service/Dockerfile`.

### Dockerfile Example
```dockerfile
FROM openjdk:11-jdk-slim
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
