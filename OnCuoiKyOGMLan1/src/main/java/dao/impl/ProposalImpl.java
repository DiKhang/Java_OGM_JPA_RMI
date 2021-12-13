package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;

import dao.ProposalDao;
import entity.Proposal;
import util.HibernateUtil;

public class ProposalImpl extends UnicastRemoteObject implements ProposalDao{
private EntityManager em;
	
	public ProposalImpl() throws RemoteException{
		em = HibernateUtil.getInstance().getEntityManager();
	}
	@Override
	public boolean addProposal(Proposal proposal) throws RemoteException {
		OgmSession session = em.unwrap(OgmSession.class);
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			session.save(proposal);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	@Override
	public List<Proposal> getProposals(String email) throws RemoteException {
		// db.Employee.aggregate([{ $lookup: { from: "Proposal", localField: "_id", foreignField: "employeeID", as: "rs" } },
		// 							{$match:{email:"duc@gmail.com"}},
		//							{$project:{_id:0, rs:1}},{$unwind:"$rs"},{$replaceWith:"$rs"}])
		OgmSession session = em.unwrap(OgmSession.class);
		Proposal pro = new Proposal();
		List<Proposal> proposals = new ArrayList<Proposal>();
		Transaction tr = session.beginTransaction();

		try {
			String query = "db.Employee.aggregate([{ '$lookup': { 'from': \"Proposal\", 'localField': \"_id\", 'foreignField': \"employeeID\", as: \"rs\" } },{'$match': {'email': \""+email+"\"}},{'$project': {_id: 0,rs:1}},{'$unwind':\"$rs\"},{'$replaceWith':\"$rs\"}])";
			
			List<?> list = session.createNativeQuery(query).getResultList();
			for(Object obj : list) {
				Object[] o = (Object[]) obj;
				String proId = (String) o[0];
				pro = session.find(Proposal.class, proId);
				proposals.add(pro);
			}
			
			tr.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return proposals;
	}

}
