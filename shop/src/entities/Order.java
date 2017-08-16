package entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class Order
 *
 * Created by yslabko on 08/08/2017.
 */
@Data
@NoArgsConstructor
public class Order {
    private long id;
    private long userId;
    private List<Item> items = new ArrayList<>();
    private double total;
}
