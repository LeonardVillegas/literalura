package com.apibook.literalura.principal;

import com.apibook.literalura.models.Book;
import com.apibook.literalura.models.BookEntry;
import com.apibook.literalura.models.DataWrapper;
import com.apibook.literalura.repository.BookRepository;
import com.apibook.literalura.service.ConsumoAPI;
import com.apibook.literalura.service.ConvertData;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static com.apibook.literalura.utils.ArrayUtils.checkArray;

public class Principal {
  private final String URL_BASE = "https://gutendex.com/books/";
  private Scanner scanner = new Scanner(System.in);
  private ConsumoAPI consumoApi = new ConsumoAPI();
  private ConvertData conversor = new ConvertData();
  private BookRepository repository;

  public Principal(BookRepository repository) {
    this.repository = repository;
  }




  public void showMenu() {
//    var json = consumoApi.obtenerDatos(URL_BASE);
//    System.out.println(json);
//    var data = conversor.getData(json, DataWrapper.class);
//
//    System.out.println(data);
    System.out.println("Start");

    var option = -1;
    while (option != 0) {
      var menu = """
          1 - Buscar Libro
          2 - Guardar a la Colección
          
          0 - Salir
          """;
      System.out.println(menu);
      option = scanner.nextInt();
      scanner.nextLine();
      switch (option) {
        case 1:
          findBook();
          break;

        case 2:
          saveToColection();
          break;
        case 0:
          System.out.println("Cerrando la aplicación --");
          break;
        default:
          System.out.println("Opción Invalida");
      }
    }
  }

  private void saveToColection() {
    Optional data = getBookById();
    if (data.isPresent()) {
      //var bookEntry = (BookEntry) data.get();
      List<BookEntry> bookEntry = (List<BookEntry>)data.get();
      //System.out.println(bookEntry.get(0));
      Book book = new Book(bookEntry.get(0));
    repository.save(book);
    }else{

    System.out.println("Fallo");
    }
  }

  private Optional<List<BookEntry>> getBookById() {
    System.out.println("Escriba el id del libro: ");
    var i = scanner.nextInt();
    scanner.nextLine();
    String queryString = String.format("?ids=%d", i);
    var json = consumoApi.obtenerDatos(URL_BASE+queryString);
    var result = conversor.getData(json,DataWrapper.class).books();
    return checkArray(result);





  }

  private void findBook() {
    List<BookEntry> dataBook = getDataBook();
    //Book book = new Book(dataBook);
    //repository.save(book);
    dataBook.stream().forEach(e -> System.out.println((new Book(e))));
    //System.out.println(dataBook);

  }

  private List<BookEntry> getDataBook() {
    System.out.println("Escribe el nombre del libro: ");
    var name = scanner.nextLine();
    String queryString = String.format("?search=%s", name.replace(" ", "+"));
    var json = consumoApi.obtenerDatos(URL_BASE+queryString);
    return conversor.getData(json,DataWrapper.class).books();
  }
}
