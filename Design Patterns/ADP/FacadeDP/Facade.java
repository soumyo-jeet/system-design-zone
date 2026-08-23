// Home theater attributes
class Tv {
    public void turnOn () {
        System.out.println("TV is turned on.");
    }
}
class Light {
    public void dimLight () {
        System.out.println("Light is dimmed.");
    }
}
class MusicPlayer {
    public void playMusic () {
        System.out.println("Music is playing.");
    }
}
class DvdPlayer {
    public void playDvd () {
        System.out.println("DVD is playing.");
    }
}

// Home theater remote -> Facade class
class Remote {
    private Tv tv;
    private Light light;
    private MusicPlayer musicPlayer;
    private DvdPlayer dvdPlayer;

    public Remote(Tv tv, Light light, MusicPlayer musicPlayer, DvdPlayer dvdPlayer) {
        this.tv = tv;
        this.light = light;
        this.musicPlayer = musicPlayer;
        this.dvdPlayer = dvdPlayer;
    }

    public void playMovie () {
        System.out.println("Setting up the theater system...");
        this.tv.turnOn();
        this.light.dimLight();
        this.dvdPlayer.playDvd();
        this.musicPlayer.playMusic();
    }
}


public class Facade {
    public static void main(String[] args) {
        Remote clientRemote = new Remote(new Tv(), 
        new Light(), 
        new MusicPlayer(),
        new DvdPlayer());

        clientRemote.playMovie();
    }
}
