package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import ec.edu.uce.modelo.jpa.CitaMedica;
import ec.edu.uce.modelo.jpa.CitaSimple;
import ec.edu.uce.modelo.jpa.Doctor;
import ec.edu.uce.modelo.jpa.Paciente;

public interface IGestorCitasMedicasService {

	void ingresarDoctor (Doctor doc);
	
	void ingresarPaciente(Paciente pc);
	
	void ingresarCitaSimple(CitaSimple cisi);
	
	void ActualizacionDeDoctor(Doctor doc);
	
	void ActualizacionDePaciente(Paciente pc);
	
	Paciente buscarPacienteCodSeguro(String codigoIess);
	
	Doctor buscarDoctorApellido(String apellido);
	
	void ingresarCitaMedica(CitaMedica cita); 
	
	void AgendarCita(Integer num,LocalDateTime fecha,BigDecimal valor, String lugar,String apellidoDoctor, String CodSeguroPaciente);
	
}
