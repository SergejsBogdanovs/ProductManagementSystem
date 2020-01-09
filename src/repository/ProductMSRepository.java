package repository;

import repository.model.Product;

import java.util.List;

public interface ProductMSRepository {

    void saveProduct(Product product);
    Product getProduct(long id) throws Exception;
    List<Product> getAllProducts();
    void deleteProduct();

}
