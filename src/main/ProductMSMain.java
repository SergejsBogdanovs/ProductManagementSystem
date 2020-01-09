package main;

import controller.ProductMSController;
import repository.model.Product;
import java.util.Scanner;

public class ProductMSMain {

    public static void main(String[] args) {
        ProductMSContract.Controller controller = new ProductMSController();

        Scanner scanner = new Scanner(System.in);

        try {
            Product product = controller.getProduct(0);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
