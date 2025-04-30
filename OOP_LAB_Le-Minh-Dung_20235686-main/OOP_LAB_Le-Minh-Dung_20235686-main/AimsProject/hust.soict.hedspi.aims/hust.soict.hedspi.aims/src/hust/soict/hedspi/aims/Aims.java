package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.hedspi.cart.Cart;
import hust.soict.hedspi.media.Book;
import hust.soict.hedspi.media.CompactDisc;
import hust.soict.hedspi.media.DigitalVideoDisc;
import hust.soict.hedspi.media.Media;
import hust.soict.hedspi.media.Playable;
import hust.soict.hedspi.media.Track;
import hust.soict.hedspi.store.Store;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Khởi tạo một số media mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        ArrayList<String> authors = new ArrayList<>();
        authors.add("J.K. Rowling");
        Book book = new Book("Harry Potter", "Fantasy", 29.99f, authors);
        CompactDisc cd = new CompactDisc("Thriller", "Pop", "Michael Jackson", "Quincy Jones", 15.99f);
        cd.addTrack(new Track("Billie Jean", 300));
        cd.addTrack(new Track("Beat It", 250));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book);
        store.addMedia(cd);

        showMenu();
    }

    public static void showMenu() {
        while (true) {
            System.out.println("AIMS:");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");

            int choice = getUserChoice(0, 3);
            switch (choice) {
                case 1 -> storeMenu();
                case 2 -> updateStore();
                case 3 -> cart.print();
                case 0 -> {
                    System.out.println("Exiting AIMS. Goodbye!");
                    scanner.close();
                    System.exit(0);
                }
            }
        }
    }

    public static void storeMenu() {
        while (true) {
            store.displayStore();
            System.out.println("Options:");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");

            int choice = getUserChoice(0, 4);
            switch (choice) {
                case 1 -> seeMediaDetails();
                case 2 -> addMediaToCart();
                case 3 -> playMedia();
                case 4 -> cart.print();
                case 0 -> { return; }
            }
        }
    }

    private static void updateStore() {
        System.out.println("Update store:");
        System.out.println("1. Add a media");
        System.out.println("2. Remove a media");
        System.out.println("0. Back");
        System.out.println("Please choose a number: 0-1-2");

        int choice = getUserChoice(0, 2);
        switch (choice) {
            case 1 -> addMediaToStore();
            case 2 -> removeMediaFromStore();
            case 0 -> { return; }
        }
    }

    private static void addMediaToStore() {
        System.out.println("Enter media type (1: DVD, 2: CD, 3: Book):");
        int type = getUserChoice(1, 3);

        System.out.println("Enter title:");
        String title = scanner.nextLine();
        System.out.println("Enter category:");
        String category = scanner.nextLine();
        System.out.println("Enter cost:");
        float cost = Float.parseFloat(scanner.nextLine());

        Media media = null;
        switch (type) {
            case 1 -> {
                System.out.println("Enter director:");
                String director = scanner.nextLine();
                System.out.println("Enter length:");
                int length = Integer.parseInt(scanner.nextLine());
                media = new DigitalVideoDisc(title, category, director, length, cost);
            }
            case 2 -> {
                System.out.println("Enter artist:");
                String artist = scanner.nextLine();
                System.out.println("Enter director:");
                String director = scanner.nextLine();
                media = new CompactDisc(title, category, artist, director, cost);
            }
            case 3 -> {
                ArrayList<String> authors = new ArrayList<>();
                System.out.println("Enter authors (type 'done' to finish):");
                while (true) {
                    String author = scanner.nextLine();
                    if (author.equalsIgnoreCase("done")) break;
                    authors.add(author);
                }
                media = new Book(title, category, cost, authors);
            }
        }

        if (media != null) {
            store.addMedia(media);
        }
    }

    private static void removeMediaFromStore() {
        System.out.println("Enter the title of the media to remove:");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            store.removeMedia(media);
        } else {
            System.out.println("Media not found in store.");
        }
    }

    private static void seeMediaDetails() {
        System.out.println("Enter the title of the media to see details:");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            System.out.println(media);
        } else {
            System.out.println("Media not found in store.");
        }
    }

    private static void addMediaToCart() {
        System.out.println("Enter the title of the media to add to cart:");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            cart.addMedia(media);
        } else {
            System.out.println("Media not found in store.");
        }
    }

    private static void playMedia() {
        System.out.println("Enter the title of the media to play:");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            if (media instanceof Playable playable) {
                playable.play();
            } else {
                System.out.println("This media cannot be played.");
            }
        } else {
            System.out.println("Media not found in store.");
        }
    }

    private static int getUserChoice(int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max) {
                    return choice;
                }
                System.out.println("Please enter a number between " + min + " and " + max + ":");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ":");
            }
        }
    }
}