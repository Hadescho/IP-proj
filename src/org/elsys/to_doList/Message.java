package org.elsys.to_doList;
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
	public Message(){
		ID = getNextID();
		created = new Date();
		content = "Dumy message";
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
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
