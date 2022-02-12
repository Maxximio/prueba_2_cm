package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Paciente;
import ec.edu.uce.repository.jpa.IPacienteRepo;

@Service
public class PacienteServiceImpl implements IPacienteService{

	@Autowired
	private IPacienteRepo paciRepo;
	
	@Override
	public void InsertarPacienteService(Paciente paci) {
		this.paciRepo.InsertarPaciente(paci);
	}

	@Override
	public Paciente buscarPacienteService(Integer id) {
		return this.paciRepo.buscarPaciente(id);
	}

	@Override
	public void ActualizarPacienteService(Paciente paci) {
		this.paciRepo.ActualizarPaciente(paci);
	}

	@Override
	public void borrarDoctorService(Integer id) {
		this.paciRepo.borrarDoctor(id);
	}

}
