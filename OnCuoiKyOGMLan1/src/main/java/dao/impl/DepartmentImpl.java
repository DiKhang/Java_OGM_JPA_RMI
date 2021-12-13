package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.EntityManager;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;

import dao.DepartmentDao;
import entity.Department;
import util.HibernateUtil;

public class DepartmentImpl extends UnicastRemoteObject implements DepartmentDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7518007675608403946L;
	private EntityManager em;
	
	public DepartmentImpl() throws RemoteException{
		em = HibernateUtil.getInstance().getEntityManager();
	}
	@Override
	public boolean addDepartment(Department department) throws RemoteException {
		OgmSession session = em.unwrap(OgmSession.class);
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			session.save(department);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

}
