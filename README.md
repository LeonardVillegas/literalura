# LiterAlura
Catálogo de Libros que permita la interacción textual con los usuarios a través de la consola. Los usuarios podrán elegir entre al menos 5 opciones de interacción para buscar y gestionar libros utilizando una API específica.

## Acerca de la API que se consume en este proyecto.
[Gutendex](https://gutendex.com/) es una API web en formato JSON que tiene información de metadatos de libros
Listas de Libros
Para consultar listas de libros de la base de datos, use el endpoint `/books`

**Estructura básica de la respuesta**
```
{
  "count": <número>,
  "next": <cadena o null>,
  "previous": <cadena o null>,
  "results": <array de libros>
}
```
### Parámetros de Consulta

* `author_year_start` y `author_year_end`: Encuentra libros con al menos un autor vivo dentro de un rango de años determinado. Ejemplo: /books?author_year_start=1900&author_year_end=1999.
* `copyright`: Filtrar por estado de derechos de autor (true, false o null). Ejemplo: `/books?copyright=true,false`.
* `ids`: Listar libros con números de ID específicos de Project Gutenberg. Ejemplo: `/books?ids=11,12,13`.
* `languages`: Encuentra libros en idiomas específicos usando códigos de dos caracteres. Ejemplo: `/books?languages=en,fr`.
* `mime_type`: Filtrar libros por tipo MIME. Ejemplo: `/books?mime_type=text%2Fhtml`.
* `search`: Buscar libros por nombres de autores o títulos usando palabras específicas. Ejemplo: `/books?search=dickens%20great`.
* `sort`: Ordenar libros por popularidad (por defecto), en orden ascendente o descendente de números de ID. Ejemplo: `/books?sort=ascending`.

Documentación de la API: [Gutendex](https://gutendex.com/)