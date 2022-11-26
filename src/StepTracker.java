import java.util.HashMap;
import java.util.ArrayList;
public class StepTracker {
    static Integer[] monthArray = new Integer[30];
    /*ArrayList<Integer> jan = new ArrayList<>();
    ArrayList<Integer> feb = new ArrayList<>();
    ArrayList<Integer> mar = new ArrayList<>();
    ArrayList<Integer> apr = new ArrayList<>();
    ArrayList<Integer> may = new ArrayList<>();
    ArrayList<Integer> jun = new ArrayList<>();
    ArrayList<Integer> jul = new ArrayList<>();
    ArrayList<Integer> aug = new ArrayList<>();
    ArrayList<Integer> sep = new ArrayList<>();
    ArrayList<Integer> oct = new ArrayList<>();
    ArrayList<Integer> nov = new ArrayList<>();
    ArrayList<Integer> dec = new ArrayList<>();*/
    static HashMap<Integer, Integer[]> statistic = new HashMap<>();
    //static HashMap<Integer, ArrayList<Integer>> statistic= new HashMap<>();

    static int stepsTarget = 10_000;

    public static void createMonthList() {
        Integer[] jan = new Integer[30];
        Integer[] feb = new Integer[30];
        Integer[] mar = new Integer[30];
        Integer[] apr = new Integer[30];
        Integer[] may = new Integer[30];
        Integer[] jun = new Integer[30];
        Integer[] jul = new Integer[30];
        Integer[] aug = new Integer[30];
        Integer[] sep = new Integer[30];
        Integer[] oct = new Integer[30];
        Integer[] nov = new Integer[30];
        Integer[] dec = new Integer[30];
        statistic.put(1, jan);
        statistic.put(2, feb);
        statistic.put(3, mar);
        statistic.put(4, apr);
        statistic.put(5, may);
        statistic.put(6, jun);
        statistic.put(7, jul);
        statistic.put(8, aug);
        statistic.put(9, sep);
        statistic.put(10, oct);
        statistic.put(11, nov);
        statistic.put(12, dec);
        Integer[] tempArray = new Integer[30];
        Integer[] tempArray2 = new Integer[30];
        for (int j=1; j<13; j++) {
            tempArray = statistic.get(j);
            for (int i=0; i<30; i++) {
                tempArray[i] = 0;
            }
            statistic.put(j, tempArray);
        }

        /*for (int i=1; i<13; i++) {
            statistic.put(i, monthList);
        }

        tempArray = statistic.get(1);
        oct[1] = 1000;
        statistic.put(1, tempArray);
        tempArray2 = statistic.get(10);
        for (int i=0; i<30; i++) {
            System.out.println(tempArray2[i]);
        }
        System.out.println(monthArray[1]);
        System.out.println(statistic);*/
    }
    public static void enterStepsPerDay(int month, int day, int steps) {
        Integer[] tempArray = new Integer[30];
        tempArray = statistic.get(month);
        tempArray[day-1] = steps;
        statistic.put(month, tempArray);
        System.out.println("Шаги добавлены" + month + day + steps);
        /*ArrayList<Integer> tempMonth = new ArrayList<>();
        tempMonth = statistic.get(month);
        tempMonth.remove(day-1);
        tempMonth.add(day-1, steps);
        statistic.put(month, tempMonth);
        System.out.println("Шаги добавлены" + month + day + steps);
        tempMonth.add(10, 666);*/
        //tempMonth.clear();
    }

    public static void printStatistics (int month) {
        //ArrayList<Integer> tempMonth = new ArrayList<>();
        Integer[] tempMonth = new Integer[30];
        tempMonth = statistic.get(month);
        int stepsPerMonth = 0;  // суммарное количество шагов в текущем месяце
        int maxStepsPerDay = 0; // максимальное количество шагов в день
        int averageStepCount = 0; // среднее количество шагов в месяце
        int stepsInRowAboveNorm = 0; // максимальная серия шагов выше цели
        int daysAboveNormCount = 0; // счетчик для поиска серии выше цели

        for (int i=0; i<30; i++) {
            stepsPerMonth = stepsPerMonth + tempMonth[i];                   //считаем шаги за месяц
            System.out.println((i+1) + "-й день: " + tempMonth[i] + "; ");
            if (maxStepsPerDay < tempMonth[i]) {                            //
                maxStepsPerDay = tempMonth[i];                              // ищем максимальное количество шагов в день
            }
            if (tempMonth[i] > stepsTarget) {
                daysAboveNormCount++;
            } else {
                daysAboveNormCount = 0;
            }
            if (stepsInRowAboveNorm < daysAboveNormCount) {
                stepsInRowAboveNorm = daysAboveNormCount;
            }
        }
        averageStepCount = stepsPerMonth/30;
        System.out.println("Общее количество шагов за месяц: " + stepsPerMonth);
        System.out.println("Максимально пройденное количество шагов в месяце: " + maxStepsPerDay);
        System.out.println("Среднее количество шагов: " + averageStepCount);
        System.out.println("Пройденная дистанция в км.: " + (stepsPerMonth*0.71/1000));
        System.out.println("Количество сожжных килокалорий: " + (stepsPerMonth/20));
        System.out.println("Лучшая серия: " + stepsInRowAboveNorm + " дней подряд Вы прошли больше " + stepsTarget + " шагов.");
        System.out.println("Статистика напечатана.");
        //System.out.println(statistic);

    }

    public static void changeTargetSteps (int target) {
        if (target>0) {
            stepsTarget = target;
            System.out.println("Новая цель по шагам установлена: " + stepsTarget + " шагов.");
        } else {
            System.out.println("Ах ты ж хитрая жопа!");
        }
    }
}
