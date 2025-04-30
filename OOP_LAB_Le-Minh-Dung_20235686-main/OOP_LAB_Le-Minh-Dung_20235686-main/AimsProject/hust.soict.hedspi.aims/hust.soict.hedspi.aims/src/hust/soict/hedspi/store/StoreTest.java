package hust.soict.hedspi.store;

import hust.soict.hedspi.media.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        // Tạo cửa hàng mới
        Store store = new Store();

        // Tạo một số DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
            "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
            "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", 
            "Animation", 18.99f);

        // Test thêm DVD vào cửa hàng
        System.out.println("--- Testing addDVD ---");
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.displayStore();

        // Test thêm DVD khi cửa hàng đầy
        for (int i = 0; i < 100; i++) {
            store.addMedia(new DigitalVideoDisc("Test DVD " + i));
        }

        // Test xóa DVD
        System.out.println("\n--- Testing removeDVD ---");
        store.removeMedia(dvd2); // DVD có trong cửa hàng
        store.displayStore();

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Not Existed");
        store.removeMedia(dvd4); // DVD không có trong cửa hàng
    }
}