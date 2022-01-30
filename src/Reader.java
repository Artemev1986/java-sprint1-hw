//Класс отвечает за считывание данных из файлов

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
public class Reader {

    //Получение пути в папку resources
    public Path getResourcesPath(){
        Path filePath = Path.of(System.getProperty("user.dir"));
        for (int i=0;i<3;i++)
            filePath = Path.of(filePath.toString()).getParent();
        return  Paths.get(filePath.toString(),"resources");
    }

    //Считывание месячных отчётов
    public boolean readDataM(Data data){
        for (int i=0; i<3; i++) {
            Path filePath = Paths.get(getResourcesPath().toString(), "m.20210" + (i + 1) + ".csv");
            try {
                String fileContents = Files.readString(filePath);
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

    //Считывание годового отчёта
    public boolean readDataY(Data data){
        Path filePath = Paths.get(getResourcesPath().toString(),"y.2021.csv");
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
