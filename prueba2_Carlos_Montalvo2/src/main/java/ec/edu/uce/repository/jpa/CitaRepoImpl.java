package ec.edu.uce.repository.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.CitaMedica;
import ec.edu.uce.modelo.jpa.CitaSimple;
import ec.edu.uce.modelo.jpa.Paciente;

@Repository
@Transactional
public class CitaRepoImpl implements ICitaRepo{

	private static final Logger LOG= LogManager.getLogger(CitaRepoImpl.class);
	
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

	@Override
	public CitaMedica buscarPorNumero(Integer num) {
		CitaMedica g=null;
		try {
		Query miQuery= this.entityManager.createQuery("select c from CitaMedica c where c.numero=:valor");
		miQuery.setParameter("valor", num);
		
		 g=(CitaMedica) miQuery.getSingleResult();
	}catch(NoResultException e) {
		LOG.error("No existe un resultado para: "+num,e);
	}	
		return g;
	}

	@Override
	public List<CitaMedica> ReporteCitas(LocalDateTime fechaMin, BigDecimal bigDecimal) {
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<CitaMedica> myQuery=myCriteria.createQuery(CitaMedica.class);
		
		Root<CitaMedica>myTabla=myQuery.from(CitaMedica.class);
		
		Predicate p1=myCriteria.equal(myTabla.get("fechaCita"),fechaMin);
		Predicate p2=myCriteria.equal(myTabla.get("valorCita"),bigDecimal);
		Predicate and=myCriteria.or(p1,p2);
		
		myQuery.select(myTabla).where(and);
			
		TypedQuery<CitaMedica> typedQuery=this.entityManager.createQuery(myQuery);
		
		return typedQuery.getResultList();
	}

	
	
}
