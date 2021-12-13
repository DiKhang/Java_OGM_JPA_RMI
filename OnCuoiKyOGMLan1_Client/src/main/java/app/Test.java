package app;

import java.rmi.Naming;

import dao.EmployeeDao;
import dao.impl.EmployeeImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager==null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());;
		}
		
		try {
			EmployeeDao employeeDao =(EmployeeDao) Naming.lookup("rmi://DESKTOP-JUE6O6V:9999/employeeDao");
			employeeDao.getGoodEmployees().forEach(e->{
				System.out.println(e);
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
