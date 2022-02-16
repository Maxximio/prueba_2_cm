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
		doc1.setCedula("23452352");
		doc1.setNombre("Manuel");
		doc1.setApellido("Perez");
		LocalDateTime mifecha=LocalDateTime.of(1999, Month.AUGUST,8,12,45);
		doc1.setFechaNacimiento(mifecha);
		doc1.setNumeroConsultorio(23);
		doc1.setCodigoSenescyt("hdfh346365");
		doc1.setSueldo(new BigDecimal(1400.00));
		
		Doctor doc2=new Doctor();
		doc2.setCedula("53463453");
		doc2.setNombre("Maria");
		doc2.setApellido("Cabrera");
		LocalDateTime mifecha2=LocalDateTime.of(1985, Month.DECEMBER,7,4,15);
		doc2.setFechaNacimiento(mifecha2);
		doc2.setNumeroConsultorio(10);
		doc2.setCodigoSenescyt("dfgdgcfbdh");
		doc2.setSueldo(new BigDecimal(1200.00));
		
		//gestorService.ingresarDoctor(doc2);/////insertando doctores
		//gestorService.ingresarDoctor(doc1);
		
		Paciente pac1=new Paciente();
		pac1.setCedula("2525424234");
		pac1.setNombre("Andres");
		pac1.setApellido("Fernandez");
		LocalDateTime mifecha3=LocalDateTime.of(1965, Month.JUNE,7,4,15);
		pac1.setFecha_nacimiento(mifecha3);
		pac1.setCodigoIess("dfhfmf3");
		pac1.setEstatura(175);
		pac1.setPeso(80);
		pac1.setEdad(55);
		
		Paciente pac2=new Paciente();
		pac2.setCedula("4564546456");
		pac2.setNombre("Samanta");
		pac2.setApellido("Maldonado");
		LocalDateTime mifecha4=LocalDateTime.of(1990, Month.JULY,7,4,15);
		pac2.setFecha_nacimiento(mifecha4);
		pac2.setCodigoIess("sdgdgdf454");
		pac2.setEstatura(155);
		pac2.setPeso(60);
		pac2.setEdad(30);
		
		//gestorService.ingresarPaciente(pac2);////////insertando pacientes
		//gestorService.ingresarPaciente(pac1);
		
		gestorService.AgendarCita(1234, mifecha4, new BigDecimal(20.50), "Clinica Quito", "23452352", "4564546456");
		
		gestorService.ActualizarCitas(1234, "dolor de pancreas", "2 miligramos de descanzo", mifecha4);
		
	}

}
