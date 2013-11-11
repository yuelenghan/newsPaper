package com.ghtn.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于观察方法的执行效率
 *
 * @author yuelenghan
 */
public class MethodEfficiencyUtil {
    private static Log log = LogFactory.getLog(LogUtil.class);

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object returnValue = joinPoint.proceed();

        long end = System.currentTimeMillis();

        log.debug("=======执行[" + joinPoint.getTarget().getClass() + "]类的["
                + joinPoint.getSignature().getName() + "]方法用时"
                + (end - start) + "ms=======");

        return returnValue;

    }
}
