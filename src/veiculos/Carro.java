package veiculos;

import java.time.LocalDate;

public class Carro {
	
	private String tipo, modelo, placa;
	private boolean disponivel;
	private LocalDate dataReserva;
	
	public Carro(String tipo, String modelo, String placa, boolean disponivel) {
		super();
		this.tipo = tipo;
		this.modelo = modelo;
		this.placa = placa;
		this.disponivel = disponivel;
		this.dataReserva = null;
	}

	public String getTipo() {
		return tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public String getPlaca() {
		return placa;
	}
	
	public boolean isDisponivel() {
		return disponivel;
	}
	
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public LocalDate getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}
	
}