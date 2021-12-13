package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Proposal;

public interface ProposalDao extends Remote{
	public boolean addProposal (Proposal proposal) throws RemoteException;
	
	public List<Proposal> getProposals(String email) throws RemoteException;
}
