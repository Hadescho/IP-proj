package org.elsys.messages;
import java.util.Date;


public class Message {
	private int ID;
	private Date created;
	private String content;
	private static int NextID = 0;
	public Message(String cont)
	{
		ID = getNextID();
		created = new Date();
		content = cont;
	}
	
	
	public int getID() {
		return ID;
	}
	
	
	public Date getCreated() {
		return created;
	}
	
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getNextID()
	{
		NextID++;
		return (NextID);
	}
	
}
