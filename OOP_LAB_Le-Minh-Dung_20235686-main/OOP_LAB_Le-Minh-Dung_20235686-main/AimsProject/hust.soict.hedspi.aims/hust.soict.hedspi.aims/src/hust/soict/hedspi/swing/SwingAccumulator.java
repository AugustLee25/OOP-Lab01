package hust.soict.hedspi.swing;

import javax.swing.*;        // Swing components
import java.awt.*;            // Layout managers
import java.awt.event.*;      // Event classes

public class SwingAccumulator extends JFrame implements ActionListener {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2, 5, 5));

        cp.add(new JLabel("Enter an Integer:"));

        tfInput = new JTextField(10);
        cp.add(tfInput);

        cp.add(new JLabel("The Accumulated Sum is:"));

        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        tfInput.addActionListener(this);

        setTitle("Swing Accumulator");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int number = Integer.parseInt(tfInput.getText());
        sum += number;
        tfInput.setText("");
        tfOutput.setText(sum + "");
    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }
}
