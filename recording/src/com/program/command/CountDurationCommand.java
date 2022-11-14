package com.program.command;

import com.program.entity.Disk;
import com.program.entity.music.Music;


public class CountDurationCommand extends Command{

    public CountDurationCommand(Disk disk){
        super(disk);
        setName("CountDuration");
    }

    @Override
    public boolean execute() {
        int duration=0;
        for(Music music: save.getMusicList()){
            duration+= music.getDuration();
        }

        System.out.format("%nTotal time is %d hours, %d minutes and %d seconds.",duration/3600,(duration%3600)/60,(duration%360)%60);
        return true;
    }
}

