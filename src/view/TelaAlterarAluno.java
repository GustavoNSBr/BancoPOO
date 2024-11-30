 package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlunoController;
import dao.UsuarioDAO;
import model.Aluno;
import model.Curso;
import model.Curso.NomeCurso;
import model.TipoUsuario;
import model.Usuario;

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
import java.sql.Date;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaAlterarAluno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField endereco_usuario;
	private JTextField nome_usuario;
	private JTextField telefone_usuario;
	private JTextField senha;
	private JTextField cpf_usuario;
	private JTextField filiacao_aluno;
	private JTextField data_nacsimento_aluno;
	private Usuario usuario;

	public TelaAlterarAluno(Usuario usuario) {
		this.usuario = usuario;
		initialize();
	}
	public void initialize() {
		
		setTitle("Tela Alterar Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(215, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Gustavo Nunes\\Desktop\\BancoPOO\\estutanteTela.png"));
		
		JLabel lblNewLabel_1 = new JLabel("Alterar aluno");
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
		
		JLabel lblNewLabel_7 = new JLabel("Digite a data de filiacao do Aluno:");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 12));
		
		filiacao_aluno = new JTextField();
		filiacao_aluno.setForeground(new Color(182, 182, 182));
		filiacao_aluno.setFont(new Font("Arial", Font.PLAIN, 12));
		filiacao_aluno.setText("yyyy-mm-dd");
		filiacao_aluno.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Data de nascimento:");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 12));
		
		data_nacsimento_aluno = new JTextField();
		data_nacsimento_aluno.setForeground(new Color(182, 182, 182));
		data_nacsimento_aluno.setFont(new Font("Arial", Font.PLAIN, 12));
		data_nacsimento_aluno.setText("yyyy-mm-dd");
		data_nacsimento_aluno.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ensino Fundamental", "Ensino Medio"}));
		
		JLabel lblNewLabel_2_1 = new JLabel("Selecione o curso:");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton btnNewButton = new JButton("ALTERAR");
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Curso curso = new Curso();
				
				if(comboBox.getSelectedItem() == "Ensino Fundamental") {
					curso.setNomeCurso(NomeCurso.EnsinoFundamental);
				} else
					curso.setNomeCurso(NomeCurso.EnsinoMedio);
				
				Aluno aluno = new Aluno(1,
										cpf_usuario.getText(),
										usuario.getId_usuario(),
										Date.valueOf(filiacao_aluno.getText()),
										Date.valueOf(data_nacsimento_aluno.getText()),
										nome_usuario.getText(),
										endereco_usuario.getText(),
										telefone_usuario.getText(),
										senha.getText(),
										curso);
				
				try {
					AlunoController alunoCont = new AlunoController();
					alunoCont.alterarAluno(usuario.getId_usuario(), aluno);
					JOptionPane.showMessageDialog(null, alunoCont.buscarAluno(aluno).getMensagem());
					if(alunoCont.buscarAluno(aluno).getMensagem() == "Sucesso!") {
						TelaInicial inicio = new TelaInicial();
						inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						inicio.setSize(450,450);
						inicio.setVisible(true);
						
						dispose();
					}
					System.out.println(alunoCont.buscarAluno(aluno).getMensagem());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(telefone_usuario, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(senha, Alignment.LEADING)
									.addComponent(lblNewLabel_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
								.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
								.addComponent(cpf_usuario, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addComponent(filiacao_aluno, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addComponent(data_nacsimento_aluno, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(nome_usuario, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
										.addComponent(endereco_usuario)
										.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(105)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addGap(64))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(145)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(180, Short.MAX_VALUE))
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
					.addComponent(filiacao_aluno, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(data_nacsimento_aluno, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
