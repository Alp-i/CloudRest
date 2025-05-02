# Resmi OpenJDK 17 görüntüsünü kullan
FROM openjdk:17-jdk-slim

# Çalışma dizini oluştur
WORKDIR /app

# Bağımlılıkları ve uygulama JAR dosyasını kopyala
COPY build/libs/CloudRest-0.0.1-SNAPSHOT.jar CloudRest.jar

# Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "CloudRest.jar"]
