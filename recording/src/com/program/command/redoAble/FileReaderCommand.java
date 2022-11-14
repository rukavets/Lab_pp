package com.program.command.redoAble;

import com.program.command.Command;
import com.program.entity.Disk;
import com.program.manager.MusicManager;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderCommand extends Command implements RedoAble {

    public FileReaderCommand(Disk disk) {
        super(disk);
        setName("FileReader");
    }

    @Override
    public boolean execute() {

        Disk disk = saveDisk(save);
        try(FileReader reader = new FileReader(getFileName())){
            StringBuilder sb = new StringBuilder();
            int c =0;
            String name;
            int duration;
            String genre;
            while (c!=-1) {
                while ((c = reader.read()) != 10 && c != -1) {
                    sb.append((char) c);
                }
                if(c == -1){
                    break;
                }
                name = sb.toString().trim();
                sb.delete(0,sb.length());

                while ((c = reader.read()) != 10 && c != -1) {
                    sb.append((char)c);
                }
                duration = Integer.parseInt(sb.toString().trim());
                sb.delete(0,sb.length());

                while ((c = reader.read()) != 10 && c != -1) {
                    sb.append((char)c);
                }
                genre = sb.toString().trim();
                sb.delete(0,sb.length());

                save.getMusicList().add(MusicManager.getCreatedClass(name,duration,MusicManager.genreStringToIntConverter(genre)));
            }

            save = disk;
        } catch (IOException e) {
            System.out.println("Файл не знайдено, перевірте чи вірно все написали...");
            return false;
        }


        return true;
    }

    private String getFileName(){
        String fileName;
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\tВведіть назву файлу\n>");
        fileName = scanner.nextLine();
        fileName.trim();
        if(!fileName.matches("(.*\\.txt)")){
            fileName = fileName + ".txt";
        }
        return fileName;
    }
}

