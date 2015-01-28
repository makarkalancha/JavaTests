package everything.algorithms.byRobertLafore.ch13;

/**
 * User: Makar Kalancha
 * Date: 27/01/2015
 * Time: 11:27
 */
public class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char lab) {
        this.label = lab;
        wasVisited = false;
    }
}
