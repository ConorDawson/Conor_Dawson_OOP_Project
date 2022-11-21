// Importing required classes
import java.util.*;
import javax.swing.*;

public class Shuffle {
   static List<String> deck = new ArrayList<>();//Cards of the deck

    static List<String> p1Hand = new ArrayList<>();//player hand

     static List<String> cHand = new ArrayList<>();//computer hand
    static List <String> dispatch =new ArrayList<>();//Any cards that aren't in use

    static Object[] options1 = {"Draw", "Knock", "Quit"};//Options Menu options

    static int quit = 0, turn = 1;


    static Object[] options2 = {"Deck", "Dispatch", "quit"};
    public static void main(String[] args){

        cards();
        player1HandStart();
        computerHandStart();
        dispatch.add("Start");

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

    public static void player1HandStart(){
        for(int i=0; i<3; i++){
            int rnd = new Random().nextInt(deck.size());//Chooses random card from deck
            p1Hand.add(deck.get(rnd));//Adds to players hand
            deck.remove(rnd);//Removes selected card from available cards
        }

    }//Fills in players hand while removing those cards from the deck

    public static void computerHandStart(){
        for(int i=0; i<3; i++){
            int rnd = new Random().nextInt(deck.size());//Chooses random card from deck
            cHand.add(deck.get(rnd));//Adds to computers hand
            deck.remove(rnd);//Removes selected card from available cards
        }

    }//Fills in the computers hand while removing those cards from the deck

    public static void player1Hand(){
        int rnd = new Random().nextInt(deck.size());//Chooses random card from deck
        p1Hand.add(deck.get(rnd));//Adds to players hand
        deck.remove(rnd);//Removes selected card from available cards

    }//Adds random card

    public static void computerHand(){
        int rnd = new Random().nextInt(deck.size());//Chooses random card from deck
        cHand.add(deck.get(rnd));//Adds to players hand
        deck.remove(rnd);//Removes selected card from available cards

        int ditchCard = (int)Math.floor(Math.random() * 4);

        if(ditchCard== 1|| ditchCard<1){
            dispatch.add(0,cHand.get(0));
            cHand.remove(0);
        }

        if(ditchCard== 2){
            dispatch.add(0,cHand.get(1));
            cHand.remove(1);
        }

        if(ditchCard== 3){
            dispatch.add(0,cHand.get(1));
            cHand.remove(2);
        }

        if(ditchCard== 4){
            dispatch.add(0,cHand.get(1));
            cHand.remove(3);
        }

    }//Adds random card

    public static void mainGame(){
        player1Turn();
        System.out.print(turn+"\nRid of "+ dispatch+"\nPlayer"+ "\n" + p1Hand );
        computerTurn();
        System.out.print("\n"+"Rid of "+dispatch+ "\n" +"Computer"+ cHand + "\n");

    }// Main turn designation.



    public static void player1Turn(){
        JOptionPane.showMessageDialog(null,"Turn"+ turn+"\nYour hand is: "+p1Hand, "Knock 31",JOptionPane.INFORMATION_MESSAGE);




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
                player1Hand();

                JOptionPane.showMessageDialog(null,"Your hand is: "+p1Hand, "Knock 31",JOptionPane.INFORMATION_MESSAGE);

                int ditchCard = JOptionPane.showOptionDialog(null, "Please Select a card to get rid of","knock 31",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        p1Hand.toArray(new String[0]), null);

                if(ditchCard== 0){
                    dispatch.add(0,p1Hand.get(0));
                    p1Hand.remove(0);
                }

                if(ditchCard== 1){
                    dispatch.add(0,p1Hand.get(1));
                    p1Hand.remove(1);
                }

                if(ditchCard== 2){
                    dispatch.add(0,p1Hand.get(2));
                    p1Hand.remove(2);
                }

                if(ditchCard== 3){
                    dispatch.add(0,p1Hand.get(3));
                    p1Hand.remove(3);
                }

            }// First turn no dispatch pile available



            else {

                int answer2 = JOptionPane.showOptionDialog(null, "Draw from the deck(random card) or top of dispatch pile("+dispatch.get(0)+")",
                        "Knock 31", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, options2, null);

                if(answer2 == 0){
                    player1Hand();

                    JOptionPane.showMessageDialog(null,"Your hand is: "+p1Hand, "Knock 31",JOptionPane.INFORMATION_MESSAGE);

                    int ditchCard = JOptionPane.showOptionDialog(null, "Please Select a card to get rid of","knock 31",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            p1Hand.toArray(new String[0]), null);

                    if(ditchCard== 0){
                        dispatch.add(0,p1Hand.get(0));
                        p1Hand.remove(0);
                    }

                    if(ditchCard== 1){
                        dispatch.add(0,p1Hand.get(1));
                        p1Hand.remove(1);
                    }

                    if(ditchCard== 2){
                        dispatch.add(0,p1Hand.get(2));
                        p1Hand.remove(2);
                    }

                    if(ditchCard== 3){
                        dispatch.add(0,p1Hand.get(3));
                        p1Hand.remove(3);
                    }

                }//Deck is Selected


                if(answer2 == 1){
                    p1Hand.add(dispatch.get(0));//Adds to players hand


                    int ditchCard = JOptionPane.showOptionDialog(null, "Please Select a card to get rid of","knock 31",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            p1Hand.toArray(new String[0]), null);

                    if(ditchCard== 0){
                        dispatch.add(0,p1Hand.get(0));
                        p1Hand.remove(0);
                    }

                    if(ditchCard== 1){
                        dispatch.add(0,p1Hand.get(1));
                        p1Hand.remove(1);
                    }

                    if(ditchCard== 2){
                        dispatch.add(0,p1Hand.get(2));
                        p1Hand.remove(2);
                    }

                    if(ditchCard== 3){
                        dispatch.add(0,p1Hand.get(3));
                        p1Hand.remove(3);
                    }

                }//Dispatch is selected

            }
            turn++;


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





        int answer  = (int)Math.floor(Math.random() * 2);

        if(answer== 1){
            computerHand();


        }// Extra card is drawn from deck and a random card is tossed

        if(answer== 2){

            cHand.add(dispatch.get(0));//Adds to computers hand



            int ditchCard = (int)Math.floor(Math.random() * 4);

            if(ditchCard== 1|| ditchCard<1){
                dispatch.add(0,cHand.get(0));
                cHand.remove(0);
            }

            if(ditchCard== 2){
                dispatch.add(0,cHand.get(1));
                cHand.remove(1);
            }

            if(ditchCard== 3){
                dispatch.add(0,cHand.get(1));
                cHand.remove(2);
            }

            if(ditchCard== 4){
                dispatch.add(0,cHand.get(1));
                cHand.remove(3);
            }

        }//Extra card is drawn from dispatch




    }//Computers Turn

    }






