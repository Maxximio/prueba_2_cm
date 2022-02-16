package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.Paciente;

public interface IPacienteService {

	void InsertarPacienteService(Paciente paci);
	
	Paciente buscarPacienteService(Integer id);
	
	void ActualizarPacienteService(Paciente paci);
	
	void borrarDoctorService(Integer id);
	
	Paciente buscarPacienteCedulaService(String ced);
}
