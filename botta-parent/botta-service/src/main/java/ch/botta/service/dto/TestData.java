package ch.botta.service.dto;

public class TestData {
	private int number;
	private String name;
	
	public TestData(int number, String name){
		this.number = number;
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
