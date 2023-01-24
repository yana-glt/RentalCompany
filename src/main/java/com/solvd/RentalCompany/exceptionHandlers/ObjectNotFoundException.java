package com.solvd.RentalCompany.exceptionHandlers;

public class ObjectNotFoundException extends Exception implements IObjectNotFoundException<Integer> {

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