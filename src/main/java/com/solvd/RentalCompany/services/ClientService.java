package com.solvd.RentalCompany.services;

import com.solvd.RentalCompany.core.ClientCore;
import com.solvd.RentalCompany.dao.ClientDAO;
import com.solvd.RentalCompany.dao.IClientDAO;
import com.solvd.RentalCompany.exceptionHandlers.ObjectNotFoundException;
import com.solvd.RentalCompany.mappers.ClientMapper;
import com.solvd.RentalCompany.mappers.IClientMapper;
import com.solvd.RentalCompany.models.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;

public class ClientService implements IClientService{
    private final static Logger logger = LogManager.getLogger(ClientService.class);
    private final IClientDAO clientDAO = new ClientDAO();
    private final IClientMapper clientMapper = new ClientMapper();
    @Override
    public ClientCore createEntity(ClientCore clientCore) {
        Client employee = clientMapper.coreToModel(clientCore);
        Client savedClient = this.clientDAO.createEntity(employee);
        logger.info("Object of class Client has been successfully created.");
        return clientCore;
    }

    @Override
    public ClientCore getEntityById(Integer id) {
        Optional<Client> clientOptional = this.clientDAO.getEntityById(id);
        try{
            if(clientOptional.isEmpty()){
                throw new ObjectNotFoundException("Object was not found!", id);
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class Client with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        Client client = clientOptional.get();
        return clientMapper.modelToCore(client);
    }

    @Override
    public ClientCore updateEntity(ClientCore clientCore, Integer id) {
        Optional<Client> clientOptional = this.clientDAO.updateEntity(clientMapper.coreToModel(clientCore), id);
        try {
            if (clientOptional.isEmpty()) {
                throw new ObjectNotFoundException("Object was not found!", clientCore.getId());
            }
        }catch(ObjectNotFoundException e){
            logger.error("Object of class Client with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        logger.info("Object of class Client has been successfully updated.");
        return clientMapper.modelToCore(clientOptional.get());
    }

    @Override
    public void removeEntityById(Integer id) {
        this.clientDAO.removeEntityById(id);
        logger.info("Object of class Client has been successfully deleted.");
    }
}