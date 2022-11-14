package com.program.command;

import com.program.entity.Disk;
import com.program.manager.Menu;
import com.program.manager.UndoManager;

import java.util.Objects;

public class UndoCommand extends Command{

    public UndoCommand(Disk disk) {
        super(disk);
        setName("Undo");
    }

    @Override
    public boolean execute() {
        if(!UndoManager.isEmpty()) {
            Menu.setDisk(Objects.requireNonNull(UndoManager.pop()).save);
            return true;
        }
        return false;
    }
}
