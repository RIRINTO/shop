package com.rinto.shop.service;

import com.rinto.shop.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
}
