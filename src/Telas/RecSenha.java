package Telas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.MainController;
import usuario.BancoUsuarios;

public class RecSenha extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCpf;
	private JPasswordField passwordSenha;
	private JPasswordField passwordConfSenha;
	private JLabel lblNomeUsu;
	private JTextField textNomeUsu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecSenha frame = new RecSenha();
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
	public RecSenha() {
		setTitle("Recupere sua Senha");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 313);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/Logo.png"));
		setIconImage(icon.getImage());
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textCpf = new JTextField();
		textCpf.setBounds(147, 89, 214, 24);
		contentPane.add(textCpf);
		textCpf.setColumns(10);
		
		JLabel lblCpf = new JLabel("Digite seu CPF:");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCpf.setBounds(39, 92, 110, 17);
		contentPane.add(lblCpf);
		
		JLabel lblDigiteNSenha = new JLabel("Digite sua nova senha:");
		lblDigiteNSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDigiteNSenha.setBounds(39, 147, 145, 17);
		contentPane.add(lblDigiteNSenha);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setBounds(194, 140, 167, 24);
		contentPane.add(passwordSenha);
		
		JLabel lblConfirmeSenha = new JLabel("Confirme a senha:");
		lblConfirmeSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		lblConfirmeSenha.setBounds(39, 199, 145, 17);
		contentPane.add(lblConfirmeSenha);
		
		passwordConfSenha = new JPasswordField();
		passwordConfSenha.setBounds(194, 196, 167, 24);
		contentPane.add(passwordConfSenha);
		
		lblNomeUsu = new JLabel("Nome de Usuário:");
		lblNomeUsu.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNomeUsu.setBounds(39, 34, 125, 17);
		contentPane.add(lblNomeUsu);
		
		textNomeUsu = new JTextField();
		textNomeUsu.setColumns(10);
		textNomeUsu.setBounds(156, 31, 205, 24);
		contentPane.add(textNomeUsu);
		
		JButton btnConf = new JButton("Confirmar");
		btnConf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nomeUsu = textNomeUsu.getText();
				String cpf = textCpf.getText();
				String senha = new String(passwordSenha.getPassword());
				String senhaConf = new String(passwordConfSenha.getPassword());
				
				if (cpf.isEmpty() || senha.isEmpty() || senhaConf.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Vazio", JOptionPane.ERROR_MESSAGE);
				}
				
				else if(!senha.equals(senhaConf)) {
					JOptionPane.showMessageDialog(null, "Senhas não compatíveis", "Incompatibilidade", JOptionPane.ERROR_MESSAGE);
				}
				
				else if(!BancoUsuarios.existe(nomeUsu)) {
					JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);

				}
				
				else if (BancoUsuarios.existe(nomeUsu)) {
					BancoUsuarios.alterarSenha(cpf, senha);
					JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					MainController.abrirLogin();
				}
				
			}
		});
		btnConf.setBounds(268, 234, 93, 29);
		contentPane.add(btnConf);
	}
}
