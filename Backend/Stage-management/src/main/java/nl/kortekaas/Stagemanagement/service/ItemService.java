package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Item;
import nl.kortekaas.Stagemanagement.domain.Risk;
import nl.kortekaas.Stagemanagement.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements IItemService {

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
    public List<Item> getItem() {
        List<Item> itemList = itemRepository.findAll();
        return itemList;
    }
}
