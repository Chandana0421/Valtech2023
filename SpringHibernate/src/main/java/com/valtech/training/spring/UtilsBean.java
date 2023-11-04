package com.valtech.training.spring;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UtilsBean {

	private List<String> names;
	// key-value both strings
	private Properties settings;
	// key-value objects
	private Map<Point, Line> points;

	public Map<Point, Line> getPoints() {
		return points;
	}

	public void setPoints(Map<Point, Line> points) {
		this.points = points;
	}

	public Properties getSettings() {
		return settings;
	}

	public void setSettings(Properties settings) {
		this.settings = settings;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> name) {
		this.names = name;
	}
}
