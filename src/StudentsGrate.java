import java.util.Scanner;

public class StudentsGrate {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Saver saver = new Saver(in);
        Worker worker = new Worker(in);

        saver.create(); //созддаем или открываем файл
        saver.download(); //подгружаем файлы

        worker.startWork(); //основная работа

        saver.save(); //сохраняем

        in.close();
    }
}
