package com.apibook.literalura.service;

public interface IConvertData {
  <T> T getData(String json, Class<T> clazz);
}
