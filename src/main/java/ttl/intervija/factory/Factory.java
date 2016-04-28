package ttl.intervija.factory;

import ttl.intervija.util.Notificaion;
import ttl.intervija.warehouse.Warehouse;

import java.math.BigDecimal;

/**
 * Created by Andris on 28.04.2016.
 */
public class Factory {
    private Notificaion note;

    public Factory(Notificaion note){
        this.note = note;
    }

    public void produce(String productid, BigDecimal quantity){
        Warehouse warehouse = new Warehouse(this.note);
        warehouse.addQuantity(productid, quantity);
    }
}
