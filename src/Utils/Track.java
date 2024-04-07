package Utils;

import javafx.scene.media.AudioClip;

public class Track {
    public static final Track bgm = new Track(Asset.Audio.bgm);
    public static final Track bulletSound = new Track(Asset.Audio.bulletSound);
//    private static final AudioClip enemyBulletSound = Asset.Audio.enemyBulletSound;
//    private static final AudioClip enemyDeathSound = Asset.Audio.enemyDeathSound;
    public static final Track bossTheme = new Track(Asset.Audio.bossFight1);

    public static final Track warp = new Track(Asset.Audio.warp);



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
    public void setRate(double rate) {
        audioClip.setRate(rate);
    }
    public void setCycleCount(int cycleCount) {
        audioClip.setCycleCount(cycleCount);
    }
}
