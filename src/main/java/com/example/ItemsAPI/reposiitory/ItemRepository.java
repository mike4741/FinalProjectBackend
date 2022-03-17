package com.example.ItemsAPI.reposiitory;

import com.example.ItemsAPI.entity.Item;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {

}
