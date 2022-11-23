package Knock_31;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player2Info extends JFrame{
    private JPanel mainbody;
    private JButton submitButton;
    private JTextField User2;

    static String P2Name;
    Player2Info(){
        setContentPane(mainbody);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500
        );
        setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                P2Name= User2.getText();

                if(P2Name.isEmpty()== true){
                    setVisible(false);
                    new Player2Info();
                }

                else{
                    setVisible(false);
                    TwoPlayer.instructions();
                    Test.save1();

                }



            }
        });
    }

    public static void main(String[] args) {
     new  Player2Info();
    }


}
