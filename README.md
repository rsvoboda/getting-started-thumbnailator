# getting-started-thumbnailator project

This project uses Quarkus and Thumbnailator

 - https://github.com/quarkusio/quarkus
 - https://github.com/coobird/thumbnailator

Run in JVM / DEV mode:
```bash
mvn quarkus:dev
```

Run in native:
```bash
mvn clean package -Dnative -Dquarkus.native.container-build=true -Dquarkus.native.builder-image=quay.io/quarkus/ubi-quarkus-native-image:20.3.0-java11 && docker build -f src/main/docker/Dockerfile.native -t quarkus/getting-started-thumbnailator . && docker run -i --rm -p 8080:8080 quarkus/getting-started-thumbnailator
```

Endpoint invocation:
```
curl http://localhost:8080/hello
```