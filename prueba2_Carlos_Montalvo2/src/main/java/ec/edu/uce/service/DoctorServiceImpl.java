package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Doctor;
import ec.edu.uce.repository.jpa.IDoctorRepo;

@Service
public class DoctorServiceImpl implements IDoctorService{

	@Autowired
	private IDoctorRepo docRepo;

	@Override
	public void InsertarDoctorService(Doctor doc) {
		this.docRepo.InsertarDoctor(doc);
	}

	@Override
	public Doctor buscarDoctorService(Integer id) {
		return this.docRepo.buscarDoctor(id);
	}

	@Override
	public void ActualizarDoctorService(Doctor doc) {
		this.docRepo.ActualizarDoctor(doc);
	}

	@Override
	public void borrarDoctorService(Integer id) {
		this.docRepo.borrarDoctor(id);
	}
	
}
