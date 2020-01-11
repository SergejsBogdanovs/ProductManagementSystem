package controller;

import main.ProductMSMain;
import repository.ProductMSRepository;
import repository.ProductMSRepositoryImpl;
import repository.model.Category;
import repository.model.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

import static main.Utils.isNumeric;

public class ProductMSController implements Controller {

    private ProductMSRepository repository = new ProductMSRepositoryImpl();
    private BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
    private static long productId = 0;

    @Override
    public void createProduct() throws Exception {

        System.out.println("Adding product...\nEnter the product name:");
        String scannerResultForName= scanner.readLine();
        String name = "";
        if (scannerResultForName != null && !scannerResultForName.isEmpty() && !scannerResultForName.isBlank()) {
            name = scannerResultForName;
        } else {
            System.out.println("Please add correct product name!");
            ProductMSMain.makeChoice();
        }

        System.out.println("Enter the product price:");
        String scannerResultForPrice = scanner.readLine();
        BigDecimal price = BigDecimal.valueOf(0);
        if (scannerResultForPrice != null
                && !scannerResultForPrice.isEmpty()
                && !scannerResultForPrice.isBlank()
                && isNumeric(scannerResultForPrice)) {
            price = BigDecimal.valueOf(Float.parseFloat(scannerResultForPrice));
        } else {
            System.out.println("Please add correct product price!");
            ProductMSMain.makeChoice();
        }

        System.out.println("Chose the product category from FRUIT, VEGETABLES, JUICES, ALCOHOL:");
        String scannerResultForCategory = scanner.readLine();
        Category category = Category.UNKNOWN;
        if (scannerResultForCategory != null
                && !scannerResultForCategory.isEmpty()
                && !scannerResultForCategory.isBlank()) {

            switch (scannerResultForCategory.toUpperCase()) {
                case "VEGETABLES":
                    category = Category.VEGETABLES;
                    break;
                case "JUICES":
                    category = Category.JUICES;
                    break;
                case "ALCOHOL":
                    category = Category.ALCOHOL;
                    break;
                case "FRUIT":
                    category = Category.FRUIT;
                break;
            }
        } else {
            System.out.println("Please choice correct product category!");
            ProductMSMain.makeChoice();
        }

        System.out.println("Enter the product discount from or leave it blank:");
        String scannerResultForDiscount = scanner.readLine();
        BigDecimal discount = BigDecimal.valueOf(0);
        if (scannerResultForDiscount != null
                && !scannerResultForDiscount.isEmpty()
                && !scannerResultForDiscount.isBlank()
                && isNumeric(scannerResultForDiscount)) {
            discount = BigDecimal.valueOf(Float.parseFloat(scannerResultForDiscount));
        }

        System.out.println("Enter the product description or leave it blank:");
        String scannerResultForDescription = scanner.readLine();
        String description = "";
        if (scannerResultForDescription != null
                && !scannerResultForDescription.isEmpty()
                && !scannerResultForDescription.isBlank()) {

            description = scannerResultForDescription;
        }
            Product product = new Product(
                productId,
                name,
                price,
                category,
                discount,
                description
        );

        repository.addProduct(product);
        productId++;
    }

    @Override
    public Product getProduct() throws Exception {
        System.out.println("Please enter product id:");
        String scannerResultForProductId = scanner.readLine();
        int productId;
        if (scannerResultForProductId != null
                && !scannerResultForProductId.isEmpty()
                && !scannerResultForProductId.isBlank()
                && isNumeric(scannerResultForProductId)) {
            productId = Integer.parseInt(scannerResultForProductId);
            return repository.getProduct(productId);
        } else {
            throw new Exception();
        }
    }

    @Override
    public List<Product> getAllProducts() throws Exception {
        List<Product> products = repository.getAllProducts();
        if (products != null && products.size() != 0) {
            return products;
        } else {
            throw new Exception();
        }
    }

    @Override
    public boolean deleteProduct() throws Exception {
        System.out.println("Please enter product id you want to delete:");
        String scannerResultForProductIdToDelete = scanner.readLine();
        int productId;
        if (scannerResultForProductIdToDelete != null
                && !scannerResultForProductIdToDelete.isEmpty()
                && !scannerResultForProductIdToDelete.isBlank()
                && isNumeric(scannerResultForProductIdToDelete)) {
            productId = Integer.parseInt(scannerResultForProductIdToDelete);
            return repository.deleteProduct(productId);
        } else {
            throw new Exception();
        }
    }

}
