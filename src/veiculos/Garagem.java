package veiculos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Garagem {
	

	private LocalDate dataReti;
	
	private static List<Carro> garagem = new ArrayList<>();

	static {
		garagem.add(new Carro("SUV", "Captur", null, true));
		garagem.add(new Carro("Economico", "Carroça", "JSHF7DG", true));
		garagem.add(new Carro("Luxo", "Uno com escada", null, true));
		garagem.add(new Carro("SUV", "Jeep", "Placa não alterada", true));
	}
	
	public static boolean reservar(Carro carro, LocalDate dataReti) {
		if (carro.isDisponivel() == true) {
			carro.setDisponivel(false);
			carro.setDataReserva(dataReti);
			return true;
		}
		return false;
	}
	
	// Method to manager add new cars
	public static void adicionar(Carro carro) {
		garagem.add(carro);
	}
	
	public static List<Carro> carrosDisponiveis() {
		List<Carro> disponiveis = new ArrayList<>();
		for(Carro carro : garagem) {
			if (carro.isDisponivel()) {
				disponiveis.add(carro);
			}
		}
		return disponiveis;
	}
}