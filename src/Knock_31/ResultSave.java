package Knock_31;

import javax.swing.*;
import java.io.*;

public class ResultSave implements java.io.Serializable {

    public String a;


    // Default constructor
    public ResultSave( String a)
    {
        this.a = a;

    }

}


class Test {
    public static String ResultSave="Scores\n";
    public static void main(String[] args) {

    }

    public static void save1(){
       ResultSave =ResultSave +"\n\n\n"+TwoPlayer.result;
        String filename = "results.txt";

        // Serialization
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(ResultSave);

            out.close();
            file.close();

            JOptionPane.showMessageDialog(null, getResultSave(), "Results",JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }


    }

    public static void save2(){
        ResultSave = ResultSave +"\n\n\n"+OnePlayer.result;
        String filename = "results.txt";

        // Serialization
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(ResultSave);

            out.close();
            file.close();

            JOptionPane.showMessageDialog(null, getResultSave(),"Results",JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }


    }

    public static String getResultSave() {
        return ResultSave;
    }


}
