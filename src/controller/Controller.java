package controller;

import repository.model.Product;
import java.util.List;

public interface Controller {

    Product getProduct() throws Exception;

    void createProduct() throws Exception;

    List<Product> getAllProducts() throws Exception;

    boolean deleteProduct() throws Exception;
}
