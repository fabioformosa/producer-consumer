package it.fabioformosa.lab.prodcons.utils;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

public class DatePropertyEditor extends PropertyEditorSupport {

	private static final DateFormat format = new SimpleDateFormat("dd-MM-yyyy");

	@Override
	public String getAsText() {
		if (getValue() == null)
			return "";
		return format.format(getValue());
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			if (StringUtils.isEmpty(text))
				setValue(null);
			else
				setValue(format.parse(text));
		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid date formatter " + text);
		}
	}

}
