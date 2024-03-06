package com.example.yttest.service.impl;



import com.example.yttest.dto.ClientDtoReq;
import com.example.yttest.dto.ClientDtoRes;
import com.example.yttest.entity.Client;
import com.example.yttest.repository.ClientRepository;
import com.example.yttest.service.interfaces.IClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ClientService implements IClient {
    private final ClientRepository clientRepository;
    @Autowired
    private ModelMapper modelMapper;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public List<ClientDtoRes> findAll() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

//        return clients.stream()
//                .map(client -> modelMapper.map(client, ClientDtoRes.class))
//                .collect(Collectors.toList());
    }

    @Override
    public ClientDtoRes findById(Integer id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
        return convertToDto(client);
    }

    @Override
    public ClientDtoRes createUser(ClientDtoReq clientCreateDto) {
        Client client = convertToEntity(clientCreateDto);
        Client savedClient = clientRepository.save(client);
        return convertToDto(savedClient);
    }

    @Override
    public long count() {
        return clientRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        clientRepository.deleteById(id);
    }

    private ClientDtoRes convertToDto(Client client) {
        return modelMapper.map(client, ClientDtoRes.class);
    }

    private Client convertToEntity(ClientDtoReq carDtoReq) {
        return modelMapper.map(carDtoReq, Client.class);
    }
}
