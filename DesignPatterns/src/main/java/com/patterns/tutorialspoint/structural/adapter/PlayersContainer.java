package com.patterns.tutorialspoint.structural.adapter;

//public class PlayersContainer {
//}

/*
Step 2
        Create concrete classes implementing the AdvancedMediaPlayer interface.

        VlcPlayer.java
*/
// public class VlcPlayer implements AdvancedMediaPlayer{
class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //do nothing
    }
}

/*
Mp4Player.java
*/
// public class Mp4Player implements AdvancedMediaPlayer{
class Mp4Player implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        //do nothing
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
