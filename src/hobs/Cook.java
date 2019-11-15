package hobs;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class Cook implements Runnable {
    public static Logger logger = (Logger) LoggerFactory.getLogger("BreadStation");

    @Override
    public void run() {
        Person.cooking = 0;
        Person.breadForSandwich -= 8;
        Person.sausageForSandwich -= 8;
        Person.mayonnaiseForSandwich -= 8;
        logger.info("БРОДЯГИ КУШАЮТ!!!");
    }
}
