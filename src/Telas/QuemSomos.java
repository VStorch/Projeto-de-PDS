package Telas;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import controller.MainController;
import usuario.Usuario;

public class QuemSomos extends JFrame {

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
					
					QuemSomos frame = new QuemSomos(usuario);
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
	public QuemSomos(Usuario usuario) {
		setTitle("Quem Somos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/Logo.png"));
		setIconImage(icon.getImage());
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String html = """
				<html>
					<h2 text-align: center; style='margin-top: 5px'>Quem Somos</h2>
					<p style='margin-left: 15px; margin-right: 10px;'>Na TurboCar Aluguéis, acreditamos que cada viagem tem seu próprio destino e cada cliente merece uma experiência única. Desde 1754, estamos comprometidos em oferecer soluções de mobilidade práticas, seguras e acessíveis para tornar sua jornada ainda mais confortável.</p>
					<p style='margin-left: 15px; margin-right: 10px;'>Nossa frota conta com veículos modernos e bem equipados, prontos para atender às suas necessidades, seja para uma viagem de negócios, lazer ou emergências. Com um atendimento personalizado, buscamos sempre superar expectativas e garantir que você tenha a melhor experiência possível.</p>
					<p style='margin-left: 15px; margin-right: 10px;'>Seja qual for o seu destino, nós te levamos até lá! TurboCar Aluguéis — A liberdade sobre quatro rodas.</p>
					<div text-align: right; style='margin-top: 5px'>Fone: (47) 9 9372-1983</div>
				</html>
				""";
		
		JEditorPane editorPane = new JEditorPane("text/html", html);
		editorPane.setEditable(false);
		editorPane.setOpaque(false);
		editorPane.setBorder(null);
		editorPane.setFocusable(false);
		contentPane.add(editorPane);
		
		JScrollPane scrollPane = new JScrollPane(editorPane);
		scrollPane.setBounds(10, 11, 414, 239);
		scrollPane.setBorder(null);
		contentPane.add(scrollPane);
		
		// This static method forces the window to start at the top
		SwingUtilities.invokeLater(() -> editorPane.setCaretPosition(0));
		
		addWindowListener(new WindowAdapter() {
		    public void windowClosed(WindowEvent e) {
		        MainController.abrirMenu(usuario);
		    }
		});

	}
}
