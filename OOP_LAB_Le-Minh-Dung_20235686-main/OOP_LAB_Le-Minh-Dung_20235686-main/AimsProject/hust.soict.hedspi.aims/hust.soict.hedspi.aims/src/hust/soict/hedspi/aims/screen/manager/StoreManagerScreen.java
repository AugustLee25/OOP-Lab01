package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.store.Store;
import hust.soict.hedspi.media.Media;

import javax.swing.*;
import java.awt.*;

public class StoreManagerScreen extends JFrame {
    private Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store Manager");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

        JMenuBar menuBar = createMenuBar();
        north.add(menuBar);

        JLabel title = new JLabel("AIMS", SwingConstants.CENTER);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        north.add(title);

        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");	

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addDVD = new JMenuItem("Add DVD");
        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(e -> {
            dispose();
            new StoreManagerScreen(store);
        });
        // Gắn hành động khi click vào menu
        addBook.addActionListener(e -> new AddBookToStoreScreen(store));
        addDVD.addActionListener(e -> new AddDigitalVideoDiscToStoreScreen(store));
        addCD.addActionListener(e -> new AddCompactDiscToStoreScreen(store));

        
        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        for (Media media : store.getItemsInStore()) {
            MediaStore cell = new MediaStore(media);
            center.add(cell);
        }

        return center;
    }

    public static void main(String[] args) {
        Store store = new Store();
        // Add media to store here (dummy data)
        new StoreManagerScreen(store);
    }
}
