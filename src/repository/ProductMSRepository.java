package repository;

import repository.model.Product;

import java.util.List;

public interface ProductMSRepository {

    void addProduct(Product product);
    Product getProduct(long id);
    List<Product> getAllProducts();
    boolean deleteProduct(long id);
}
