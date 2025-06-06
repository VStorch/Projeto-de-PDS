package veiculos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Garagem {
	

	private LocalDate dataReti;
	
	private List<Carro> garagem = new ArrayList<>();

	public Garagem() {
		garagem.add(new Carro("SUV", "Captur", null, true));
		garagem.add(new Carro("Economico", "Carroça", "JSHF7DG", true));
		garagem.add(new Carro("Luxu", "Uno com escada", null, true));
		garagem.add(new Carro("SUV", "Jeep", "Esta placa não foi alterada", true));
	}
	
	public void reservar() {
		for (Carro carro : garagem) {
			if (carro.isDisponivel() == true) {
				garagem.remove(carro);
				// Implementar data
			}
		}
	}
	
	// Method to manager add new cars
	public void adicionar(Carro carro) {
		garagem.add(carro);
	}
	
}