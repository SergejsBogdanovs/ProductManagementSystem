package repository;

import repository.model.Product;

import java.util.*;

public class ProductMSRepositoryImpl implements ProductMSRepository {

    private List<Product> data = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        data.add(product);
    }

    @Override
    public Product getProduct(long id) {
        return data.stream()
                .filter(product -> product.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return data;
    }

    @Override
    public boolean deleteProduct(long id) {
        return data.removeIf(product -> product.getId() == id);
    }
}
