Es una API que permite operaciones CRUD de los productos de la tienda online:

Paso 1:
PS C:\ws_java\buscalo-product-api> ./mvnw clean package -DskipTests
Paso 2:
PS C:\ws_java\buscalo-product-api> docker-compose up
Paso 3:
http://localhost:8080/swagger-ui.html

![image](https://github.com/crizcode/buscalo-product-api/assets/88556496/3225144c-fb1b-43ee-81a5-e766494a25d4)

Ejemplo:
  - Add producto:

    {
    "id": 1,
    "nombre": "Laptop HP",
    "descripcion": "Laptop Hp Pavilion Amd R7 16Gb",
    "precio": 3059.99,
    "cantidad": 1,
    "imagenUrl": "http://img.com",
    "fechaCreacion": "2024-01-08T04:11:59.995+00:00",
    "categoria": {
      "id": 1,
      "nombre": "Tecnologia",
      "estado": "ACTIVO"
    },
    "proveedor": {
      "id": 1,
      "nombre": "Estrella S.A.C",
      "estado": "ACTIVO"
    },
    "estado": "ACTIVO"
  }

  - Modi producto:
  {
    "id": 1,
    "nombre": "Laptop HP 2",
    "descripcion": "Laptop Hp Pavilion Amd R7 16Gb",
    "precio": 3059.99,
    "cantidad": 1,
    "imagenUrl": "http://img.com",
    "fechaCreacion": "2024-01-08T04:11:59.995+00:00",
    "categoria": {
      "id": 1,
      "nombre": "Tecnologia",
      "estado": "ACTIVO"
    },
    "proveedor": {
      "id": 1,
      "nombre": "Estrella S.A.C",
      "estado": "ACTIVO"
    },
    "estado": "ACTIVO"
  }
