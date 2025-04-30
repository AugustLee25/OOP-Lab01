package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.media.DigitalVideoDisc;
import hust.soict.hedspi.store.Store;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);

        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfCost = new JTextField();
        tfDirector = new JTextField();
        tfLength = new JTextField();

        addFormField("Title:", tfTitle);
        addFormField("Category:", tfCategory);
        addFormField("Cost:", tfCost);
        addFormField("Director:", tfDirector);
        addFormField("Length (minutes):", tfLength);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String title = tfTitle.getText();
                    String category = tfCategory.getText();
                    float cost = Float.parseFloat(tfCost.getText());
                    String director = tfDirector.getText();
                    int length = Integer.parseInt(tfLength.getText());

                    DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                    store.addMedia(dvd);

                    JOptionPane.showMessageDialog(null, "DVD added successfully!");
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric values for Cost and Length.");
                }
            }
        });
    }
}
