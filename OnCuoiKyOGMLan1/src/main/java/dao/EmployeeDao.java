package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Employee;

public interface EmployeeDao extends Remote{
	public boolean addEmployee(Employee employee) throws RemoteException;
	public List<Employee> getGoodEmployees() throws RemoteException;
	
}
