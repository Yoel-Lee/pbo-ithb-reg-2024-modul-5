package View;
import javax.swing.*;
import java.awt.*;

public class MainMenu {
    public MainMenu(){
        showMenu();
    }
    
    public void showMenu(){
        
        Toolkit toolkit = Toolkit.getDefaultToolkit(); // INIT TOOLKIT
        Dimension screenSize = toolkit.getScreenSize(); // GET MY SCREEN SIZE


        JFrame mainMenu= new JFrame("Main Menu");
        mainMenu.setLayout(null);
        mainMenu.setSize(400, 300);
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int x = (screenSize.width - mainMenu.getWidth()) / 2;  // Hitung posisi x
        int y = (screenSize.height - mainMenu.getHeight()) / 2; // Hitung posisi y
        mainMenu.setLocation(x, y);



        JLabel label = new JLabel("Selamat Datang di Menu Utama");
        label.setBounds(100, 20, 200, 30);
        mainMenu.add(label);

        
        JLabel title2 = new JLabel("E-KTP");
        title2.setBounds(150, 50, 100, 50);
        title2.setFont(new Font("SansSerif", Font.BOLD, 24));
        mainMenu.add(title2);

        JButton perekamanBtn = new JButton("PEREKAMAN");
        perekamanBtn.setBounds(110, 110, 150, 30);
        mainMenu.add(perekamanBtn);

        perekamanBtn.addActionListener(e -> {
            mainMenu.dispose();
            new FormInputData("Perekaman",null);
        });





        mainMenu.setVisible(true);
    }
}
