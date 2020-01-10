package repository;

import repository.model.Product;

import java.util.*;

public class ProductMSRepositoryImpl implements ProductMSRepository {

    private List<Product> data = new ArrayList<>();
//    private static int addedId = 0;

    @Override
    public boolean saveProduct(Product product) {
        if (product.getName() == null || product.getPrice() == null || product.getCategory() == null) {
            return false;
        } else {
            data.add(product);
            return true;
        }
    }

    @Override
    public Product getProduct(long id) throws Exception {
        if (data != null) {
            return data.stream()
                    .filter(product -> product.getId() == id)
                    .findAny()
                    .orElse(null);
        } else {
            throw new Exception("The product db is empty");
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
