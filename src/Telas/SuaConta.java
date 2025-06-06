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
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MainController;
import usuario.Usuario;

public class SuaConta extends JFrame {

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
					
					SuaConta frame = new SuaConta(usuario);
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
	public SuaConta(Usuario usuario) {
		setTitle("Sua Conta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/Logo.png"));
		setIconImage(icon.getImage());
		
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
		JLabel lblDadosP = new JLabel("Dados Pessoais");
		lblDadosP.setFont(new Font("Arial", Font.PLAIN, 14));
		c2.gridx = 1;
		c2.gridy = 1;
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.weightx = 1;
		contentPane.add(lblDadosP, c2);
		
		GridBagConstraints c3 = new GridBagConstraints();
		JPanel panelDadosP = new JPanel();
		panelDadosP.setBackground(new Color(255, 255, 255));
		c3.gridx = 1;
		c3.gridy = 2;
		c3.fill = GridBagConstraints.BOTH;
		c3.weightx = 1;
		c3.weighty = 1;
		contentPane.add(panelDadosP, c3);
		
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx = 2;
		c4.gridy = 0;
		c4.weightx = 0.1;
		contentPane.add(Box.createHorizontalStrut(10), c4);
		
		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridx = 1;
		c5.gridy = 3;
		c5.weighty = 0.1;
		contentPane.add(Box.createVerticalStrut(10), c5);
		
		GridBagConstraints c6 = new GridBagConstraints();
		JLabel lblHist = new JLabel("Histórico");
		lblHist.setFont(new Font("Arial", Font.PLAIN, 14));
		c6.gridx = 1;
		c6.gridy = 4;
		c6.fill = GridBagConstraints.HORIZONTAL;
		c6.weightx = 1;
		contentPane.add(lblHist, c6);
		
		GridBagConstraints c7 = new GridBagConstraints();
		JPanel panelHist = new JPanel();
		panelHist.setBackground(new Color(255, 255, 255));
		c7.gridx = 1;
		c7.gridy = 5;
		c7.fill = GridBagConstraints.BOTH;
		c7.weightx = 1;
		c7.weighty = 1;
		contentPane.add(panelHist, c7);
		
		GridBagConstraints c8 = new GridBagConstraints();
		c8.gridx = 1;
		c8.gridy = 6;
		c8.weighty = 0.1;
		contentPane.add(Box.createVerticalStrut(10), c8);
		
		// editorP and editorHist create the user text and allow the user to update it
		JEditorPane editorP = new JEditorPane();
		panelDadosP.add(editorP);
		
		JEditorPane editorHist = new JEditorPane();
		panelHist.add(editorHist);
		
		// Close the window and open Menu
		addWindowListener(new WindowAdapter() {
		    public void windowClosed(WindowEvent e) {
		        MainController.abrirMenu(usuario);
		    }
		});
	}

}