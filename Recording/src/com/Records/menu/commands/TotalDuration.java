package com.Records.menu.commands;
import com.Records.InfoTrack.Track;

public class TotalDuration implements MenuExecute{
    @Override
    public void execute(Track track) {
        System.out.println("Total duration of all tracks!");
    }
}
