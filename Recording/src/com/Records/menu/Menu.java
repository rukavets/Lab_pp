package com.Records.menu;
import com.Records.InfoTrack.Track;
import com.Records.menu.commands.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final Map<Integer, MenuExecute> command = new HashMap<>();
    public Menu() {
        command.put(1, new AddNewTrack());
        command.put(2, new DeletingTrack());
        command.put(3, new SelectByParametrs());
        command.put(4, new TotalDuration());
        command.put(5, new SortingByStyle());
        command.put(6, new PrintAll());
        command.put(7, new Exit());
    }

    public void openProgram(Track track){
        Menu menu =new Menu();
        Scanner scanner= new Scanner(System.in);
        while(true){
            menu();
            System.out.println("Input your choice:");
            MenuExecute inp = command.get(scanner.nextInt());
            if(inp!= null) inp.execute(track);
        }
    }
    public void menu(){
        System.out.println("\n1 - add new track\n2 - delete track\n3 - select track\n4 - get total duration\n5 - sorting by style\n6 - print all tracks\n7 - exit programm");
    }
}
