package nl.kortekaas.Stagemanagement.controller;

import nl.kortekaas.Stagemanagement.domain.Item;
import nl.kortekaas.Stagemanagement.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private IItemService itemService;

    @GetMapping(value = "/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteItem(@PathVariable Long id) {
        return itemService.deleteItem(id);
    }

    @PostMapping(value = "/{userid}")
    public Item addItemToUserById(@PathVariable long userid,
                                @RequestBody Item newItem) {
        return itemService.saveItem(newItem);
    }

}
