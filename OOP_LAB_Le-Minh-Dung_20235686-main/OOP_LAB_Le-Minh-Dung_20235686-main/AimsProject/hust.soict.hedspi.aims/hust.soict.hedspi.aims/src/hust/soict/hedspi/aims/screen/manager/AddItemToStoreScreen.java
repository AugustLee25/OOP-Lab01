package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JPanel formPanel;
    protected JButton btnAdd;

    public AddItemToStoreScreen(Store store) {
        this.store = store;

        setTitle("Add Item To Store");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 2, 5, 5)); // Dynamic rows, 2 columns
        cp.add(formPanel, BorderLayout.CENTER);

        btnAdd = new JButton("Add to Store");
        cp.add(btnAdd, BorderLayout.SOUTH);

        setVisible(true);
    }

    protected void addFormField(String label, JComponent inputField) {
        formPanel.add(new JLabel(label));
        formPanel.add(inputField);
    }
}
