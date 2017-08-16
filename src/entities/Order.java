package entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by admin on 8/16/17.
 */
@Data
@NoArgsConstructor
public class Order {
    private long orderNumber;
    private  long customerNumber;
    private Date orderDate;
    private Date shippedDate;
}
