package com.program.command;

import com.program.entity.Disk;

public abstract class Command {
    private  String name;
    protected Disk save;

    public abstract boolean execute();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected Command( Disk disk){
        save = disk;
        name = "Command";
    }
}
