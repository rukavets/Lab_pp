package com.program.command;

import com.program.entity.Disk;
import com.program.entity.music.Music;

import java.io.FileWriter;

public class SaveCommand extends Command {

    public SaveCommand(Disk disk){
        super(disk);
        setName("Save");
    }

    @Override
    public boolean execute() {
        try(FileWriter fw = new FileWriter("musicDisk.txt")) {
            for(Music music: save.getMusicList()) {
                fw.write(music.toString());
            }
            fw.flush();
        } catch (Exception e) {
            System.out.println("Помилка запису на диск.");
            return false;
        }
        save.getMusicList();
        return true;
    }
}

