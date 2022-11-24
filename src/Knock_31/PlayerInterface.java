package Knock_31;

import javax.swing.*;

public class PlayerInterface extends JFrame {
    private JButton Deck;
    private JButton dispatchPileButton;
    private JPanel Board;
    private JButton knockButton;
    private JLabel Card3;
    private JLabel Card2;
    private JLabel Card1;




    public PlayerInterface(){
        setContentPane(Board);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Card1.setText(P1.card1);
        Card2.setText(P1.card2);
        Card3.setText(P1.card3);
    }


}
