package it.fabioformosa.lab.prodcons.aspects;

import it.fabioformosa.lab.prodcons.entities.Buffer;

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

	@AfterReturning(pointcut = "execution(* it.fabioformosa.lab.prodcons.entities.Buffer.getItem())", returning = "retVal")
	public void logDequeueBuffer(JoinPoint joinPoint, Object retVal) {
		Buffer buffer = (Buffer) joinPoint.getTarget();
		log.info(Thread.currentThread().getName() + " dequeues " + retVal
				+ " <- " + buffer.toString());
	}

	@AfterReturning(pointcut = "execution(* it.fabioformosa.lab.prodcons.entities.Buffer.isEmpty())", returning = "retVal")
	public void logEmptyBuffer(JoinPoint joinPoint, Object retVal) {
		Boolean retValBool = (Boolean) retVal;
		if (retValBool) {
			Buffer buffer = (Buffer) joinPoint.getTarget();
			log.info(Thread.currentThread().getName() + " : Empty condition ("
					+ buffer.toString() + ") for getting request");
		}

	}

	@Before("execution(* it.fabioformosa.lab.prodcons.entities.Buffer.addItem(..))")
	public void logEnqueueBuffer(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		Buffer buffer = (Buffer) joinPoint.getTarget();
		log.info(Thread.currentThread().getName() + " enqueues " + args[0]
				+ " -> " + buffer.toString());
	}

	@AfterReturning(pointcut = "execution(* it.fabioformosa.lab.prodcons.entities.Buffer.hasEmptyPlace())", returning = "retVal")
	public void logFullBuffer(JoinPoint joinPoint, Object retVal) {
		Boolean retValBool = (Boolean) retVal;
		if (!retValBool) {
			Buffer buffer = (Buffer) joinPoint.getTarget();
			log.info(Thread.currentThread().getName() + " : Full condition ("
					+ buffer.toString() + ") for putting request");
		}

	}

	@Before("call(* java.lang.Object.wait(..))")
	public void logWait(JoinPoint joinPoint) {
		StringBuilder sb = new StringBuilder();
		sb.append(Thread.currentThread().getName() + " has been blocked!");
		log.info(sb.toString());
	}

}
