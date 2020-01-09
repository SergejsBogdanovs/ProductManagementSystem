package controller;

import main.ProductMSContract;
import repository.ProductMSRepository;
import repository.ProductMSRepositoryImpl;
import repository.model.Product;

public class ProductMSController implements ProductMSContract.Controller {

    private ProductMSRepository repository = new ProductMSRepositoryImpl();

    @Override
    public Product getProduct(long id) throws Exception {
        return repository.getProduct(id);
    }
}
