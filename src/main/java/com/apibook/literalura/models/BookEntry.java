package com.apibook.literalura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record BookEntry(
    Integer id,
    String title,
    List<Author> authors,
    List<String> languages
) {}
