package br.dev.danielmesquita.fipesimulator.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleBrands {
  private final String name;
  private final Integer code;

  @JsonCreator
  public VehicleBrands(@JsonProperty("codigo") String code, @JsonProperty("nome") String name) {
    this.code = Integer.parseInt(code);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Integer getCode() {
    return code;
  }

  @Override
  public String toString() {
    return "{\"codigo\":\"" + code + "\", \"nome\":\"" + name + "\"}";
  }
}
