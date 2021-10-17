package com.usa.ciclo3.reto3.service;

import java.util.List;
import java.util.Optional;
import com.usa.ciclo3.reto3.model.Client;
import com.usa.ciclo3.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    /**
     * 
     * @return
     */
    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    /**
     * 
     * @param id
     * @return
     */
    public Optional<Client> getClientId(int id) {
        return clientRepository.getClientId(id);
    }

    /**
     * 
     * @param client
     * @return
     */
    public Client saveClient(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.saveClient(client);
        } else {
            Optional<Client> consulta = clientRepository.getClientId(client.getIdClient());
            if (consulta.isEmpty()) {
                return clientRepository.saveClient(client);
            } else {
                return client;
            }
        }
    }

    /**
     * 
     * @param client
     * @return
     */
    public Client updateClient(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> e = clientRepository.getClientId(client.getIdClient());
            if (!e.isEmpty()) {
                if (client.getEmail() != null) {
                    e.get().setEmail(client.getEmail());
                }
                if (client.getPassword() != null) {
                    e.get().setPassword(client.getPassword());
                }
                if (client.getName() != null) {
                    e.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    e.get().setAge(client.getAge());
                }              
                clientRepository.saveClient(e.get());
                return e.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    /**
     * 
     * @param clientId
     * @return
     */
    public boolean deleteClientId(int clientId) {
        Boolean aBoolean = getClientId(clientId).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
