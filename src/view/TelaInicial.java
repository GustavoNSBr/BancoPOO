package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.*;
import model.*;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCPF;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setTitle("Tela Inicial");
		setAlwaysOnTop(true);
		setBackground(new Color(0, 0, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 55));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnCadastrar.setForeground(new Color(0, 0, 255));
		btnCadastrar.setBackground(new Color(255, 255, 255));
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaUsuario telaUsuario = new TelaUsuario();
				telaUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				telaUsuario.setVisible(true);
				
				dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Gustavo Nunes\\Desktop\\BancoPOO\\user_17169061.png"));
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		
		txtCPF = new JTextField();
		txtCPF.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCPF.setForeground(new Color(182, 182, 182));
		txtCPF.setToolTipText("");
		txtCPF.setText("CPF");
		txtCPF.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setForeground(new Color(182, 182, 182));
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 12));
		txtSenha.setText("Senha");
		txtSenha.setColumns(10);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			    Usuario usuario = new Usuario(txtCPF.getText(), txtSenha.getText());
			    UsuarioDAO userDao = new UsuarioDAO();
			    
			    usuario = userDao.logarUsuario(usuario);
			    
			    if (usuario != null) {
			        AlunoDao alunoDao = new AlunoDao();
			        Aluno aluno = alunoDao.getDadosAluno(usuario);
			        ProfessorDAO profDao = new ProfessorDAO();
			        Professor prof = profDao.getDadosProfessor(usuario);
			        
			        if (userDao.getTipoUsuario(usuario) == TipoUsuario.ALUNO) {
			            TelaAluno telaAluno = new TelaAluno(usuario, aluno);
			            telaAluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			            telaAluno.setVisible(true);
			            dispose();
			        } else {
			            TelaProfessor telaProfessor = new TelaProfessor(usuario, prof);
			            telaProfessor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			            telaProfessor.setVisible(true);
			            dispose();
			        }
			    } else {
			        System.out.println("Falha no login.");
			    }
			}
		});
		btnEntrar.setBackground(new Color(255, 255, 255));
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 18));
		btnEntrar.setForeground(new Color(0, 0, 255));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(159)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
								.addComponent(txtSenha)
								.addComponent(txtCPF)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(159)
							.addComponent(btnCadastrar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(127)
							.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(124, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(btnCadastrar)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
