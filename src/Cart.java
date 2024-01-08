import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {

    private List<Item> items = new ArrayList<>();

    public Cart() {
    }

    public Cart(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(String itemName) {
        items
                .stream()
                .filter(item -> item.getName().equals(itemName))
                .findFirst()
                .ifPresent(item -> this.items.remove(item));
    }

    public Optional<Double> computeTotalPrice() {
        return items.stream()
                .map(item -> item.getPrice() * item.getQuantity())
                .reduce(Double::sum);
    }
}
