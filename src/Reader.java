import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
public class Reader {

    public boolean readDataM(Data data){
        Path[] filePath = new Path[3];
        for (int i=0; i<filePath.length; i++) {
            filePath[i] = Paths.get("C:/", "Users", "Artemev1986",
                    "dev", "java-sprint1-hw", "resources", "m.20210" + (i + 1) + ".csv");
            try {

                String fileContents = Files.readString(filePath[i]);
                String[] lines = fileContents.split("\\n");
                for (int j = 1; j < lines.length; j++) {
                    String[] lineContents = lines[j].split(",");
                    data.monthItems[i].add(lineContents[0]);
                    data.isMonthExpenses[i].add(Boolean.parseBoolean(lineContents[1]));
                    data.monthQuantity[i].add(Integer.parseInt(lineContents[2]));
                    data.monthPrice[i].add(Integer.parseInt(lineContents[3]));
                }
            } catch (IOException e) {
                System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
                return false;
            }
        }
        return true;
    }

    public boolean readDataY(Data data){
        Path filePath = Paths.get("C:/", "Users", "Artemev1986",
                    "dev", "java-sprint1-hw", "resources", "y.2021.csv");
            try {

                String fileContents = Files.readString(filePath);
                String[] lines = fileContents.split("\\n");
                for (int j = 1; j < lines.length; j++) {
                    String[] lineContents = lines[j].split(",");
                    data.month.add(Integer.parseInt(lineContents[0]));
                    data.amount.add(Integer.parseInt(lineContents[1]));
                    data.isExpenses.add(Boolean.parseBoolean(lineContents[2].trim()));
                }
            } catch (IOException e) {
                System.out.println("Невозможно прочитать файл с годовым отчётом. Возможно, файл не находится в нужной директории.");
                return false;
              }
        return true;
    }
}
