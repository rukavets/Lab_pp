package com.Records.menu.commands;
import com.Records.InfoTrack.Track;

public class Exit implements MenuExecute{
    @Override
    public void execute(Track track) {
        System.out.println("You ended your session!");
        System.exit(0);
    }
}
