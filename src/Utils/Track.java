package Utils;

import javafx.scene.media.AudioClip;

public class Track {
    public static final Track BGM = new Track(Asset.Audio.bgm);
    public static final Track BULLETSOUND = new Track(Asset.Audio.bulletSound);
    //    private static final AudioClip enemyBulletSound = Asset.Audio.enemyBulletSound;
//    private static final AudioClip enemyDeathSound = Asset.Audio.enemyDeathSound;
    public static final Track BOSSTHEME = new Track(Asset.Audio.bossFight1);

    public static final Track WARP = new Track(Asset.Audio.warp);

    public static final Track TECHNOSHOOT1 = new Track(Asset.Audio.technoShoot1);
    public static final Track PLAYERDEAD = new Track(Asset.Audio.playerDead);


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
