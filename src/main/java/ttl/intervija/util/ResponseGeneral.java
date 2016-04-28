package ttl.intervija.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andris on 27.04.2016.
 */
public class ResponseGeneral {
    private List<Error> errors;
    private String message;

    public  ResponseGeneral(){
        this.errors = new ArrayList<>();
        this.message="";
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
