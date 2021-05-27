import java.util.ArrayList;
import java.util.List;

class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}

class Originator {
    private String state;

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }
}

class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}

public class MementoPattern {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("Stare #1");
        originator.setState("Stare #2");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("Stare #3");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("Stare #4");
        System.out.println("Current Stare: " + originator.getState());

        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("Prima stare salvata: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("A doua stare salvata: " + originator.getState());
    }
}
