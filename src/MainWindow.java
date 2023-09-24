import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private static int width = 600;
    private static int height = 600;
    private JPanel panel;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JSpinner spinner1;
    private JSlider slider1;
    private JButton button1;
    private JTextArea textArea2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JRadioButton fizRadio;
    private JRadioButton entRadio;
    private JCheckBox inforBox;
    private JCheckBox finBox;
    private JTextField textField3;
    private JLabel label9;

    public MainWindow() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(MainWindow.width, MainWindow.height);
        this.setLocation(d.width / 2 - MainWindow.width / 2, d.height / 2 - MainWindow.height / 2);
        this.getContentPane().add(panel);

        button1.addActionListener(new MyButtonListener());

        spinner1.setValue(20);
        spinner1.addChangeListener(new SpinnerChangeListener());

    }

    private class SpinnerChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            JSpinner sp = (JSpinner) e.getSource();
            int age = Math.min(100, Math.max(20, (int) sp.getValue()));
            sp.setValue(age);
        }
    }

    private class MyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String message = "<html><body>";
            message += label1.getText() + ": " + textField1.getText() + "<br>";
            message += label2.getText() + ": " + textField2.getText() + "<br>";
            message += label9.getText() + ": " + textField3.getText() + "<br>";
            message += label3.getText() + ": " + comboBox1.getItemAt(comboBox1.getSelectedIndex()) + "<br>";
            message += label4.getText() + ": " + String.valueOf(spinner1.getValue()) + "<br>";

            String fiz = "";
            fiz = fizRadio.isSelected() ? fizRadio.getText() : "";
            fiz = entRadio.isSelected() ? entRadio.getText() : "";
            message += label5.getText() + ": " + fiz + "<br>";

            String act = "";
            if (inforBox.isSelected()) {
                act += inforBox.getText();
            }
            if (finBox.isSelected()) {
                if (act.length() != 0) {
                    act += ", ";
                }
                act += finBox.getText();
            }
            message += label6.getText() + ": " + act + "<br>";

            message += label7.getText() + ": " + String.valueOf(slider1.getValue()) + "<br>";
            message += label8.getText() + ": " + textArea2.getText() + "<br>";

            message += "</body></html>";

            JOptionPane.showMessageDialog(null, message, "Регистрация", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
