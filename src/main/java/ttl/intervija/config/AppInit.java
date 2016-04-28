package ttl.intervija.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;


/**
 * Created by Andris on 25.04.2016.
 */
@ApplicationPath("api")
public class AppInit extends ResourceConfig {
    public AppInit(){
        packages("ttl.intervija.controller");
        register(JacksonFeature.class);
    }
}
