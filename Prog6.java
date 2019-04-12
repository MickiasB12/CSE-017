
/*CSE17
Mickias Bekele
mib222
Program Description: The purpose of this program is to create
program that functions like hashtable using nodes and links 
Prog6
*/
import java.lang.NullPointerException; // importing for null pointer exception
import java.lang.IndexOutOfBoundsException; /*importing indexoutofbounds exception for index of the list*/

public class Prog6 {

    public static void main(String[] args) {
        Bashtable<Integer> bt = new Bashtable<Integer>(); //initializing bashtable with integer
        bt.put("Blah Blah", 45454); 
        bt.put("Shit", 74747); //assigning strings to integer
        bt.put("Hola como estas", 93390);
        bt.put("Que pasa wey", 7869);
        Bashtable<String> bt2 = new Bashtable<String>(); //initializing a bashtable with strings

        bt2.put("Tell me This", "Tell me That"); //assingning strings to strings
        bt2.put("She said", "Hola comostas");
        bt2.put("She said Konichiwa", "She said Pardon My french");
        //using try catch meth to catch all the exception errors
        try {
            System.out.println("Blah Blah: " + bt.get("Blah Blah")); //printing out the output
            System.out.println("Shit: " + bt.get("Shit")); 
            bt.remove("Shit"); //removing one one node from bashtable object
            System.out.println("Hola comostas: " + bt.get("Hola como estas"));
            System.out.println("Shit: " + bt.get("Shit")); //outputting the removed node
            System.out.println("Tell me This: " + bt2.get("Tell me This"));
            System.out.println("She said: " + bt2.get("She said"));
            bt2.remove("She said");
            System.out.println("She said: " + bt2.get("She said"));
            System.out.println("Wow: " + bt2.get("Wow")); //outputting string object that is not found in the bashtable
        } catch (NullPointerException ex) { //catching nullpointerexception 
            System.out.println(ex.getMessage());
            System.out.println("Not found");
        } catch (IndexOutOfBoundsException ex1) { //catching indexoutofbound exception for index errors
            System.out.println("Indexoutofbound exception ex1");
            System.out.println(ex1.getMessage());
        }//end of catch method

    } //end of main method

}