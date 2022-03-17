package com.example.ItemsAPI.service;

import com.example.ItemsAPI.entity.Item;
import com.example.ItemsAPI.reposiitory.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@Transactional
public class ItemServiceImpl implements  ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems(){
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public Optional<Item> getItemById(Integer id){

       return itemRepository.findById(id);
    }


    @Override
    public Item addItems(Item item){

        return  itemRepository.save(item);
//        return null;
    }


    @Override
    public  void  deleteItem(Integer id){

        if(!itemRepository.existsById(id)){
            throw  new IllegalStateException("item with"+id+" not found");
        }
        itemRepository.deleteById(id);

        }

    @Override
    public  void updateItem(Integer id , String name, String description , String imageUrl){
        Item oldItem = itemRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Item not found"));
        if(!Objects.equals(oldItem.getName(),name)){
            oldItem.setName(name);
        }
        if(!Objects.equals(oldItem.getImageUrl(),imageUrl)){
            oldItem.setName(imageUrl);
        }

        if(!Objects.equals(oldItem.getDescription(),imageUrl)){
            oldItem.setName(description);
        }

    }



}
