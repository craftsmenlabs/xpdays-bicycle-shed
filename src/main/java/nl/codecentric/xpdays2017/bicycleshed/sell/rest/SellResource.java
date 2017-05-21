package nl.codecentric.xpdays2017.bicycleshed.sell.rest;

import nl.codecentric.xpdays2017.bicycleshed.sell.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hylke on 21/05/2017.
 */
@RestController
public class SellResource {


    @Autowired
    private SellService sellService;

    @PostMapping(path = "/sell/{id}")
    public void sellProduct(@PathVariable  final Long id) {
        sellService.sellProduct(id);
    }
}
