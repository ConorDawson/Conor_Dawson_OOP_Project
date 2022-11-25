package Knock_31;

import javax.swing.*;



/**
An instantiable class
This lets a user enter the second players name for game about to be played
and prevents the name from being blank.
@author Conor Dawson
 */
public class Player2Info extends JFrame{


    private JPanel mainbody;
    private JButton submitButton;
    private JTextField User2;

    static String P2Name="";

    /**
    A method that sets up the GUI for the user to input their name

     */
    Player2Info(){
        setContentPane(mainbody);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500
        );
        setVisible(true);



        /**
        An instantiable class that activates when the users hit's the submit button.
        It ensures the text field has some data entered into it and if it doesn't reset the GUI and prevents the user
        from moving on until there is a name entered.
        Once a name is entered it starts the main game and hides itself
         @return return the users name.
         */

        submitButton.addActionListener(e -> {

            /**
             * @param mainbody acts as the main form presented in the GUI
             * @param submitButton allows the user to submit player 2s name.
             * @param User2 is what player types their name into.
             * @param p2Name is what will take the users name from the User 2 JTextField
             * */
            P2Name= User2.getText();

            if(P2Name.isEmpty()){
                setVisible(false);
                new Player2Info();
            }

            else{
                setVisible(false);
                TwoPlayer.instructions();
                Test.save1();
                Player1Info.P1Name="";
                P2Name="";




            }



        });
    }

    public static void main(String[] args) {

    }


}
