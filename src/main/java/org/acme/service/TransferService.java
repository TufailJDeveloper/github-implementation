package org.acme.service;



import org.acme.entity.Transaction;
import org.acme.entity.Transfer;
import org.acme.repository.TransferRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;



@Transactional
@ApplicationScoped
public class TransferService {
	@Inject
	EntityManager em;
	@Inject
	TransferRepository transferRepository;



	@Transactional
	public void saveTransfer(Transfer transfer) {
		Transaction transaction = transfer.getTransaction();
		if (transaction != null) {
			transaction.setTransfer(transfer);
			em.persist(transaction);
		}

		em.persist(transfer);
	}

	@Transactional
	public Transfer updateTransferAndTransaction(Long id, Transfer updatedTransfer) {
	    Transfer existingTransfer = transferRepository.findById(id);
	    if (existingTransfer == null) {
	        return null;
	    }

	    existingTransfer.setAccountFrom(updatedTransfer.getAccountFrom());
	    existingTransfer.setAccountTo(updatedTransfer.getAccountTo());
	    existingTransfer.setTransferDate(updatedTransfer.getTransferDate());
	    existingTransfer.setAmount(updatedTransfer.getAmount());

	    Transaction existingTransaction = existingTransfer.getTransaction();
	    if (existingTransaction != null) {
	        existingTransaction.setDescription(updatedTransfer.getTransaction().getDescription());
	        existingTransaction.setAmount(updatedTransfer.getTransaction().getAmount());
	    }

	    em.persist(existingTransfer); 
	    return existingTransfer;
	}


	public void deleteTransfer(Long id) {
		Transfer transfer = em.find(Transfer.class, id);
		if (transfer != null) {
			em.remove(transfer);
		}
	}

}
