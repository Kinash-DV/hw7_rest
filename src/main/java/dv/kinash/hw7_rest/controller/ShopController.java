package dv.kinash.hw7_rest.controller;

import dv.kinash.hw7_rest.model.Shop;
import dv.kinash.hw7_rest.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopController {
    @Autowired
    private ShopService service;

    @GetMapping(value = {"", "/", "/list"})
    @ResponseStatus(HttpStatus.OK)
    public List<Shop> getList(){
        return service.getList();
    }

    @PostMapping(value = {"/", "/add"})
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Shop newShop){
        service.add(newShop);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Shop> getById(@PathVariable("id") Integer id){
        Shop foundShop = service.getById(id);
        if (foundShop == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(foundShop, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public ResponseEntity deleteById(@PathVariable("id") Integer id){
        if (! service.deleteById(id))
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = {"/{id}", "/update/{id}"}, method = {RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.POST})
    public ResponseEntity<Shop> updateById(@PathVariable("id") Integer id, @RequestBody Shop shop){
        Shop updatedShop = service.updateById(id, shop);
        if (updatedShop == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedShop, HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        if (service.getList().size() > 0)
            return new ResponseEntity<>("Base already has data!", HttpStatus.METHOD_NOT_ALLOWED);
        service.add(new Shop("All for home", "Kyiv", "Khreshchatyk 13", 5, true));
        return new ResponseEntity<>("Added test data!", HttpStatus.OK);
    }

}
