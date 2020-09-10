package nl.kortekaas.Stagemanagement.service;


import nl.kortekaas.Stagemanagement.model.Item;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IItemService {

    List<Item> getItems();
    Item getItemByName(String itemName);
    Item saveItem(Item newItem);
    String deleteItem(String itemName);
    Item addItemToUserByUsername(String username, Item newItem);

    void addPhoto();
    void addVideo();
}
