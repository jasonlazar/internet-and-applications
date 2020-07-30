package com.ntua.appathon.models;

public class Distribution {

	private int men;
	private int women;
	private int total;
	
	public Distribution(int men, int women) {
		this.men = men;
		this.women = women;
		total = men+women;
	}

	public int getMen() {
		return men;
	}

	public int getWomen() {
		return women;
	}

	public int getTotal() {
		return total;
	}
}
