package entities;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by admin on 8/16/17.
 */
@Data
@NoArgsConstructor
public class OrderDetail {
    private long orderNumber;
    private long productCode;
    private double priceEach;

    public OrderDetail(long orderNumber, long productCode, double priceEach){
        this.orderNumber = orderNumber;
        this.productCode = productCode;
        this.priceEach = priceEach;
    }
}
