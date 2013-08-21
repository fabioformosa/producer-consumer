package it.fabioformosa.lab.prodcons.views;

public class LoggingViewHelper {

	public static String filterClassName(String qualifiedClassName) {
		String[] splittedQualifiedName = qualifiedClassName.split("\\.");
		return splittedQualifiedName[splittedQualifiedName.length - 1];
	}
}
