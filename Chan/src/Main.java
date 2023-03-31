import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        String folderPath = "C:\\Users\\timat\\IdeaProjects\\Chan\\data";
        String outputPath = "C:\\Users\\timat\\IdeaProjects\\Chan\\results.txt";

        try (Stream<Path> paths = Files.walk(Paths.get(folderPath))) {
            paths.filter(Files::isRegularFile)
                    .forEach(filePath -> {
                        List<Point> points = new ArrayList<>();
                        try (BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                String[] coordinates = line.trim().split("\\s+");
                                if (coordinates.length != 2) {
                                    System.err.println("Некорректая строка: '" + line + "'. Ожидаются два числа, разделенных пробелом или табуляцией.");
                                    continue;
                                }
                                double x = Double.parseDouble(coordinates[0]);
                                double y = Double.parseDouble(coordinates[1]);
                                points.add(new Point(x, y));
                            }
                        } catch (IOException e) {
                            System.err.println("Ошибка при чтении файла: " + e.getMessage());
                            return;
                        }
                        // Измерение размера входных данных
                        long inputSize = new File(filePath.toUri()).length();

                        // Измерение времени работы алгоритма
                        long startTime = System.nanoTime();
                        List<Point> convexHull = ChanAlgorithm.findConvexHull(points);
                        long endTime = System.nanoTime();

                        // Измерение количества итераций
                        long iterations = ChanAlgorithm.getIterations();

                        // Сохранение результатов в файл
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath, true))) {
                            bw.write(filePath.getFileName() + "\t" + (endTime - startTime) / 1e6 + " мс" + "\t" + iterations + "\t" + inputSize + " байт" + "\n");
                        } catch (IOException e) {
                            System.err.println("Ошибка при записи результатов в файл: " + e.getMessage());
                            return;
                        }
                    });
        } catch (IOException e) {
            System.err.println("Ошибка при обработке папки: " + e.getMessage());
        }
    }
}
