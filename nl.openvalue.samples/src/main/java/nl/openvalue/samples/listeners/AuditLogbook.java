package nl.openvalue.samples.listeners;

import java.util.LinkedList;
import java.util.List;

public class AuditLogbook {
	
	private List<String> logs;
	
	public AuditLogbook() { 
		this.logs = new LinkedList<>();
	}
	
	public void addLog(String log) {
		this.logs.add(log);
	}
	
	public void printLogs() {
		if (logs.isEmpty()) {
			System.out.println("Audit logbook is  empty");	
		} else {
			System.out.println("Printing audit logs:");
			for (String l : logs) {
				System.out.println("> " + l);
			}
		}
	}

}
