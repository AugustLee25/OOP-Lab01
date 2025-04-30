package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.media.CompactDisc;
import hust.soict.hedspi.media.Track;
import hust.soict.hedspi.store.Store;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfArtist;
    private JTextField tfDirector;
    private JTextArea taTracks;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);

        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfCost = new JTextField();
        tfArtist = new JTextField();
        tfDirector = new JTextField();
        taTracks = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(taTracks);

        addFormField("Title:", tfTitle);
        addFormField("Category:", tfCategory);
        addFormField("Cost:", tfCost);
        addFormField("Artist:", tfArtist);
        addFormField("Director:", tfDirector);
        addFormField("Tracks (format: Name - Length per line):", scrollPane);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String title = tfTitle.getText();
                    String category = tfCategory.getText();
                    float cost = Float.parseFloat(tfCost.getText());
                    String artist = tfArtist.getText();
                    String director = tfDirector.getText();

                    CompactDisc cd = new CompactDisc(title, category, artist, director, cost);

                    String[] lines = taTracks.getText().split("\\n");
                    for (String line : lines) {
                        String[] parts = line.split("-");
                        if (parts.length == 2) {
                            String trackTitle = parts[0].trim();
                            int trackLength = Integer.parseInt(parts[1].trim());
                            cd.addTrack(new Track(trackTitle, trackLength));
                        }
                    }

                    store.addMedia(cd);
                    JOptionPane.showMessageDialog(null, "CD added successfully!");
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid cost or track length.");
                }
            }
        });
    }
}
