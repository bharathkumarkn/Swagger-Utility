package com.apigee.swagger;

public class VolosQuota {
	
	private int allow;
	private int interval;
	private String timeUnit;
	
	
	public int getAllowCount() {
		return allow;
	}
	public void setAllow(int allowCount) {
		this.allow = allowCount;
	}
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		this.interval = interval;
	}
	public String getTimeUnit() {
		return timeUnit;
	}
	public void setTimeUnit(String timeUnit) {
		this.timeUnit = timeUnit;
	}
	


}
