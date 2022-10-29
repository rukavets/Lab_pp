package com.Records.menu.commands;
import com.Records.InfoTrack.Track;

public class SortingByStyle implements MenuExecute{
    @Override
    public void execute(Track track) {
        System.out.println("You sorted all tracks by style!");
    }
}
