package com.program.command.redoAble;

import com.program.command.Command;
import com.program.entity.Disk;
import com.program.entity.music.Music;

import java.util.Scanner;

public class DeleteCommand extends Command implements RedoAble {

    public DeleteCommand(Disk disk) {
        super(disk);
        setName("Delete");
    }

    @Override
    public boolean execute() {
        int count=0;
        Scanner scanner = new Scanner(System.in);
        int input;
        boolean check =false;

        if(save.getMusicList().isEmpty()){
            System.out.println("Нема що видаляти....");
            return false;
        }
        System.out.println("\n┌------------------------------------------------------------------------┐");
        for(Music music : save.getMusicList()){
            count++;
            System.out.format("|%-3d|%-40s|%2d:%-2d| %-20s|%n",count,music.getName(),music.getDuration()/60,music.getDuration()%60,music.getStyle());
        }
        System.out.println("└------------------------------------------------------------------------┘\n");
        System.out.print("Ух... Напишіть порядок композиції яку композицію хочете видалити\n>");
        do {
            if(check){
                System.out.println("Помикла вводу. Попадіть в рамки пісень.");
            }
            input = scanner.nextInt();
            check = true;
        }while(input<1 || input > save.getMusicList().size());
        Disk disk = saveDisk(save);
        save.getMusicList().remove(input - 1);
        save = disk;
        return  true;
    }
}
