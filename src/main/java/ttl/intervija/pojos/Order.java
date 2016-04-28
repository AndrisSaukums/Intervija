package ttl.intervija.pojos;


import com.fasterxml.jackson.annotation.JsonProperty;
import ttl.intervija.util.Notificaion;

import java.math.BigDecimal;

/**
 * Created by Andris on 27.04.2016.
 */
public class Order {
    @JsonProperty("productid")
    private String productid;
    @JsonProperty("quantity")
    private BigDecimal quantity;

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public void validate(Notificaion note){
        if (this.productid == null) {
            note.addError(3, "Pasūtījumā trūkst Produkta numurs.");
            return;
        }

        this.productid = this.productid.trim().toUpperCase();
        if (this.productid.length() == 0){
            note.addError(3, "Pasūtījumā trūkst Produkta numurs.");
            return;
        }

        this.quantity = this.quantity.setScale(3, BigDecimal.ROUND_FLOOR);
        if (this.quantity.compareTo(BigDecimal.ZERO) != 1){
            note.addError(4, "Pasūtījuma daudzumam jābūt lielākam par nulli.");
            return;
        }
    }
}
