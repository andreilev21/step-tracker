import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        StepTracker.createMonthList();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        while (true) {
            if (userInput<0 || userInput>3) {
                System.out.println ("Выбрана неверная команда. Введите число от 0 до 3");
            } else if (userInput == 1) {
                System.out.println ("Выбрана команда: Ввести количество шагов за определённый день");
                System.out.println ("Выберите номер месяца:");
                int month = scanner.nextInt();
                System.out.println ("Введите число:");
                int day = scanner.nextInt();
                System.out.println ("Введите количество шагов в этот день");
                int steps = scanner.nextInt();
                StepTracker.enterStepsPerDay(month, day, steps);
            } else if (userInput == 2) {
                System.out.println ("Выбрана команда: Напечатать статистику за определённый месяц");
                System.out.println ("Статистику за какой месяц надо распечатать?");
                int month = scanner.nextInt();
                StepTracker.printStatistics(month);
            } else if (userInput == 3) {
                System.out.println ("Выбрана команда: Изменить цель по количеству шагов в день");
                System.out.println ("Задайте новое целевое количество шагов в день");
                int target = scanner.nextInt();
                StepTracker.changeTargetSteps(target);

            } else {
                System.out.println ("Выход из приложения...");
                break;
            }
            printMenu();
            userInput = scanner.nextInt();
        }
    }

    private static void printMenu() {
        System.out.println ("Выберите действие. Введите нужное число и нажмите Enter");
        System.out.println ("1 - Ввести количество шагов за определённый день");
        System.out.println ("2 - Напечатать статистику за определённый месяц");
        System.out.println ("3 - Изменить цель по количеству шагов в день");
        System.out.println ("0 - Выход из приложения");
    }
}