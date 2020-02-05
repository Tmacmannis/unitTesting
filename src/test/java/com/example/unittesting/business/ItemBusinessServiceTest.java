package com.example.unittesting.business;

import com.example.unittesting.data.ItemRepository;
import com.example.unittesting.data.SomeDataService;
import com.example.unittesting.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService business;

    @Mock
    private ItemRepository repository;

    @Test
    void calculateSumUsingDataService_basic() {
        when(repository.findAll()).thenReturn(Arrays.asList(new Item(2, "Item2", 2, 2),
                new Item(3, "Item3", 20, 20)));
        List<Item> items = business.retrieveAllItems();
        Assertions.assertEquals(4, items.get(0).getValue());
        Assertions.assertEquals(400, items.get(1).getValue());
    }

}