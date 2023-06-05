package uniandes.dpoo.project1.interface1.panels;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanel extends JPanel implements ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JTextField nameField;
    JTextField emailField;
    JTextField phoneField;
    JButton capture_button;

    String userName, userMail, userPhone;

    public UserPanel() {
        this.setBackground(Color.BLACK);
        this.setForeground(Color.CYAN);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Change layout manager to BoxLayout with Y_AXIS
        this.setBounds(100, 355, 220, 190);
        
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.CYAN);
        nameLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
        nameField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.CYAN);
        emailLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
        emailField = new JTextField();

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setForeground(Color.CYAN);
        phoneLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
        phoneField = new JTextField();

        capture_button = new JButton("Submit");
     // Set preferred size
        capture_button.setPreferredSize(new Dimension(80, 20));

        // Adjust font size
        capture_button.setFont(capture_button.getFont().deriveFont(Font.PLAIN, 10));
        capture_button.setBorder(new EmptyBorder(0,4,0,4));
        capture_button.addActionListener(this);

        this.add(nameLabel);
        this.add(nameField);
        this.add(emailLabel);
        this.add(emailField);
        this.add(phoneLabel);
        this.add(phoneField);
        this.add(capture_button);
        
        Border outerBorder = BorderFactory.createLineBorder(Color.CYAN, 2);
        Border innerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border compoundBorder = BorderFactory.createCompoundBorder(outerBorder, innerBorder);
        this.setBorder(compoundBorder);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == capture_button) {
            userName = nameField.getText();
            userMail = emailField.getText();
            userPhone = phoneField.getText();
        }
    }

    public String getName() {
        return userName;
    }

    public String getMail() {
        return userMail;
    }

    public String getPhone() {
        return userPhone;
    }
}
