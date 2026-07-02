
//strategy for different speed players
interface PlaybackStrategy {
    void play();
}

class NormalPlayback implements PlaybackStrategy {
    public void play() {
        System.out.println("Playing at 1x speed..!!!");
    }
}

class SlowPlayBack implements PlaybackStrategy {
    public void play() {
        System.out.println("Playing at 0.5x speed ..!!");
    }
}

class FastPlayback implements PlaybackStrategy {
    public void play() {
        System.out.println("Playing at 2x speed ..!!");
    }
}

class MusicPlayer {
    private String songName;
    private PlaybackStrategy p;

    public MusicPlayer(String songName, PlaybackStrategy p) {
        this.songName = songName;
        this.p = p;
    }

    public void PlayMusic() {
        p.play();
    }

    public void displaySongInfo() {
        System.out.println("Now playing : " + songName);
    }

    public void setStrategy(PlaybackStrategy p) {
        this.p = p;
    }
}

public class Main {
    public static void main(String args[]) {
        MusicPlayer player = new MusicPlayer("Believer", new NormalPlayback());
        player.PlayMusic();
        player.setStrategy(new SlowPlayBack());
        player.displaySongInfo();

        player.PlayMusic();
        player.setStrategy(new FastPlayback());
        player.PlayMusic();

        player.displaySongInfo();
        // strategies are changing at run time
    }
}
