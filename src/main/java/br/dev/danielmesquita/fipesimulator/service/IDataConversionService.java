package br.dev.danielmesquita.fipesimulator.service;

public interface IDataConversionService {
    <T> T convertToObject(String json, Class<T> clazz);
}
