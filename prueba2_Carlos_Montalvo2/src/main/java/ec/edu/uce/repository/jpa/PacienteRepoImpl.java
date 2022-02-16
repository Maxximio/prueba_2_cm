package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Paciente;

@Repository
@Transactional
public class PacienteRepoImpl implements IPacienteRepo{

	private static final Logger LOG= LogManager.getLogger(PacienteRepoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void InsertarPaciente(Paciente paci) {
		this.entityManager.persist(paci);
	}

	@Override
	public Paciente buscarPaciente(Integer id) {
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void ActualizarPaciente(Paciente paci) {
		this.entityManager.merge(paci);
	}

	@Override
	public void borrarDoctor(Integer id) {
		Paciente pacieteBorrar=this.buscarPaciente(id);
		this.entityManager.remove(pacieteBorrar);
	}

	@Override
	public Paciente buscarPacienteCedula(String ced) {
		Paciente g=null;
		try {
		Query miQuery= this.entityManager.createQuery("select p from Paciente p where p.cedula =:valor");
		miQuery.setParameter("valor",ced);
		
		 g=(Paciente) miQuery.getSingleResult();
	}catch(NoResultException e) {
		LOG.error("No existe un resultado para: "+ced ,e);
	}	
		return g;
	}

}
