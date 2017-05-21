package nl.codecentric.xpdays2017.bicycleshed.sell.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import nl.codecentric.xpdays2017.bicycleshed.model.Product;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hylke on 21/05/2017.
 */
@Slf4j
@Service
public class SellService {

    public void sellProduct(final Long id) {
        try {
            final Product product = getProducts()
                    .stream()
                    .filter(e -> e.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("Product cannot be found"));

            final String JSONLINE = objectMapper().writeValueAsString(product) + System.lineSeparator();
            final File tmpFile = new File(FileUtils.getTempDirectory(), "bicycle-shed-sales.txt");
            FileUtils.writeStringToFile(tmpFile, JSONLINE, Charset.defaultCharset(), true);
        } catch (final JsonProcessingException e) {
            log.error("Error while processing json", e);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Product> getProducts() {
        return Arrays.asList(new Product(1L, "Bicycle seat", false),
                new Product(2L, "Bicycle tires", false),
                new Product(3L, "Bicycle lights", false),
                new Product(4L, "Wheels spokes", true),
                new Product(5L, "Reflectors", true));


    }


    private ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
