package hust.soict.hedspi.cart;

import hust.soict.hedspi.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();
        
        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
            "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);
        
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
            "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
            "Animation", 18.99f);
        cart.addMedia(dvd3);

        // Test the print method
        System.out.println("\n--- Testing print cart ---");
        cart.print();

        // Test search by ID
        System.out.println("\n--- Testing search by ID ---");
        cart.searchById(1);  // Existing ID
        cart.searchById(99); // Non-existing ID

        // Test search by title
        System.out.println("\n--- Testing search by title ---");
        cart.searchByTitle("lion");   // Partial match
        cart.searchByTitle("Star");   // Partial match
        cart.searchByTitle("Aladin"); // Exact match
        cart.searchByTitle("Harry");  // No match
    }
}