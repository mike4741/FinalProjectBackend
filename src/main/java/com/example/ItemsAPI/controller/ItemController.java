package com.example.ItemsAPI.controller;

import com.example.ItemsAPI.controller.dto.ItemDto;
import com.example.ItemsAPI.entity.Item;
import com.example.ItemsAPI.service.ItemServiceImpl;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("api/items")
public class ItemController {

    @Autowired
    private final ItemServiceImpl itemService ;

    public ItemController(ItemServiceImpl itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public Iterable<Item> getItems(){
        return  itemService.getAllItems();
    }


    @GetMapping("/{id}")
    public Optional<Item> getItems(@PathVariable Integer id){
        return  itemService.getItemById(id);
    }

    @PostMapping
    public Item save( @RequestBody ItemDto itemDto )
    {
      return itemService.addItems(new Item(itemDto));
    }

    @DeleteMapping(path = "{id}")
    public void  removeItem(@PathVariable ("id")Integer id){
        itemService.deleteItem(id);
    }

    @PutMapping(path = "{id}")
    public  void updateItem(@PathVariable("id") Integer id ,
                            @RequestParam(required = false) String name ,
                            @RequestParam(required = false) String description ,
                            @RequestParam(required = false) String imageUrl){
              itemService.updateItem(id,"test","description","imageUrl");

    }


}
