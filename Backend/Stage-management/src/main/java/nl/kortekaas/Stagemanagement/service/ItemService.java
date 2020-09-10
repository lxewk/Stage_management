package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.model.Item;
import nl.kortekaas.Stagemanagement.model.User;
import nl.kortekaas.Stagemanagement.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements IItemService {

    private static final String ITEM_NOT_FOUND_ERROR = "Error: Item is not found.";

    private ItemRepository itemRepository;
    private RiskRepository riskRepository;
    private UserRepository userRepository;


    @Autowired
    public void setUserRepository(UserRepository userRepository) { this.userRepository = userRepository; }

    @Autowired
    public void setRiskRepository(RiskRepository riskRepository) { this.riskRepository = riskRepository; }

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) { this.itemRepository = itemRepository; }


    @PreAuthorize("hasRole('STAGEMANAGER') or hasRole('DEPUTY') or hasRole('ASSISTANT') or hasRole('PROPS')")
    @Override
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemByName(String itemName) {

        Optional<Item> _item = itemRepository.findByItemName(itemName);

        if(_item.isPresent()) {
            Item item = _item.get();
            item.getNotes().size();
            return item;
        }
        throw new RuntimeException(ITEM_NOT_FOUND_ERROR);

    }

    @Override
    public Item saveItem(Item newItem) {
        return itemRepository.save(newItem);
    }

    @Override
    public String deleteItem(String itemName) {
        Optional<Item> _item = itemRepository.findByItemName(itemName);
        if (_item.isPresent()) {
            Item item = _item.get();
            itemRepository.delete(item);
            return "Item " + itemName + " is deleted.";
        }
        throw new RuntimeException(ITEM_NOT_FOUND_ERROR);
    }

    @Override
    public Item addItemToUserByUsername(String username, Item newItem) {

        Optional<User> user =
                userRepository.findByUsername(username);
        if(user.isPresent()) {
            newItem.setCreator(user.get());
            return itemRepository.save(newItem);
        }
        return null;
    }

    public void addPhoto(){
        System.out.println("here should be a picture");
    }

    public void addVideo(){
        System.out.println("here should be a video");
    }
}
