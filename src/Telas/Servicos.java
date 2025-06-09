package Telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.MainController;
import usuario.Usuario;
import veiculos.Carro;
import veiculos.Garagem;

public class Servicos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Usuario usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Usuario usuario = new Usuario("JSilva", "João Silva", "027.113.900-55","1234");

					
					Servicos frame = new Servicos(usuario);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	

	public Servicos(Usuario usuario) {
		this.usuario = usuario;
		
		setTitle("Serviços");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/Logo.png"));
		setIconImage(icon.getImage());
		
		setContentPane(contentPane);
				
		GridBagLayout gbl_contentPane = new GridBagLayout();
		contentPane.setLayout(gbl_contentPane);
		
		GridBagConstraints c0 = new GridBagConstraints();
		c0.gridx = 1;
		c0.gridy = 0;
		c0.weightx = 0.1;
		contentPane.add(Box.createVerticalStrut(10), c0);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.1;
		contentPane.add(Box.createHorizontalStrut(10), c);

		Set<String> tipos = new HashSet<>();
		for(Carro carro : Garagem.carrosDisponiveis()) {
			tipos.add(carro.getTipo());
		}
		
		GridBagConstraints c2 = new GridBagConstraints();
		JComboBox<String> cbTipos = new JComboBox<>();
		cbTipos.setPreferredSize(new java.awt.Dimension(100, 18));
		c2.gridx = 1;
		c2.gridy = 1;
		c2.anchor = GridBagConstraints.WEST;
		c2.weightx = 1;
		contentPane.add(cbTipos, c2);
		
		// Add the list to the JComboBox
		for (String tipo : tipos) {
			cbTipos.addItem(tipo);
		}
		
		GridBagConstraints cLabel = new GridBagConstraints();
		JLabel lblInfo = new JLabel("Serviços Disponíveis");
		lblInfo.setFont(new Font("Calibri", Font.PLAIN, 16));
		cLabel.gridx = 1;
		cLabel.gridy = 1;
		cLabel.anchor = GridBagConstraints.CENTER;
		cLabel.weightx = 1;
		contentPane.add(lblInfo, cLabel);
		
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 2;
		c3.gridy = 0;
		c3.weightx = 0.1;
		contentPane.add(Box.createHorizontalStrut(10), c3);
		
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx = 1;
		c4.gridy = 2;
		c4.weightx = 0.1;
		contentPane.add(Box.createVerticalStrut(10), c4);
		
		GridBagConstraints c5 = new GridBagConstraints();
		JPanel panel = new JPanel(null);
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(600, 500));
		c5.gridx = 1;
		c5.gridy = 3;
		c5.fill = GridBagConstraints.BOTH;
		c5.weightx = 1;
		c5.weighty = 1;
		contentPane.add(panel, c5);
		
		GridBagConstraints cS = new GridBagConstraints();
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setPreferredSize(new Dimension(650, 150));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		cS.gridx = 1;
		cS.gridy = 3;
		cS.fill = GridBagConstraints.BOTH;
		cS.weightx = 1;
		cS.weighty = 1;
		contentPane.add(scrollPane, cS);
		
		cbTipos.addActionListener(e -> {
			String tipoSelecionado = (String) cbTipos.getSelectedItem();		
			if(tipoSelecionado != null) {
				atualizarCarros(tipoSelecionado, panel);
			}
		});
		
		
		GridBagConstraints c6 = new GridBagConstraints();
		c6.gridx = 1;
		c6.gridy = 5;
		c6.weightx = 0.1;
		c6.weighty = 0.02;
		contentPane.add(Box.createVerticalStrut(10), c6);
		
		addWindowListener(new WindowAdapter() {
		    public void windowClosed(WindowEvent e) {
		        MainController.abrirMenu(usuario);
		    }
		});
	}

	
	
	private void atualizarCarros(String tipoSelecionado, JPanel panel) {
		
		panel.removeAll();
		
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
	    List<Carro> carros = Garagem.carrosDisponiveis();
	    
	    for (Carro carro : carros) {
			if(carro.getTipo().equals(tipoSelecionado)) {
				
				JPanel carroPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
				carroPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
				carroPanel.setBackground(Color.WHITE);
				
				JLabel lblCar = new JLabel("Modelo: "+ carro.getModelo() +" | Placa: " +carro.getPlaca());
				JButton btnReservar = new JButton("Reservar");
				
				btnReservar.addActionListener(ev -> {
					String data = JOptionPane.showInputDialog(null, "Digite a Data da Reserva:", "Reserva", JOptionPane.INFORMATION_MESSAGE);
					if(data != null && !data.isEmpty()) {
						try {
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							LocalDate dataReserva = LocalDate.parse(data, formatter);
							boolean sucesso = Garagem.reservar(carro, dataReserva);
							
							if (sucesso == true) {
								String dataF = dataReserva.format(formatter);
				                JOptionPane.showMessageDialog(null, "Carro " + carro.getModelo() + " reservado para " + dataF, "Reserva Realizada", JOptionPane.INFORMATION_MESSAGE);
								atualizarCarros(tipoSelecionado, panel);
								usuario.setUltimaReserva(carro.getModelo(), dataF);

							}

						} catch (DateTimeParseException ex) {
				            JOptionPane.showMessageDialog(null, "Formato de data inválido", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				
				carroPanel.add(lblCar);
				carroPanel.add(btnReservar);
				
				panel.add(carroPanel);
			}
			
			panel.revalidate();
			panel.repaint();
		}
	}

}