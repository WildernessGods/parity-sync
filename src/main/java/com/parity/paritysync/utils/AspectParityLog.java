package com.parity.paritysync.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author an_qiang on 2018/06/02 0002.
 * @version 1.0
 */
@Aspect
@Component
public class AspectParityLog {

    private Logger logger = LoggerFactory.getLogger(AspectParityLog.class);

    private long before = 0;

    @Pointcut("execution(* com.parity.paritysync.controller.*.*(..))")
    public void methodPointcut() {
    }

    @Before("methodPointcut()")
    public void doBefore(JoinPoint joinPoint) throws JsonProcessingException {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        ParityLog annotation = method.getAnnotation(ParityLog.class);
        if (annotation != null) {

            //请求的方法名
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = signature.getName();

            //请求的参数
            Object[] args = joinPoint.getArgs();
            StringBuilder params = new StringBuilder();

            if (args != null) {
                for (Object arg : args) {
                    if (arg != null) {
                        String argName = arg.getClass().getName();
                        ObjectMapper objectMapper = new ObjectMapper();
                        if (argName.contains("com.uniptt.uniptt_admin.utils.")) {
                            params = new StringBuilder(objectMapper.writeValueAsString(arg));
                        } else if (argName.contains("java.lang")) {
                            params.append(objectMapper.writeValueAsString(arg)).append(" ");
                        }
                    }
                }
            }
            logger.info(annotation.value() + " 参数：" + params);
            before = System.currentTimeMillis();
        }
    }

    @After("methodPointcut()")
    public void doAfter(JoinPoint p) {
        long after = System.currentTimeMillis();
        MethodSignature sign = (MethodSignature) p.getSignature();
        Method method = sign.getMethod();
        ParityLog annotation = method.getAnnotation(ParityLog.class);
        if (annotation != null) {
            long time = after - before;
            logger.info(annotation.value() + " 执行时间 = " + time + " ms");
        }
    }
}
