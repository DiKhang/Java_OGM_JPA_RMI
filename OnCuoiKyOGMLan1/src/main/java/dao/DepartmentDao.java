package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.Department;

public interface DepartmentDao extends Remote{
	public boolean addDepartment (Department department) throws RemoteException; 
}
