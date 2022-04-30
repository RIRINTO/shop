package com.rinto.shop.service;

import com.rinto.shop.dto.ItemDTO;
import com.rinto.shop.dto.ItemSaveRequestDTO;
import com.rinto.shop.repository.ItemRepository;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ItemService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemDTO> getItemLists() {
        return itemRepository.findAll(Sort.by("id").descending())
                .stream()
                .map(ItemDTO::new)
                .collect(Collectors.toList());
    }

    public void save(@NotNull ItemSaveRequestDTO itemSaveRequestDTO) {
        itemRepository.save(itemSaveRequestDTO.toEntity());
    }
}
