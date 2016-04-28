package ttl.intervija.warehouse;

import ttl.intervija.util.Notificaion;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andris on 26.04.2016.
 */
public class Warehouse {
    private static Map<String, BigDecimal> storage = Collections.synchronizedMap(new HashMap<>());

    private Notificaion notes;

    public Warehouse(Notificaion notes){
        this.notes = notes;
    }

    public void registerNewProduct (String productId){
        synchronized (storage){
            if (!storage.containsKey(productId))
                storage.put(productId, BigDecimal.ZERO);
        }
    }

    public BigDecimal getAvailableQuantity(String productId){

        if (storage.containsKey(productId))
            return storage.get(productId);
        else {
            this.notes.addError(1, "Produkts nav reģistrēts noliktavā");
            return new BigDecimal(-1);
        }
    }

    public void addQuantity (String productId, BigDecimal quantity){

        synchronized (storage) {
            if (storage.containsKey(productId))
                storage.put(productId, storage.get(productId).add(quantity));
            else
                this.notes.addError(1, "Produkts nav reģistrēts noliktavā");
        }
    }

    public void decreaseQuantity (String productId, BigDecimal quantity){

        synchronized (storage) {
            if (!storage.containsKey(productId))
                this.notes.addError(1, "Produkts nav reģistrēts noliktavā");
            else {
                BigDecimal availableQty = storage.get(productId);
                if (availableQty.compareTo(quantity) == -1)
                    this.notes.addError(2, "Noliktavā nepietiek preces. Pieejamais daudzums: " + availableQty);
                else {
                    storage.put(productId, availableQty.subtract(quantity));
                }
            }
        }
    }


}
