package com.dcharmon.persistence;

import com.dcharmon.entity.Pet;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PetDaoTest {

    @Test
    void getPetsByStatusSuccess() {
        PetDao dao = new PetDao();
        List<Pet> pets = dao.getPetsByStatus("available");

        assertNotNull(pets);
        assertFalse(pets.isEmpty());

        Pet firstPet = pets.get(0);
        assertNotNull(firstPet.getName());
        assertEquals("available", firstPet.getStatus());
    }
}