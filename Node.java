import java.util.List;
import java.util.LinkedList;
/*Node class*/

public class Node<T> {
    public T tvalue; //initialing T value

    private List<Link> links; //list that links all the list
    private int index; //int index for the list

    public Node() { //contstructor
        links = new LinkedList<Link>(); //initializing the links
        index = 0; //initializing the index for the list
    }

    public int getNext(char x) { //getting the next index of the list
        index = -1;
        if (!(links.isEmpty())) { //if there is node in the links it assigns the index for i and returns index
            for (int i = 0; i < links.size(); ++i) {
                if (x == links.get(i).getChar()) {
                    index = i;
                }

            }
            return index; //returns index

        } else {
            return -1; //if the link doesn't contain the node
        }

    }

    public Node<T> attachNode2(char x) { //attaches the node
        int ind = getNext(x);
        Link<T> node = new Link<T>(x);
        if (ind != -1) {
            return links.get(ind).attachNode(); //calles another attachnode 
        } else {

            links.add(node);
            return node.attachNode(); //otherwise it calls the attachnode from node objects
        }
    }

    public Node<T> getNode(char x) throws NullPointerException {
        index = -1;
        if (links.isEmpty()) {
            throw new NullPointerException();
        } else {
            for (int i = 0; i < links.size(); ++i) {
                if (x == links.get(i).getChar()) {
                    index = i;
                }
            }
            return links.get(index).attachNode();
        }

    }

    public T valueSetup(T va) { //setting the node to another value
        tvalue = va;
        return tvalue;
    }

    public T getValue() { //getting the value of the node of the list
        return this.tvalue;
    }
}