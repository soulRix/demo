package com.example.demo;

public class Greeting {
	
	//Final = Constant, Cannot be changed
	
	private final long id;
	private final String content;
	
	public Greeting(long id, String content){
		this.id = id;
		this.content = content;
	}
	
	
	//Public Method (Encapsulation)
	  public long getId() {
		  return id;
	  }
	
	  public String getContent() {
		  return content;
	  }
	
}
