package Telas;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.MainController;
import usuario.BancoUsuarios;
import usuario.Usuario;

public class Cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeUsuario;
	private JTextField textNome;
	private JTextField textCPF;
	private JPasswordField passwordSenhaConf;
	private JPasswordField passwordSenha;
	private JButton btnCadastrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setResizable(false);
		setTitle("Tela de Cadastro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 473, 342);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/Logo.png"));
		setIconImage(icon.getImage());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeUsuario = new JLabel("Crie um nome de usuário:");
		lblNomeUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNomeUsuario.setBounds(15, 24, 156, 20);
		contentPane.add(lblNomeUsuario);
		
		JLabel lblDigiteSeuNome = new JLabel("Digite seu nome completo:");
		lblDigiteSeuNome.setFont(new Font("Arial", Font.PLAIN, 13));
		lblDigiteSeuNome.setBounds(15, 76, 156, 20);
		contentPane.add(lblDigiteSeuNome);
		
		JLabel lblDigiteASua = new JLabel("Digite o seu CPF:");
		lblDigiteASua.setFont(new Font("Arial", Font.PLAIN, 13));
		lblDigiteASua.setBounds(63, 128, 108, 20);
		contentPane.add(lblDigiteASua);
		
		JLabel lblCrieUmaSenha = new JLabel("Crie uma senha:");
		lblCrieUmaSenha.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCrieUmaSenha.setBounds(63, 179, 108, 20);
		contentPane.add(lblCrieUmaSenha);
		
		JLabel lblCrieUmaSenha_1 = new JLabel("Confirme a senha:");
		lblCrieUmaSenha_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCrieUmaSenha_1.setBounds(63, 227, 108, 20);
		contentPane.add(lblCrieUmaSenha_1);
		
		textNomeUsuario = new JTextField();
		textNomeUsuario.setBounds(175, 22, 244, 25);
		contentPane.add(textNomeUsuario);
		textNomeUsuario.setColumns(10);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(175, 76, 244, 25);
		contentPane.add(textNome);
		
		textCPF = new JTextField();
		textCPF.setColumns(10);
		textCPF.setBounds(175, 126, 244, 25);
		contentPane.add(textCPF);
		
		passwordSenhaConf = new JPasswordField();
		passwordSenhaConf.setBounds(175, 225, 244, 25);
		contentPane.add(passwordSenhaConf);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setBounds(175, 179, 244, 25);
		contentPane.add(passwordSenha);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nomeUsu = textNomeUsuario.getText();
				String nome = textNome.getText();
				String cpf = textCPF.getText();
				String senha = new String (passwordSenha.getPassword());
				String senhaConf = new String (passwordSenhaConf.getPassword());
				
				if (nomeUsu.isEmpty() || nome.isEmpty() || cpf.isEmpty() || senha.isEmpty() || senhaConf.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Vazio", JOptionPane.ERROR_MESSAGE);
				}
				
				else if (!senha.equals(senhaConf)) {
					JOptionPane.showMessageDialog(null, "Senhas não compatíveis", "Incompatibilidade", JOptionPane.ERROR_MESSAGE);
				}
				
				else if (BancoUsuarios.existe(nomeUsu)) {
					JOptionPane.showMessageDialog(null, "Nome de Usuário já existente", "Nome Inválido", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					Usuario novoUsuario = new Usuario(nomeUsu, nome, cpf, senha);
					BancoUsuarios.adicionarUsuario(novoUsuario);
					
					JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!", "Seja Bem-Vindo", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					MainController.abrirLogin();

				}
			}
		});
		btnCadastrar.setBounds(245, 267, 98, 25);
		contentPane.add(btnCadastrar);
		
		addWindowListener(new WindowAdapter() {
		    public void windowClosed(WindowEvent e) {
		        MainController.abrirLogin();
		    }
		});
		
	}

}
