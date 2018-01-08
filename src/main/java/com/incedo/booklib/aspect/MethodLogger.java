/*
 * 
 */
package com.incedo.booklib.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class MethodLogger.
 */
@Component
@Aspect
public class MethodLogger {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(MethodLogger.class);

	/**
	 * Around.
	 *
	 * @param proceedingJoinPoint the proceeding join point
	 * @return the object
	 * @throws Throwable the throwable
	 */
	@Around("@annotation(Loggable)")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object result = proceedingJoinPoint.proceed();
		logger.info("Class : "+proceedingJoinPoint.getTarget().getClass() + " ; Method : "
				+ proceedingJoinPoint.getSignature().getName() +" ; took " + (System.currentTimeMillis() - start)+" milisecond in execution");
		return result;
	}
}