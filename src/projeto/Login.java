package projeto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeUsu;
	private JPasswordField passwordSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		super("Tela de Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNomeUsu = new JTextField();
		textNomeUsu.setBounds(145, 42, 186, 27);
		contentPane.add(textNomeUsu);
		textNomeUsu.setColumns(10);
		
		JLabel lblNomeUsuario = new JLabel("Nome de usuário:");
		lblNomeUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNomeUsuario.setBounds(25, 44, 118, 20);
		contentPane.add(lblNomeUsuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSenha.setBounds(82, 108, 61, 20);
		contentPane.add(lblSenha);
		
		JLabel lblCadastro = new JLabel(" Se cadastre aqui.");
		lblCadastro.addMouseListener(new MouseAdapter() {
			// This method start when label is clicked
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lblCadastro.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCadastro.setBounds(236, 230, 105, 20);
		contentPane.add(lblCadastro);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(186, 155, 94, 27);
		contentPane.add(btnLogin);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setBounds(145, 106, 186, 27);
		contentPane.add(passwordSenha);
		
		JLabel lblMensCadastro = new JLabel("Não possui uma conta?");
		lblMensCadastro.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMensCadastro.setBounds(105, 230, 132, 20);
		contentPane.add(lblMensCadastro);
		
		JLabel lblEsqueceuASenha = new JLabel("Esqueceu a senha?");
		lblEsqueceuASenha.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEsqueceuASenha.setBounds(132, 199, 125, 20);
		contentPane.add(lblEsqueceuASenha);
		
		JLabel lblCliqueAqui = new JLabel(" Clique aqui.");
		lblCliqueAqui.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCliqueAqui.setBounds(243, 199, 77, 20);
		contentPane.add(lblCliqueAqui);
	}
}