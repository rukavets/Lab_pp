package com.Records.menu;
import com.Records.InfoTrack.Track;

public class MainMenu {
    private final Menu menu = new Menu();
    Track track = new Track();
    public void start(){
        menu.openProgram(track);
    }
}
