package everything.design_patterns.tests.memento;

/**
 * User: Makar Kalancha
 * Date: 09/04/2016
 * Time: 23:25
 */
public class Originator {
    private String state;

    public void setState(String state){
        System.out.println("Originator set state: "+state);
        this.state = state;
    }

    public Memento saveState(){
        System.out.println("Originator save state: "+state);
        return new Memento(state);
    }

    public String restoreState(Memento m){
        state = m.getState();
        System.out.println("Originator restore state: "+state);
        return state;
    }
}
