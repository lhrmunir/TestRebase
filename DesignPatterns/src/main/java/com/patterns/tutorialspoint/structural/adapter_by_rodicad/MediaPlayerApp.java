package com.patterns.tutorialspoint.structural.adapter_by_rodicad;

import com.patterns.tutorialspoint.structural.adapter_by_rodicad.mediaPlayer.AudioPlayer;

/**
 * Created by rodicad on 26/10/2017.
 */
public class MediaPlayerApp {

    public static void main(String[] args) {
        AudioPlayer musicPlayer = new AudioPlayer();

        musicPlayer.play( "audio", "verde-imparat.aud" );
        musicPlayer.play( "mp4", "berreta.mp4" );
        musicPlayer.play( "vlc", "vaya-ser.vlc" );


    }
}
