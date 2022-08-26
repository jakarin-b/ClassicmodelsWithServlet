package sit.int202.classicmodelweb.models;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cart <K,V extends CartItem>{
    private Map<K, V> map;
    public Cart() {
        this.map= new HashMap<>();
    }
    public double getTotalPrice() {
        return map.values().stream().mapToDouble(o -> o.getTotal()).sum();
    }

    public int countItem() {
        return map.size();
    }

    public int countPiece() {
        return map.values().stream().mapToInt(o -> o.getQuantity()).sum();
    }

    public Collection<V> getAllItem() {
        return Collections.unmodifiableCollection(map.values());
    }

    public void addItem(K key,V value) {
        V item = map.get(key);
        if(item == null) {
            map.put(key, value);
        } else {
            item.setQuantity(item.getQuantity() + value.getQuantity());
        }
    }
    public void removeEachItem(K key,V value) {
        V item = map.get(key);
        if(item == null || item.getQuantity() <= 1) {
            removeItem(key);
        } else {
            item.setQuantity(item.getQuantity()-1);
        }
    }

    public V removeItem(K key) {
        return map.remove(key);
    }
    public void clear() {
        map.clear();
    }
}
