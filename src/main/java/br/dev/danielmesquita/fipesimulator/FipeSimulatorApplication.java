package br.dev.danielmesquita.fipesimulator;

import br.dev.danielmesquita.fipesimulator.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeSimulatorApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(FipeSimulatorApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    // This method is executed after the application context is loaded
    // You can add your logic here if needed
    System.out.println("Fipe Simulator Application started!");
    // For example, you can call your main method here
    Main main = new Main();
    main.showMenu();
  }
}
