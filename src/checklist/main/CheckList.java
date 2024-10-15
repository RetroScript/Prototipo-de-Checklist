package checklist.main;

import java.io.Serializable;

public class CheckList implements Serializable{

	private String preferredName;
	private String[] tasks;
	
	public void deleteChecklist() {
		
	}
	
	public void saveChecklist() {
		
	}
	
	public void loadChecklist() {
		
	}
	
	public CheckList(String name, String task1, String task2, String task3) {
		tasks = new String[3];
		//tasks[2] = new String(); -> INCORRETO!
		preferredName = name;
		
		
		tasks[0] = task1;
		tasks[1] = task2;
		tasks[2] = task3;
		
	}
	
	public void exportData() {
		
	}
	
	public void setName(String newName) {
		preferredName = newName;
	}
	
	public void setTask(String [] newTasks) {
		tasks = newTasks;
	}
	
	public String getName() {
		return preferredName;
	}
	
	public String getTasks(int index) {
		return tasks[index];
	}
	
}
