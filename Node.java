public class Node {
    private String value;
    public Node left;
    public Node right;

    public Node(String v, Node l, Node r) { // class Node
        value = v;
        left = l;
        right = r;
    }

    public Node(int x) {
        value = Integer.toString(x);
        right = null;
        left = null;
    }

    public String getValue() {
        return this.value;
    }

}