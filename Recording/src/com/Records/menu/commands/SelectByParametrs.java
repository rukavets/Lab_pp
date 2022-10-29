package com.Records.menu.commands;
import com.Records.InfoTrack.Track;

public class SelectByParametrs implements MenuExecute{
    @Override
    public void execute(Track track) {
        System.out.println("You selected some parametr!");
    }
}
