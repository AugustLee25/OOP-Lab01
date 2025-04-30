package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.media.Media;
import hust.soict.hedspi.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(String.format("%.2f $", media.getCost()));
        cost.setAlignmentX(CENTER_ALIGNMENT);

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.setAlignmentX(CENTER_ALIGNMENT);
            playButton.addActionListener(e -> {
                JDialog dialog = new JDialog();
                dialog.setTitle("Now Playing...");
                JTextArea ta = new JTextArea(((Playable) media).play());
                ta.setEditable(false);
                ta.setLineWrap(true);
                ta.setWrapStyleWord(true);
                dialog.add(new JScrollPane(ta));
                dialog.setSize(300, 200);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            });
            this.add(playButton);
        }
    }
}
