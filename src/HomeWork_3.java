import java.io.*;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;


public class HomeWork_3 {
    public static void main(String[] args) throws IOException {
        //Базовый уровень (для зачета нужно сделать хотя бы 2 из 3)
        //Задача №1
        //Дано: у нас есть две модели машин - жигули и toyota. Каждая из этих машин умеет: начинать движение,
        //останавливаться, включать фары. У жигули есть особенность: она ломается. У Toyota особенность: включает музыку
        //Необходимо:
        // 1.Создать абстрактный класс, который будет описывать общие действия этих машин (методы будут не абстрактные)
        // 2.Создать два класса, которые будут наследоваться от абстрактного класса, и реализовывать особенности этих машин
        // Методы должны просто печатать на экран действия машин (начал движение, включил музыку и тд.)

        Lada lada = new Lada();
        lada.moving();
        lada.stop();
        lada.onLights();
        lada.breakdown();

        Toyota toyota = new Toyota();
        toyota.moving();
        toyota.stop();
        toyota.onLights();
        toyota.onMusic();

        //Задача №2
        //Необходимо:
        // 1. Создать папку resource, пометить ее как папку Resourсe root.
        // 2. Создать в ней файл "my_first_file.txt". На первой строке написать: "Моя бабушка", на второй: "читает газету жизнь"
        // 3. Прочитать файл, и вывести на экран все слова файла в одну строку
        // Ожидаемый результат: "Моя бабушка читает газету жизнь"

        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\MyProgram\\JavaAblazzing\\HomeWork_3\\HomeWork_3\\resource\\my_first_file.txt"));
        while (bufferedReader.ready()) {
            String row = bufferedReader.readLine();
            System.out.print(row + " ");
        }
        System.out.println("");

        //Задача №3
        //Необходимо:
        // 1. Создать класс Financial record, с двумя атрибутами: incomes, outcomes (доходы, расходы)
        // 2. Создать в этом классе геттеры, сеттеры и конструктор на все атрибуты
        // 3. Создать объект этого класса прямо здесь (class Homework3, метод main), с доходами 500, расходами 300
        // 4. Записать в файл "report.txt" данные из объекта класса.
        // Ожидаемый результат: в файле report.txt - одна строка: доходы = 500, расходы = 300

        FinancialRecord financialRecord = new FinancialRecord(500, 300);
        FileWriter fileWriter = new FileWriter("C:\\MyProgram\\JavaAblazzing\\HomeWork_3\\HomeWork_3\\resource\\report.txt", false);
        fileWriter.write("доходы = " + financialRecord.getIncomes() + ", расходы = " + financialRecord.getOutcomes() + " \n");
        fileWriter.close();

        //Продвинутый уровень
        //Задача №1
        // Сделать задачу №1 из базовой.
        // 1. Создать класс CarFactory, у которого есть два статических методы: создать жигули, создать toyota.
        // 2. Создать 20 тойот, 20 жигулей с помощью CarFactory, положить их в один массив.
        // 3. Пройтись по массиву, проверить к какому классу принадлежит машина, привести тип к классу машины
        // и вызвать характерные для нее методы.

        Car[] cars = new Car[40];
        for (int i = 0; i < 40; i++) {
            if (i%2 == 0) {
                cars[i] = CarFactory.makeLada();
            } else {
                Toyota toyota1 = CarFactory.makeToyota();
                cars[i] = toyota1;
            }
        }

        for (Car car : cars) {
            if (car instanceof Lada) {
                ((Lada) car).breakdown();
            } else if (car instanceof Toyota) {
                Toyota toyota1 = (Toyota) car;
                toyota1.onMusic();
            }
        }

        //Задача №2
        // 1. Создать класс Financial record, с двумя атрибутами: incomes, outcomes (доходы, расходы)
        // 2. Создать в этом классе геттеры, сеттеры и конструктор на все атрибуты
        // 3. Создать 10 отчетов, с разными доходами и расходами (Смотри класс new Random(1).nextInt() )
        // 4. Записать в файл "report.txt" все данные из отчетов.
        // 5. Прочитать файл report.txt, просуммировать все доходы и вывести на экран, тоже самое с расходами
        // Ожидаемый результат: общие доходы - (какое то число), общие расходы - (какое то число)

        FinancialRecord[] financialRecords = new FinancialRecord[10];
        Random random = new Random(1);
        for (int i = 0; i < financialRecords.length; i++) {
            int i1 = random.nextInt(10_000);
            int i2 = random.nextInt(10_000);
            financialRecords[i] = new FinancialRecord(i1, i2);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\MyProgram\\JavaAblazzing\\HomeWork_3\\HomeWork_3\\resource\\report_1.txt"));
        String result = "";
        for (FinancialRecord record : financialRecords) {
            result += record.toString() + "\n";
        }
        result = result.substring(0, result.length() - 1);
        bufferedWriter.write(result);
        bufferedWriter.close();

        BufferedReader bufferedReader1 = new BufferedReader(new FileReader("C:\\MyProgram\\JavaAblazzing\\HomeWork_3\\HomeWork_3\\resource\\report_1.txt"));
        int totalIncome = 0;
        int totalOutcome = 0;
        while (bufferedReader1.ready()) {
            String line = bufferedReader1.readLine();
            String[] strings = line.split(":");
            int income = Integer.parseInt(strings[0]);
            int outcome = Integer.parseInt(strings[1]);
            totalIncome += income;
            totalOutcome += outcome;
        }
        System.out.println("Общие доходы - " + totalIncome + ", общие расходы - " + totalOutcome);
        bufferedReader1.close();






        //Экспертный уровень
        // Дано: папка, внутри которой находятся файлы, следующего именования - report_01_2012.txt, где 01 - месяц, 2012 - год
        // Внутри файла следующий формат:
        // pyterochka;122300.20;100312.10;20/01/2012
        // pyterochka;299922.00;323333.02;21/01/2012
        // perekrestok;9920.20;28200.01;21/01/2012
        // Где pyterochka - название магазина; 122300.20 - доход; 100312.10 - расход, 20/01/2012 - дата операции

        // Задача №1
        // Необходимо составить отчет о итоговой прибыли за каждый месяц по магазину pyterochka
        // Формат ожидаемого результат:
        // Прибыль по магазину pyterochka по месяцам
        // 01.2012: 20000.00
        // 02.2012: -100332.00
        // и тд


        // Задача №2
        // Необходим составить отчет о расходах всех магазинов за весь период по магазинам (т.е. прочитать все файлы внутри папки)
        // Формат ожидаемого результат:
        // Расходы pyterochka за весь период: 20032220.00
        // Расходы perekrestok за весь период: 1734220.00
        // .. и тд

    }
}
