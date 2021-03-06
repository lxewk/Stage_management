package nl.kortekaas.Stagemanagement.service;


import nl.kortekaas.Stagemanagement.model.Item;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IItemService {

    List<Item> getAllItems();
    Item getItemByName(String itemName);
    Item saveItem(Item newItem);
    String deleteItem(String itemName);

    void addPhoto();
    void addVideo();
}
