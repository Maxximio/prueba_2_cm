package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Doctor;

@Repository
@Transactional
public class DoctorRepoImpl implements IDoctorRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void InsertarDoctor(Doctor doc) {
		this.entityManager.persist(doc);
	}

	@Override
	public Doctor buscarDoctor(Integer id) {
		return this.entityManager.find(Doctor.class, id);
	}

	@Override
	public void ActualizarDoctor(Doctor doc) {
		this.entityManager.merge(doc);
	}

	@Override
	public void borrarDoctor(Integer id) {
		Doctor doctorBorrar=this.buscarDoctor(id);
		this.entityManager.remove(doctorBorrar);
	}

}
