package br.dev.danielmesquita.fipesimulator.main;

import java.util.Scanner;

public class Main {
  private final Scanner scanner = new Scanner(System.in);
  private final String url = "https://parallelum.com.br/fipe/api/v1/";
  public void showMenu() {
    System.out.println("Welcome to the Fipe Simulator! Select your type of vehicle:");
    System.out.println("Car");
    System.out.println("Motorcycle");
    System.out.println("Truck");

    String option = scanner.nextLine();

    String optionVariables;

    while(true) {
      if(option.toLowerCase().contains("car")) {
        optionVariables = "car";
        break;
      } else if(option.toLowerCase().contains("moto")) {
        optionVariables = "motorcycle";
        break;
      } else if(option.toLowerCase().contains("truck")) {
        optionVariables = "truck";
        break;
      } else {
        System.out.println("Invalid option. Please try again.");
        option = scanner.nextLine();
      }
    }
  }
}
