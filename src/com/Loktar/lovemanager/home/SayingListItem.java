package com.Loktar.lovemanager.home;

public class SayingListItem {
	public String content;
	public String time;
	
	public SayingListItem(String conString){
		this.content = conString;
//		this.time = timeString;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	

}
