package com.program.command;

import com.program.entity.Disk;
import com.program.manager.Menu;

public class ExitCommand extends Command{

    public ExitCommand(Disk disk) {
        super(disk);
        setName("Exit");
    }

    @Override
    public boolean execute() {
        Menu.setIsRunning(false);
        return true;
    }
}

