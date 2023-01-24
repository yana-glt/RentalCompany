package com.solvd.RentalCompany.exceptionHandlers;

public class ObjectNotFoundExceptionForStringId extends Exception implements IObjectNotFoundException<String> {

    String objectId;
    public ObjectNotFoundExceptionForStringId() {
    }

    public ObjectNotFoundExceptionForStringId(String mess, String objectId) {
        super(mess);
        this.objectId = objectId;
    }
    public String getObjectId() {
        return objectId;
    }
}
