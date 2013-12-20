package org.elsys.to_doList;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class To_doList {
 static List<Message> taskList = new ArrayList<Message>();
	public To_doList() {
		taskList.add(new Message());
	}
 	@GET
 	@Path("to-doList")
 	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getTaskList()
	{
		return taskList;
	}
 	@POST
 	@Path("to-doList/add")
 	@Consumes(MediaType.APPLICATION_JSON)
 	public void addTask(Message m)
 	{
 		taskList.add(m);
 	}
 	
 	@POST
 	@Path("to-doList/remove/{id}")
 	@Consumes(MediaType.APPLICATION_JSON)
 	public void removeTask(Message m)
 	{
 		taskList.remove(m);
//		int id = m.getID();
 		
// 		for(int i = 0; i < taskList.size();i++)
// 		{
// 			if(taskList.get(i).getID() == id)
// 			{
// 				taskList.remove(taskList.get(i));
// 				return true;
// 			}
// 		}
// 		return false;
 	}
 	
 
}
