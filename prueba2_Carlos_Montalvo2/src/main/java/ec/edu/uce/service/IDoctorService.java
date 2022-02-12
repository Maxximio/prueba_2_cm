package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.Doctor;

public interface IDoctorService {

	void InsertarDoctorService(Doctor doc);
	
	Doctor buscarDoctorService(Integer id);
	
	void ActualizarDoctorService(Doctor doc);
	
	void borrarDoctorService(Integer id);
	
}
