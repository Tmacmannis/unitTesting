package com.example.unittesting.data;

import com.example.unittesting.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Test
    public void testFindAll(){
        List<Item> items = repository.findAll();
        Assertions.assertEquals(3, items.size());
    }
}
