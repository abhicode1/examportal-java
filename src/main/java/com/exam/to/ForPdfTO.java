package com.exam.to;

import java.beans.JavaBean;

@JavaBean
public class ForPdfTO {
	String name;
	String percent;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	

}
