package ttl.intervija.warehouse;

import ttl.intervija.util.ResponseGeneral;

import java.math.BigDecimal;

/**
 * Created by Andris on 27.04.2016.
 */
public class ResponseWarehouseQuantityAvailable extends ResponseGeneral {
    private String productId;
    private BigDecimal quantityAvailable;

    public ResponseWarehouseQuantityAvailable(){
        super();
        this.productId = "";
        this.quantityAvailable = BigDecimal.ZERO;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(BigDecimal quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }
}
