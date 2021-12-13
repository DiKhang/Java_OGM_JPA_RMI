package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;

import dao.EmployeeDao;
import entity.Employee;
import util.HibernateUtil;

public class EmployeeImpl extends UnicastRemoteObject implements EmployeeDao {
	/**
		 * 
		 */
	private static final long serialVersionUID = 2125461641760628169L;
	private EntityManager em;

	public EmployeeImpl() throws RemoteException {
		em = HibernateUtil.getInstance().getEntityManager();
	}

	@Override
	public boolean addEmployee(Employee employee) throws RemoteException {
		OgmSession session = em.unwrap(OgmSession.class);
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			session.save(employee);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public List<Employee> getGoodEmployees() throws RemoteException {
		OgmSession session = em.unwrap(OgmSession.class);
		Employee employee = new Employee();
		List<Employee> employees = new ArrayList<Employee>();
		Transaction tr = session.beginTransaction();

		try {
			String query = "db.Employee.aggregate([{'$lookup': {'from': \"proposals\",'localField':\"_id\",'foreignField':\"employeeId\",as:\"rs\"}},{'$project': {num: {'$size': {\"$ifNull\":[\"$rs\",[]]}}}},{'$group': {_id: null,is:{$push: '$$ROOT'},'max' :{$max: '$num'}}},{'$unwind': '$is'},{'$match': {'$expr': {'$eq': ['$is.num','$max']}}},{'$replaceWith': '$is'}])";

			List<?> list = session.createNativeQuery(query).getResultList();
			for (Object obj : list) {
				Object[] o = (Object[]) obj;
				String employeeId = (String) o[0];
				employee = session.find(Employee.class, employeeId);
				employees.add(employee);
			}
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return employees;
	}

}
