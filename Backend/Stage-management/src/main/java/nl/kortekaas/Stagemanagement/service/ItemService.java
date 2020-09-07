package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.model.Item;
import nl.kortekaas.Stagemanagement.model.User;
import nl.kortekaas.Stagemanagement.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


//    @PreAuthorize("hasRole('STAGEMANAGER') or hasRole('DEPUTY') or hasRole('ASSISTANT') or hasRole('PROPS')")
//    @Override
//    public List<Item> getItems() {
//        List<Item> itemList = itemRepository.findAll();
//        return itemList;
//    }

    @Override
    public Item getItemById(Long id) {

        Optional<Item> _item = itemRepository.findById(id);

        if(_item.isPresent()) {
            Item item = _item.get();
            item.getNotes(); //NICK OM van Lazy Eager te maken
            return item;
        }
        throw new RuntimeException(ITEM_NOT_FOUND_ERROR);

    }

    @Override
    public Item saveItem(Item newItem) {
        return itemRepository.save(newItem);
    }

    @Override
    public String deleteItem(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            itemRepository.deleteById(id);
            return "Item with id " + item.get().getItemId() + " is deleted.";
        }
        throw new RuntimeException(ITEM_NOT_FOUND_ERROR);
    }

    @Override
    public Item addItemToUser(Long id, Item newItem) {

        Optional<User> user =
                userRepository.findById(id);
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
