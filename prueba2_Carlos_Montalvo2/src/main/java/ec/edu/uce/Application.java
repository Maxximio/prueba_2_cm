package ec.edu.uce;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.jpa.CitaMedica;
import ec.edu.uce.modelo.jpa.CitaSimple;
import ec.edu.uce.modelo.jpa.Doctor;
import ec.edu.uce.modelo.jpa.Paciente;
import ec.edu.uce.service.IDoctorService;
import ec.edu.uce.service.IGestorCitasMedicasService;
import ec.edu.uce.service.IPacienteService;


@SpringBootApplication
public class Application implements CommandLineRunner{
	
	private static final Logger LOG= LogManager.getLogger(Application.class);
	
	@Autowired
	private IGestorCitasMedicasService gestorService;

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		Doctor doc1=new Doctor();
		doc1.setCedula("11532435563");
		doc1.setNombre("Enrique");
		doc1.setApellido("Jackson");
		LocalDateTime mifecha=LocalDateTime.of(1999, Month.AUGUST,8,12,45);
		doc1.setFechaNacimiento(mifecha);
		doc1.setNumeroConsultorio(12);
		doc1.setCodigoSenescyt("1244364saf");
		doc1.setSueldo(new BigDecimal(1400.00));
		
		Doctor doc2=new Doctor();
		doc2.setCedula("34645433455");
		doc2.setNombre("Alejandra");
		doc2.setApellido("Correa");
		LocalDateTime mifecha2=LocalDateTime.of(1985, Month.DECEMBER,7,4,15);
		doc2.setFechaNacimiento(mifecha2);
		doc2.setNumeroConsultorio(10);
		doc2.setCodigoSenescyt("asdqw114124");
		doc2.setSueldo(new BigDecimal(1200.00));
		
		//gestorService.ingresarDoctor(doc2);/////insertando doctores
		//gestorService.ingresarDoctor(doc1);
		
		Paciente pac1=new Paciente();
		pac1.setCedula("12141244");
		pac1.setNombre("Julio");
		pac1.setApellido("Arboleda");
		LocalDateTime mifecha3=LocalDateTime.of(1965, Month.JUNE,7,4,15);
		pac1.setFecha_nacimiento(mifecha3);
		pac1.setCodigoIess("abcde");
		pac1.setEstatura(175);
		pac1.setPeso(80);
		pac1.setEdad(55);
		
		Paciente pac2=new Paciente();
		pac2.setCedula("1245132");
		pac2.setNombre("Maria");
		pac2.setApellido("Garces");
		LocalDateTime mifecha4=LocalDateTime.of(1990, Month.JULY,7,4,15);
		pac2.setFecha_nacimiento(mifecha4);
		pac2.setCodigoIess("sdssgs2322");
		pac2.setEstatura(155);
		pac2.setPeso(60);
		pac2.setEdad(30);
		
		//gestorService.ingresarPaciente(pac2);////////insertando pacientes
		//gestorService.ingresarPaciente(pac1);
		
		
		doc2.setNumeroConsultorio(23);
		
		pac2.setPeso(85);
		
		//gestorService.ActualizacionDeDoctor(doc2);/////////actualizacion de doctor
		//gestorService.ActualizacionDePaciente(pac2);//y paciente

		
		CitaSimple cis=new CitaSimple();
		cis.setNumero(235);
		LocalDateTime mifecha5=LocalDateTime.of(2022, Month.JULY,7,4,15);
		cis.setFechaCita(mifecha5);
		cis.setValorCita(new BigDecimal(20.50));
		cis.setLugarCita("Clinica Quito");
		//cis.setDoctor(doc2);
		//cis.setPaciente(pac2);
		
		//gestorService.ingresarCitaSimple(cis);
		
		
		
		CitaMedica cit=new CitaMedica();
		cit.setNumero(235);
		LocalDateTime mifecha0=LocalDateTime.of(2022, Month.JULY,7,4,15);
		cit.setFechaCita(mifecha0);
		cit.setValorCita(new BigDecimal(20.50));
		cit.setLugarCita("Clinica Quito");
		cit.setDiagnostico("Se va a morir");
		cit.setReceta("descanzo en paz");
		
		CitaMedica cit2=new CitaMedica();
		cit2.setNumero(235);
		LocalDateTime mifecha02=LocalDateTime.of(2022, Month.JULY,7,4,15);
		cit2.setFechaCita(mifecha02);
		cit2.setValorCita(new BigDecimal(20.50));
		cit2.setLugarCita("Clinica Quito");
		cit2.setDiagnostico("Se va a morir");
		cit2.setReceta("descanzo en paz");
		
		List<CitaMedica> citasM=new ArrayList<>();
		List<CitaMedica> citasM2=new ArrayList<>();
		
		citasM.add(cit);
		citasM2.add(cit2);
		
		doc1.setCita_medica(citasM);
		pac1.setCita_medica(citasM2);

		
		gestorService.AgendarCita(123, mifecha0, new BigDecimal(20.50), "Clinica Quito", "Jackson", "abcde");
	}

}
