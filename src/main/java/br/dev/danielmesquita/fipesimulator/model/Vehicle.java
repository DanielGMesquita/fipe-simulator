package br.dev.danielmesquita.fipesimulator.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Vehicle(
    @JsonAlias("TipoVeiculo") int vehicleType,
    @JsonAlias("Valor") String value,
    @JsonAlias("Marca") String brand,
    @JsonAlias("Modelo") String model,
    @JsonAlias("AnoModelo") int year,
    @JsonAlias("Combustivel") String fuel,
    @JsonAlias("CodigoFipe") String codeFipe,
    @JsonAlias("MesReferencia") String monthReference,
    @JsonAlias("SiglaCombustivel") String fuelAbbreviation) {
  @Override
  public String toString() {
    return "Vehicle{"
        + "vehicleType="
        + vehicleType
        + ", value='"
        + value
        + '\''
        + ", brand='"
        + brand
        + '\''
        + ", model='"
        + model
        + '\''
        + ", year="
        + year
        + ", fuel='"
        + fuel
        + '\''
        + ", codeFipe='"
        + codeFipe
        + '\''
        + ", monthReference='"
        + monthReference
        + '\''
        + ", fuelAbbreviation='"
        + fuelAbbreviation
        + '\''
        + '}';
  }
}
