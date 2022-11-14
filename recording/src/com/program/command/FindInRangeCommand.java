package com.program.command;

import com.program.entity.Disk;
import com.program.entity.music.Music;

import java.util.Scanner;

public class FindInRangeCommand extends Command{
    public FindInRangeCommand(Disk disk) {
        super(disk);
        setName("FindInRange");
    }

    @Override
    public boolean execute() {
        Scanner scanner = new Scanner(System.in);
        int a1,a2,temp,count=0;
        boolean check = false;

        System.out.print("Окей введи межі довжин треків\n\nВведи першу межу\n>");
        a1 = scanner.nextInt();
        System.out.print("\nТепер другу межу\n>");
        a2 = scanner.nextInt();

        if(a1 > a2){
            temp = a1;
            a1 = a2;
            a2 = temp;
        }

        for(Music music: save.getMusicList()){
            if(music.getDuration() >= a1 && music.getDuration() <= a2){
                check = true;
                count++;
                System.out.format("|%-3d|%-40s|%2d:%-2d| %-20s|%n",count,music.getName(),music.getDuration()/60,music.getDuration()%60,music.getStyle());
            }
        }
        if (!check){
            System.out.println("Немає елементів");
            return  false;
        }
        return true;
    }
}

