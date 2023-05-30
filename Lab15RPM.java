import java.io.*;
import java.util.Scanner;

public class Lab15RPM {
    private double x;
    private double y;

    public void calculate() {
        y = x - Math.sin(x);
        System.out.println("y = " + y);
    }

    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\datch\\OneDrive\\Рабочий стол\\otvet.txt");
            writer.write(Double.toString(x) + "\n");
            writer.write(Double.toString(y) + "\n");
            writer.close();
            System.out.println("Информация занесена в otvet.txt");
        } catch (IOException e) {
            System.out.println("Не удалось сохранить в файл: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try {
            FileReader reader = new FileReader("C:\\Users\\datch\\OneDrive\\Рабочий стол\\otvet.txt");
            Scanner scanner = new Scanner(reader);
            x = Double.parseDouble(scanner.nextLine());
            y = Double.parseDouble(scanner.nextLine());
            System.out.println("Информация загружена из файла.");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Неудалось загрузить информацию из файла: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Lab15RPM myObject = new Lab15RPM();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите x.или же введите 'exit' чтобы завершить: ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            try {
                double x = Double.parseDouble(input);
                myObject.x = x;
                myObject.calculate();
            } catch (NumberFormatException e) {
                System.out.println("Неверное значение.Введите корректное значение");
            }

            System.out.print("Введите 'save' или 'upload' чтобы сохранить или загрузить данные в/из файла: ");
            input = scanner.nextLine();
            if (input.equals("save")) {
                myObject.saveToFile();
            } else if (input.equals("upload")) {
                myObject.loadFromFile();
                myObject.calculate();
            }
        }
    }
}
