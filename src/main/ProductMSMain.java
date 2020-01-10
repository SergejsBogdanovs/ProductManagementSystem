package main;

import controller.ProductMSController;
import repository.model.Category;
import repository.model.Product;

import java.math.BigDecimal;
import java.util.Scanner;

public class ProductMSMain {

    private static long productId = 0;

    public static void main(String[] args) {
        ProductMSContract.Controller controller = new ProductMSController();

        Scanner scanner = new Scanner(System.in);

        Product product1 = new Product(
                productId,
                "Apple",
                new BigDecimal("0.50"),
                Category.FRUIT,
                new BigDecimal("0.05"),
                "Tasty apple from LV");

        if (controller.addProduct(product1)) {
            System.out.println("Product add successfully");
            productId++;
        } else {
            System.out.println("Can't add product! Please check product name, price or category!");
        }


        try {
            Product product = controller.getProduct(0);
            System.out.println(product.getName());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
