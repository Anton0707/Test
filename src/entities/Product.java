package entities;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by admin on 8/16/17.
 */
@Data
@NoArgsConstructor
public class Product {
    private String productCode;
    private String productName;
    private int quantityInStock;
    private double buyPrice;

    public Product(String productCode, String productName, int quantityInStock, double buyPrice){
        this.productCode = productCode;
        this.productName = productName;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
    }
}
