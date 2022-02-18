package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.Application;
import ec.edu.uce.modelo.jpa.CitaMedica;
import ec.edu.uce.modelo.jpa.CitaSimple;
import ec.edu.uce.modelo.jpa.Doctor;
import ec.edu.uce.modelo.jpa.Paciente;
import ec.edu.uce.repository.jpa.ICitaRepo;

@Service
public class GestorCitasMedicasServiceImpl implements IGestorCitasMedicasService{

	private static final Logger LOG= LogManager.getLogger(GestorCitasMedicasServiceImpl.class);
	
	@Autowired
	private IPacienteService pacService;
	
	@Autowired
	private IDoctorService docService;
	
	@Autowired
	private ICitaService citaService;
	
	
	
	
	
	@Override
	public void ingresarDoctor(Doctor doc) {
		this.docService.InsertarDoctorService(doc);
	}

	@Override
	public void ingresarPaciente(Paciente pc) {
		this.pacService.InsertarPacienteService(pc);
	}

	@Override
	public void ingresarCitaSimple(CitaSimple cisi) {
		this.citaService.insertCitaSimpleService(cisi);
	}

	@Override
	public void ActualizacionDeDoctor(Doctor doc) {
		this.docService.ActualizarDoctorService(doc);
	}

	@Override
	public void ActualizacionDePaciente(Paciente pc) {
		this.pacService.ActualizarPacienteService(pc);
	}

	@Override
	public Paciente buscarPacienteCodSeguro(String codigoIess) {
		return this.pacService.buscarPacienteCedulaService(codigoIess);
	}

	@Override
	public Doctor buscarDoctorApellido(String apellido) {
		return this.docService.buscarDoctorCedulaService(apellido);
	}

	@Override
	public void AgendarCita(Integer num, LocalDateTime fecha, BigDecimal valor, String lugar, String cedulaDoctor,
			String cedulaPaciente) {
		
		Paciente p1=this.pacService.buscarPacienteCedulaService(cedulaPaciente);
		Doctor d1=this.docService.buscarDoctorCedulaService(cedulaDoctor);
		
		CitaMedica cit=new CitaMedica();
		cit.setNumero(num);
		cit.setFechaCita(fecha);
		cit.setValorCita(valor);
		cit.setLugarCita(lugar);
		cit.setPaciente(p1);
		cit.setDoctor(d1);
		
		this.citaService.InsertarCitaMedicaService(cit);
	}

	@Override
	public void ingresarCitaMedica(CitaMedica cita) {
		this.citaService.InsertarCitaMedicaService(cita);
	}

	@Override
	public void ActualizarCitas(Integer numero, String diagnostico, String receta, LocalDateTime fechaProx) {
		CitaMedica cit=citaService.buscarPorNumeroService(numero);
		cit.setDiagnostico(diagnostico);
		cit.setReceta(receta);
		cit.setFechaControl(fechaProx);
		
		this.citaService.ActualizarCitaMedicaService(cit);
	}

	@Override
	public List<CitaMedica> ReporteCitas(LocalDateTime fechaMin, BigDecimal bigDecimal) {
		return this.citaService.ReporteCitasService(fechaMin, bigDecimal);
	}

}
