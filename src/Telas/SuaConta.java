	package Telas;
	
	import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.MainController;
import usuario.BancoUsuarios;
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
						BancoUsuarios.adicionarUsuario(usuario);
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
			JPanel panelDadosP = new JPanel(null);
			panelDadosP.setBackground(Color.WHITE);
			panelDadosP.setPreferredSize(new Dimension(400, 500));
			c3.gridx = 1;
			c3.gridy = 2;
			c3.fill = GridBagConstraints.BOTH;
			c3.weightx = 1;
			c3.weighty = 1;
			contentPane.add(panelDadosP, c3);
			
			JLabel lblNomeUsu = new JLabel("Nome de Usuário:");
			lblNomeUsu.setFont(new Font("Arial", Font.PLAIN, 14));
			lblNomeUsu.setBounds(10, 10, 112, 14);
			panelDadosP.add(lblNomeUsu);
			
			JTextField txtNomeUsu = new JTextField();
			txtNomeUsu.setBounds(130, 9, 150, 18);
			txtNomeUsu.setText(usuario.getNomeUsu());
			panelDadosP.add(txtNomeUsu);
			
			JLabel lblNomeComp = new JLabel("Nome Completo:");
			lblNomeComp.setFont(new Font("Arial", Font.PLAIN, 14));
			lblNomeComp.setBounds(10, 35, 112, 14);
			panelDadosP.add(lblNomeComp);
			
			JTextField txtNome = new JTextField();
			txtNome.setBounds(130, 34, 150, 18);
			txtNome.setText(usuario.getNome());
			panelDadosP.add(txtNome);
			
			JLabel lblCpf = new JLabel("CPF:");
			lblCpf.setFont(new Font("Arial", Font.PLAIN, 14));
			lblCpf.setBounds(10, 60, 32, 14);
			panelDadosP.add(lblCpf);
			
			JTextField txtCpf = new JTextField();
			txtCpf.setBounds(130, 59, 150, 18);
			txtCpf.setText(usuario.getCpf());
			txtCpf.setEditable(false);
			txtCpf.setBackground(panelDadosP.getBackground());
			panelDadosP.add(txtCpf);
			
			JLabel lblDataNasc = new JLabel("Data de Nascimento:");
			lblDataNasc.setFont(new Font("Arial", Font.PLAIN, 14));
			lblDataNasc.setBounds(10, 85, 150, 14);
			panelDadosP.add(lblDataNasc);
						
			JTextField txtDataNasc = new JTextField();
			txtDataNasc.setBounds(145, 84, 135, 18);
			if (usuario.getDataNasc() != null) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				txtDataNasc.setText(usuario.getDataNasc().format(formatter));
			}
			panelDadosP.add(txtDataNasc);
			
			JLabel lblUf = new JLabel("UF:");
			lblUf.setFont(new Font("Arial", Font.PLAIN, 14));
			lblUf.setBounds(10, 110, 32, 14);
			panelDadosP.add(lblUf);
						
			JTextField txtUf = new JTextField();
			txtUf.setBounds(130, 109, 150, 18);
			if (usuario.getUf() != null) {
				txtUf.setText(usuario.getUf());
			}
			panelDadosP.add(txtUf);
			
			JLabel lblCidade = new JLabel("Cidade:");
			lblCidade.setFont(new Font("Arial", Font.PLAIN, 14));
			lblCidade.setBounds(10, 135, 112, 14);
			panelDadosP.add(lblCidade);
			
			JTextField txtCidade = new JTextField();
			txtCidade.setBounds(130, 134, 150, 18);
			if (usuario.getCidade() != null) {
				txtCidade.setText(usuario.getCidade());
			}
			panelDadosP.add(txtCidade);
			
			JLabel lblRua = new JLabel("Rua:");
			lblRua.setFont(new Font("Arial", Font.PLAIN, 14));
			lblRua.setBounds(10, 160, 80, 14);
			panelDadosP.add(lblRua);
			
			JTextField txtRua = new JTextField();
			txtRua.setBounds(130, 159, 150, 18);
			if (usuario.getRua() != null) {
				txtRua.setText(usuario.getRua());
			}
			panelDadosP.add(txtRua);
			
			JLabel lblNum = new JLabel("Número:");
			lblNum.setFont(new Font("Arial", Font.PLAIN, 14));
			lblNum.setBounds(10, 185, 112, 14);
			panelDadosP.add(lblNum);
			
			JTextField txtNum = new JTextField();
			txtNum.setBounds(130, 184, 150, 18);
			if (usuario.getNumero() != null) {
				txtNum.setText(usuario.getNumero());
			}
			panelDadosP.add(txtNum);
			
			GridBagConstraints c9 = new GridBagConstraints();
			JScrollPane scrollPane1 = new JScrollPane(panelDadosP);
			scrollPane1.setPreferredSize(new Dimension(450, 150));
			scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			scrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			c9.gridx = 1;
			c9.gridy = 2;
			c9.fill = GridBagConstraints.BOTH;
			c9.weightx = 1;
			c9.weighty = 1;
			contentPane.add(scrollPane1, c9);
			
			GridBagConstraints c4 = new GridBagConstraints();
			c4.gridx = 2;
			c4.gridy = 0;
			c4.weightx = 0.1;
			contentPane.add(Box.createHorizontalStrut(10), c4);
			
			GridBagConstraints c5 = new GridBagConstraints();
			JButton btnConfi = new JButton("Confirmar");
			c5.gridx = 1;
			c5.gridy = 3;
			c5.anchor = GridBagConstraints.EAST;
			contentPane.add(btnConfi, c5);
			
			btnConfi.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String cpf = txtCpf.getText();
					String nomeUsu = txtNomeUsu.getText();
					String nome = txtNome.getText();
					String uf = txtUf.getText();
					String cidade = txtCidade.getText();
					String rua = txtRua.getText();
					String numero = txtNum.getText();
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					String dataStr = txtDataNasc.getText();
					
					if (nomeUsu.isEmpty() || nome.isEmpty()) {
					    JOptionPane.showMessageDialog(null, "Você apagou os campos obrigatórios", "Erro", JOptionPane.ERROR_MESSAGE);
					    return;
					}

					if (!uf.isEmpty() && uf.length() != 2) {
					    JOptionPane.showMessageDialog(null, "Você informou sua UF incorretamente", "Erro", JOptionPane.ERROR_MESSAGE);
					    return;
					}

					LocalDate data = null;
					if (!dataStr.isEmpty()) {
					    try {
					        data = LocalDate.parse(dataStr, formatter);
					    } catch(DateTimeParseException ex) {
					        JOptionPane.showMessageDialog(null, "Data inserida de modo inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
					        return;
					    }
					}

					BancoUsuarios.atualizar(cpf, nomeUsu, nome, data, uf, cidade, rua, numero);
					JOptionPane.showMessageDialog(null, "Atualização Realizada com Sucesso!", "Atualização dos dados", JOptionPane.INFORMATION_MESSAGE);

					dispose();
				}
			});
			
			GridBagConstraints c6 = new GridBagConstraints();
			JLabel lblHist = new JLabel("Histórico");
			lblHist.setFont(new Font("Arial", Font.PLAIN, 14));
			c6.gridx = 1;
			c6.gridy = 4;
			c6.fill = GridBagConstraints.HORIZONTAL;
			c6.weightx = 1;
			contentPane.add(lblHist, c6);
			
			GridBagConstraints c7 = new GridBagConstraints();
			JPanel panelHist = new JPanel(null);
			panelHist.setBackground(new Color(255, 255, 255));
			panelHist.setPreferredSize(new Dimension(400, 500));
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
			
			GridBagConstraints c10 = new GridBagConstraints();
			JScrollPane scrollPane2 = new JScrollPane(panelHist);
			scrollPane2.setPreferredSize(new Dimension(450, 150));
			scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			c10.gridx = 1;
			c10.gridy = 5;
			c10.fill = GridBagConstraints.BOTH;
			c10.weightx = 1;
			c10.weighty = 1;
			contentPane.add(scrollPane2, c10);
			
			// Close the window and open Menu
			addWindowListener(new WindowAdapter() {
			    public void windowClosed(WindowEvent e) {
			        MainController.abrirMenu(usuario);
			    }
			});
		}
	}