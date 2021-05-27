import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

interface Conversation {

    public void replica(String mesaj, Participant p);

}

class RealConversation implements Conversation {
    //get current date time
    DateFormat dateFormat = new SimpleDateFormat("E dd-MM-yyyy hh:mm a");
    Date date = new Date();

    @Override
    public void replica(String msg, Participant p) {

        System.out.println(p.getName() + "'gets message: " + msg);
        System.out.println("\t\t\t\t" + "[" + dateFormat.format(date).toString() + "]");
    }
}

class FirstPerson extends Participant {

    private String name;
    private Conversation chat;

    @Override
    public void sendMsg(String msg) {
        chat.replica(msg, this);

    }

    @Override
    public void setname(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public FirstPerson(Conversation chat) {
        this.chat = chat;
    }

}


class SecondPerson extends Participant {

    private String name;
    private Conversation chat;

    @Override
    public void sendMsg(String msg) {
        chat.replica(msg, this);

    }

    @Override
    public void setname(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public SecondPerson(Conversation chat) {
        this.chat = chat;
    }

}

abstract class Participant {
    public abstract void sendMsg(String msg);

    public abstract void setname(String name);

    public abstract String getName();
}

public class Mediator {
    public static void main(String[] args) {
        Conversation conversation = new RealConversation();
        FirstPerson u1 = new FirstPerson(conversation);
        u1.setname("John Doe");
        u1.sendMsg("How are you?");


        SecondPerson u2 = new SecondPerson(conversation);
        u2.setname("Betty Tancredi");
        u2.sendMsg("I'm fine");
    }
}
