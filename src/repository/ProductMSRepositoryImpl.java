package repository;

import repository.model.Product;

import java.util.*;

public class ProductMSRepositoryImpl implements ProductMSRepository {

    private Map<Long, Product> data = new HashMap<>();
    private long addedId = 0;

    @Override
    public void saveProduct(Product product) {
        data.put(addedId, product);
        addedId++;
    }

    @Override
    public Product getProduct(long id) throws Exception {
        if (data.containsKey(id)) {
            return data.get(id);
        } else {
            throw new Exception("Can't find any product!");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public void deleteProduct() {

    }
}
