public class Main {
    public static void main(String[] args) {

        Cart cart = new Cart();

        Item item1 = new Item("Table", 1, 150.0);
        Item item2 = new Item("Stylo", 5, 2.5);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.removeItem("Stylo");

        cart.addItem(new Item("Ecouteur", 2, 27.99));

        System.out.println(cart.computeTotalPrice());
    }
}