package com.sxlg.goblet.serialization;

import java.util.ArrayList;
import java.util.List;

public class School {
 
   private List<Error> errors;

    public List<Error> getErrors() {
        return errors;
    }
//
//    public void setErrors(List<Error> errors) {
//        this.errors = errors;
//    }

    @Override
    public String toString() {
        return "School{" +
                "errors=" + errors +
                '}';
    }
}
