package org.elsys.to_doList;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.elsys.messages.Message;

@Path("list")
public class To_doList {
	
	static List<Message> taskList = new ArrayList<Message>();
	
	public To_doList() {

	}
 	@GET
 	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getTaskList()
	{
		return taskList;
	}
 	@POST
 	@Path("/add")
 	@Consumes(MediaType.APPLICATION_JSON)
 	public void addTask(Message m)
 	{
 		
 		taskList.add(m);
 	}
 	
 	@DELETE
 	@Path("/remove/{id}")
 	public void removeTask(@PathParam("id") String id)
 	{
 		Integer intID = Integer.parseInt(id);
		for(int i = 0; i < taskList.size();i++)
		{
			if(taskList.get(i).getID() == intID)
			{
				taskList.remove(taskList.get(i));
			}
		}
 	}
 	@PUT
 	@Path("/edit/{id}")
 	@Consumes(MediaType.APPLICATION_JSON)
 	public void editTask(@PathParam("id") String id,String m)
 	{
 		Integer intID = Integer.parseInt(id);
 		for(int i = 0; i < taskList.size();i++)
		{
 			Message mes = taskList.get(i);
 			if(mes.getID() == intID)
			{
 				mes.setContent(m);
			}
		}
		
 	}
 	
 
}
