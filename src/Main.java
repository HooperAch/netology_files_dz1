//������� 3. ������ 1.

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        //������ ����� ����� StringBuilder
        StringBuilder log = new StringBuilder();

        // ����������
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
            log.append(src + ": ���������� �������\n");
        else
            log.append(src + ": ������ ��� ������� ����������\n");
        if (res.mkdir())
            log.append(res + ": ���������� �������\n");
        else
            log.append(res + ": ������ ��� ������� ����������\n");
        if (saveGames.mkdir())
            log.append(saveGames + ": ���������� �������\n");
        else
            log.append(saveGames + ": ������ ��� ������� ����������\n");

        if (temp.mkdir())
            log.append(temp + ": ���������� �������\n");
        else
            log.append(temp + ": ������ ��� ������� ����������\n");

        if (main.mkdir())
            log.append(main + ": ���������� �������\n");
        else
            log.append(main + ": ������ ��� ������� ����������\n");
        if (test.mkdir())
            log.append(test + ": ���������� �������\n");
        else
            log.append(test + ": ������ ��� ������� ����������\n");

        if(drawables.mkdir())
            log.append(drawables + ": ���������� �������\n");
        else
            log.append(drawables + ": ������ ��� ������� ����������\n");
        if(vectors.mkdir())
            log.append(vectors + ": ���������� �������\n");
        else
            log.append(vectors + ": ������ ��� ������� ����������\n");
        if(icons.mkdir())
            log.append(icons + ": ���������� �������\n");
        else
            log.append(icons + ": ������ ��� ������� ����������\n");


        // �����
        File mainJava = new File(main, "Main.java");
        File utilsJava = new File(main, "Utils.java");

        File tempTxt = new File(temp, "temp.txt");

        try {
            if( mainJava.createNewFile())
                log.append(mainJava + ": ���� ������\n");
            else
                System.out.println(mainJava + ": ���� �� ������\n");
        } catch (IOException e) {
            System.out.println(mainJava + ": ������ ��� �������� �����\n");
            throw new RuntimeException(e);
        }
        try {
            if( utilsJava.createNewFile())
                log.append(utilsJava + ": ���� ������\n");
            else
                System.out.println(utilsJava + ": ���� �� ������\n");
        } catch (IOException e) {
            System.out.println(utilsJava + ": ������ ��� �������� �����\n");
            throw new RuntimeException(e);
        }

        try {
            if( tempTxt.createNewFile())
                log.append(tempTxt + ": ���� ������\n");
            else
                System.out.println(tempTxt + ": ���� �� ������\n");
        } catch (IOException e) {
            System.out.println(tempTxt + ": ������ ��� �������� \n");
            throw new RuntimeException(e);
        }

        //������ �����. ����� � ����
        String result = log.toString();

        try (FileOutputStream fos = new FileOutputStream(tempTxt)) {
            // ������� ������ � ������ ������
            byte[] bytes = result.getBytes();
            // ������ ������ � ����
            fos.write(bytes, 0, bytes.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("������� ��������� ��������");
    }
}