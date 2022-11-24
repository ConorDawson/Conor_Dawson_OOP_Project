package Knock_31;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class P1 {
    static List<String> p1Hand = new ArrayList<>();//player hand

    static List<Integer> player1scores = new ArrayList<>();
    static List<Integer> player1suitscores = new ArrayList<>();

    static int p1Total=0, p1Turn=1, turn=1;

    static String name1 = Player1Info.P1Name, card1, card2, card3;

    public static void player1HandStart(){
        for(int i=0; i<3; i++){
            int rnd = new Random().nextInt(Deck.deck.size());//Chooses random card from deck
            p1Hand.add(Deck.deck.get(rnd));//Adds to players hand
            Deck.deck.remove(rnd);//Removes selected card from available cards
        }
         card1= P1.p1Hand.get(0); card2 = P1.p1Hand.get(1); card3= P1.p1Hand.get(2);

    }//Fills in player 1s hand while removing those cards from the deck

    public static void player1Hand(){
        int rnd = new Random().nextInt(Deck.deck.size());//Chooses random card from deck
        p1Hand.add(Deck.deck.get(rnd));//Adds to players hand
        Deck.deck.remove(rnd);//Removes selected card from available cards

    }//Adds random card

    public static void player1Turn(){




        int answer = JOptionPane.showOptionDialog(null,
                name1+"'s Turn "+p1Turn+"\n Your hand is: "+p1Hand.get(0)+"   "+p1Hand.get(1)+"   "+p1Hand.get(2)+"\nWould you like to draw a card or Knock",
                "Player 1",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                Options.options1,
                null);

        if(answer== 0){

            if( turn == 1){

                player1Hand();


                int ditchCard = JOptionPane.showOptionDialog(null, "Please Select a card to get rid of","Player 1",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        p1Hand.toArray(new String[0]), null);

                if(ditchCard== 0){
                    Deck.dispatch.add(0,p1Hand.get(0));
                    p1Hand.remove(0);
                }

                if(ditchCard== 1){
                    Deck.dispatch.add(0,p1Hand.get(1));
                    p1Hand.remove(1);
                }

                if(ditchCard== 2){
                    Deck.dispatch.add(0,p1Hand.get(2));
                    p1Hand.remove(2);
                }

                if(ditchCard== 3){
                    Deck.dispatch.add(0,p1Hand.get(3));
                    p1Hand.remove(3);
                }

            }// First turn no dispatch pile available



            else {

                int answer2 = JOptionPane.showOptionDialog(null, "Draw from the deck(random card) or top of dispatch pile("+Deck.dispatch.get(0)+")",
                        "Player 1", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, Options.options2, null);

                if(answer2 == 0){
                    player1Hand();

                    JOptionPane.showMessageDialog(null,"Your hand is: "+p1Hand, "Player 1",JOptionPane.INFORMATION_MESSAGE);

                    int ditchCard = JOptionPane.showOptionDialog(null, "Please Select a card to get rid of","Player 1",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            p1Hand.toArray(new String[0]), null);

                    if(ditchCard== 0){
                        Deck.dispatch.add(0,p1Hand.get(0));
                        p1Hand.remove(0);
                    }

                    if(ditchCard== 1){
                        Deck.dispatch.add(0,p1Hand.get(1));
                        p1Hand.remove(1);
                    }

                    if(ditchCard== 2){
                        Deck.dispatch.add(0,p1Hand.get(2));
                        p1Hand.remove(2);
                    }

                    if(ditchCard== 3){
                        Deck.dispatch.add(0,p1Hand.get(3));
                        p1Hand.remove(3);
                    }

                }//Deck is Selected


                if(answer2 == 1){
                    p1Hand.add(Deck.dispatch.get(0));//Adds to players hand


                    int ditchCard = JOptionPane.showOptionDialog(null, "Please Select a card to get rid of","Player 1",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            p1Hand.toArray(new String[0]), null);

                    if(ditchCard== 0){
                        Deck.dispatch.add(0,p1Hand.get(0));
                        p1Hand.remove(0);
                    }

                    if(ditchCard== 1){
                        Deck.dispatch.add(0,p1Hand.get(1));
                        p1Hand.remove(1);
                    }

                    if(ditchCard== 2){
                        Deck.dispatch.add(0,p1Hand.get(2));
                        p1Hand.remove(2);
                    }

                    if(ditchCard== 3){
                        Deck.dispatch.add(0,p1Hand.get(3));
                        p1Hand.remove(3);
                    }

                }//Dispatch is selected

            }
            turn++;
            p1Turn++;


        }// Extra card is selected

        if(answer== 1){
            JOptionPane.showMessageDialog(null,"You Selected Knock", "Player 1",JOptionPane.INFORMATION_MESSAGE);
            Deck.resign++;//Starts for validation

        }//Knock is selected

        if(answer== 2){
            System.exit(0);
        }//Quit Button

    } //Player 1s turn
    public static void player1Validation(){
        player1ScoreValidation();
        player1SuitValidation();
    }


    public static void player1ScoreValidation(){

        for(int i=0; i< 3; i++){

            String check = P1.p1Hand.get(i);
            int value;

            if(check.equals( "2 of Spades")||check.equals("2 of Diamonds")||check.equals("2 of Hearts")||check.equals("2 of Clubs")){
                value = 2;
                P1.player1scores.add(i, value);
            }

            if(check.equals( "3 of Spades")||check.equals("3 of Diamonds")||check.equals("3 of Hearts")||check.equals("3 of Clubs")){
                value = 3;
                P1.player1scores.add(i, value);
            }

            if(check.equals( "4 of Spades")||check.equals("4 of Diamonds")||check.equals("4 of Hearts")||check.equals("4 of Clubs")){
                value = 4;
                P1.player1scores.add(i, value);
            }

            if(check.equals( "5 of Spades")||check.equals("5 of Diamonds")||check.equals("5 of Hearts")||check.equals("5 of Clubs")){
                value = 5;
                P1.player1scores.add(i, value);
            }

            if(check.equals( "6 of Spades")||check.equals("6 of Diamonds")||check.equals("6 of Hearts")||check.equals("6 of Clubs")){
                value = 6;
                P1.player1scores.add(i, value);
            }

            if(check.equals( "7 of Spades")||check.equals("7 of Diamonds")||check.equals("7 of Hearts")||check.equals("7 of Clubs")){
                value = 7;
                P1.player1scores.add(i, value);
            }

            if(check.equals( "8 of Spades")||check.equals("8 of Diamonds")||check.equals("8 of Hearts")||check.equals("8 of Clubs")){
                value = 8;
                P1.player1scores.add(i, value);          }

            if(check.equals( "9 of Spades")||check.equals("9 of Diamonds")||check.equals("9 of Hearts")||check.equals("9 of Clubs")){
                value = 2;
                P1.player1scores.add(i, value);
            }

            if(check.equals( "10 of Spades")||check.equals("10 of Diamonds")||check.equals("10 of Hearts")||check.equals("10 of Clubs")){
                value = 10;
                P1.player1scores.add(i, value);
            }

            if(check.equals( "Queen of Spades")||check.equals("Queen of Diamonds")||check.equals("Queen of Hearts")||check.equals("Queen of Clubs")){
                value = 10;
                P1.player1scores.add(i, value);
            }

            if(check.equals( "Jack of Spades")||check.equals("Jack of Diamonds")||check.equals("Jack of Hearts")||check.equals("Jack of Clubs")){
                value = 10;
                P1.player1scores.add(i, value);
            }

            if(check.equals( "King of Spades")||check.equals("King of Diamonds")||check.equals("King of Hearts")||check.equals("King of Clubs")){
                value = 10;
                P1.player1scores.add(i, value);
            }

            if(check.equals( "Ace of Spades")||check.equals("Ace of Diamonds")||check.equals("Ace of Hearts")||check.equals("Ace of Clubs")){
                value = 11;
                P1.player1scores.add(i, value);
            }

        }



    }// Validates player 1s hand for a total

    public static  void player1SuitValidation(){
        int diamondTotal=0, heartTotal=0, spadeTotal=0, clubTotal=0;

        for(int i=0; i<3; i++){
            if(P1.p1Hand.get(i).contains("Diamonds")){
                diamondTotal = diamondTotal+ P1.player1scores.get(i);
            }

            if(P1.p1Hand.get(i).contains("Hearts")){
                heartTotal = heartTotal+ P1.player1scores.get(i);
            }

            if(P1.p1Hand.get(i).contains("Spades")){
                spadeTotal = spadeTotal+ P1.player1scores.get(i);
            }

            if(P1.p1Hand.get(i).contains("Clubs")){
                clubTotal = clubTotal+ P1.player1scores.get(i);
            }
        }

        P1.player1suitscores.add(diamondTotal);
        P1.player1suitscores.add(heartTotal);
        P1.player1suitscores.add(spadeTotal);
        P1.player1suitscores.add(clubTotal);

        for(int j = 0; j<4; j++){
            if(P1.player1suitscores.get(j)> p1Total){
                p1Total =P1.player1suitscores.get(j) ;
            }
        }

    }


}
