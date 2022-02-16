package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Doctor;

@Repository
@Transactional
public class DoctorRepoImpl implements IDoctorRepo{

	private static final Logger LOG= LogManager.getLogger(DoctorRepoImpl.class);
	
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

	@Override
	public Doctor buscarDoctorCedula(String ced) {
		Doctor g=null;
		try {
		Query miQuery= this.entityManager.createQuery("select d from Doctor d where d.cedula=:valor");
		miQuery.setParameter("valor", ced);
		
		 g=(Doctor) miQuery.getSingleResult();
	}catch(NoResultException e) {
		LOG.error("No existe un resultado para: "+ced,e);
	}	
		return g;
	}

}
