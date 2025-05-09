package br.dev.danielmesquita.fipesimulator.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VehicleModels(List<VehicleBrands> vehicleBrandsList) {
  @JsonCreator
  public VehicleModels(@JsonProperty("modelos") List<VehicleBrands> vehicleBrandsList) {
    this.vehicleBrandsList = vehicleBrandsList;
  }

  @Override
  public String toString() {
    return "{\"Modelo\":\"" + vehicleBrandsList + "\"}";
  }
}
