package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    //id, item 을 저장하는 저장소
    private static final Map<Long, Item> store = new HashMap<>(); //static
    private static long sequence = 0L; //static, item 갯수

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(long itemId, Item updateParam) {
        Item findItem = findById(itemId); // 변경할 item 을 찾음
        findItem.setItemName(updateParam.getItemName()); // item 의 name 변경
        findItem.setPrice(updateParam.getPrice()); // item 의 price 변경
        findItem.setQuantity(updateParam.getQuantity()); // item 의 quantity 변경
    }

    public void clearStore() {
        store.clear();
    }
}
