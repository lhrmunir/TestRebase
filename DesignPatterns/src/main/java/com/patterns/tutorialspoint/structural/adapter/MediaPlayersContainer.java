package com.patterns.tutorialspoint.structural.adapter;

public interface MediaPlayersContainer {
    public void play(String audioType, String fileName);
}
/*
Step 1
        Create interfaces for Media Player and Advanced Media Player.

        MediaPlayersContainer.java
*/
// public interface MediaPlayer {
interface MediaPlayer {
    public void play(String audioType, String fileName);
}

// AdvancedMediaPlayer.java

// public interface AdvancedMediaPlayer {
interface AdvancedMediaPlayer {
    public void playVlc(String fileName);
    public void playMp4(String fileName);
}