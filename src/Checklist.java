
public class Checklist {

	private String checklistName;
	private String task1Name;
	private String task2Name;
	private String task3Name;
	
	public Checklist(String name, String task1, String task2, String task3) {

		checklistName = name;
		task1Name = task1;
		task2Name = task2;
		task3Name = task3;
		
		System.out.println(checklistName + task1Name + task2Name + task3Name);
		
	}
	
	public void finishTask() {
		
	}
	
	public void finishCheckList() {
		
	}
	
}
