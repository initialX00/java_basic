package chapter10.practice2.repository;

import chapter10.practice2.entity.Item;

import java.util.HashSet;
import java.util.Set;

public class InMemoryItemRepository implements ItemRepository {

    private Set<Item> items = new HashSet<>();

    //인터페이스를 받는 오버라이딩는 alt + shift + enter로 자동완성
    @Override
    public void addItem(Item item) {
        items.add(item); //Set컬렉션으로 저장되기에 중복 신경 쓸 필요없음
    }

    @Override
    public void removeItem(String itemId) {
        Item target = null;

        for(Item item : items){
            if(item.getId().equals(itemId)){
                target = item;
                break;
            }
        }
        if(target != null) {
            items.remove(target);
        }
    }

    @Override
    public Item findById(String itemId) {
        for(Item item : items){
            if(item.getId().equals(itemId)){
                return item;
            }
        }
        return null;
    }

    @Override
    public Set<Item> findAll() {
        return new HashSet<>(items); //Set에서 HashSet으로 다운캐스팅
    }

}
