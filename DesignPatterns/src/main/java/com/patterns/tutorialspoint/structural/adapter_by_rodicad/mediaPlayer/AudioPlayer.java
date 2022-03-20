package com.patterns.tutorialspoint.structural.adapter_by_rodicad.mediaPlayer;

/**
 * Created by rodicad on 26/10/2017.
 */
public class AudioPlayer implements MediaPlayer {

    private MediaAdapter mediaAdapter;

    @Override public void play( String audioType, String fileName ) {
        if ( audioType.equals( "audio" ) ) {
            System.out.println( "Playing audio file: " + fileName );
        } else {
            mediaAdapter = new MediaAdapter( audioType );
            mediaAdapter.play( fileName );
        }
    }
}
