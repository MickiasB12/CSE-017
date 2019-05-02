
/*
CSE 17
Mickias Bekele
mib222
The purpose of the program is to convert an expression to a binary tree and perform
arthimetic
*/
public class Prog7 { // class Prog7
    public static void main(String[] args) {
        InFixToBinaryTreeConverter fp = new InFixToBinaryTreeConverter();
        fp.run("(( 6 + 2 ) - 5 ) * 8 / 2");
    }
}