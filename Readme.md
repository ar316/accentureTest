# AccentureTest

Este repositorio contiene una prueba técnica de backend desarrollada en Java. A continuación, se proporciona la documentación para desplegar la aplicación tanto en un entorno local como utilizando Docker.

> **Nota:**  
> la aplicacion ya se encuentra desplegada y puedes acceder a ella a través del siguiente link:
###### se demora un poco en cargar, pero es normal, ya que la aplicación se encuentra en un servidor gratuito.

>  https://accenturetest.onrender.com/swagger-ui/index.html#




## Requisitos previos

Antes de comenzar, asegúrate de tener lo siguiente instalado:

- [Java Development Kit (JDK) 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) o superior.
- [Maven](https://maven.apache.org/) para la gestión de dependencias.
- [Docker](https://www.docker.com/) para la ejecución de contenedores.
- Git para clonar el repositorio.

## Pasos para desplegar la aplicación localmente

Sigue estos pasos para configurar y ejecutar el proyecto en tu local:

### 1. Clonar el repositorio

Clona este repositorio en tu pc:

```bash
git clone https://github.com/ar316/accentureTest.git
```

### 2. Navegar al directorio del proyecto

Accede al directorio que contiene el proyecto:

```bash
cd accentureTest
```

### 3. Construir el proyecto

Usa Maven para construir el proyecto y descargar las dependencias necesarias:

```bash
mvn clean package -DskipTests
```

### 4. Ejecuta la aplicación

Ejecuta la aplicación utilizando el siguiente comando:

```bash
java -jar target/*.jar
```

La aplicación estará disponible en `http://localhost:8020`.

> **Nota:**  
> Si deseas ver la documentación generada por Swagger, accede a la URL:  
> 
> [http://localhost:8082/swagger-ui/index.html#](http://localhost:8082/swagger-ui/index.html#)

## Desplegar la aplicación con Docker

El proyecto incluye un archivo `Dockerfile` que permite construir y ejecutar la aplicación en un contenedor Docker.

### 1. Construir la imagen Docker

Ejecuta el siguiente comando para construir la imagen Docker:

```bash
docker build -t accenture-test:latest .
```

### 2. Ejecutar el contenedor Docker

Ejecuta el siguiente comando para iniciar el contenedor:

```bash
docker run -p 8020:8020 accenture-test:latest
```

### 3. Acceder a la aplicación

Una vez que el contenedor esté en ejecución, la aplicación estará disponible en `http://localhost:8020`.

## Estructura del proyecto

La estructura del proyecto sigue el estándar de Maven:

```
accentureTest/
├── src/
│   ├── main/
│   │   ├── java/          # Código fuente principal
│   │   └── resources/     # Archivos de configuración y recursos
│   ├── test/              # Pruebas unitarias
├── target/                # Archivos generados después de compilar
├── Dockerfile             # Archivo para construir imágenes Docker
├── pom.xml                # Archivo de configuración de Maven
└── README.md              # Documentación del proyecto
```

## Pruebas

no se incluyeron pruebas unitarias en el proyecto :c  
sin embargo pude haberlas incluido con un poco más de tiempo, 
si deseas que lo haga por favor házmelo saber y lo haré con gusto.