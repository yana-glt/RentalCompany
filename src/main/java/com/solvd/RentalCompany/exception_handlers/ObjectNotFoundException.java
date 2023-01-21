package com.solvd.RentalCompany.exception_handlers;

public class ObjectNotFoundException extends Exception {

    Integer objectId;
    public ObjectNotFoundException() {
    }

    public ObjectNotFoundException(String mess, Integer objectId) {
        super(mess);
        this.objectId = objectId;
    }
    public Integer getObjectId() {
        return objectId;
    }

}
