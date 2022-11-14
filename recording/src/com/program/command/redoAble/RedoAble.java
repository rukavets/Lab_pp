package com.program.command.redoAble;

import com.program.entity.Disk;

public interface RedoAble {
    default Disk saveDisk(Disk save){
        try {
            return save.clone();
        } catch (Exception e) {
            System.out.println("Не правильно використаний клас для колування.");
            return save;
        }
    }
}

