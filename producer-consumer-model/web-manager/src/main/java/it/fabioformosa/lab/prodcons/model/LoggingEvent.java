package it.fabioformosa.lab.prodcons.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "logging_event")
public class LoggingEvent {

	@Column(name = "event_id", nullable = false)
	@Id
	@GeneratedValue
	private long eventId;

	@Column(name = "timestmp", nullable = false)
	private long timestmp;

	@Column(name = "formatted_message", nullable = false)
	private String formattedMessage;

	@Column(name = "logger_name", nullable = false)
	private String loggerName;

	@Column(name = "level_string", nullable = false)
	private String levelString;

	@Column(name = "thread_name")
	private String threadName;

	@Column(name = "reference_flag")
	private int referenceFlag;

	private String arg0;

	private String arg1;

	private String arg2;

	private String arg3;

	@Column(name = "caller_filename", nullable = false)
	private String callerFilename;

	@Column(name = "caller_class", nullable = false)
	private String callerClass;

	@Column(name = "caller_method", nullable = false)
	private String callerMethod;

	@Column(name = "caller_line", nullable = false)
	private char callerLine;

	public String getArg0() {
		return arg0;
	}

	public String getArg1() {
		return arg1;
	}

	public String getArg2() {
		return arg2;
	}

	public String getArg3() {
		return arg3;
	}

	public String getCallerClass() {
		return callerClass;
	}

	public String getCallerFilename() {
		return callerFilename;
	}

	public char getCallerLine() {
		return callerLine;
	}

	public String getCallerMethod() {
		return callerMethod;
	}

	public long getEventId() {
		return eventId;
	}

	public String getFormattedMessage() {
		return formattedMessage;
	}

	public String getLevelString() {
		return levelString;
	}

	public String getLoggerName() {
		return loggerName;
	}

	public int getReferenceFlag() {
		return referenceFlag;
	}

	public String getThreadName() {
		return threadName;
	}

	public long getTimestmp() {
		return timestmp;
	}

	public void setArg0(String arg0) {
		this.arg0 = arg0;
	}

	public void setArg1(String arg1) {
		this.arg1 = arg1;
	}

	public void setArg2(String arg2) {
		this.arg2 = arg2;
	}

	public void setArg3(String arg3) {
		this.arg3 = arg3;
	}

	public void setCallerClass(String callerClass) {
		this.callerClass = callerClass;
	}

	public void setCallerFilename(String callerFilename) {
		this.callerFilename = callerFilename;
	}

	public void setCallerLine(char callerLine) {
		this.callerLine = callerLine;
	}

	public void setCallerMethod(String callerMethod) {
		this.callerMethod = callerMethod;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public void setFormattedMessage(String formattedMessage) {
		this.formattedMessage = formattedMessage;
	}

	public void setLevelString(String levelString) {
		this.levelString = levelString;
	}

	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
	}

	public void setReferenceFlag(int referenceFlag) {
		this.referenceFlag = referenceFlag;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public void setTimestmp(long timestmp) {
		this.timestmp = timestmp;
	}

}
