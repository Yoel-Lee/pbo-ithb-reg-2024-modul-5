package View;

import javax.swing.*;

import Controller.DBController;

import java.awt.*;

public class FormPencarianData {
    
    public FormPencarianData() {
        showSearchForm();
    }

    public void showSearchForm() {

        Toolkit toolkit = Toolkit.getDefaultToolkit(); // INIT TOOLKIT
        Dimension screenSize = toolkit.getScreenSize(); // GET MY SCREEN SIZE

        int screenWidth = screenSize.width; // GET PIXELS FOR WIDTH
        int screenHeight = screenSize.height; // GET PIXELS FOR HEIGHT

        final int FRAME_WIDTH = 500; // SET WIDTH
        final int FRAME_HEIGHT = 250; // SET WEIGHT

        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2); // SET START LOCATION FOR X
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2); // SET START LOCATION FOR Y
        
        JFrame frame = new JFrame("Cetak KTP");
        frame.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT); // SET FRAME BOUND
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        JLabel keyLabel = new JLabel("Masukkan NIK : ");
        keyLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        keyLabel.setBounds(10, 10, 120, 20);
        panel.add(keyLabel);

        JTextField keyField = new JTextField();
        keyField.setBounds(130, 10, 240, 25);
        panel.add(keyField);

        JButton searchButton = new JButton("SEARCH");
        searchButton.setBounds(150, 50, 90, 30);
        panel.add(searchButton);

        searchButton.addActionListener(e -> {

            if (!keyField.getText().isEmpty()) {
                
                
                if (DBController.getKTP(keyField.getText()) != null) {
                    
                    frame.dispose();
                    new FormInputData(2, DBController.getKTP(keyField.getText()));

                }
                else {

                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan!", "Notifikasi", JOptionPane.INFORMATION_MESSAGE);

                }

            }
            else {

                JOptionPane.showMessageDialog(null, "Field Harus Diisi!", "Error", JOptionPane.ERROR_MESSAGE);

            }

        });

        JButton mainMenuButton = new JButton("MAIN MENU");
        mainMenuButton.setBounds(20, 50, 140, 30);
        panel.add(mainMenuButton);

        mainMenuButton.addActionListener(e -> {
            frame.dispose();
            new MainMenu();
        });

        frame.add(panel);
        frame.setVisible(true);

    }

}