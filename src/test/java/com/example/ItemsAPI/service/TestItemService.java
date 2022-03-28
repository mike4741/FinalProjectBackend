package com.example.ItemsAPI.service;

import com.example.ItemsAPI.controller.dto.ItemDto;
import com.example.ItemsAPI.entity.Item;
import com.example.ItemsAPI.reposiitory.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class TestItemService {

    ItemRepository itemRepository = mock(ItemRepository.class);

    ItemServiceImpl itemService  = new ItemServiceImpl(itemRepository);

    @Test
    public  void  getAllItemsTest(){
        ArrayList list = new ArrayList<Item>();
        for (ItemDto itemDto : Arrays.asList(new ItemDto("name one", "description one", "img-url", 12.2),
//                                             new ItemDto("name one", "description one", "img-url", 12.2),
                                             new ItemDto("name two", "description two", "img-url", 12.5))) {
            list.add(itemDto);

        }
        when(itemRepository.findAll()).thenReturn(list);

        assertEquals(2,itemService.getAllItems().size());

        verify(itemRepository).findAll();
    }
@Test
    public  void getItemByIdTest(){
        Integer id =22;
        List<ItemDto> list1 = new ArrayList<>();
        for (ItemDto itemDto : Arrays.asList(new ItemDto("name two", "description two", "img-url", 12.5))) {
            boolean add = list1.add(itemDto);

            when(itemRepository.findById(id)).equals(list1);
        assertEquals(false,itemService.getItemById(22).isPresent());
        verify(itemRepository).findById(id);
    }

}
}
