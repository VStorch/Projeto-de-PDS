package veiculos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Garagem {
	

	private LocalDate dataReti;
	
	private static List<Carro> garagem = new ArrayList<>();

	static {
		garagem.add(new Carro("SUV", "Captur", "Uma Placa", true));
		garagem.add(new Carro("Economico", "Carroça", "JSHF7DG", true));
		garagem.add(new Carro("Luxo", "Uno com escada", "null", true));
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
		boolean existeP = false;
		for (Carro carrol : garagem) {
			if (carro.getPlaca().equals(carrol.getPlaca())) {
				existeP = true;
			}
		}
		
		if (!existeP) {
			garagem.add(carro);
			JOptionPane.showMessageDialog(null, "Carro adicionado com Sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "Placa já existente", "Erro", JOptionPane.ERROR_MESSAGE);

		}
	}
	
	public static void remover(String placa) {
		Carro carroExcluir = null;
		for (Carro carro : garagem) {
			if (placa != null && placa.equals(carro.getPlaca())) {
				carroExcluir = carro;
			}
		}
		
		if (carroExcluir != null) {
			garagem.remove(carroExcluir);
			JOptionPane.showMessageDialog(null, "Carro removido com Sucesso!", "Remoção", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "Carro não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
		}
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