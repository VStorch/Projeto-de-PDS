package Telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.MainController;
import veiculos.Carro;
import veiculos.Garagem;

public class TelaAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textTipo;
	private JTextField textModelo;
	private JTextField textPlaca;
	private JTextField textPlacaEx;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdmin frame = new TelaAdmin();
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
	public TelaAdmin() {
		setResizable(false);
		setTitle("Tela Admin");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/Logo.png"));
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);
		
		JLabel lblInfo = new JLabel("Altere os carros na Garagem");
		lblInfo.setFont(new Font("Arial", Font.BOLD, 14));
		lblInfo.setBounds(112, 11, 200, 14);
		getContentPane().add(lblInfo);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(20, 36, 264, 203);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTipo.setBounds(10, 62, 46, 14);
		panel.add(lblTipo);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblModelo.setBounds(10, 103, 57, 14);
		panel.add(lblModelo);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPlaca.setBounds(10, 148, 46, 14);
		panel.add(lblPlaca);
		
		JLabel lblAdicionarCarro = new JLabel("Adicionar Carro");
		lblAdicionarCarro.setFont(new Font("Arial", Font.ITALIC, 14));
		lblAdicionarCarro.setBounds(78, 11, 99, 14);
		panel.add(lblAdicionarCarro);
		
		textTipo = new JTextField();
		textTipo.setBounds(66, 60, 128, 20);
		panel.add(textTipo);
		textTipo.setColumns(10);
		
		textModelo = new JTextField();
		textModelo.setColumns(10);
		textModelo.setBounds(66, 101, 128, 20);
		panel.add(textModelo);
		
		textPlaca = new JTextField();
		textPlaca.setColumns(10);
		textPlaca.setBounds(66, 146, 128, 20);
		panel.add(textPlaca);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tipo = textTipo.getText();
				String modelo = textModelo.getText();
				String placa = textPlaca.getText();
				
				if (!tipo.isEmpty() && !modelo.isEmpty() && !placa.isEmpty()) {
					Carro carro = new Carro(tipo, modelo, placa, true);
					Garagem.adicionar(carro);
					textTipo.setText("");
					textModelo.setText("");
					textPlaca.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnAdicionar.setBounds(88, 177, 89, 23);
		panel.add(btnAdicionar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(302, 36, 111, 203);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblExcluirCarro = new JLabel("Excluir Carro");
		lblExcluirCarro.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluirCarro.setFont(new Font("Arial", Font.ITALIC, 14));
		lblExcluirCarro.setBounds(0, 11, 111, 14);
		panel_1.add(lblExcluirCarro);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String placa = textPlacaEx.getText();
				Garagem.remover(placa);
				textPlacaEx.setText("");
				
			}
		});
		btnExcluir.setBounds(10, 169, 89, 23);
		panel_1.add(btnExcluir);
		
		JLabel lblPlaca_1 = new JLabel("Placa:");
		lblPlaca_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPlaca_1.setBounds(33, 63, 46, 14);
		panel_1.add(lblPlaca_1);
		
		textPlacaEx = new JTextField();
		textPlacaEx.setColumns(10);
		textPlacaEx.setBounds(10, 82, 91, 20);
		panel_1.add(textPlacaEx);
		
		addWindowListener(new WindowAdapter() {
		    public void windowClosed(WindowEvent e) {
		        MainController.abrirLogin();
		    }
		});
	}
}
