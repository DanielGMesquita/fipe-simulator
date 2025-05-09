package br.dev.danielmesquita.fipesimulator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;

public interface IDataConversionService {
  <T> T convertToObject(String json, Class<T> clazz);

  <T> List<T> obtainObject(String json, Class<T> clazz) throws JsonProcessingException;
}
