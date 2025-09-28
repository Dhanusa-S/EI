package patterns;

// Target interface
interface MediaPlayer {
    void play(String fileName);
}

// Adaptee (legacy class)
class LegacyMediaPlayer {
    public void playFile(String file) {
        System.out.println("Playing legacy file: " + file);
    }
}

// Adapter
class MediaAdapter implements MediaPlayer {
    private LegacyMediaPlayer legacyPlayer;

    public MediaAdapter(LegacyMediaPlayer legacyPlayer) {
        this.legacyPlayer = legacyPlayer;
    }

    public void play(String fileName) {
        legacyPlayer.playFile(fileName);
    }
}

// Client
public class AdapterDemo {
    public static void main(String[] args) {
        LegacyMediaPlayer oldPlayer = new LegacyMediaPlayer();
        MediaPlayer newSystem = new MediaAdapter(oldPlayer);

        newSystem.play("old_song.mp3");
    }
}
