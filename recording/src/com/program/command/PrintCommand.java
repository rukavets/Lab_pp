package com.program.command;

import com.program.entity.Disk;
import com.program.entity.music.Music;

public class PrintCommand extends Command{

    public PrintCommand(Disk disk) {
        super(disk);
        setName("Print");
    }

    @Override
    public boolean execute() {
        int count=0;
        if(save.getMusicList().isEmpty()){
            System.out.println("Немає елементів :(");
            return false;
        }
        System.out.println("\n┌------------------------------------------------------------------------┐");
        for(Music music : save.getMusicList()){
            count++;
            System.out.format("|%-3d|%-40s|%2d:%-2d| %-20s|%n",count,music.getName(),music.getDuration()/60,music.getDuration()%60,music.getStyle());
        }
        System.out.println("└------------------------------------------------------------------------┘\n\n\n");
        return true;
    }
}
