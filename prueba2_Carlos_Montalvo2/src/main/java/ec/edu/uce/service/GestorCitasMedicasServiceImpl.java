package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

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
	private ICitaRepo citaService;
	
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
		this.citaService.insertCitaSimple(cisi);
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
		return this.pacService.buscarPacienteCodSeguroService(codigoIess);
	}

	@Override
	public Doctor buscarDoctorApellido(String apellido) {
		return this.docService.buscarDoctorApellidoService(apellido);
	}

	@Override
	public void AgendarCita(Integer num, LocalDateTime fecha, BigDecimal valor, String lugar, String apellidoDoctor,
			String CodSeguroPaciente) {
		CitaMedica cit=new CitaMedica();//mayor a la fecha actual osino imprimir un warn
		cit.setNumero(num);//el valor debe aumentar un 12%
		LocalDateTime miFechaActual=LocalDateTime.now();
		int diferencia= fecha.compareTo(miFechaActual);
		if(diferencia<0) {
			LOG.warn("El valor de la fecha ingresada no es correcto");
		}
		cit.setFechaCita(fecha);
		BigDecimal b2 = new BigDecimal("0.12");
		BigDecimal b3 = valor.multiply(b2);
		cit.setValorCita(b3);
		cit.setLugarCita(lugar);
		cit.setDiagnostico("Se va a morir");
		cit.setReceta("descanzo en paz");
		cit.setDoctor(this.docService.buscarDoctorApellidoService(apellidoDoctor));
		cit.setPaciente(this.pacService.buscarPacienteCodSeguroService(CodSeguroPaciente));
		
		this.citaService.InsertarCitaMedica(cit);
	}

	@Override
	public void ingresarCitaMedica(CitaMedica cita) {
		this.citaService.InsertarCitaMedica(cita);
	}

}
