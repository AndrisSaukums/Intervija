package ttl.intervija.controller;

import ttl.intervija.factory.Factory;
import ttl.intervija.pojos.Order;
import ttl.intervija.util.Notificaion;
import ttl.intervija.util.ResponseGeneral;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Andris on 28.04.2016.
 */
@Path("factory")
public class FactoryCtrl {
    @Path("produce")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseGeneral produce(Order productionOrder){
        ResponseGeneral resp = new ResponseGeneral();
        Notificaion notes = new Notificaion();
        productionOrder.validate(notes);

        if (!notes.hasErrors()){
            Factory factory = new Factory(notes);
            factory.produce(productionOrder.getProductid(), productionOrder.getQuantity());
        }

        if (notes.hasErrors()){
            resp.setErrors(notes.getErrors());
        } else {
            resp.setMessage("Operācija veiksmīga");
        }

        return resp;
    }
}
