package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.CitaMedica;
import ec.edu.uce.modelo.jpa.CitaSimple;

@Repository
@Transactional
public class CitaRepoImpl implements ICitaMedicaRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertCitaSimple(CitaSimple citsi) {
		this.entityManager.persist(citsi);
	}

	@Override
	public void ActualizarCita(CitaMedica cita) {
		
	}

	
	
}
