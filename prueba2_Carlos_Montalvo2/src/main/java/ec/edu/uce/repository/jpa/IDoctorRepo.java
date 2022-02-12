package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.Doctor;

public interface IDoctorRepo {

	void InsertarDoctor(Doctor doc);
	
	Doctor buscarDoctor(Integer id);
	
	void ActualizarDoctor(Doctor doc);
	
	void borrarDoctor(Integer id);
	
}
