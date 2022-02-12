package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.CitaSimple;
import ec.edu.uce.modelo.jpa.Doctor;
import ec.edu.uce.modelo.jpa.Paciente;
import ec.edu.uce.repository.jpa.ICitaMedicaRepo;

@Service
public class GestorCitasMedicasServiceImpl implements IGestorCitasMedicasService{

	@Autowired
	private IPacienteService pacService;
	
	@Autowired
	private IDoctorService docService;
	
	@Autowired
	private ICitaMedicaRepo citaService;
	
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

}
