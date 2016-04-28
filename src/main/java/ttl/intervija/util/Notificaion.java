package ttl.intervija.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andris on 27.04.2016.
 */
public class Notificaion {
    private List<Error> errors = new ArrayList<>();

    public boolean hasErrors(){
        return this.errors.size() > 0 ? true : false;
    }

    public  void addError (int code, String message){
        this.errors.add(new Error(code, message));
    }

    public List<Error> getErrors() {
        return this.errors;
    }
}
