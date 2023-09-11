//Занятие 3. Задача 1.

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Директории
        ArrayList<String> directory = new ArrayList<>();
        directory.add("Games/temp");
        directory.add("Games/src");
        directory.add("Games/res");
        directory.add("Games/savegames");

        ArrayList<String> directorySrc = new ArrayList<>();
        directorySrc.add("Games/src/main");
        directorySrc.add("Games/src/test");

        ArrayList<String> directoryRes = new ArrayList<>();
        directoryRes.add("Games/res/drawables");
        directoryRes.add("Games/res/vectors");
        directoryRes.add("Games/res/icons");

        for (String dir:directory) {
            setupGamesDir(dir);
        }

        for (String dir:directorySrc) {
            setupGamesDir(dir);
        }

        for (String dir:directoryRes) {
            setupGamesDir(dir);
        }
        // Файлы
        ArrayList<String> filesMain = new ArrayList<>();
        filesMain.add("Main.java");
        filesMain.add("Utils.java");

        for (String file: filesMain) {
            setupGamesFile("Games/src/main", file);
        }
        //setupGamesFile("Games/temp", "temp.txt");

        System.out.println("Процесс установки завершен");

    }

    public static void setupGamesDir(String dir) {

        //Журнал логов через StringBuilder
        StringBuilder log = new StringBuilder();

        File setup = new File(dir);

        if (setup.mkdir())
            log.append(setup + ": директория создана\n");
        else
            log.append(setup + ": ошибка при создани директории\n");

        log(log.toString());
    }

    public static void log(String log) {
        //относительный: try (FileOutputStream fos = new FileOutputStream("/Games/temp/temp.txt", true)) {
        try (FileOutputStream fos = new FileOutputStream("C:/Users/filyuzin/IdeaProjects/netology_core_ser_1/Games/temp/temp.txt", true)) {
            fos.write(log.getBytes());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void setupGamesFile(String dir, String file) {

        File mainJava = new File(dir, file);

        try {
            if (mainJava.createNewFile())
                log(mainJava + ": файл создан\n");
            else
                log(mainJava + ": файл не создан\n");
        } catch (IOException e) {
            log(mainJava + ": ошибка при создании файла\n");
            throw new RuntimeException(e);
        }

    }

}