import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Saver {

    final private Scanner in;
    final private File file = new File("student_grate.txt");
    private String value = "";

    public Saver(Scanner in) {
        this.in = in;
    }

    public void create() {
        try {
            if (file.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("The file already exists. Create new? If a new file is created, your saves will be lost.");
                value = in.nextLine().toLowerCase();
                if (value.equals("yes")) {
                    file.delete();
                    file.createNewFile();
                    System.out.println("New file was created");
                } else {
                    System.out.println("New file was not created");
                }

            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла");
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            FileWriter writer = new FileWriter("student_grate.txt");
            writer.write(Utils.getStudents());
            writer.close();
            System.out.println("File saved");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }
    }

    public void download() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("student_grate.txt"));

            if (!lines.isEmpty()) {
                Map<String, List<Integer>> studentGrates = new HashMap<>();
                for (String line: lines) {
                    String[] split = line.split(": ");
                    String name = split[0].trim();

                    List<Integer> grates = new LinkedList<>();
                    if(split.length > 1) {
                        grates = Arrays.stream(split[1].split(","))
                                .map(String::trim)
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());
                    }
                    studentGrates.put(name, grates);
                }
                Utils.students = studentGrates;
            }

        } catch (IOException e) {
            System.out.println("Ошибка при чтении из файла");
            e.printStackTrace();
        }
    }

}
