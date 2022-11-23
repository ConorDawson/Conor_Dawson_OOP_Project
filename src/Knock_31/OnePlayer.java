package Knock_31;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OnePlayer extends JFrame{





    static List<String> cHand = new ArrayList<>();//computer hand

    static List<Integer> computerscores = new ArrayList<>();
    static  List<Integer> computersuitscores = new ArrayList<>();

     static int cTotal=0;

    static String result = " ";




    public static void main(String[] args) {


    }

    public static void instructions(){
        Deck.cards();
        P1.player1HandStart();
        computerHandStart();

        do {
            mainGame();

        } while (Deck.resign<1);

        P1.player1Validation();
        computerValidation();

        if(P1.p1Total> cTotal)
            result =( "Player Ones Score: "+P1.p1Total+"\nComputers Total: "+cTotal+"\nPlayer One Wins");

        if(P1.p1Total< cTotal)
            result =( "Player Ones Score: "+P1.p1Total+"\nComputers Total: "+cTotal+"\nComputer Wins");

        if(P1.p1Total== cTotal)
            result = ("Player Ones score is " +P1.p1Total+"\nComputers Score is "+ cTotal+"\n Its a draw");


        JOptionPane.showMessageDialog(null, result);
        P1.p1Hand.clear();
        cHand.clear();
        Deck.deck.clear();
        Deck.dispatch.clear();
        P1.player1scores.clear();
        computerscores.clear();
        P1.player1suitscores.clear();
        computersuitscores.clear();
        P1.p1Total=0;
        cTotal=0;

    }//How the game is to run from the menu

    public static void computerHandStart(){
        for(int i=0; i<3; i++){
            int rnd = new Random().nextInt(Deck.deck.size());//Chooses random card from deck
            cHand.add(Deck.deck.get(rnd));//Adds to players hand
            Deck.deck.remove(rnd);//Removes selected card from available cards
        }

    }//Fills in player 2s hand while removing those cards from the deck

    public static void computerHand(){
        int rnd = new Random().nextInt(Deck.deck.size());//Chooses random card from deck
        cHand.add(Deck.deck.get(rnd));//Adds to players hand
        Deck.deck.remove(rnd);//Removes selected card from available cards

    }//Adds random card


    public static void computerTurn(){




        int answer2 = new Random().nextInt(2);





            if(answer2 == 0){
                computerHand();


                int ditchCard = new Random().nextInt(cHand.size());

                if(ditchCard== 0){
                    Deck.dispatch.add(0,cHand.get(0));
                    cHand.remove(0);
                }

                if(ditchCard== 1){
                    Deck.dispatch.add(0,cHand.get(1));
                    cHand.remove(1);
                }

                if(ditchCard== 2){
                    Deck.dispatch.add(0,cHand.get(2));
                    cHand.remove(2);
                }

                if(ditchCard== 3){
                    Deck.dispatch.add(0,cHand.get(3));
                    cHand.remove(3);
                }

            }//Deck is Selected


            if(answer2 == 1){
                cHand.add(Deck.dispatch.get(0));//Adds to players hand


                 int ditchCard = new Random().nextInt(cHand.size());

                if(ditchCard== 0){
                    Deck.dispatch.add(0,cHand.get(0));
                    cHand.remove(0);
                }

                if(ditchCard== 1){
                    Deck.dispatch.add(0,cHand.get(1));
                    cHand.remove(1);
                }

                if(ditchCard== 2){
                    Deck.dispatch.add(0,cHand.get(2));
                    cHand.remove(2);
                }

                if(ditchCard== 3){
                    Deck.dispatch.add(0,cHand.get(3));
                    cHand.remove(3);
                }

            }//Dispatch is selected


            P1.turn++;






    } //Computers turn

    public static void mainGame(){
        P1.player1Turn();
        computerTurn();


    }// Knock_31.Main turn designation.


    public static void computerValidation(){
        computerScoreValidation();
        computerSuitValidation();
    }


    public static void computerScoreValidation(){

        for(int i=0; i< 3; i++){

            String check = cHand.get(i);
            int value;

            if(check.equals( "2 of Spades")||check.equals("2 of Diamonds")||check.equals("2 of Hearts")||check.equals("2 of Clubs")){
                value = 2;
                computerscores.add(i, value);
            }

            if(check.equals( "3 of Spades")||check.equals("3 of Diamonds")||check.equals("3 of Hearts")||check.equals("3 of Clubs")){
                value = 3;
                computerscores.add(i, value);            }

            if(check.equals( "4 of Spades")||check.equals("4 of Diamonds")||check.equals("4 of Hearts")||check.equals("4 of Clubs")){
                value = 4;
                computerscores.add(i, value);            }

            if(check.equals( "5 of Spades")||check.equals("5 of Diamonds")||check.equals("5 of Hearts")||check.equals("5 of Clubs")){
                value = 5;
                computerscores.add(i, value);            }

            if(check.equals( "6 of Spades")||check.equals("6 of Diamonds")||check.equals("6 of Hearts")||check.equals("6 of Clubs")){
                value = 6;
                computerscores.add(i, value);            }

            if(check.equals( "7 of Spades")||check.equals("7 of Diamonds")||check.equals("7 of Hearts")||check.equals("7 of Clubs")){
                value = 7;
                computerscores.add(i, value);            }

            if(check.equals( "8 of Spades")||check.equals("8 of Diamonds")||check.equals("8 of Hearts")||check.equals("8 of Clubs")){
                value = 8;
                computerscores.add(i, value);       }

            if(check.equals( "9 of Spades")||check.equals("9 of Diamonds")||check.equals("9 of Hearts")||check.equals("9 of Clubs")){
                value = 2;
                computerscores.add(i, value);
            }

            if(check.equals( "10 of Spades")||check.equals("10 of Diamonds")||check.equals("10 of Hearts")||check.equals("10 of Clubs")){
                value = 10;
                computerscores.add(i, value);
            }

            if(check.equals( "Queen of Spades")||check.equals("Queen of Diamonds")||check.equals("Queen of Hearts")||check.equals("Queen of Clubs")){
                value = 10;
                computerscores.add(i, value);
            }

            if(check.equals( "Jack of Spades")||check.equals("Jack of Diamonds")||check.equals("Jack of Hearts")||check.equals("Jack of Clubs")){
                value = 10;
                computerscores.add(i, value);
            }

            if(check.equals( "King of Spades")||check.equals("King of Diamonds")||check.equals("King of Hearts")||check.equals("King of Clubs")){
                value = 10;
                computerscores.add(i, value);
            }

            if(check.equals( "Ace of Spades")||check.equals("Ace of Diamonds")||check.equals("Ace of Hearts")||check.equals("Ace of Clubs")){
                value = 11;
                computerscores.add(i, value);
            }

        }



    }// Validates player 2s hand for a total
    public static void computerSuitValidation(){
        int diamondTotal2=0, heartTotal2=0, spadeTotal2=0, clubTotal2=0;

        for(int i=0; i<3; i++){
            if(cHand.get(i).contains("Diamonds")){
                diamondTotal2 = diamondTotal2+ computerscores.get(i);
            }

            if(cHand.get(i).contains("Hearts")){
                heartTotal2 = heartTotal2+ computerscores.get(i);
            }

            if(cHand.get(i).contains("Spades")){
                spadeTotal2 = spadeTotal2+ computerscores.get(i);
            }

            if(cHand.get(i).contains("Clubs")){
                clubTotal2 = clubTotal2+ computerscores.get(i);
            }
        }

        computersuitscores.add(diamondTotal2);
        computersuitscores.add(heartTotal2);
        computersuitscores.add(spadeTotal2);
        computersuitscores.add(clubTotal2);

        for(int j = 0; j<4; j++){
            if(computersuitscores.get(j)> cTotal){
                cTotal =computersuitscores.get(j) ;
            }
        }

    }


}

