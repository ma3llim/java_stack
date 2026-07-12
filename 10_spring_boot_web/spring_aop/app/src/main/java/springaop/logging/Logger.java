package springaop.logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Logger {
    @Before("execution(public void springaop.service.UserService.login()")
    public void loggerAdviceBefore() {
        System.out.println("Before Advice for login is executed");
    }

    @After("execution(public void springaop.service.UserService.logOut()")
    public void loggerAdviceAfter() {
        System.out.println("After Advice for login is executed");
    }
}
