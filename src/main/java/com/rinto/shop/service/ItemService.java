package com.rinto.shop.service;

import com.rinto.shop.dto.ItemChangeRequestDTO;
import com.rinto.shop.dto.ItemDTO;
import com.rinto.shop.dto.ItemSaveRequestDTO;
import com.rinto.shop.entity.Item;
import com.rinto.shop.repository.ItemRepository;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static com.rinto.shop.entity.extend.Item.update;

@Service
public class ItemService {
    private final Logger log = LoggerFactory.getLogger(getClass());
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
        log.info("save 성공");
    }

    public ItemDTO getItem(int itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(
                () -> {
                    throw new IllegalArgumentException("해당 id 없음");
                }
        );
        return new ItemDTO(item);
    }

    @Transactional
    public void editItem(int itemId, @NotNull ItemChangeRequestDTO itemChangeRequestDTO) {
        Item item = itemRepository.findById(itemId).orElseThrow(
                () -> {
                    throw new IllegalArgumentException("해당 id 없음");
                }
        );

        update(item, itemChangeRequestDTO);
    }
}