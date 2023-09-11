//Занятие 3. Задача 1.

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        //Журнал логов через StringBuilder
        StringBuilder log = new StringBuilder();

        // Директории
        File src = new File("Games/src");
        File res = new File("Games/res");
        File saveGames = new File("Games/savegames");
        File temp = new File("Games/temp");

        File main = new File("Games/src/main");
        File test = new File("Games/src/test");

        File drawables = new File("Games/res/drawables");
        File vectors = new File("Games/res/vectors");
        File icons = new File("Games/res/icons");

        if (src.mkdir())
            log.append(src + ": директория создана\n");
        else
            log.append(src + ": ошибка при создани директории\n");
        if (res.mkdir())
            log.append(res + ": директория создана\n");
        else
            log.append(res + ": ошибка при создани директории\n");
        if (saveGames.mkdir())
            log.append(saveGames + ": директория создана\n");
        else
            log.append(saveGames + ": ошибка при создани директории\n");

        if (temp.mkdir())
            log.append(temp + ": директория создана\n");
        else
            log.append(temp + ": ошибка при создани директории\n");

        if (main.mkdir())
            log.append(main + ": директория создана\n");
        else
            log.append(main + ": ошибка при создани директории\n");
        if (test.mkdir())
            log.append(test + ": директория создана\n");
        else
            log.append(test + ": ошибка при создани директории\n");

        if(drawables.mkdir())
            log.append(drawables + ": директория создана\n");
        else
            log.append(drawables + ": ошибка при создани директории\n");
        if(vectors.mkdir())
            log.append(vectors + ": директория создана\n");
        else
            log.append(vectors + ": ошибка при создани директории\n");
        if(icons.mkdir())
            log.append(icons + ": директория создана\n");
        else
            log.append(icons + ": ошибка при создани директории\n");


        // Файлы
        File mainJava = new File(main, "Main.java");
        File utilsJava = new File(main, "Utils.java");

        File tempTxt = new File(temp, "temp.txt");

        try {
            if( mainJava.createNewFile())
                log.append(mainJava + ": файл создан\n");
            else
                System.out.println(mainJava + ": файл не создан\n");
        } catch (IOException e) {
            System.out.println(mainJava + ": ошибка при создании файла\n");
            throw new RuntimeException(e);
        }
        try {
            if( utilsJava.createNewFile())
                log.append(utilsJava + ": файл создан\n");
            else
                System.out.println(utilsJava + ": файл не создан\n");
        } catch (IOException e) {
            System.out.println(utilsJava + ": ошибка при создании файла\n");
            throw new RuntimeException(e);
        }

        try {
            if( tempTxt.createNewFile())
                log.append(tempTxt + ": файл создан\n");
            else
                System.out.println(tempTxt + ": файл не создан\n");
        } catch (IOException e) {
            System.out.println(tempTxt + ": ошибка при создании \n");
            throw new RuntimeException(e);
        }

        //Журнал логов. Пишем в файл
        String result = log.toString();

        try (FileOutputStream fos = new FileOutputStream(tempTxt)) {
            // перевод строки в массив байтов
            byte[] bytes = result.getBytes();
            // запись байтов в файл
            fos.write(bytes, 0, bytes.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Процесс установки завершен");
    }
}