import java.util.List;
import java.util.ArrayList;
 /*Bashtable class that puts, gets and removes nodes */
public class Bashtable<T> {
    private Node<T> startNode; //private node that is found in the first place
    public Node<T> nextNode;
    public List<Link> list;

    public Bashtable() { //constructor
        startNode = new Node<>(); //initializing the node object
        list = new ArrayList<Link>(); //initializing link object

    }

    public T get(String key) { //method that gets the node
        char next; //char
        for (int i = 0; i < key.length(); ++i) {
            next = key.charAt(i);
            if (i > 0) {
                nextNode = nextNode.getNode(next);
            } else {
                nextNode = startNode.getNode(next);
            }
        }
        T value = nextNode.getValue(); //getting the value and returning it to another value
        if (value == null) {
            return null; //if there is no value it returns null
        } else {
            return value; //returns the value
        }
    }

    public T remove(String key) { //removes the node
        T value = get(key);
        value = nextNode.valueSetup(null);
        return value; 
    }

    public void put(String key, T value) { //puts or adds node to the bashtable
        char temp;
        for (int i = 0; i < key.length(); ++i) {
            temp = key.charAt(i);
            if (i == 0) {
                nextNode = startNode.attachNode2(temp);

            } else {
                nextNode = nextNode.attachNode2(temp);
            }
        }
        nextNode.valueSetup(value); //adds the node to link of the bashtable

    }
}
