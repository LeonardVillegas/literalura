package com.apibook.literalura.principal;

import com.apibook.literalura.models.DataWrapper;
import com.apibook.literalura.service.ConsumoAPI;
import com.apibook.literalura.service.ConvertData;

import java.util.Scanner;

public class Principal {
  private final String URL_BASE = "https://gutendex.com/books/";
  private Scanner scanner = new Scanner(System.in);
  private ConsumoAPI consumoApi = new ConsumoAPI();
  private ConvertData conversor = new ConvertData();

  public void startDemo() {
    var json = consumoApi.obtenerDatos(URL_BASE);
    System.out.println(json);
    var data = conversor.getData(json, DataWrapper.class);

    System.out.println(data);

  }

  }
