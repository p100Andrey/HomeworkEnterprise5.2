import com.company.mycalculatorlib.Calculator;
import com.company.mycalculatorlib.MyCalculatorLib;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"config.xml"});
        MyCalculatorLib calc = (MyCalculatorLib) ac.getBean("calculator");
        System.out.println("Введите алгеброическое выражение в виде формулы, например, \"+,5,6\"");
        String formula = sc.nextLine();
        calc.calculate(formula);
    }
}
