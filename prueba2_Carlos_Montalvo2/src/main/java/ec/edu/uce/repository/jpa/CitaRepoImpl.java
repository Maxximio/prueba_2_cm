package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.CitaMedica;
import ec.edu.uce.modelo.jpa.CitaSimple;

@Repository
@Transactional
public class CitaRepoImpl implements ICitaRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertCitaSimple(CitaSimple citsi) {
		this.entityManager.persist(citsi);
	}

	@Override
	public void InsertarCitaMedica(CitaMedica cita) {
		this.entityManager.persist(cita);
	}

	@Override
	public CitaMedica buscarCitaMedica(Integer id) {
		return this.entityManager.find(CitaMedica.class, id);
	}

	@Override
	public void ActualizarCitaMedica(CitaMedica cita) {
		this.entityManager.merge(cita);
	}

	@Override
	public void borrarCitaMedica(Integer id) {
		CitaMedica citaBorrar=this.buscarCitaMedica(id);
		this.entityManager.remove(citaBorrar);
	}

	
	
}
