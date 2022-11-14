package com.program.command.redoAble;

import com.program.command.Command;
import com.program.entity.Disk;
import com.program.entity.music.Music;

import java.util.Comparator;

public class SortCommand extends Command implements RedoAble {

    public SortCommand(Disk disk) {
        super(disk);
        setName("Sort");
    }

    @Override
    public boolean execute() {
        if(save.getMusicList().isEmpty()) {
            System.out.println("Тут немає що сортувати.");
            return false;
        }
        Disk disk = saveDisk(save);
        save.getMusicList().sort(Comparator.comparing(Music::getStyle));
        save = disk;
        return true;
    }
}

