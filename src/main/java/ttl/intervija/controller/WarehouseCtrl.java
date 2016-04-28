package ttl.intervija.controller;

import ttl.intervija.util.Notificaion;
import ttl.intervija.util.ResponseGeneral;
import ttl.intervija.warehouse.ResponseWarehouseQuantityAvailable;
import ttl.intervija.pojos.Order;
import ttl.intervija.warehouse.Warehouse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Andris on 25.04.2016.
 */
@Path("warehouse")
public class WarehouseCtrl {

    @GET
    @Produces("text/plain")
    public String getGreeting(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return "Noliktavas laiks: " + LocalDateTime.now().format(formatter);
    }

    @Path("products/{productid}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseWarehouseQuantityAvailable getAvailableQuantity(@PathParam("productid") String pID){
        ResponseWarehouseQuantityAvailable resp = new ResponseWarehouseQuantityAvailable();
        String productId = pID.trim().toUpperCase();

        Notificaion notes = new Notificaion();
        Warehouse warehouse = new Warehouse(notes);
        BigDecimal qtyInWarehouse = warehouse.getAvailableQuantity(productId);

        if (notes.hasErrors()){
            resp.setErrors(notes.getErrors());
        } else {
            resp.setQuantityAvailable(qtyInWarehouse);
        }

        resp.setProductId(productId);

        return resp;
    }

    @Path("products/new/{productid}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseGeneral registerNewProductId(@PathParam("productid") String pID){
        ResponseGeneral resp = new ResponseGeneral();
        String productId = pID.trim().toUpperCase();

        Notificaion notes = new Notificaion();
        Warehouse warehouse = new Warehouse(notes);
        warehouse.registerNewProduct(productId);

        if (notes.hasErrors()){
            resp.setErrors(notes.getErrors());
        } else {
            resp.setMessage("Operācija veiksmīga");
        }

        return resp;
    }

    @Path("ship")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public  ResponseGeneral shipOrder(Order shippingOrder){
        ResponseGeneral resp = new ResponseGeneral();
        Notificaion notes = new Notificaion();
        shippingOrder.validate(notes);

        if (!notes.hasErrors()){
            Warehouse warehouse = new Warehouse(notes);
            warehouse.decreaseQuantity(shippingOrder.getProductid(), shippingOrder.getQuantity());
        }

        if (notes.hasErrors()){
            resp.setErrors(notes.getErrors());
        } else {
            resp.setMessage("Operācija veiksmīga");
        }

        return resp;
    }
}
