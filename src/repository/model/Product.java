package repository.model;

import java.math.BigDecimal;

public class Product {

    private long id;
    private String name;
    private BigDecimal price;
    private Category category;

    private BigDecimal discount;
    private String description;

    public Product(long id, String name, BigDecimal price, Category category, BigDecimal discount, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.discount = discount;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}


