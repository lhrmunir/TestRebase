package com.patterns.tutorialspoint.structural.adapter_by_rodicad.mediaPlayer;

/**
 * Created by rodicad on 26/10/2017.
 */
public class MediaAdapter {
    private AdvancedMediaPlayer advancedPlayer;

    public MediaAdapter( String type ) {
        if ( type.equals( "vlc" ) ) {
            advancedPlayer = new VLCPlayer();

        } else if ( type.equals( "mp4" ) ) {
            advancedPlayer = new MP4Player();
        }
    }

    public void play(  String filename ) {
        advancedPlayer.play( filename );
    }

}
