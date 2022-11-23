package Knock_31;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player1Info extends JFrame {
    private JPanel mainbody;
    private JButton submitButton;
    private JTextField User1;

     static String P1Name="Player 1";


    public Player1Info(){

        setContentPane(mainbody);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500
        );
        setVisible(true);

        submitButton.addActionListener((ActionEvent e) -> {
             P1Name= User1.getText();
            if(User1.getText().isEmpty()== true){
                setVisible(false);
                new Player1Info();
            }

            else{
                setVisible(false);
                new Player2Info();
            }

        });
    }

    public static void main(String[] args) {
        new Player1Info();
    }
}
