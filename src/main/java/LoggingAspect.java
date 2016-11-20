import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.company.mycalculatorlib.MyCalculatorLib.calculate(..))")
    public void logBefore(JoinPoint joinPoint) throws FileNotFoundException {

        String text = "logBefore() is running! " + new Date() + ", It's : " + joinPoint.getSignature().getName() + "\n******";
        String fileName = "Log.txt";
        System.out.println(text);
        File file = new File(fileName);
        if (!file.exists()) {
            FileWorker.write(fileName, text);
        } else {
            FileWorker.update(fileName, text);
        }
    }
}
