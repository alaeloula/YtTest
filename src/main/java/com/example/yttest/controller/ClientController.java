package com.example.yttest.controller;

import com.example.yttest.dto.ClientDtoReq;
import com.example.yttest.dto.ClientDtoRes;
import com.example.yttest.entity.Client;
import com.example.yttest.service.interfaces.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private IClient clientService;

    @GetMapping
    public List<ClientDtoRes> getAllClients() {
        List<ClientDtoRes> clients= clientService.findAll();
        for (ClientDtoRes cl : clients) {
            System.out.println("Client ID: " + cl.getId());
            System.out.println("Client Name: " + cl.getEmail());
            // Afficher d'autres détails du client
        }
        return clients;
    }

    @GetMapping("/{id}")
    public ClientDtoRes getClientById(@PathVariable Integer id) {
        return clientService.findById(id);
    }

    @PostMapping
    public ClientDtoRes createClient(@RequestBody ClientDtoReq clientDtoReq) {
        return clientService.createUser(clientDtoReq);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Integer id) {
        clientService.deleteById(id);
    }
}
