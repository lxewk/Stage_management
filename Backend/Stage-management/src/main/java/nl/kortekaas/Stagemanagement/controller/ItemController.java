package nl.kortekaas.Stagemanagement.controller;

import nl.kortekaas.Stagemanagement.model.Item;
import nl.kortekaas.Stagemanagement.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private IItemService itemService;

    @GetMapping(value = "/{itemName}")
    public Item getItemByName(@PathVariable String itemName) {
        return itemService.getItemByName(itemName);
    }

    @DeleteMapping(value = "/{itemName}")
    public String deleteItem(@PathVariable String itemName) {
        return itemService.deleteItem(itemName);
    }

    @PostMapping(value = "/{username}")
    public Item addItemToUserByUsername(@PathVariable String username,
                                  @RequestBody Item newItem) {
        return itemService.saveItem(newItem);
    }

}
