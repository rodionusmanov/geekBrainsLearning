package homework2;

import java.util.concurrent.ThreadLocalRandom;

public class HomeWorkApp2 {

    public static void main(String[] args){
        int a = ThreadLocalRandom.current().nextInt(-10, 15);   // переменная 1 и 2 пунктов д/з в интервале [-10; 15]
        int b = ThreadLocalRandom.current().nextInt(-10, 15);   // переменная 1 и 3 пунктов д/з в интервале [-10; 15]
        int c = ThreadLocalRandom.current().nextInt(-1, 9);     // переменная 4 пункта д/з в интервале [-1; 9]
        int d = ThreadLocalRandom.current().nextInt(-1000, 2010);   // переменная 5 пункта д/з в интервале [-1000; 2010]
        String s = "строка";                                                // строчная переменная для вывода в 4 пункте д/з
        System.out.printf("a = %d  b = %d  c = %d  d = %d  s = %s%n%n", a, b, c, d, s); //контрольный вывод переменных
        System.out.println(sumControl(a, b));       //вызов и вывод в консоль 1 метода д/з
        System.out.println();                       //разделительная строка между методами
        signControl(a);                             //вызов 2 метода д/з
        System.out.println();                       //разделительная строка между методами
        System.out.println(negativeSignControl(b)); //вызов и вывод в консоль 3 метода д/з
        System.out.println();                       //разделительная строка между методами
        cTimesWriter(s, c);                         //вызов 4 метода д/з
        System.out.println();                       //разделительная строка между методами
        System.out.println(leapYear(d));            //вызов и вывод в консоль 5 метода д/з
    }
    public static boolean sumControl(int a, int b){ //объявление метода 1 пункта домашнего задания
        return ((a + b) >= 10 && (a + b) <= 20);    //проверка выполнения условия с последующим возвратом результата
    }

    public static void signControl(int a){          //объявление метода 2 пункта домашнего задания
        if (a >= 0){                                //проверка выполнения условия с последующим выводом в консоль результата
            System.out.println("число " + a + " - положительное");
        }else System.out.println("число " + a + " - отрицательное");
    }

    public static boolean negativeSignControl(int b){   //объявление метода 3 пункта домашнего задания
        return (b < 0);                                 //проверка выполнения условия с последующим возвратом результата
    }

    public static void cTimesWriter(String s, int c){   //объявление метода 4 пункта домашнего задания
        for (int i = 0; i < c; i++) {                   //вывод c-раз в консоль результата
            System.out.println(s);
        }
    }

    public static boolean leapYear(int d){              //объявление метода 3 пункта домашнего задания
        return !(((d % 4) != 0) || (((d % 100) == 0) && ((d % 400) != 0))); //проверка выполнения условия с последующим возвратом результата
    }
}
