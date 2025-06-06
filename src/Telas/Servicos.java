package Telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MainController;
import usuario.Usuario;
import veiculos.Carro;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	
	// Revisar a classe Serviços
	// Implementar as reservas e os carros disponíveis
	public Servicos(Usuario usuario) {
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

		GridBagConstraints c2 = new GridBagConstraints();
		JComboBox<Carro> cbTipos = new JComboBox<>();
		// Implementar o ListCellRenderer
		
		cbTipos.setPreferredSize(new java.awt.Dimension(100, 18));
		c2.gridx = 1;
		c2.gridy = 1;
		c2.anchor = GridBagConstraints.WEST;
		c2.weightx = 1;
		contentPane.add(cbTipos, c2);
		
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
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		c5.gridx = 1;
		c5.gridy = 3;
		c5.fill = GridBagConstraints.BOTH;
		c5.weightx = 1;
		c5.weighty = 1;
		contentPane.add(panel, c5);
				
		GridBagConstraints cB = new GridBagConstraints();
		JButton botaoRes = new JButton("Reservar");
		botaoRes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// I need implement this system
				JOptionPane.showInputDialog(null, "Digite a data", "Data de retirada", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		cB.gridx = 1;
		cB.gridy = 4;
		cB.anchor = GridBagConstraints.EAST;
		cB.weightx = 1;
		contentPane.add(botaoRes, cB);
		
		GridBagConstraints c6 = new GridBagConstraints();
		c6.gridx = 1;
		c6.gridy = 5;
		c6.weightx = 0.1;
		contentPane.add(Box.createVerticalStrut(10), c6);
		
		addWindowListener(new WindowAdapter() {
		    public void windowClosed(WindowEvent e) {
		        MainController.abrirMenu(usuario);
		    }
		});
	}
}
