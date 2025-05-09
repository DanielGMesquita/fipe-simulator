package br.dev.danielmesquita.fipesimulator.main;

import br.dev.danielmesquita.fipesimulator.connection.APIProvider;
import br.dev.danielmesquita.fipesimulator.enums.OptionURLs;
import br.dev.danielmesquita.fipesimulator.model.Vehicle;
import br.dev.danielmesquita.fipesimulator.model.VehicleBrands;
import br.dev.danielmesquita.fipesimulator.model.VehicleDataByYear;
import br.dev.danielmesquita.fipesimulator.model.VehicleModels;
import br.dev.danielmesquita.fipesimulator.service.DataConversionService;
import br.dev.danielmesquita.fipesimulator.service.IDataConversionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
  private final Scanner scanner = new Scanner(System.in);
  private final APIProvider apiProvider = new APIProvider();
  private final IDataConversionService dataConversionService = new DataConversionService();
  private static final ObjectMapper objectMapper = new ObjectMapper();

  public void showMenu() throws JsonProcessingException {
    System.out.println("Welcome to the Fipe Simulator! Select your type of vehicle:");
    System.out.println("Car");
    System.out.println("Motorcycle");
    System.out.println("Truck");

    String option = scanner.nextLine();

    String optionVariables;

    while (true) {
      if (option.toLowerCase().contains("car")) {
        optionVariables = OptionURLs.CAR.getUrl();
        break;
      } else if (option.toLowerCase().contains("mot")) {
        optionVariables = OptionURLs.MOTORCYCLE.getUrl();
        break;
      } else if (option.toLowerCase().contains("tru")) {
        optionVariables = OptionURLs.TRUCK.getUrl();
        break;
      } else {
        System.out.println("Invalid option. Please try again.");
        option = scanner.nextLine();
      }
    }
    String url = "https://parallelum.com.br/fipe/api/v1/";
    String completeUrl = url + optionVariables;

    String json = apiProvider.getApiData(completeUrl);

    List<VehicleBrands> vehicleBrandsList =
        dataConversionService.obtainObject(json, VehicleBrands.class);

    System.out.println("Select the brand of the vehicle by code:");
    vehicleBrandsList.stream()
        .sorted(Comparator.comparing(VehicleBrands::getCode))
        .forEach(System.out::println);

    String brandOption = scanner.nextLine();

    String urlBrand = completeUrl + "/" + brandOption + "/modelos";

    json = apiProvider.getApiData(urlBrand);

    VehicleModels vehicleBrandList =
        dataConversionService.convertToObject(json, VehicleModels.class);

    System.out.println("Models available:");
    vehicleBrandList.vehicleBrandsList().stream()
        .sorted(Comparator.comparing(VehicleBrands::getCode))
        .forEach(System.out::println);

    System.out.println("Select a model by typing the name or part of it:");
    String modelOption = scanner.nextLine();

    List<VehicleBrands> filteredModelList =
        vehicleBrandList.vehicleBrandsList().stream()
            .filter(
                vehicleBrand ->
                    vehicleBrand.getName().toLowerCase().contains(modelOption.toLowerCase()))
            .toList();

    System.out.println("Filtered model list:");
    filteredModelList.forEach(System.out::println);

    System.out.println("Select the model of the vehicle by code:");
    String modelCode = scanner.nextLine();

    String urlModel = urlBrand + "/" + modelCode + "/anos";

    json = apiProvider.getApiData(urlModel);
    List<VehicleDataByYear> vehicleDataByYearList =
        dataConversionService.obtainObject(json, VehicleDataByYear.class);

    List<Vehicle> vehicles = new ArrayList<>();

    for (VehicleDataByYear vehicleDataByYear : vehicleDataByYearList) {
      String urlYear = urlModel + "/" + vehicleDataByYear.code();
      String jsonYear = apiProvider.getApiData(urlYear);
      Vehicle vehicle = objectMapper.readValue(jsonYear, Vehicle.class);
      vehicles.add(vehicle);
    }
    vehicles.sort(Comparator.comparing(Vehicle::year));
    vehicles.forEach(vehicle -> System.out.println(vehicle.toString()));

    scanner.close();
    System.exit(0);
  }
}
