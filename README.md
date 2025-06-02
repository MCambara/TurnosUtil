# TurnosUtil

**TurnosUtil** es una librería Java para la gestión de turnos y estructuras de datos personalizadas. Está diseñada para integrarse fácilmente como dependencia en proyectos Java, proporcionando implementaciones robustas y genéricas de estructuras como listas enlazadas, colas y árboles binarios. Facilita operaciones básicas y avanzadas sobre colecciones de datos, enfocándose en simplicidad y eficiencia.

---

## Características principales

- **Lista Enlazada**  
  Implementación genérica que permite almacenar y manipular elementos de cualquier tipo con operaciones básicas de inserción, eliminación y recorrido.

- **Cola (FIFO)**  
  Estructura de datos para gestión secuencial de turnos, con métodos para encolar, desencolar y obtener el primer elemento sin removerlo.

- **Árbol Binario**  
  Soporta operaciones de inserción, búsqueda, eliminación y recorridos en preorden, inorden y postorden. Diseñado para trabajar con elementos comparables.

- **Clases utilitarias**  
  Incluye implementaciones de nodos genéricos y un tipo opcional simple (`Opcion`) para manejar valores que pueden o no estar presentes.

---

## Tecnologías usadas

- Java 17  
- Maven 3.x

---

## Instalación

Para agregar **TurnosUtil** como dependencia en tu proyecto Maven, incluye lo siguiente en tu archivo `pom.xml`:

```xml
<dependency>
    <groupId>umg.edu.gt.prograIII</groupId>
    <artifactId>TurnosUtil</artifactId>
    <version>1.6-SNAPSHOT</version>
</dependency>
