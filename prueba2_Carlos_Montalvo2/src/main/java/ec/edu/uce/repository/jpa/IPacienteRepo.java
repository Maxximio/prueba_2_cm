package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.Paciente;

public interface IPacienteRepo {

	void InsertarPaciente(Paciente paci);
	
	Paciente buscarPaciente(Integer id);
	
	void ActualizarPaciente(Paciente paci);
	
	void borrarDoctor(Integer id);
	
}
