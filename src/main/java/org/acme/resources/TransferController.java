package org.acme.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.acme.entity.Transaction;
import org.acme.entity.Transfer;
import org.acme.repository.TransferRepository;
import org.acme.service.TransferService;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/transfer")
public class TransferController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransferController.class);

	@Inject
	TransferService transferService;
	@Inject
	EntityManager em;

	@Inject
	TransferRepository transferRepository;

	@GET
	@Path("/data/all")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public List<Transfer> findAllWithTransactions() {
		LOGGER.info("Finding all transfers with transactions.");
		return em.createQuery("SELECT t FROM Transfer t JOIN FETCH t.transaction", Transfer.class).getResultList();
	}

	@GET
	@Path("/data/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getTransferAndTransactionData(@PathParam("id") Long id) {
		LOGGER.info("Getting transfer and transaction data for id: {}", id);
		Optional<Transfer> transferOptional = transferRepository.findByIdOptional(id);
		if (transferOptional.isEmpty()) {
			LOGGER.warn("Transfer with id {} not found.", id);
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		Transfer transfer = transferOptional.get();
		Transaction transaction = transfer.getTransaction();

		LOGGER.info("Transfer and transaction data retrieved successfully for id: {}", id);
		return Response.ok().entity("Transfer: " + transfer.toString() + "\nTransaction: " + transaction.toString())
				.build();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveTransfer(Transfer transfer) {
		LOGGER.info("Saving transfer: {}", transfer);
		transferService.saveTransfer(transfer);
		return Response.created(URI.create("/transfer/" + transfer.getId())).build();
	}

	@PUT
	@Path("/{id}")
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateTransferAndTransaction(@PathParam("id") Long id, Transfer updatedTransfer) {
		LOGGER.info("Updating transfer with id: {}", id);
		Transfer updated = transferService.updateTransferAndTransaction(id, updatedTransfer);
		if (updated == null) {
			LOGGER.warn("Transfer with id {} not found for updating.", id);
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		LOGGER.info("Transfer with id {} updated successfully.", id);
		return Response.ok(updated).build();
	}

	@DELETE
	@Path("/{id}")
	@Transactional
	public Response deleteTransfer(@PathParam("id") Long id) {
		LOGGER.info("Deleting transfer with id: {}", id);
		transferService.deleteTransfer(id);
		return Response.ok().build();
	}
}
