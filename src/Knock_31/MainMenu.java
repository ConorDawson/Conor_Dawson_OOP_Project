package Knock_31;

import javax.swing.*;
import java.awt.event.ActionEvent;





public class MainMenu extends JFrame{
    private JButton p1VSCPUButton;
    private JButton p1VSP2Button;
    private JButton quitButton;
    private JPanel MainMenuPanel;

    public MainMenu() {
        setContentPane(MainMenuPanel);
        setSize(600,800);
        setLocationRelativeTo(null);
        setVisible(true);


        p1VSCPUButton.addActionListener((ActionEvent e) -> {





        });
        p1VSP2Button.addActionListener((ActionEvent e) -> {
            TwoPlayer.cards();
            TwoPlayer.player1HandStart();
            TwoPlayer.player2HandStart();

            do {
                TwoPlayer.mainGame();

            } while (TwoPlayer.resign<1);

            TwoPlayer.player1Validation();
            TwoPlayer.player2Validation();

            if(TwoPlayer.p1Total> TwoPlayer.p2Total)
                TwoPlayer.result =( "Player Ones Score: "+TwoPlayer.p1Total+"\nPlayer Twos Total: "+TwoPlayer.p2Total+"\nPlayer One Wins");

            if(TwoPlayer.p1Total< TwoPlayer.p2Total)
                TwoPlayer.result =( "Player Ones Score: "+TwoPlayer.p1Total+"\nPlayer Twos Total: "+TwoPlayer.p2Total+"\nPlayer Two Wins");

            if(TwoPlayer.p1Total== TwoPlayer.p2Total)
                TwoPlayer.result = ("Player Ones score is " +TwoPlayer.p1Total+"\nPlayer Twos Score is "+ TwoPlayer.p2Total+"\n Its a draw");


            JOptionPane.showMessageDialog(null, TwoPlayer.result);
        });//Two Player Mode of the Game

        quitButton.addActionListener((ActionEvent e) -> System.exit(0));// Quits the game
    }


    public static void main(String[] args) {
                 new MainMenu();
    }
}
