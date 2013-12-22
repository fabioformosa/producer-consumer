package it.fabioformosa.lab.prodcons.aspects;

import it.fabioformosa.lab.prodcons.spi.entities.Buffer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BufferLogAspect {

	private Log log = LogFactory.getLog(BufferLogAspect.class);;

	//@Before("execution(* it.fabioformosa.lab.prodcons.impl.BufferImpl.*(..)) && ! execution(* it.fabioformosa.lab.prodcons.impl.BufferImpl.toString())")
	//	public void logBuffer(JoinPoint joinPoint) {
	//		Buffer buffer = (Buffer) joinPoint.getTarget();
	//		log.info(buffer.toString());
	//	}

	@AfterReturning(pointcut = "execution(* it.fabioformosa.lab.prodcons.spi.entities.Buffer.getItem())", returning = "retVal")
	public void logConsumer(JoinPoint joinPoint, Object retVal) {
		Buffer buffer = (Buffer) joinPoint.getTarget();
		log.info(Thread.currentThread().getName() + " consumes " + retVal
				+ " <- " + buffer.toString());
	}

	@AfterReturning(pointcut = "execution(* it.fabioformosa.lab.prodcons.spi.entities.Buffer.isEmpty())", returning = "retVal")
	public void logEmptyBuffer(JoinPoint joinPoint, Object retVal) {
		Boolean retValBool = (Boolean) retVal;
		if (retValBool) {
			Buffer buffer = (Buffer) joinPoint.getTarget();
			log.info(Thread.currentThread().getName() + " can't consume "
					+ buffer.toString() + " (EMPTY CONDITION)");
		}

	}

	@Before("execution(* it.fabioformosa.lab.prodcons.spi.entities.Buffer.addItem(..))")
	public void logProducer(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		Buffer buffer = (Buffer) joinPoint.getTarget();
		log.info(Thread.currentThread().getName() + " produces " + args[0]
				+ " -> " + buffer.toString());
	}

	@AfterReturning(pointcut = "execution(* it.fabioformosa.lab.prodcons.spi.entities.Buffer.hasEmptyPlace())", returning = "retVal")
	public void logFullBuffer(JoinPoint joinPoint, Object retVal) {
		Boolean retValBool = (Boolean) retVal;
		if (!retValBool) {
			Buffer buffer = (Buffer) joinPoint.getTarget();
			log.info(Thread.currentThread().getName() + " can't put in "
					+ buffer.toString() + " (FULL CONDITION)");
		}

	}

	@Before("call(* java.lang.Object.wait(..))")
	public void logBlockedWorker(JoinPoint joinPoint) {
		StringBuilder sb = new StringBuilder();
		sb.append(Thread.currentThread().getName() + " is blocked now!");
		log.info(sb.toString());
	}

}
