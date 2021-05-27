
import java.util.ArrayList;
import java.util.List;

interface Observer {

    public void notification(String handle, String tweet);

}


interface Subject {

    public void addSubscriber(Observer observer);

    public void removeSubscriber(Observer observer);
    public void notifySubscribers(String tweet);

}

class PublicFigure implements Subject {

    protected List<Observer> observers = new ArrayList<Observer>();

    protected String name;

    protected String handle;


    public PublicFigure(String name, String handle) {

        super();

        this.name = name;

        this.handle = "#" + handle;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public String getHandle() {

        return handle;

    }

    public void tweet(String tweet) {

        System.out.printf("\nName: %s, Tweet: %s\n", name, tweet);

        notifySubscribers(tweet);

    }

    @Override

    public synchronized void addSubscriber(Observer observer) {

        observers.add(observer);

    }

    @Override
    public synchronized void removeSubscriber(Observer observer) {

        observers.remove(observer);

    }

    @Override
    public void notifySubscribers(String tweet) {

        observers.forEach(observer -> observer.notification(handle, tweet));

    }

}

class Follower implements Observer {

    protected String name;

    public Follower(String name) {

        super();

        this.name = name;

    }

    @Override

    public void notification(String handle, String tweet) {

        System.out.printf("'%s' received notification from Handle: '%s', Tweet: '%s'\n", name, handle, tweet);

    }

}

public class ObserverPattern {
    public static void main(String[] args) {

        //trash
        PublicFigure dodon = new PublicFigure("Igor Dodon", "dodon");

        PublicFigure sandu = new PublicFigure("Maia Sandu", "sandu");

        Follower ion = new Follower("ion");

        Follower victor = new Follower("victor");

        Follower rodica = new Follower("rodica");

        Follower mihai = new Follower("mihai");

        Follower pavel = new Follower("pavel");

        dodon.addSubscriber(ion);

        dodon.addSubscriber(victor);

        dodon.addSubscriber(rodica);

        dodon.addSubscriber(mihai);

        dodon.addSubscriber(pavel);

        sandu.addSubscriber(ion);

        sandu.addSubscriber(victor);

        sandu.addSubscriber(rodica);

        sandu.addSubscriber(mihai);

        sandu.addSubscriber(pavel);

        dodon.tweet("Buna ziua cetateni!");

        sandu.tweet("Va doresc sanatate!");

        dodon.removeSubscriber(rodica);

        dodon.tweet("Stati acasa!");
    }
}
