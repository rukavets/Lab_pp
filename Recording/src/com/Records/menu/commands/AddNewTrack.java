package com.Records.menu.commands;
import com.Records.InfoTrack.Track;

public class AddNewTrack implements MenuExecute{
    @Override
    public void execute(Track track) {
        System.out.println("You add a track!");
    }
}
