package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.media.Book;
import hust.soict.hedspi.store.Store;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfAuthors;

    public AddBookToStoreScreen(Store store) {
        super(store);

        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfCost = new JTextField();
        tfAuthors = new JTextField();

        addFormField("Title:", tfTitle);
        addFormField("Category:", tfCategory);
        addFormField("Cost:", tfCost);
        addFormField("Authors (comma separated):", tfAuthors);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                float cost;

                try {
                    cost = Float.parseFloat(tfCost.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Cost must be a number.");
                    return;
                }

                String[] authorArr = tfAuthors.getText().split(",");
                ArrayList<String> authors = new ArrayList<>();
                for (String a : authorArr) {
                    authors.add(a.trim());
                }

                Book book = new Book(title, category, cost, authors);
                store.addMedia(book);

                JOptionPane.showMessageDialog(null, "Book added successfully!");
                dispose(); // Close window
            }
        });
    }
}
