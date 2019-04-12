 /*Link class*/
public class Link<T> {
    private char charLink; //initializing char
    public Node<T> nextNode; //initializing node

    public Link(char x) { //constructor
        charLink = x;
        nextNode = new Node<>(); //initializing the node

    }

    public Node<T> attachNode() { //attaches the node
        return this.nextNode;

    }

    public char getChar() { //returns the character
        return charLink;
    }

}