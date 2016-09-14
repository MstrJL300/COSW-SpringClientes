/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.samples.controller;

import edu2.eci.cosw.stubs.fakeclientslibrary.ClientServicesStub;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2087133
 */
@RestController
public class ClientController {
     
    ClientServicesStub clientServices = new ClientServicesStub();
    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getClientById(@PathVariable("id") int val) throws edu2.eci.cosw.stubs.fakeclientslibrary.CliendLoadException{
        edu2.eci.cosw.stubs.fakeclientslibrary.Client c = clientServices.getClientById(val);
        return new ResponseEntity<>(c,HttpStatus.ACCEPTED);        
    }
    
    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public Set <edu2.eci.cosw.stubs.fakeclientslibrary.Client> listAllClients(){
        
        return clientServices.getAllClients();
    }
    
    @RequestMapping(value = "/picture/{id}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getPicture(@PathVariable("id") int val) {
        try{
            return ResponseEntity.ok().contentType(MediaType.parseMediaType("image/jpg")).body(new InputStreamResource(clientServices.getClientPicture(val)));
        }catch(edu2.eci.cosw.stubs.fakeclientslibrary.CliendLoadException cle) {
            
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, cle);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }
}
