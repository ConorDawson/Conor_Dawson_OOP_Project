import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TwoPlayer {

    static List<String> deck = new ArrayList<>();//Cards of the deck
    static List<String> p1Hand = new ArrayList<>();//player hand
    static List<String> p2Hand = new ArrayList<>();//computer hand
    static List <String> dispatch =new ArrayList<>();//Any cards that aren't in use

    static List<Integer> player1scores = new ArrayList<>();
    static List<Integer> player1suitscores = new ArrayList<>();

    static List<Integer> player2scores = new ArrayList<>();
    static List<Integer> player2suitscores = new ArrayList<>();
    static Object[] options1 = {"Draw", "Knock", "Quit"};//Options Menu options
    static Object[] options2 = {"Deck", "Dispatch"};
    static int resign = 0, p1turn = 1, p2Turn=1, p1Total=0, p2Total=0;



    public static void main(String []args){
        cards();
        player1HandStart();
        player2HandStart();

        dispatch.add("Start");

        do {
            mainGame();

        } while (resign<1);

        player1Validation();
        player2Validation();

        if(p1Total> p2Total)
            JOptionPane.showMessageDialog(null, "Player Ones Score: "+p1Total+"\nPlayer Twos Total: "+p2Total+"\nPlayer One Wins");

        if(p1Total< p2Total)
            JOptionPane.showMessageDialog(null, "Player Ones Score: "+p1Total+"\nPlayer Twos Total: "+p2Total+"\nPlayer Two Wins");

        if(p1Total== p2Total)
            JOptionPane.showMessageDialog(null, "Player Ones Score: "+p1Total+"\nPlayer Twos Total: "+p2Total+"\n Its a draw");

    }

    public static void cards(){
        deck.add("Ace of Hearts");
        deck.add("2 of Hearts");
        deck.add("3 of Hearts");
        deck.add("4 of Hearts");
        deck.add("5 of Hearts");
        deck.add("6 of Hearts");
        deck.add("7 of Hearts");
        deck.add("8 of Hearts");
        deck.add("9 of Hearts");
        deck.add("10 of Hearts");
        deck.add("Jack of Hearts");
        deck.add("Queen of Hearts");
        deck.add("King of Hearts");
        deck.add("Ace of Diamonds");
        deck.add("2 of Diamonds");
        deck.add("3 of Diamonds");
        deck.add("4 of Diamonds");
        deck.add("5 of Diamonds");
        deck.add("6 of Diamonds");
        deck.add("7 of Diamonds");
        deck.add("8 of Diamonds");
        deck.add("9 of Diamonds");
        deck.add("10 of Diamonds");
        deck.add("Jack of Diamonds");
        deck.add("Queen of Diamonds");
        deck.add("King of Diamonds");
        deck.add("Ace of Clubs");
        deck.add("2 of Clubs");
        deck.add("3 of Clubs");
        deck.add("4 of Clubs");
        deck.add("5 of Clubs");
        deck.add("6 of Clubs");
        deck.add("7 of Clubs");
        deck.add("8 of Clubs");
        deck.add("9 of Clubs");
        deck.add("10 of Clubs");
        deck.add("Jack of Clubs");
        deck.add("Queen of Clubs");
        deck.add("King of Clubs");
        deck.add("Ace of Spades");
        deck.add("2 of Spades");
        deck.add("3 of Spades");
        deck.add("4 of Spades");
        deck.add("5 of Spades");
        deck.add("6 of Spades");
        deck.add("7 of Spades");
        deck.add("8 of Spades");
        deck.add("9 of Spades");
        deck.add("10 of Spades");
        deck.add("Jack of Spades");
        deck.add("Queen of Spades");
        deck.add("King of Spades");
        dispatch.add("Start");



    }//Fills in deck

    public static void player1HandStart(){
        for(int i=0; i<3; i++){
            int rnd = new Random().nextInt(deck.size());//Chooses random card from deck
            p1Hand.add(deck.get(rnd));//Adds to players hand
            deck.remove(rnd);//Removes selected card from available cards
        }

    }//Fills in player 1s hand while removing those cards from the deck
    public static void player2HandStart(){
        for(int i=0; i<3; i++){
            int rnd = new Random().nextInt(deck.size());//Chooses random card from deck
            p2Hand.add(deck.get(rnd));//Adds to players hand
            deck.remove(rnd);//Removes selected card from available cards
        }

    }//Fills in player 2s hand while removing those cards from the deck

    public static void player1Hand(){
        int rnd = new Random().nextInt(deck.size());//Chooses random card from deck
        p1Hand.add(deck.get(rnd));//Adds to players hand
        deck.remove(rnd);//Removes selected card from available cards

    }//Adds random card
    public static void player2Hand(){
        int rnd = new Random().nextInt(deck.size());//Chooses random card from deck
        p2Hand.add(deck.get(rnd));//Adds to players hand
        deck.remove(rnd);//Removes selected card from available cards

    }//Adds random card
    public static void player1Turn(){
        JOptionPane.showMessageDialog(null,"Turn"+ p1turn+"\nYour hand is: "+p1Hand, "Player 1",JOptionPane.INFORMATION_MESSAGE);




        int answer =JOptionPane.showOptionDialog(null,
                "would you like to draw a card or Knock",
                "Player 1",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options1,
                null);

        if(answer== 0){

            if( p1turn == 1){

                player1Hand();

                JOptionPane.showMessageDialog(null,"Your hand is: "+p1Hand, "Player 1",JOptionPane.INFORMATION_MESSAGE);

                int ditchCard = JOptionPane.showOptionDialog(null, "Please Select a card to get rid of","Player 1",
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
                        "Player 1", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, options2, null);

                if(answer2 == 0){
                    player1Hand();

                    JOptionPane.showMessageDialog(null,"Your hand is: "+p1Hand, "Player 1",JOptionPane.INFORMATION_MESSAGE);

                    int ditchCard = JOptionPane.showOptionDialog(null, "Please Select a card to get rid of","Player 1",
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


                    int ditchCard = JOptionPane.showOptionDialog(null, "Please Select a card to get rid of","Player 1",
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
            p1turn++;


        }// Extra card is selected

        if(answer== 1){
            JOptionPane.showMessageDialog(null,"You Selected Knock", "Player 1",JOptionPane.INFORMATION_MESSAGE);
            resign++;//Placeholder for validation

        }//Knock is selected

        if(answer== 2){
            System.exit(0);
        }//Quit Button

    } //Player 1s turn

    public static void player2Turn(){
        JOptionPane.showMessageDialog(null,"Turn"+ p2Turn+"\nYour hand is: "+p2Hand, "Player 2",JOptionPane.INFORMATION_MESSAGE);




        int answer =JOptionPane.showOptionDialog(null,
                "would you like to draw a card or Knock",
                "Player 2",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options1,
                null);

        if(answer== 0){

            int answer2 = JOptionPane.showOptionDialog(null, "Draw from the deck(random card) or top of dispatch pile("+dispatch.get(0)+")",
                    "Knock 31", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, options2, null);

            if(answer2 == 0){
                player2Hand();

                JOptionPane.showMessageDialog(null,"Your hand is: "+p2Hand, "Knock 31",JOptionPane.INFORMATION_MESSAGE);

                int ditchCard = JOptionPane.showOptionDialog(null, "Please Select a card to get rid of","knock 31",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        p2Hand.toArray(new String[0]), null);

                if(ditchCard== 0){
                    dispatch.add(0,p2Hand.get(0));
                    p2Hand.remove(0);
                }

                if(ditchCard== 1){
                    dispatch.add(0,p2Hand.get(1));
                    p2Hand.remove(1);
                }

                if(ditchCard== 2){
                    dispatch.add(0,p2Hand.get(2));
                    p2Hand.remove(2);
                }

                if(ditchCard== 3){
                    dispatch.add(0,p2Hand.get(3));
                    p2Hand.remove(3);
                }

            }//Deck is Selected


            if(answer2 == 1){
                p2Hand.add(dispatch.get(0));//Adds to players hand


                int ditchCard = JOptionPane.showOptionDialog(null, "Please Select a card to get rid of","knock 31",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        p2Hand.toArray(new String[0]), null);

                if(ditchCard== 0){
                    dispatch.add(0,p2Hand.get(0));
                    p2Hand.remove(0);
                }

                if(ditchCard== 1){
                    dispatch.add(0,p2Hand.get(1));
                    p2Hand.remove(1);
                }

                if(ditchCard== 2){
                    dispatch.add(0,p2Hand.get(2));
                    p2Hand.remove(2);
                }

                if(ditchCard== 3){
                    dispatch.add(0,p2Hand.get(3));
                    p2Hand.remove(3);
                }

            }//Dispatch is selected


            p2Turn++;


        }// Extra card is selected

        if(answer== 1){
            JOptionPane.showMessageDialog(null,"You Selected Knock", "Player 2",JOptionPane.INFORMATION_MESSAGE);
            resign++;//Placeholder for validation

        }//Knock is selected

        if(answer== 2){
            System.exit(0);
        }//Quit Button

    } //Player 2s turn

    public static void mainGame(){
        player1Turn();
        player2Turn();


    }// Main turn designation.

    public static void player1Validation(){
        player1ScoreValidation();
        player1SuitValidation();
    }

    public static void player2Validation(){
        player2ScoreValidation();
        player2SuitValidation();
    }

    public static void player1ScoreValidation(){

        for(int i=0; i< 3; i++){

            String check = p1Hand.get(i);
            int value;

            if(check.equals( "2 of Spades")||check.equals("2 of Diamonds")||check.equals("2 of Hearts")||check.equals("2 of Clubs")){
                value = 2;
                player1scores.add(i, value);
            }

            if(check.equals( "3 of Spades")||check.equals("3 of Diamonds")||check.equals("3 of Hearts")||check.equals("3 of Clubs")){
                value = 3;
                player1scores.add(i, value);
            }

            if(check.equals( "4 of Spades")||check.equals("4 of Diamonds")||check.equals("4 of Hearts")||check.equals("4 of Clubs")){
                value = 4;
                player1scores.add(i, value);
            }

            if(check.equals( "5 of Spades")||check.equals("5 of Diamonds")||check.equals("5 of Hearts")||check.equals("5 of Clubs")){
                value = 5;
                player1scores.add(i, value);
            }

            if(check.equals( "6 of Spades")||check.equals("6 of Diamonds")||check.equals("6 of Hearts")||check.equals("6 of Clubs")){
                value = 6;
                player1scores.add(i, value);
            }

            if(check.equals( "7 of Spades")||check.equals("7 of Diamonds")||check.equals("7 of Hearts")||check.equals("7 of Clubs")){
                value = 7;
                player1scores.add(i, value);
            }

            if(check.equals( "8 of Spades")||check.equals("8 of Diamonds")||check.equals("8 of Hearts")||check.equals("8 of Clubs")){
                value = 8;
                player1scores.add(i, value);          }

            if(check.equals( "9 of Spades")||check.equals("9 of Diamonds")||check.equals("9 of Hearts")||check.equals("9 of Clubs")){
                value = 2;
                player1scores.add(i, value);
            }

            if(check.equals( "10 of Spades")||check.equals("10 of Diamonds")||check.equals("10 of Hearts")||check.equals("10 of Clubs")){
                value = 10;
                player1scores.add(i, value);
            }

            if(check.equals( "Queen of Spades")||check.equals("Queen of Diamonds")||check.equals("Queen of Hearts")||check.equals("Queen of Clubs")){
                value = 10;
                player1scores.add(i, value);
            }

            if(check.equals( "Jack of Spades")||check.equals("Jack of Diamonds")||check.equals("Jack of Hearts")||check.equals("Jack of Clubs")){
                value = 10;
                player1scores.add(i, value);
            }

            if(check.equals( "King of Spades")||check.equals("King of Diamonds")||check.equals("King of Hearts")||check.equals("King of Clubs")){
                value = 10;
                player1scores.add(i, value);
            }

            if(check.equals( "Ace of Spades")||check.equals("Ace of Diamonds")||check.equals("Ace of Hearts")||check.equals("Ace of Clubs")){
                value = 11;
                player1scores.add(i, value);
            }

        }



    }// Validates player 1s hand for a total
    public static void player1SuitValidation(){
        int diamondTotal=0, heartTotal=0, spadeTotal=0, clubTotal=0;

        for(int i=0; i<3; i++){
            if(p1Hand.get(i).contains("Diamonds")){
                diamondTotal = diamondTotal+ player1scores.get(i);
            }

            if(p1Hand.get(i).contains("Hearts")){
                heartTotal = heartTotal+ player1scores.get(i);
            }

            if(p1Hand.get(i).contains("Spades")){
                spadeTotal = spadeTotal+ player1scores.get(i);
            }

            if(p1Hand.get(i).contains("Clubs")){
                clubTotal = clubTotal+ player1scores.get(i);
            }
        }

        player1suitscores.add(diamondTotal);
        player1suitscores.add(heartTotal);
        player1suitscores.add(spadeTotal);
        player1suitscores.add(clubTotal);

        for(int j = 0; j<4; j++){
            if(player1suitscores.get(j)> p1Total){
                p1Total =player1suitscores.get(j) ;
            }
        }

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
