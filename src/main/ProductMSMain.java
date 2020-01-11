package main;

import controller.Controller;
import controller.ProductMSController;
import repository.model.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static main.Utils.isNumeric;

public class ProductMSMain {

    private static final Controller controller = new ProductMSController();
    private static BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        makeChoice();
    }

    public static void makeChoice() {

        System.out.println("Welcome to product management system. Please chose the option number:\n" +
                "1. Add the product.\n" +
                "2. Get the product by id.\n" +
                "3. Get all products.\n" +
                "4. Delete the product.\n" +
                "5. Exit.");

        try {
            String optionNumber = scanner.readLine();
            if (isNumeric(optionNumber)
                    && Integer.parseInt(optionNumber) <= 5
                    && Integer.parseInt(optionNumber) > 0) {
                startProgram(optionNumber);
            } else {
                System.out.println("Please enter number from 1 to 5.\n");
                makeChoice();
            }
        } catch (Exception e) {
            System.out.println("Exit!");
        }
    }

    private static void startProgram(String optionNumber) throws Exception {
        switch (optionNumber) {
            case "1":
                try {
                    controller.createProduct();
                    System.out.println("Product added successfully\n");
                    makeChoice();
                } catch (IOException e) {
                    System.out.println("Can't add product\n");
                    makeChoice();
                }
                break;
            case "2":
                try {
                    Product product = controller.getProduct();
                    System.out.println(product.toString() + "\n");
                    makeChoice();
                } catch (Exception e) {
                    System.out.println("There is no product with this id in DB.\n");
                    makeChoice();
                }
                break;
            case "3":
                try {
                    List<Product> products = controller.getAllProducts();
                    products.forEach(System.out::println);
                    makeChoice();
                } catch (IOException e) {
                    System.out.println("There are no products in DB.\n");
                    makeChoice();
                }
                break;
            case "4": {
                try {
                    if (controller.deleteProduct()) {
                        System.out.println("Product deleted successfully.");
                    } else {
                        System.out.println("There is no product with this id in DB.\n");
                    }
                    makeChoice();
                } catch (Exception e) {
                    makeChoice();
                }
            }
            case "5": {
                scanner.close();
            }
        }
    }
}
