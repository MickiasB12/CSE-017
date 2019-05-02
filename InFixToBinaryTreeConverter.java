
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;

public class InFixToBinaryTreeConverter { // class InFixToBinaryTreeConverter

    private List<String> inFix;
    private List<String> stack;
    private List<Node> btstack;
    private String expression;

    public InFixToBinaryTreeConverter() {
        inFix = new LinkedList<String>();
        stack = new ArrayList<String>();
        btstack = new ArrayList<Node>();
    }

    public void run(String value) {
        expression = value;
        System.out.println(expression);
        createInFix(expression);
        Node bottom = createBinaryTree();
        inOrder(bottom);
        System.out.println();
        preOrder(bottom);
        System.out.println();
        postOrder(bottom);
        System.out.println("\n" + Value(bottom));

    }

    public void createInFix(String value) {
        String[] array = value.split("\\s]+");
        String[] newString = new String[array.length + 2];
        newString[0] = "(";
        for (int i = 0; i < array.length; i++) {
            newString[i + 1] = array[i];
        }
        newString[array.length + 1] = ")";

        for (String input : newString) {
            Scanner scan = new Scanner(input);

            if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/") || input.equals("(")
                    || input.equals(")") || scan.hasNextInt()) {
                inFix.add(input);
            } else {
                System.exit(0);
            } // end of if statement
            scan.close();
        } // end of for loop

    }

    public Node createBinaryTree() {
        while (!(inFix.isEmpty())) {
            String current = inFix.remove(0);
            Scanner newScanner = new Scanner(current);
            if (newScanner.hasNextInt()) {
                int number = newScanner.nextInt();
                Node next = new Node(number);
                btstack.add(next);
            } else {
                String ne = newScanner.next();
                if (ne.equals("+") || ne.equals("/") || ne.equals("*") || ne.equals("-")) {
                    if (!(stack.isEmpty())) {
                        String newone = stack.get(stack.size() - 1);
                        boolean check = newone.equals("+") || newone.equals("*") || newone.equals("/")
                                || newone.equals("-");

                        while (check) {
                            if (stack.isEmpty()) {
                                break;
                            }
                            Node firstNode = btstack.remove(btstack.size() - 1);
                            Node secondNode = btstack.remove(btstack.size() - 1);
                            String operator = stack.remove(stack.size() - 1);
                            Node anotherNode = new Node(operator, secondNode, firstNode);
                            btstack.add(anotherNode);
                            newone = stack.get(stack.size() - 1);
                            check = newone.equals("+") || newone.equals("*") || newone.equals("/")
                                    || newone.equals("-");

                        }
                    }
                    stack.add(ne);
                } else if (ne.equals("(")) {
                    stack.add(ne);

                } else if (ne.equals(")")) {
                    String anotherOne = stack.get(stack.size() - 1);
                    while (anotherOne.equals("(")) {

                        Node first = btstack.remove(btstack.size() - 1);
                        Node second = btstack.remove(btstack.size() - 1);
                        String off = stack.remove(stack.size() - 1);
                        Node newone1 = new Node(off, second, first);
                        btstack.add(newone1);
                        anotherOne = stack.get(stack.size() - 1);

                    }
                    stack.remove(stack.size() - 1);
                }
            }
            newScanner.close();
        }
        return btstack.remove(0);
    }

    public void preOrder(Node blah) {
        if (blah != null) {
            System.out.println(blah.getValue() + " ");
            preOrder(blah.left);
            preOrder(blah.right);
        }
    }

    public void inOrder(Node blah) {
        if (blah != null) {
            inOrder(blah.left);
            System.out.print(blah.getValue() + " ");
            inOrder(blah.right);
        }
    }

    public void postOrder(Node blah) {
        if (blah != null) {
            postOrder(blah.left);
            postOrder(blah.right);
            System.out.print(blah.getValue() + " ");
        }
    }

    public int Value(Node value) {
        Scanner newScanner = new Scanner(value.getValue());
        int number = 0;
        if (value != null) {
            if (value.getValue() == "+") {
                number = Value(value.left) + Value(value.right);

            } else if (value.getValue() == "-") {
                number = Value(value.left) - Value(value.right);
            } else if (value.getValue() == "/") {
                number = Value(value.left) / Value(value.right);

            } else if (value.getValue() == "*") {
                number = Value(value.left) * Value(value.right);

            } else {
                number = newScanner.nextInt();
            }

        }
        newScanner.close();
        return number;
    }

    public boolean check(String x, String y) {
        if (x.equals("+")) {// if the next symbol is a "+"
            if (y.equals("+")) {
                return true;
            } else if (y.equals("-")) {
                return true;
            } else if (y.equals("*")) {
                return false;
            } else if (y.equals("/")) {
                return false;
            }
        } else if (x.equals("-")) {// if the next symbol is a "-"
            if (y.equals("+")) {
                return true;
            } else if (y.equals("-")) {
                return true;
            } else if (y.equals("*")) {
                return false;
            } else if (y.equals("/")) {
                return false;
            }
        } else if (x.equals("*")) {// if the next symbol is a "*"
            if (y.equals("+")) {
                return true;
            } else if (y.equals("-")) {
                return true;
            } else if (y.equals("*")) {
                return true;
            } else if (y.equals("/")) {
                return true;
            }
        } else if (x.equals("/")) {// if the next symbol is a "/"
            if (y.equals("+")) {
                return true;
            } else if (y.equals("-")) {
                return true;
            } else if (y.equals("*")) {
                return true;
            } else if (y.equals("/")) {
                return true;
            }
        }
        return false;// else return false
    }

}