  package Knock_31;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

  public  class TwoPlayer extends JFrame{

     static List<String> p2Hand = new ArrayList<>();//computer hand

     static List<Integer> player2scores = new ArrayList<>();
      static List<Integer> player2suitscores = new ArrayList<>();

     static int p2Turn=1, p2Total=0;

     static String result, name2 = Player2Info.P2Name;




    public static void main(String[] args) {


    }
    public static void instructions(){
        result=" ";
        Deck.cards();
        P1.player1HandStart();
        player2HandStart();

        JOptionPane.showMessageDialog(null, "Welcome to a two player black jack please makes sure both players are ready\n Enjoy and Good Luck");

        do {
            if(Deck.deck.size()==0){Deck.resign++;}
           mainGame();


        } while (Deck.resign<1);

        P1.player1Validation();
        player2Validation();


        if(P1.p1Total> p2Total)
             result =( P1.name1+"s Score: "+P1.p1Total+"\n"+name2+"s Total: "+p2Total+"\n"+P1.name1+"s Wins");

        if(P1.p1Total< p2Total)
            result =( P1.name1+"s Score: " +P1.p1Total+"\n"+name2+"s Total: "+p2Total+"\n"+name2+"s Wins");

        if(P1.p1Total== p2Total)
            result = (P1.name1+"s Score: "+P1.p1Total+"\n"+name2+"s Total: "+ p2Total+"\n Its a draw");


        JOptionPane.showMessageDialog(null, result);
        P1.p1Hand.clear();
        p2Hand.clear();
        Deck.deck.clear();
        Deck.dispatch.clear();
        P1.player1scores.clear();
        player2scores.clear();
        P1.player1suitscores.clear();
        player2suitscores.clear();
        P1.p1Total=0;
        p2Total=0;
        P1.turn=1;
        p2Turn=1;

    }//How the game is to run from the menu



    public static void player2HandStart(){
        for(int i=0; i<3; i++){
            int rnd = new Random().nextInt(Deck.deck.size());//Chooses random card from deck
            p2Hand.add(Deck.deck.get(rnd));//Adds to players hand
            Deck.deck.remove(rnd);//Removes selected card from available cards
        }

    }//Fills in player 2s hand while removing those cards from the deck


    public static void player2Hand(){
        int rnd = new Random().nextInt(Deck.deck.size());//Chooses random card from deck
        p2Hand.add(Deck.deck.get(rnd));//Adds to players hand
        Deck.deck.remove(rnd);//Removes selected card from available cards

    }//Adds random card


    public static void player2Turn(){



        int answer =JOptionPane.showOptionDialog(null,
                name2+"'s' 2 Turn "+p2Turn+"\n Your hand is: "+p2Hand.get(0)+"   "+p2Hand.get(1)+"   "+p2Hand.get(2)+"\nWould you like to draw a card or Knock",
                "Player 2",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                Options.options1,
                null);

        if(answer== 0){

            if( Deck.dispatch.size()<2){

                player2Hand();


                int ditchCard = JOptionPane.showOptionDialog(null, "Please Select a card to get rid of","Player 1",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        p2Hand.toArray(new String[0]), null);

                if(ditchCard== 0){
                    Deck.dispatch.add(0,p2Hand.get(0));
                    p2Hand.remove(0);
                }

                if(ditchCard== 1){
                    Deck.dispatch.add(0,p2Hand.get(1));
                    p2Hand.remove(1);
                }

                if(ditchCard== 2){
                    Deck.dispatch.add(0,p2Hand.get(2));
                    p2Hand.remove(2);
                }

                if(ditchCard== 3){
                    Deck.dispatch.add(0,p2Hand.get(3));
                    p2Hand.remove(3);
                }

            }// If Player 1 picks knock first go there is no dispatch pile available

           else{ int answer2 = JOptionPane.showOptionDialog(null, "Draw from the deck(random card) or top of dispatch pile("+Deck.dispatch.get(0)+")",
                    "Knock 31", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, Options.options2, null);

                if(answer2 == 0){
                    player2Hand();

                    JOptionPane.showMessageDialog(null,"Your hand is: "+p2Hand, "Knock 31",JOptionPane.INFORMATION_MESSAGE);

                    int ditchCard = JOptionPane.showOptionDialog(null, "Please Select a card to get rid of","knock 31",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            p2Hand.toArray(new String[0]), null);

                    if(ditchCard== 0){
                        Deck.dispatch.add(0,p2Hand.get(0));
                        p2Hand.remove(0);
                    }

                    if(ditchCard== 1){
                        Deck.dispatch.add(0,p2Hand.get(1));
                        p2Hand.remove(1);
                    }

                    if(ditchCard== 2){
                        Deck.dispatch.add(0,p2Hand.get(2));
                        p2Hand.remove(2);
                    }

                    if(ditchCard== 3){
                        Deck.dispatch.add(0,p2Hand.get(3));
                        p2Hand.remove(3);
                    }
                }
                if(answer2 == 1){
                    p2Hand.add(Deck.dispatch.get(0));//Adds to players hand


                    int ditchCard = JOptionPane.showOptionDialog(null, "Please Select a card to get rid of","knock 31",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            p2Hand.toArray(new String[0]), null);

                    if(ditchCard== 0){
                        Deck.dispatch.add(0,p2Hand.get(0));
                        p2Hand.remove(0);
                    }

                    if(ditchCard== 1){
                        Deck.dispatch.add(0,p2Hand.get(1));
                        p2Hand.remove(1);
                    }

                    if(ditchCard== 2){
                        Deck.dispatch.add(0,p2Hand.get(2));
                        p2Hand.remove(2);
                    }

                    if(ditchCard== 3){
                        Deck.dispatch.add(0,p2Hand.get(3));
                        p2Hand.remove(3);
                    }

                }//Dispatch is selected
            }//Deck is Selected





            P1.turn++;
            p2Turn++;


        }// Extra card is selected

        if(answer== 1){
            JOptionPane.showMessageDialog(null,"You Selected Knock", "Player 2",JOptionPane.INFORMATION_MESSAGE);
            Deck.resign++;//Placeholder for validation

        }//Knock is selected

        if(answer== 2){
            System.exit(0);
        }//Quit Button



    } //Player 2s turn

    public static void mainGame(){
        P1.player1Turn();
        player2Turn();


    }// Knock_31.Main turn designation.



    public static void player2Validation(){
        player2ScoreValidation();
        player2SuitValidation();
    }




    public static void player2ScoreValidation(){

        for(int i=0; i< 3; i++){

            String check = p2Hand.get(i);
            int value;

            if(check.equals( "2 of Spades")||check.equals("2 of Diamonds")||check.equals("2 of Hearts")||check.equals("2 of Clubs")){
                value = 2;
                player2scores.add(i, value);
            }

            if(check.equals( "3 of Spades")||check.equals("3 of Diamonds")||check.equals("3 of Hearts")||check.equals("3 of Clubs")){
                value = 3;
                player2scores.add(i, value);            }

            if(check.equals( "4 of Spades")||check.equals("4 of Diamonds")||check.equals("4 of Hearts")||check.equals("4 of Clubs")){
                value = 4;
                player2scores.add(i, value);            }

            if(check.equals( "5 of Spades")||check.equals("5 of Diamonds")||check.equals("5 of Hearts")||check.equals("5 of Clubs")){
                value = 5;
                player2scores.add(i, value);            }

            if(check.equals( "6 of Spades")||check.equals("6 of Diamonds")||check.equals("6 of Hearts")||check.equals("6 of Clubs")){
                value = 6;
                player2scores.add(i, value);            }

            if(check.equals( "7 of Spades")||check.equals("7 of Diamonds")||check.equals("7 of Hearts")||check.equals("7 of Clubs")){
                value = 7;
                player2scores.add(i, value);            }

            if(check.equals( "8 of Spades")||check.equals("8 of Diamonds")||check.equals("8 of Hearts")||check.equals("8 of Clubs")){
                value = 8;
                player2scores.add(i, value);       }

            if(check.equals( "9 of Spades")||check.equals("9 of Diamonds")||check.equals("9 of Hearts")||check.equals("9 of Clubs")){
                value = 2;
                player2scores.add(i, value);
            }

            if(check.equals( "10 of Spades")||check.equals("10 of Diamonds")||check.equals("10 of Hearts")||check.equals("10 of Clubs")){
                value = 10;
                player2scores.add(i, value);
            }

            if(check.equals( "Queen of Spades")||check.equals("Queen of Diamonds")||check.equals("Queen of Hearts")||check.equals("Queen of Clubs")){
                value = 10;
                player2scores.add(i, value);
            }

            if(check.equals( "Jack of Spades")||check.equals("Jack of Diamonds")||check.equals("Jack of Hearts")||check.equals("Jack of Clubs")){
                value = 10;
                player2scores.add(i, value);
            }

            if(check.equals( "King of Spades")||check.equals("King of Diamonds")||check.equals("King of Hearts")||check.equals("King of Clubs")){
                value = 10;
                player2scores.add(i, value);
            }

            if(check.equals( "Ace of Spades")||check.equals("Ace of Diamonds")||check.equals("Ace of Hearts")||check.equals("Ace of Clubs")){
                value = 11;
                player2scores.add(i, value);
            }

        }



    }// Validates player 2s hand for a total
    public static void player2SuitValidation(){
        int diamondTotal2=0, heartTotal2=0, spadeTotal2=0, clubTotal2=0;

        for(int i=0; i<3; i++){
            if(p2Hand.get(i).contains("Diamonds")){
                diamondTotal2 = diamondTotal2+ player2scores.get(i);
            }

            if(p2Hand.get(i).contains("Hearts")){
                heartTotal2 = heartTotal2+ player2scores.get(i);
            }

            if(p2Hand.get(i).contains("Spades")){
                spadeTotal2 = spadeTotal2+ player2scores.get(i);
            }

            if(p2Hand.get(i).contains("Clubs")){
                clubTotal2 = clubTotal2+ player2scores.get(i);
            }
        }

        player2suitscores.add(diamondTotal2);
        player2suitscores.add(heartTotal2);
        player2suitscores.add(spadeTotal2);
        player2suitscores.add(clubTotal2);

        for(int j = 0; j<4; j++){
            if(player2suitscores.get(j)> p2Total){
                p2Total =player2suitscores.get(j) ;
            }
        }

    }


}
