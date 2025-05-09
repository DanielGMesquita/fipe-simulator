package br.dev.danielmesquita.fipesimulator.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record VehicleDataByYear(String code, String name) {
  @JsonCreator
  public VehicleDataByYear(@JsonProperty("codigo") String code, @JsonProperty("nome") String name) {
    this.code = code;
    this.name = name;
  }

  @Override
  public String toString() {
    return "{\"codigo\":\"" + code + "\", \"nome\":\"" + name + "\"}";
  }
}
