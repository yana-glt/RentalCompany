package com.solvd.RentalCompany.mappers;

import com.solvd.RentalCompany.core.ClientCore;
import com.solvd.RentalCompany.mappers.mapperInterfaces.IClientMapper;
import com.solvd.RentalCompany.models.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientMapper implements IClientMapper {
    private final static Logger logger = LogManager.getLogger(ClientMapper.class);
    @Override
    public ClientCore modelToCore(Client client) {
        ClientCore clientCore = new ClientCore();
        clientCore.setId(client.getId());
        clientCore.setName(client.getName());
        clientCore.setSurname(client.getSurname());
        clientCore.setEmail(client.getEmail());
        clientCore.setPhone(client.getPhone());
        logger.info("Object of type Client has been successfully mapped to ClientCore type.");
        return clientCore;
    }

    @Override
    public Client coreToModel(ClientCore clientCore) {
        Client client = new Client();
        client.setId(clientCore.getId());
        client.setName(clientCore.getName());
        client.setSurname(clientCore.getSurname());
        client.setEmail(clientCore.getEmail());
        client.setPhone(clientCore.getPhone());
        logger.info("Object of type ClientCore has been successfully mapped to Client type.");
        return client;
    }
}