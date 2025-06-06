package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.MainController;
import usuario.Usuario;

public class Menu extends JFrame {

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
					
					Menu frame = new Menu(usuario);
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
	public Menu(Usuario usuario) {
		
		this.usuario = usuario;
		
		setTitle("Tela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 430);
		setLocationRelativeTo(null); // This method centralizes the window
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/Logo.png"));
		setIconImage(icon.getImage());
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem itemMenuSuaConta = new JMenuItem("Sua Conta");
		mnMenu.add(itemMenuSuaConta);
		itemMenuSuaConta.addActionListener(e -> {
			dispose();
			MainController.abrirSuaConta(usuario);
		});
		
		JMenuItem itemMenuServicos = new JMenuItem("Serviços");
		itemMenuServicos.addActionListener(e -> {
			dispose();
			MainController.abrirServicos(usuario);
		});
		mnMenu.add(itemMenuServicos);
		
		JMenuItem itemMenuQuemSomos = new JMenuItem("Quem somos");
		itemMenuQuemSomos.addActionListener(e -> {
			dispose();
			MainController.abrirQuemSomos(usuario);
		});
		mnMenu.add(itemMenuQuemSomos);
		
		JMenuItem itemMenuSair = new JMenuItem("Sair");
		itemMenuSair.addActionListener(e -> {
			MainController.abrirLogin();
			dispose();
		});
		mnMenu.add(itemMenuSair);
		
		// BorderLayout divides the panel
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		
		JLabel lblMensOla = new JLabel("Olá, " + usuario.getNome() + "!");
		lblMensOla.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMensOla.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblMensOla.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Specifying the part of the panel occupied by lblMensOla
		contentPane.add(lblMensOla, BorderLayout.NORTH);
		
		JLabel lblInfoUltimoAlug = new JLabel("<html>"
				+ "<div style= 'margin-top:40px;'>Modelo do Carro: </div>"
				+ "<div style= 'margin-top:15px;'>Data da Retirada: </div>"
				+ "<div style= 'margin-top:15px;'>Data de devolução:</div></html>");
		lblInfoUltimoAlug.setVerticalAlignment(SwingConstants.TOP);
		lblInfoUltimoAlug.setFont(new Font("Arial", Font.PLAIN, 16));
		lblInfoUltimoAlug.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfoUltimoAlug.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		contentPane.add(lblInfoUltimoAlug, BorderLayout.WEST);
	}
}