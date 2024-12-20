# user-mgmt-api (Puerto 8084)

API de gestión de usuarios desarrollada en Java y Spring Boot, parte del sistema de soporte de mercado de valores.

## Requisitos previos

- [Java 17](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [MySQL](https://dev.mysql.com/downloads/installer/) Crear base de datos db_stock_market_support_system
- [Git](https://git-scm.com/)

## Pasos para levantar en local

### 1. Base de datos

Crear base de datos en MySQL db_stock_market_support_system.

### 2. Configuración de variables de entorno

Es necesario configurar las variables de entorno para conectarse a la base de datos y ejecutar la aplicación correctamente. A continuación, se muestra un ejemplo de las variables necesarias:

```bash
DB_HOST=localhost
DB_PORT=3306
DB_USERNAME=root
DB_PASSWORD=123
DB_NAME=db_stock_market_support_system
```

![image](https://github.com/user-attachments/assets/4f16e6c9-55e6-451b-812a-4859d4615ecf)

### 3. Levantar el proyecto en el puerto 8084

![image](https://github.com/user-attachments/assets/1b9c91d5-939a-4eb2-a2fe-e0c60ae06f84)
