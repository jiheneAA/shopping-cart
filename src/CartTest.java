import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void addItem_shouldAddNewItemToItems() {
        Cart cart = new Cart();
        Item newItem = new Item("Test", 1, 1.0);
        cart.addItem(newItem);
        assertEquals(List.of(newItem), cart.getItems());
    }
    @Test
    void removeItem_shouldRemoveItemFromItems() {
        List<Item> items = new ArrayList<>();
        Item item = new Item("Test", 1, 1.0);
        items.add(item);
        Cart cart = new Cart(items);
        cart.removeItem("Test");
        assertEquals(Collections.emptyList(), cart.getItems());
    }

    @Test
    void computeTotalPrice_shouldComputeTotalPrice() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("Test", 1, 15.0);
        Item item2 = new Item("Test2", 5, 2.5);
        items.add(item1);
        items.add(item2);
        Cart cart = new Cart(items);
        Optional<Double> totalPrice = cart.computeTotalPrice();
        assertEquals(Optional.of(27.5), totalPrice);
    }
}