package com.codingkiddo.spring_ai__modules.ollamachatbot.model;

public class HelpDeskResponse {
	String result;
	
	public HelpDeskResponse() {}
	
    public HelpDeskResponse(String result) {
        this.result = result;
    }

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
    
}
