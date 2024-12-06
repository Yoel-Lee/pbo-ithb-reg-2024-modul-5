package View;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    
    private JFrame frame;

    public MainMenu() {

        showMainMenu();

    }

    public void showMainMenu() {

        Toolkit toolkit = Toolkit.getDefaultToolkit(); // INIT TOOLKIT
        Dimension screenSize = toolkit.getScreenSize(); // GET MY SCREEN SIZE

        int screenWidth = screenSize.width; // GET PIXELS FOR WIDTH
        int screenHeight = screenSize.height; // GET PIXELS FOR HEIGHT

        final int FRAME_WIDTH = 400; // SET WIDTH
        final int FRAME_HEIGHT = 500; // SET WEIGHT

        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2); // SET START LOCATION FOR X
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2); // SET START LOCATION FOR Y
        
        frame = new JFrame("Main Menu");
        frame.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT); // SET FRAME BOUND
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);


        JLabel title2 = new JLabel("E-KTP");
        title2.setBounds(155, 50, 120, 50);
        title2.setFont(new Font("SansSerif", Font.BOLD, 24));
        panel.add(title2);

        JButton perekamanBtn = new JButton("INSERT");
        perekamanBtn.setBounds(120, 130, 140, 50);
        panel.add(perekamanBtn);

        perekamanBtn.addActionListener(e -> {
            frame.dispose();
            new FormInputData(1, null);
        });

        JButton pencarianBtn = new JButton("SEARCH KTP");
        pencarianBtn.setBounds(120, 200, 140, 50);
        panel.add(pencarianBtn);

        pencarianBtn.addActionListener(e -> {
            frame.dispose();
            new FormPencarianData();
        });

        JButton exitBtn = new JButton("EXIT");
        exitBtn.setBounds(120, 270, 140, 50);
        panel.add(exitBtn);

        exitBtn.addActionListener(e -> {
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);

    }

}
