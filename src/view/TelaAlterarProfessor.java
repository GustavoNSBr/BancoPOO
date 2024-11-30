 package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ProfessorController;
import model.Departamento;
import model.Professor;
import model.Usuario;
import model.Departamento.NomeDep;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaAlterarProfessor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField endereco_usuario;
	private JTextField nome_usuario;
	private JTextField telefone_usuario;
	private JTextField senha;
	private JTextField cpf_usuario;
	private JTextField formacao_professor;
	private Usuario usuario;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaAlterarProfessor frame = new TelaAlterarProfessor();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public TelaAlterarProfessor(Usuario usuario) {
		this.usuario = usuario;
		initialize();
	}
	public void initialize() {
		
		setTitle("Tela Alterar Professor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(215, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Gustavo Nunes\\Desktop\\BancoPOO\\professorTela.png"));
		
		JLabel lblNewLabel_1 = new JLabel("Alterar professor");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		
		JLabel lblNewLabel_2 = new JLabel("Digite o nome:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblNewLabel_3 = new JLabel("Digite o endereco:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		
		endereco_usuario = new JTextField();
		endereco_usuario.setFont(new Font("Arial", Font.PLAIN, 12));
		endereco_usuario.setForeground(new Color(182, 182, 182));
		endereco_usuario.setText("Endereco");
		endereco_usuario.setColumns(10);
		
		nome_usuario = new JTextField();
		nome_usuario.setText("Nome");
		nome_usuario.setForeground(new Color(182, 182, 182));
		nome_usuario.setFont(new Font("Arial", Font.BOLD, 12));
		nome_usuario.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Digite o telefone:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		
		telefone_usuario = new JTextField();
		telefone_usuario.setText("Telefone");
		telefone_usuario.setForeground(new Color(182, 182, 182));
		telefone_usuario.setFont(new Font("Arial", Font.PLAIN, 12));
		telefone_usuario.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Digite a senha:");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		
		senha = new JTextField();
		senha.setForeground(new Color(182, 182, 182));
		senha.setFont(new Font("Arial", Font.PLAIN, 12));
		senha.setText("Senha");
		senha.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Digite o CPF:");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		
		cpf_usuario = new JTextField();
		cpf_usuario.setFont(new Font("Arial", Font.PLAIN, 12));
		cpf_usuario.setForeground(new Color(182, 182, 182));
		cpf_usuario.setText("CPF");
		cpf_usuario.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Digite a Formacao:");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 12));
		
		formacao_professor = new JTextField();
		formacao_professor.setForeground(new Color(182, 182, 182));
		formacao_professor.setFont(new Font("Arial", Font.PLAIN, 12));
		formacao_professor.setText("Formacao");
		formacao_professor.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Selecione o Departamento:");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 12));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Matematica", "Lingua Portuguesa", "Ciencias", "Historia"}));
		
		JButton btnNewButton = new JButton("ALTERAR");
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Departamento dep = new Departamento();
				
				if(comboBox.getSelectedItem() == "Matematica") {
					dep.setNomeDep(NomeDep.Matematica);
				} else if(comboBox.getSelectedItem() == "Ciencias") {
					dep.setNomeDep(NomeDep.Ciencias);
				} else if(comboBox.getSelectedItem() == "Lingua Portuguesa") {
					dep.setNomeDep(NomeDep.LinguaPortuguesa);
				} else 
					dep.setNomeDep(NomeDep.Historia);
				
				Professor professor = new Professor(usuario.getId_usuario(),
										telefone_usuario.getText(),
										cpf_usuario.getText(),
										formacao_professor.getText(),
										nome_usuario.getText(),
										endereco_usuario.getText(),
										1,
										senha.getText(),
										dep);
				
				try {
					ProfessorController profCont = new ProfessorController();
					profCont.alterarProfessor(usuario.getId_usuario(), professor);
					JOptionPane.showMessageDialog(null, profCont.buscarProfessor(professor).getMensagem());
					if(profCont.buscarProfessor(professor).getMensagem() == "Sucesso!") {
						TelaInicial inicio = new TelaInicial();
						inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						inicio.setSize(450,450);
						inicio.setVisible(true);
						
						dispose();
					}
					System.out.println(profCont.buscarProfessor(professor).getMensagem());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
				
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(telefone_usuario, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(nome_usuario, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE))
							.addGap(58)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(senha, Alignment.LEADING)
							.addComponent(lblNewLabel_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
						.addComponent(cpf_usuario, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
						.addComponent(formacao_professor, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(endereco_usuario, Alignment.LEADING)
							.addComponent(lblNewLabel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(comboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_8, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)))
					.addContainerGap(34, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(159, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addGap(120))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(nome_usuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(endereco_usuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(telefone_usuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(senha, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(cpf_usuario, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(formacao_professor, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(29))
		);
		contentPane.setLayout(gl_contentPane);
	}
}