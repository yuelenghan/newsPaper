package com.ghtn.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

/**
 * 用aop在指定的方法中增加日志
 *
 * @author yuelenghan
 */
public class LogUtil {

    private static Log log = LogFactory.getLog(LogUtil.class);

    public void afterReturn(JoinPoint joinPoint) {
        log.debug("=======离开[" + joinPoint.getTarget().getClass() + "]类的["
                + joinPoint.getSignature().getName() + "]方法==========");
    }

    public void before(JoinPoint joinPoint) {
        log.debug("=======进入[" + joinPoint.getTarget().getClass() + "]类的["
                + joinPoint.getSignature().getName() + "]方法==========");
    }

}
