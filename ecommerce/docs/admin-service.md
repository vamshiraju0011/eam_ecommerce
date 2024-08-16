
#### 4. **`admin-service.md`**
This file will detail the Admin Service.

```markdown
# Admin Service

## Overview
The Admin Service allows administrators to manage products and view orders.

## Setup
- **Database**: MySQL (`admin_db`)
- **Port**: 8083

## Docker Setup
The Dockerfile for the Admin Service is located in `docker/admin-service/Dockerfile`.

### Dockerfile Example
```dockerfile
FROM openjdk:11-jdk-slim
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
