package app;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import dao.DepartmentDao;
import dao.EmployeeDao;
import dao.ProposalDao;
import dao.impl.DepartmentImpl;
import dao.impl.EmployeeImpl;
import dao.impl.ProposalImpl;
import entity.Department;
import entity.Employee;
import entity.Gender;
import entity.Proposal;

public class AppTest {
	public static void main(String[] args) throws RemoteException {
		DepartmentDao departmentDao = new DepartmentImpl();
		EmployeeDao employeeDao = new EmployeeImpl();
		ProposalDao proposalDao = new ProposalImpl();
		
//		System.out.println(departmentDao.addDepartment(new Department("1","Viet Nam", "CNTT")));
		
//		Employee employee = new Employee("2", "vinh@gmail.com", new Date(2021-1900, 12, 12), "Thành ", "Vinh", new HashSet(Arrays.asList("09049034323")),Gender.Male );
//		employee.setDepartment(new Department("1","Viet Nam", "CNTT"));
//		System.out.println(employeeDao.addEmployee(employee));
		
//		Proposal proposal1 = new Proposal("1", new Date(2021-1900, 12, 12) , "HEHEHEHE", "Vinh đi trên cỏ non");
//		Proposal proposal2 = new Proposal("2", new Date(2021-1900, 12, 12) , "HIHIHIHI", "Mắt ải mắt ai");
//		Proposal proposal3 = new Proposal("3", new Date(2021-1900, 12, 12) , "HAHAHAHA", "Thành phố của tui");
//		Proposal proposal4 = new Proposal("4", new Date(2021-1900, 12, 12) , "HOHOHOHO", "Ngày mai đi học");
//		Proposal proposal5 = new Proposal("5", new Date(2021-1900, 12, 12) , "QUAOQUAO", "Ngủ ngon nhé");
//		
//		proposal1.setEmployee(new Employee("2", "vinh@gmail.com", new Date(2021-1900, 12, 12), "Thành ", "Vinh", new HashSet(Arrays.asList("09049034323")),Gender.Male ) );
//		proposal2.setEmployee(new Employee("2", "vinh@gmail.com", new Date(2021-1900, 12, 12), "Thành ", "Vinh", new HashSet(Arrays.asList("09049034323")),Gender.Male ) );
//		proposal3.setEmployee(new Employee("2", "vinh@gmail.com", new Date(2021-1900, 12, 12), "Thành ", "Vinh", new HashSet(Arrays.asList("09049034323")),Gender.Male ) );
//		proposal4.setEmployee(new Employee("2", "vinh@gmail.com", new Date(2021-1900, 12, 12), "Thành ", "Vinh", new HashSet(Arrays.asList("09049034323")),Gender.Male ) );
//		proposal5.setEmployee(new Employee("2", "vinh@gmail.com", new Date(2021-1900, 12, 12), "Thành ", "Vinh", new HashSet(Arrays.asList("09049034323")),Gender.Male ) );
//		
//		System.out.println(proposalDao.addProposal(proposal1));
//		System.out.println(proposalDao.addProposal(proposal2));
//		System.out.println(proposalDao.addProposal(proposal3));
//		System.out.println(proposalDao.addProposal(proposal4));
//		System.out.println(proposalDao.addProposal(proposal5));
//		
//		proposalDao.getProposals("vinh@gmail.com").forEach(p -> {
//			System.out.println(p);
//		});
//		
//		employeeDao.getGoodEmployees().forEach(e->{
//			System.out.println(e);
//		});
	}
}
