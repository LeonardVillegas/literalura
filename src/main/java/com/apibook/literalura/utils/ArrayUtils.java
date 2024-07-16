package com.apibook.literalura.utils;

import com.apibook.literalura.models.DataWrapper;

import java.util.List;
import java.util.Optional;

public class ArrayUtils {
  public static <T> Optional<List<T>> checkArray(List<T> array) {
    if (array == null || array.size() == 0) {
      return Optional.empty();
    } else {
      return Optional.of(array);
    }
  }
}