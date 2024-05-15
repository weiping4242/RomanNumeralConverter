package com.example.demo.DTO;

public class RomanNumeralConverterDTO {

	private String romanNumeralString;
	private int numericInt;
	
	/**
	 * @return the romanNumeralString
	 */
	public String getRomanNumeralString() {
		return romanNumeralString;
	}

	/**
	 * @param romanNumeralString the romanNumeralString to set
	 */
	public void setRomanNumeralString(String romanNumeralString) {
		this.romanNumeralString = romanNumeralString;
	}

	/**
	 * @return the numericInt
	 */
	public int getNumericInt() {
		return numericInt;
	}

	/**
	 * @param numericInt the numericInt to set
	 */
	public void setNumericInt(int numericInt) {
		this.numericInt = numericInt;
	}

	@Override
	public String toString() {
		return "RomanNumeralConverterDTO [romanNumeralString=" + romanNumeralString + ", numericInt=" + numericInt
				+ "]";
	}
}
