package com.program.command.redoAble;

import com.program.command.Command;
import com.program.entity.Disk;
import com.program.manager.MusicManager;

import java.util.Scanner;

public class KeyboardReaderCommand extends Command implements RedoAble {

    public KeyboardReaderCommand(Disk disk) {
        super(disk);
        setName("KeyboardReader");
    }

    @Override
    public boolean execute() {
        Disk disk = saveDisk(save);
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        String tempName;
        int tempDuration;
        int tempStyle;
        int countinue = 0;
        do{
            System.out.print("\nОкей, введи назву пісні\n");
            System.out.print(">");
            tempName = scanner1.nextLine();
            System.out.print("\nАга, і ще жанр пісні будь ласка\n\n");
            MusicManager.printMusicGenres();
            System.out.print(">");
            tempStyle = scanner.nextInt();
            System.out.print("\nГаразд, тепер введи довжину треку (в секундах)\n>");
            tempDuration = scanner.nextInt();

            save.getMusicList().add(MusicManager.getCreatedClass(tempName,tempDuration,tempStyle-1));
            System.out.print("\nКлас, додаємо ще когось? ([1]Так)\n>");
            countinue = scanner.nextInt();
        }while(countinue == 1);
        save = disk;
        return true;
    }
}

