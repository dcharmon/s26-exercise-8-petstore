package com.dcharmon.persistence;

import com.dcharmon.entity.Pet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class PetDao {

    public List<Pet> getPetsByStatus(String status) {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("https://petstore.swagger.io")
                .path("/v2/pet/findByStatus")
                .queryParam("status", status);

        String response = target.request(MediaType.APPLICATION_JSON)
                .get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        List<Pet> pets;

        try {
            pets = mapper.readValue(response, new TypeReference<List<Pet>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return pets;
    }
}