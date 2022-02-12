package ec.edu.uce.modelo.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CitaSimple {

	private Integer numero;
	private LocalDateTime fechaCita;
	private BigDecimal valorCita;
	private String lugarCita;

	
	public CitaSimple() {}

	public CitaSimple(Integer numero, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			Paciente paciente, Doctor doctor) {
		super();
		this.numero = numero;
		this.fechaCita = fechaCita;
		this.valorCita = valorCita;
		this.lugarCita = lugarCita;
	}

	//metodo set y get
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public BigDecimal getValorCita() {
		return valorCita;
	}

	public void setValorCita(BigDecimal valorCita) {
		this.valorCita = valorCita;
	}

	public String getLugarCita() {
		return lugarCita;
	}

	public void setLugarCita(String lugarCita) {
		this.lugarCita = lugarCita;
	}
	
}
