package model;

import java.time.ZonedDateTime;
import java.util.HashMap;

public class Projekt {
	
	private User ersteller;
	private HashMap<String, Task> tasks = new HashMap<String, Task>();
	private HashMap<String, User> users = new HashMap<String, User>();
	private String bezeichnung; /* evt. name? */
	private int id;
	private Statusliste statusliste;
	private ZonedDateTime letzteAenderung;
	private ZonedDateTime erstellungsDatum;

	public Projekt(User u, String bezeichnung) {
		this.ersteller = u;
		this.bezeichnung = bezeichnung;
		users.put(u.getNutzername(), u);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ZonedDateTime getLetzteAenderung() {
		return letzteAenderung;
	}

	public void setLetzteAenderung(ZonedDateTime letzteAenderung) {
		this.letzteAenderung = letzteAenderung;
	}

	public ZonedDateTime getErstellungsDatum() {
		return erstellungsDatum;
	}

	public void setErstellungsDatum(ZonedDateTime erstellungsDatum) {
		this.erstellungsDatum = erstellungsDatum;
	}
	
	public void setTasks(HashMap<String, Task> tasks) {
		this.tasks = tasks;
	}

	public void setUsers(HashMap<String, User> users) {
		this.users = users;
	}

	public User getErsteller() {
		return ersteller;
	}

	public void setErsteller(User ersteller) {
		this.ersteller = ersteller;
	}
	public HashMap<String, Task> getTasks() {
		return tasks;
	}

	public HashMap<String, User> getUsers() {
		return users;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	

	public Statusliste getStatusliste() {
		return statusliste;
	}
	
	public void setStatusliste(Statusliste statusliste) {
		this.statusliste = statusliste;
	}

	/**
	 * 
	 * @param task
	 */
	public void addTaskToHashMap(Task task){
		tasks.put(task.getName(), task);
	}
	
	/**
	 * 
	 * @param task
	 */
	public void deleteTaskFromHashMap(Task task){
		tasks.remove(task.getName());
	}
	
	/**
	 * 
	 * @param user
	 */
	public void addUserToHashMap(User user){
		users.put(user.getNutzername(), user);
	}
	
	/**
	 * 
	 * @param user
	 */
	public void deleteUserFromHashMap(User user){
		users.remove(user.getNutzername());
	}

	/**
	 * 
	 * @param name
	 * @param kommentar
	 * @param u
	 */
	public void createTask(String name, String kommentar, User u) {
		Task task = new Task(name,kommentar,u);
		this.addTaskToHashMap(task);
	}
	
	/**
	 * 
	 * @param tagname
	 * @return returns a HashMap of all tasks that have the tagname as tag
	 */
	public HashMap<String, Task> getTasksOfTag(String tagname)
	{
		HashMap<String, Task> taskList = new HashMap<String, Task>();
		for(int i=0; i<this.getTasks().size(); i++)
		{
			for(int j=0; j<this.getTasks().get(i).getTags().size(); j++)
			{
				if(this.getTasks().get(i).getTags().get(j) == tagname)
				{
					//System.out.println("Tag \"" + tagname + "\" gefunden in " + this.getTasks().get(i).getName() + ".");
					taskList.put(tagname, this.getTasks().get(i));
					break;
				}
			}
		}
		return taskList;
	}
}
