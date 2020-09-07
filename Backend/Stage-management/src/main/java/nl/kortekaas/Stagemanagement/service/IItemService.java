package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Item;

import java.util.List;

public interface IItemService {

//    List<Item> getItems();
    Item getItemById(Long id);
    Item saveItem(Item newItem);
    String deleteItem(Long id);
    Item addItemToUser(Long id, Item newItem);
    void addPhoto();
    void addVideo();
}
