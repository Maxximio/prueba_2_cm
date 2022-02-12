package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Paciente;

@Repository
@Transactional
public class PacienteRepoImpl implements IPacienteRepo{

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

}
