package Utils;

import javafx.scene.media.AudioClip;

public class Track {
    public static final Track bgm = new Track(Asset.Audio.bgm);
    public static final Track bossTheme = new Track(Asset.Audio.bossFight1);
    public AudioClip audioClip;
    public Track(AudioClip audioClip) {
        this.audioClip = audioClip;
    }
    public void play() {
        audioClip.play();
    }
    public void stop() {
        audioClip.stop();
    }
    public void setVolume(double volume) {
        audioClip.setVolume(volume);
    }
    public void setCycleCount(int cycleCount) {
        audioClip.setCycleCount(cycleCount);
    }
}
