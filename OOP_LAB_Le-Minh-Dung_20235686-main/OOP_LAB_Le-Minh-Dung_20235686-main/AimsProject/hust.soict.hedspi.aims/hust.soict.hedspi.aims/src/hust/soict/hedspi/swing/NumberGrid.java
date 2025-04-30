package hust.soict.hedspi.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        tfDisplay = new JTextField();
        tfDisplay.setEditable(false);
        tfDisplay.setHorizontalAlignment(JTextField.RIGHT);
        add(tfDisplay, BorderLayout.NORTH);

        JPanel panelButtons = new JPanel(new GridLayout(4, 4, 5, 5));
        addButtons(panelButtons);
        add(panelButtons, BorderLayout.CENTER);

        setTitle("Number Grid");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addButtons(JPanel panel) {
        ButtonListener btnListener = new ButtonListener();

        // Add buttons 1–9
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            panel.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }

        // Add DEL and C
        btnDelete = new JButton("DEL");
        btnReset = new JButton("C");
        panel.add(btnDelete);
        panel.add(btnReset);
        btnDelete.addActionListener(btnListener);
        btnReset.addActionListener(btnListener);

        // Add button 0
        btnNumbers[0] = new JButton("0");
        panel.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String btnLabel = e.getActionCommand();
            String currentText = tfDisplay.getText();

            switch (btnLabel) {
                case "DEL":
                    if (currentText.length() > 0) {
                        tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
                    }
                    break;
                case "C":
                    tfDisplay.setText("");
                    break;
                default: // 0–9
                    tfDisplay.setText(currentText + btnLabel);
            }
        }
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
}
