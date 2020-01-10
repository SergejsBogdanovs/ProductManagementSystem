package main;

import repository.model.Product;

public interface ProductMSContract {

    interface Main {

    }

    interface Controller {
        Product getProduct(long id) throws Exception;
        boolean addProduct(Product product);
    }
}
