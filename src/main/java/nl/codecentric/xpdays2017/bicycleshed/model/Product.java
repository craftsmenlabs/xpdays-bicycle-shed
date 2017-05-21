package nl.codecentric.xpdays2017.bicycleshed.model;

import lombok.Data;

/**
 * Created by hylke on 21/05/2017.
 */
@Data
public class Product {


    private final Long id;

    private final String name;

    /**
     * If product is on display
     */
    private final boolean onDisplay;


}
