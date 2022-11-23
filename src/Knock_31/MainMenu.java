package Knock_31;

import javax.swing.*;
import java.awt.event.ActionEvent;




//Card got from https://opengameart.org/content/playing-cards
public class MainMenu extends JFrame{
    private JButton p1VSCPUButton;
    private JButton p1VSP2Button;
    private JButton quitButton;
    private JPanel MainMenuPanel;



    public MainMenu() {
        setContentPane(MainMenuPanel);
        setSize(1920,1080);
        setLocationRelativeTo(null);
        setVisible(true);


        p1VSCPUButton.addActionListener((ActionEvent e) -> {

            OnePlayer.instructions();
            Test.save2();


        });// One Player Mode of the Game
        p1VSP2Button.addActionListener((ActionEvent e) -> {

             TwoPlayer.instructions();
             Test.save1();
        });//Two Player Mode of the Game

        quitButton.addActionListener((ActionEvent e) -> System.exit(0));// Quits the game
    }


    public static void main(String[] args) {
                 new MainMenu();
    }
}
