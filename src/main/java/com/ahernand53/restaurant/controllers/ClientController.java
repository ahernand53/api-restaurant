package com.ahernand53.restaurant.controllers;

import com.ahernand53.restaurant.entity.ClientEntity;
import com.ahernand53.restaurant.services.ClientService;
import com.ahernand53.restaurant.util.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("v1/api")
public class ClientController {

    @Autowired
    private ClientService _clientService;

    @RequestMapping(value = "/clients", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<ClientEntity>> getClients() {
        // TODO: Terminar cuando el usuario tiene una factura

        List<ClientEntity> clientEntities = _clientService.findAll();

        return new ResponseEntity<List<ClientEntity>>(clientEntities, HttpStatus.OK);
    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> createClients(@RequestBody ClientEntity clientEntity, UriComponentsBuilder uriComponentsBuilder) {
        if (clientEntity.getName().isEmpty() || clientEntity.getName() == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        if (clientEntity.getAddress().isEmpty() || clientEntity.getAddress() == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        if (clientEntity.getPhone().isEmpty() || clientEntity.getPhone() == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        _clientService.save(clientEntity);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<ClientEntity> getClientByid(@PathVariable("id") Long idClient) {
        // TODO: Terminar cuando el usuario tiene una factura

        if (idClient <= 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ClientEntity client = _clientService.findById(idClient);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<ClientEntity>(client, HttpStatus.OK);
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
    public ResponseEntity<ClientEntity> updateClient(@PathVariable("id") Long idClient, @RequestBody ClientEntity clientEntity){

        if (idClient <= 0){
            return new ResponseEntity(
                    new CustomErrorType("it need id client"),
                    HttpStatus.NO_CONTENT
            );
        }

        ClientEntity clientEntity1 = _clientService.findById(idClient);

        if (clientEntity1 == null) {
            return new ResponseEntity(
                    new CustomErrorType("Client not found in the data base"),
                    HttpStatus.NOT_FOUND
            );
        }

        if (clientEntity.getName() != null) {
            clientEntity1.setName(clientEntity.getName());
        }

        if (clientEntity.getLastname() != null) {
            clientEntity1.setLastname(clientEntity.getLastname());
        }

        if (clientEntity.getPhone() != null) {
            clientEntity1.setPhone(clientEntity.getPhone());
        }

        if (clientEntity.getAddress() != null) {
            clientEntity1.setAddress(clientEntity.getAddress());
        }

        _clientService.update(clientEntity1);

        return new ResponseEntity<ClientEntity>(clientEntity1, HttpStatus.OK);

    }

}

