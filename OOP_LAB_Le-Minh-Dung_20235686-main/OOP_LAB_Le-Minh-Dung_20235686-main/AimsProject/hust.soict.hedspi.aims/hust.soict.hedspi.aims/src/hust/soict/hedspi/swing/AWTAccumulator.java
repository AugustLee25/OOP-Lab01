package hust.soict.hedspi.swing;

import java.awt.*;       // AWT classes
import java.awt.event.*; // AWT Event classes

public class AWTAccumulator extends Frame implements ActionListener {
    private TextField tfInput;
    private TextField tfOutput; // Sửa lỗi ở đây: đúng TextField
    private int sum = 0;

    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2, 5, 5)); // 2 rows 2 columns grid

        add(new Label("Enter an Integer: "));

        tfInput = new TextField(10);
        add(tfInput);

        add(new Label("The Accumulated Sum is: "));

        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);

        tfInput.addActionListener(this); // Khi nhấn Enter thì gọi actionPerformed()

        setTitle("AWT Accumulator");
        setSize(400, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        int number = Integer.parseInt(tfInput.getText());
        sum += number;
        tfInput.setText("");                  // Clear input field
        tfOutput.setText(String.valueOf(sum)); // Update output field
    }

    public static void main(String[] args) {
        new AWTAccumulator();
    }
}
