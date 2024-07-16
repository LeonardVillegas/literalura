package com.apibook.literalura.models;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name="books")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private Integer bookId;
  private String title;
  private String author;
  private String language;

  public Book() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  @Override
  public String toString() {
    return String.format("%s --(%s) id: %d", title.toUpperCase(), author, bookId);
  }

  public Book(BookEntry bookData) {
    this.title = bookData.title();
    this.bookId = bookData.bookId();
    Optional language = bookData.languages().stream().findFirst();
    Optional author = bookData.authors().stream().map(Author::name).findFirst();
    if (language.isPresent()) {
      this.language = language.get().toString();
    }
    if (author.isPresent()) {
      this.author = author.get().toString();
    }



  }
}
