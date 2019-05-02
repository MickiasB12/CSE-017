
/*Mickias Bekele
mib222
CSE017
Prog 8
The purpose of the programis to find the prefixes and suffixes, and goes through list
and combine two words to find another word.*/

import java.io.IOException; //importing the IOEXception
import java.util.List; //importing List
import java.util.ArrayList; //importing ArrayList
import java.io.FileNotFoundException; //importing FileNotFoundException

public class Prog8 { // class Prog8

    public static void main(String[] args) { // main method

        try {// to catch errors
            Portmanteau x = new Portmanteau("Word.txt"); // creating Portmanteau object on text file
            x.workon(); // maing

        } catch (FileNotFoundException expt) { // for FileNotFoundException
            System.out.println(expt.getMessage());
            System.out.println("The file was not found"); // FileNotFoundException

        } catch (IOException exct) { // for IOEXception
            System.out.println(exct.getMessage()); // IOException
            System.out.println("Error");
        }

    }
}