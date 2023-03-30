package dv.kinash.hw7_rest.service;

import dv.kinash.hw7_rest.model.Shop;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopService {
    private Map<Integer, Shop> data = new HashMap<>();
    public ShopService() {
    }

    public Shop getById(Integer id){
        return data.get(id);
    }
    public List<Shop> getList(){
        return data.values().stream().toList();
    }
    public Shop add(Shop shop){
        Integer newId = getNewId();
        shop.setId(newId);
        data.put(newId, shop);
        return shop;
    }
    public Shop updateById(Integer id, Shop shop){
        if (data.get(id) == null)
            return null;
        shop.setId(id);
        data.put(id, shop);
        return shop;
    }
    public Boolean deleteById(Integer id){
        if (data.containsKey(id)) {
            data.remove(id);
            return true;
        }
        return false;
    }

    private Integer getNewId(){
        if (data.size() == 0)
            return 1;
        return data.values().stream().map(Shop::getId).max(Integer::compareTo).get() + 1;
    }
}
