package com.usa.ciclo3.reto3.repository;

import com.usa.ciclo3.reto3.repository.crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.usa.ciclo3.reto3.model.Client;
import java.util.List;
import java.util.Optional;


@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll() {
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClientId(int id) {
        return clientCrudRepository.findById(id);
    }

    public Client saveClient(Client client) {
        return clientCrudRepository.save(client);
    }

    public void delete(Client client){
        clientCrudRepository.delete(client);
    }
    
}
