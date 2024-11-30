package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UsuarioDAO;
import model.Usuario;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class TelaUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaUsuario frame = new TelaUsuario();
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
	public TelaUsuario() {
		setTitle("Tela Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(215, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnCadastrarProfessor = new JButton("PROFESSOR");
		btnCadastrarProfessor.setBackground(new Color(0, 0, 128));
		btnCadastrarProfessor.setForeground(new Color(255, 255, 255));
		btnCadastrarProfessor.setFont(new Font("Arial", Font.BOLD, 16));
		btnCadastrarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarProfessor loginProfessor = new TelaCadastrarProfessor();
				loginProfessor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				loginProfessor.setSize(310,600);
				loginProfessor.setVisible(true);
				
				dispose();
			}
		});
		
		JButton btnCadastrarAluno = new JButton("ESTUDANTE");
		btnCadastrarAluno.setBackground(new Color(0, 0, 128));
		btnCadastrarAluno.setForeground(new Color(255, 255, 255));
		btnCadastrarAluno.setFont(new Font("Arial", Font.BOLD, 16));
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TelaCadastrarAluno loginAluno = new TelaCadastrarAluno();
			loginAluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			loginAluno.setSize(310,600);
			loginAluno.setVisible(true);
			
			dispose();
			
			}
		});

		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(215, 255, 255));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Gustavo Nunes\\Desktop\\BancoPOO\\teacher_2307607.png"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Gustavo Nunes\\Desktop\\BancoPOO\\student_3750011.png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCadastrarProfessor))
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCadastrarAluno))
					.addGap(36))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(33, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCadastrarAluno)
						.addComponent(btnCadastrarProfessor))
					.addGap(72))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
