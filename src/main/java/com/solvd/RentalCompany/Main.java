package com.solvd.RentalCompany;

import com.solvd.RentalCompany.exception_handlers.ObjectNotFoundException;
import com.solvd.RentalCompany.services.IServiceService;
import com.solvd.RentalCompany.services.ServiceService;

public class Main {
    public static void main(String[] args) throws ObjectNotFoundException {
        IServiceService serviceService = new ServiceService();
        //serviceService.createEntity(new ServiceCore("FFF", "FFF", "+48962620520", "Spain"));
        //serviceService.createEntity(new ServiceCore("DDD", "DDD", "+48962620520", "USA"));

        //System.out.println(serviceService.getEntityById(1));
        //System.out.println(serviceService.getEntityById(12));

        //serviceService.removeEntityById(11);

        //serviceService.updateEntity(new ServiceCore("FFF", "FFF", "+48962620520", "Spain"),10);

    }
}
