package OOLaS_lab42;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        System.out.println("Queue");
        System.out.println("Дан файл, содержащий числа. За один просмотр файла напечатать элементы файла в следующем порядке: сначала все числа, из интервала [a,b], потом все числа, меньшие a, потом все числа, большие b, сохраняя исходный порядок в каждой группе чисел");
        System.out.println("================================================================================");

        Queue<Integer> qLess = new ArrayDeque<>();
        Queue<Integer> qMore = new ArrayDeque<>();
        Queue<Integer> qBetween = new ArrayDeque<>();

        Queue[] qs = new Queue[]{qBetween, qLess, qMore};

        int a = 5;
        int b = 13;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        try {

            Files.lines(Path.of("input.txt"))
                    .mapToInt(Integer::parseInt)
                    .forEach((x) -> {
                        System.out.print(x + " ");
                        if (x < a) qLess.add(x);
                        else if (x > b) qMore.add(x);
                        else qBetween.add(x);
                    });

            for (Queue q : qs) {
                System.out.println();
                while (q.size() != 0) System.out.print(q.poll() + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
