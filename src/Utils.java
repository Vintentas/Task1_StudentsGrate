import java.util.*;

public class Utils {

    /**
     * Команды
     */
    public static Map<String, String> command = new HashMap<>();
    static {
        command.put("help", "Справка");

        command.put("get", "Получить список учащихся с оценками");
        command.put("student", "Получить список оценок для одного ущашегося");
        command.put("set", "Записать оценку");

        command.put("exit", "Закрытие программы");
    }

    /**
     * Учащиеся
     */
    public static Map<String, List<Integer>> students = new HashMap<>();
    static {
        students.put("Viktoria", new LinkedList<>());
        students.put("Elena", new LinkedList<>());
        students.put("Aleksander", new LinkedList<>());
        students.put("Viktor", new LinkedList<>());
        students.put("Vladimir", new LinkedList<>());
        students.put("Anna", new LinkedList<>());
    }

    public static String getCommandInfo() {
        return command.toString()
                .replace("{","")
                .replace("}","")
                .replace("="," - ")
                .replace(", ", "\n");

    }

        public static String getStudents() {
        return students.toString()
                .replace("{"," ")
                .replace("}"," ")
                .replace("=[",": ")
                .replace("],", "\n")
                .replace("]","");
    }

    public static String getStudent(String name) {
        List<Integer> grates = students.get(name);

        if (grates.isEmpty()) {
            return name + " has no grades";
        }
        return name + ": " + grates.toString()
                .replace("[","")
                .replace("]","");
    }

}
