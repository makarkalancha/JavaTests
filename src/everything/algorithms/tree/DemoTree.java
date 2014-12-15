package everything.algorithms.tree;

import javax.swing.*;

/**
 * User: Makar Kalancha
 * Date: 15/12/2014
 * Time: 15:09
 */
public class DemoTree {
    public static void main(String[] args) {
        Node five = new Node("5");
        Node eleven = new Node("11");
        Node six = new Node("6", new Node[]{five, eleven});
        Node two = new Node("2");
        Node seven = new Node("7", new Node[]{two, six});

        Node four = new Node("4");
        Node nine = new Node("9", new Node[]{four});
        Node five_1 = new Node("5", new Node[]{nine});

        Node two_1 = new Node("2", new Node[]{seven, five_1});

//        getAllNodes(two_1);
//        System.out.println(getChildren(two_1));
        getChildren(two_1,1);
    }

    public static void getAllNodes(Node root) {
        String separator = "..";
        System.out.println(separator+root);

    }

    public static String alignator(int level){
        String separator = "..";
        if(level < 2) {
            return separator;
        } else {
            return separator + alignator(--level);
        }
    }

    public static void getChildren(Node root,int level) {
        System.out.println(alignator(level)+root);
        if (root.getChildren() != null) {
            if (root.getChildren().length > 1) {
                getChildren(root.getChildren()[0],++level);
                getChildren(root.getChildren()[1],level);
            } else {
                getChildren(root.getChildren()[0],++level);
            }
        }
    }
}
