// Importing required classes
import java.util.*;
import javax.swing.*;

public class Shuffle {
   static List<String> deck = new ArrayList<>();//Cards of the deck

    static List<String> pHand = new ArrayList<>();//player hand

     static List<String> cHand = new ArrayList<>();//computer hand
    static List <String> dispatch =new ArrayList<>();//Any cards that aren't in use

    static Object[] options1 = {"Draw", "Knock", "Quit"};//Options Menu options

    static int quit = 0, turn = 1;
            static int maxDispatch = dispatch.size() ;

    static Object[] options2 = {"Deck", "dispatch.get(maxDispatch-1)", "quit"};
    public static void main(String[] args){

        cards();
        playerHandStart();
        computerHandStart();

        do {

            mainGame();

        } while (quit<1);


        }



    public static void cards(){
            deck.add("AH");
            deck.add("2H");
            deck.add("3H");
            deck.add("4H");
            deck.add("5H");
            deck.add("6H");
            deck.add("7H");
            deck.add("8H");
            deck.add("9H");
            deck.add("10H");
            deck.add("JH");
            deck.add("QH");
            deck.add("KH");
            deck.add("AD");
            deck.add("2D");
            deck.add("3D");
            deck.add("4D");
            deck.add("5D");
            deck.add("6D");
            deck.add("7D");
            deck.add("8D");
            deck.add("9D");
            deck.add("10D");
            deck.add("JD");
            deck.add("QD");
            deck.add("KD");
            deck.add("AC");
            deck.add("2C");
            deck.add("3C");
            deck.add("4C");
            deck.add("5C");
            deck.add("6C");
            deck.add("7C");
            deck.add("8C");
            deck.add("9C");
            deck.add("10C");
            deck.add("JC");
            deck.add("QC");
            deck.add("KC");
            deck.add("AS");
            deck.add("2S");
            deck.add("3S");
            deck.add("4S");
            deck.add("5S");
            deck.add("6S");
            deck.add("7S");
            deck.add("8S");
            deck.add("9S");
            deck.add("10S");
            deck.add("JS");
            deck.add("QS");
            deck.add("KS");



        }//Fills in deck

    public static void playerHandStart(){
        for(int i=0; i<3; i++){
            int rnd = new Random().nextInt(deck.size());//Chooses random card from deck
            pHand.add(deck.get(rnd));//Adds to players hand
            deck.remove(rnd);//Removes selected card from available cards
        }

    }//Fills in players hand while removing those cards from the deck

    public static void computerHandStart(){
        for(int i=0; i<3; i++){
            int rnd = new Random().nextInt(deck.size());//Chooses random card from deck
            cHand.add(deck.get(rnd));//Adds to computers hand
            deck.remove(rnd);//Removes selected card from available cards
        }

    }//Fills in the compuetrs hand while removing those cards from the deck

    public static void playerHand(){
        int rnd = new Random().nextInt(deck.size());//Chooses random card from deck
        pHand.add(deck.get(rnd));//Adds to players hand
        deck.remove(rnd);//Removes selected card from available cards

    }//Adds random card

    public static void computerHand(){
        int rnd = new Random().nextInt(deck.size());//Chooses random card from deck
        cHand.add(deck.get(rnd));//Adds to players hand
        deck.remove(rnd);//Removes selected card from available cards

    }//Adds random card

    public static void mainGame(){
        playerTurn();
        computerTurn();

    }// Main turn desegnation.



    public static void playerTurn(){
        JOptionPane.showMessageDialog(null,"Turn"+ turn+"\nYour hand is: "+pHand, "Knock 31",JOptionPane.INFORMATION_MESSAGE);




        int answer =JOptionPane.showOptionDialog(null,
                "would you like to draw a card or Knock",
                "knock 31",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options1,
                null);

        if(answer== 0){

            if( turn == 1){
                playerHand();

                JOptionPane.showMessageDialog(null,"Your hand is: "+pHand, "Knock 31",JOptionPane.INFORMATION_MESSAGE);

                int ditchCard = JOptionPane.showOptionDialog(null, "Please Select a card to get rid of","knock 31",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        pHand.toArray(new String[0]), null);

                if(ditchCard== 0){
                    dispatch.add(pHand.get(0));
                    pHand.remove(0);
                }

                if(ditchCard== 1){
                    dispatch.add(pHand.get(1));
                    pHand.remove(1);
                }

                if(ditchCard== 2){
                    dispatch.add(pHand.get(2));
                    pHand.remove(2);
                }

                if(ditchCard== 3){
                    dispatch.add(pHand.get(3));
                    pHand.remove(3);
                }

                turn++;

            }



             else if(turn >1){

                int answer2 = JOptionPane.showOptionDialog(null, "Draw from the deck(random card) or top of dispatch pile("+ dispatch.get(maxDispatch)+")",
                        "Knock 31", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, options2, null);

                if(answer2 == 0){
                    playerHand();

                    JOptionPane.showMessageDialog(null,"Your hand is: "+pHand, "Knock 31",JOptionPane.INFORMATION_MESSAGE);

                    int ditchCard = JOptionPane.showOptionDialog(null, "Please Select a card to get rid of","knock 31",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            pHand.toArray(new String[0]), null);

                    if(ditchCard== 0){
                        dispatch.add(pHand.get(0));
                        pHand.remove(0);
                    }

                    if(ditchCard== 1){
                        dispatch.add(pHand.get(1));
                        pHand.remove(1);
                    }

                    if(ditchCard== 2){
                        dispatch.add(pHand.get(2));
                        pHand.remove(2);
                    }

                    if(ditchCard== 3){
                        dispatch.add(pHand.get(3));
                        pHand.remove(3);
                    }

                }//Deck is Selected


                if(answer2 == 1){}//Dispatch is selected

                 turn++;
            }



        }// Extra card is selected

        if(answer== 1){
            JOptionPane.showMessageDialog(null,"You Selected Knock", "Knock 31",JOptionPane.INFORMATION_MESSAGE);
            quit++;//Placeholder for validation

        }//Knock is selected

        if(answer== 2){
            quit++;
        }//Quit Button

    } //Players turn

    public static void computerTurn(){





        int answer  = (int)(Math.random() * 1);

        if(answer== 0){
            computerHand();



            int ditchCard = (int)(Math.random() * 3);

            if(ditchCard== 0){
                dispatch.add(cHand.get(0));
                cHand.remove(0);
            }

            if(ditchCard== 1){
                dispatch.add(cHand.get(1));
                cHand.remove(1);
            }

            if(ditchCard== 2){
                dispatch.add(cHand.get(2));
                cHand.remove(2);
            }

            if(ditchCard== 3){
                dispatch.add(cHand.get(3));
                cHand.remove(3);
            }

        }// Extra card is drawn and a random card is tossed

        if(answer== 1){


        }//No extra card is selected



    }//Computers Turn

    }






