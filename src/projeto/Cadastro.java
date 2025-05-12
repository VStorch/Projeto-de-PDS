package projeto;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;

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
		setTitle("Tela de Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

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
		
		JLabel lblCrieUmaSenha_1 = new JLabel("Crie uma senha:");
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
		btnCadastrar.setBounds(245, 267, 98, 25);
		contentPane.add(btnCadastrar);
		
		
	}

}
