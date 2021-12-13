package app;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDateTime;

import dao.EmployeeDao;
import dao.impl.EmployeeImpl;

public class AppServer {
	public static void main(String[] args) {
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager==null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());;
		}
		
		try {
			EmployeeDao employeeDao = new EmployeeImpl();
			
			LocateRegistry.createRegistry(9999);
			Naming.bind("rmi://DESKTOP-JUE6O6V:9999/employeeDao", employeeDao);
			System.out.println("Server started at: "+LocalDateTime.now());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
