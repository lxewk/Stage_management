package nl.kortekaas.Stagemanagement.service;


import nl.kortekaas.Stagemanagement.model.Item;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IItemService {

    List<Item> getItems();
    Item getItemById(Long id);
    Item saveItem(Item newItem);
    String deleteItem(Long id);
    Item addItemToUserByUsername(String username, Item newItem);
//    Item addItemToUser(Long id, Item newItem);
    void addPhoto();
    void addVideo();
}
