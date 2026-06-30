import java.util.*;

interface PlayListItems {
    void play();
}

class Song implements PlayListItems {
    String song;

    public Song(String song) {
        this.song = song;
    }

    public void play() {
        System.out.println("Playing song : " + song);

    }

    @Override
    public String toString() {
        return song;
    }

}

class Podcast implements PlayListItems {
    String podcast;

    public Podcast(String podcast) {
        this.podcast = podcast;
    }

    public void play() {
        System.out.println("Playing podcast : " + podcast);
    }

    @Override
    public String toString() {
        return podcast;
    }
}

class PlayList {
    List<PlayListItems> list = new ArrayList<>();

    public void addItem(PlayListItems item) {
        list.add(item);
        System.out.println(item + " added to Playlist");
    }

    public void playAll() {
        for (PlayListItems item : list) {

            item.play();
        }
    }

    @Override
    public String toString() {
        return "PlayList [list=" + list + "]";
    }

}

interface Storage {
    void save(PlayList playList);
}

class LocalStorage implements Storage {
    public void save(PlayList playList) {
        System.out.println(playList + " Saved locally !!");
    }

}

class CloudStorage implements Storage {
    public void save(PlayList playList) {
        System.out.println(playList + " Saved to Cloud !!");
    }
}

class Player {
    PlayList playList;
    Storage storage;

    public Player(PlayList playList, Storage storage) {
        this.playList = playList;
        this.storage = storage;
    }

    public void addSong(String song) {
        playList.addItem(new Song(song));
    }

    public void addPodcast(String podcast) {
        playList.addItem(new Podcast(podcast));
    }

    public void playPlayList() {
        playList.playAll();
    }

    public void saveThePlayList() {
        storage.save(playList);
    }
}

public class Main {
    @Override
    public String toString() {
        return "Main []";
    }

    public static void main(String args[]) {
        PlayList playList = new PlayList();
        Storage cloud = new CloudStorage();

        Player player = new Player(playList, cloud);
        player.addSong("Hungry Cheetah");
        player.addPodcast("Telugu Hits");
        player.playPlayList();
        player.saveThePlayList();
    }
}
