class Volume {
    public Volume() {
    }

    public void volumeUp(long vol) {
        System.out.println("volume up");
        vol += 5;
        System.out.println(vol);
    }

    public void volumeDown(long vol) {
        System.out.println("volume down");
        vol -= 5;
        System.out.println(vol);
    }
}

interface ICommand {
    void execute(long vol);
}

class volumeHigh implements ICommand {
    private Volume vol;

    public volumeHigh(Volume vol) {
        this.vol = vol;
    }

    public void execute(long vol) {
        this.vol.volumeUp(vol);
    }
}

class volumeDown implements ICommand {
    private Volume vol;

    public volumeDown(Volume vol) {
        this.vol = vol;
    }

    public void execute(long vol) {
        this.vol.volumeDown(vol);
    }
}

class Switch {
    private ICommand UpCommand;
    private ICommand DownCommand;

    public Switch(ICommand UpCommand, ICommand DownCommand) {
        this.UpCommand = UpCommand;
        this.DownCommand = DownCommand;
    }

    public void flipUp(long vol) {
        UpCommand.execute(vol);
    }

    public void flipDown(long vol) {
        DownCommand.execute(vol);
    }
}

public class Command {

    public static void main(String[] args) {
        Volume l = new Volume();
        long vol = 200;
        ICommand up = new volumeHigh(l);
        ICommand down = new volumeDown(l);

        Switch s = new Switch(up,down);
        s.flipUp(vol);
        s.flipDown(vol);
    }

}
