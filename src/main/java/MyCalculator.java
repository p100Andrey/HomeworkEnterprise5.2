import com.company.mycalculatorlib.Calculator;
import com.company.mycalculatorlib.Divideble;
import com.company.mycalculatorlib.Multiplyble;

public class MyCalculator extends Calculator implements Multiplyble, Divideble{

    @Override
    public String calculate(String str) {
        char operator = str.charAt(0);
        if (operator != 43 && operator != 45 && operator != '*' && operator != '/') {
            System.out.println("Формат ввода данных неверный!");
            return null;
        } else if (str.charAt(1) != 44) {
            System.out.println("Формат ввода данных неверный!");
            return null;
        } else {
            String x = new String("");
            String y = new String("");

            int i;
            for (i = 2; i < str.length() && str.charAt(i) != 44; ++i) {
                x = x + str.charAt(i);
            }

            ++i;

            while (i < str.length()) {
                y = y + str.charAt(i);
                ++i;
            }

            switch (operator) {
                case '+':
                    try {
                        System.out.println(x + operator + y + '=' + this.add(Double.parseDouble(x), Double.parseDouble(y)));
                    } catch (NumberFormatException var) {
                        System.out.println("Формат ввода данных неверный!");
                    }
                    break;
                case '-':
                    try {
                        System.out.println(x + operator + y + '=' + this.subtract(Double.parseDouble(x), Double.parseDouble(y)));
                    } catch (NumberFormatException var) {
                        System.out.println("Формат ввода данных неверный!");
                    }
                    break;
                case '*':
                    try {
                        System.out.println(x + operator + y + '=' + this.multiply(Double.parseDouble(x), Double.parseDouble(y)));
                    } catch (NumberFormatException var) {
                        System.out.println("Формат ввода данных неверный!");
                    }
                    break;
                case '/':
                    try {
                        System.out.println(x + operator + y + '=' + this.divide(Double.parseDouble(x), Double.parseDouble(y)));
                    } catch (NumberFormatException var) {
                        System.out.println("Формат ввода данных неверный!");
                    }
            }

            return null;
        }
    }

    public double divide(double x, double y) {
        return x / y;
    }

    public double multiply(double x, double y) {
        return x * y;
    }
}
