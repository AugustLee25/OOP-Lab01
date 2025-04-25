package hust.soict.hedspi.media;

import java.util.ArrayList;

import hust.soict.hedspi.cart.Cart;
import hust.soict.hedspi.store.Store;

public class Aims {
    public static void main(String[] args) {
        // Tạo store và cart
        Store store = new Store();
        Cart cart = new Cart();
        
        // Tạo các media
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
            "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
            "Science Fiction", "George Lucas", 87, 24.95f);
        
        ArrayList<String> authors = new ArrayList<>();
        authors.add("J.K. Rowling");
        Book book = new Book("Harry Potter", "Fantasy", 29.99f, authors);
        
        CompactDisc cd = new CompactDisc("Thriller", "Pop", "Michael Jackson", 
                                      "Quincy Jones", 15.99f);
        cd.addTrack(new Track("Billie Jean", 300));
        cd.addTrack(new Track("Beat It", 250));
        
        // Thêm vào store
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book);
        store.addMedia(cd);
        
        // Thêm vào cart
        cart.addMedia(dvd1);
        cart.addMedia(cd);
        
        // Test các chức năng
        store.displayStore();
        cart.print();
        
        System.out.println("\nTesting play functionality:");
        cart.playMedia(cd);
        cart.playMedia(dvd1);
        cart.playMedia(book);
        
        System.out.println("\nSearching for 'Star Wars':");
        Media found = store.searchByTitle("Star Wars");
        if (found != null) {
            System.out.println("Found: " + found.toString());
        }
    }
}