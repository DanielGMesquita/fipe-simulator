package br.dev.danielmesquita.fipesimulator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DataConversionService implements IDataConversionService {
  private static final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public <T> T convertToObject(String json, Class<T> clazz) {
    try {
      return objectMapper.readValue(json, clazz);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public <T> List<T> obtainObject(String json, Class<T> clazz) throws JsonProcessingException {
    CollectionType collectionType =
        objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
    return objectMapper.readValue(json, collectionType);
  }
}
