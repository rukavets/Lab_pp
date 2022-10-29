package com.Records.menu.commands;
import com.Records.InfoTrack.Track;

public class PrintAll implements MenuExecute{
    @Override
    public void execute(Track track) {
        System.out.println("This is list of tracks!");
    }
}
