import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestDataGenerator {
    public static void main(String[] args) throws IOException {
        generateTestData(50, 100, 10000, "data/");
    }

    public static void generateTestData(int sets, int minSize, int maxSize, String folderPath) throws IOException {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdir();
        }

        Random rand = new Random();

        for (int i = 0; i < sets; i++) {
            int setSize = rand.nextInt(maxSize - minSize + 1) + minSize;
            String fileName = folderPath + "data_" + setSize + "_" + i + ".txt";
            FileWriter writer = new FileWriter(fileName);

            writer.write(setSize + "\n");
            for (int j = 0; j < setSize; j++) {
                double x = rand.nextDouble() * 1000;
                double y = rand.nextDouble() * 1000;
                writer.write(x + " " + y + "\n");
            }

            writer.close();
        }
    }
}
