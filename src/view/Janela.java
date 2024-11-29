package view;

import javax.swing.*;

import config.ConnectionBD;
import dao.*;
import model.*;
import controller.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

public class Janela extends JFrame
{

	private final JTextField userField;
	private final JTextField cpfField;
	private final JTextField enderecoField;
	private final JTextField telefoneField;
	private final JPasswordField passwordField;
	private final JLabel userLabel;
	private final JLabel cpfLabel;
	private final JLabel enderecoLabel;
	private final JLabel telefoneLabel;
	private final JLabel passwordLabel;
	private final JButton entrarButton;
	private final JButton cadastrarButton;
	private final JRadioButton profRadioButton;
	private final JRadioButton estRadioButton;
	private final JComboBox<String> comboBox;

	UsuarioDAO userDAO;
	AlunoController alunoCont;

	public Janela(String titulo)
	{
		super(titulo);

		setLayout(new FlowLayout());

		Font fonte = new Font("Dialog", Font.PLAIN, 22);

		userLabel = new JLabel("Usuário: ");
		userLabel.setFont(fonte);

		passwordLabel = new JLabel("Senha: ");
		passwordLabel.setFont(fonte);
		
		cpfLabel = new JLabel("CPF: ");
		cpfLabel.setFont(fonte);
		
		enderecoLabel = new JLabel("Endereco: ");
		enderecoLabel.setFont(fonte);
		
		telefoneLabel = new JLabel("Telefone: ");
		telefoneLabel.setFont(fonte);
	
		userField = new JTextField("usuario",10);
		cpfField = new JTextField("usuario",10);
		enderecoField = new JTextField("usuario",10);
		telefoneField = new JTextField("usuario",10);
		passwordField = new JPasswordField("senha",10);

		entrarButton = new JButton("Acessar");
		cadastrarButton = new JButton("Cadastrar");	

		profRadioButton = new JRadioButton("Docente", false);
		profRadioButton.setFont(fonte);

		estRadioButton = new JRadioButton("Discente", false);
		estRadioButton.setFont(fonte);

		ButtonGroup bg = new ButtonGroup();
		bg.add(profRadioButton);
		bg.add(estRadioButton);

		String[] cursos = {"Engenharia de Software", "Sistemas de Informação", "Análise de Desenvolvimento de Software", "Ciência da Computação", "Gestão da Tecnologia da Informação", "Matemática", "Física", "Enfermagem", "Medicina", "Medicina Veterinária"};
		comboBox = new JComboBox<String>(cursos);
		comboBox.setMaximumRowCount(3);


		add(userLabel);
		add(userField);
		
		add(passwordLabel);
		add(passwordField);
		
		add(cpfLabel);
		add(cpfField);
		
		add(enderecoLabel);
		add(enderecoField);
		
		add(telefoneLabel);
		add(telefoneField);
		
		add(entrarButton);
		add(cadastrarButton);
		add(profRadioButton);
		add(estRadioButton);
		add(comboBox);
		
		try {			
			AlunoDao alunoDao = new AlunoDao();
			alunoCont = new AlunoController();
			userDAO = new UsuarioDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		ComponentsHandler handler = new ComponentsHandler();
		entrarButton.addActionListener(handler);
		cadastrarButton.addActionListener(handler);
		estRadioButton.addItemListener(handler);
		profRadioButton.addItemListener(handler);

	}

	private class ComponentsHandler implements ActionListener, ItemListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource()==cadastrarButton)
			{
				Usuario user = 
						new Usuario(1,userField.getText(),
									cpfField.getText(),
									enderecoField.getText(),
									telefoneField.getText(),
									passwordField.getText());
				if(userDAO.criar(user));
				{
					JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso!");
				}
										
			}		
			
//			if(event.getSource()==entrarButton)
//			{
//				Usuario auxUser = userDAO.getUser(userField.getText());
//				
//				if(userField.getText().equals(auxUser.getUser()) &&  passwordField.getText().equals(auxUser.getSenha()))
//				{
//					
//					JOptionPane.showMessageDialog(null, "Usário com acesso permitido!");
//					if(auxUser.getPerfil().equals("Docente"))
//					{ 
//							profRadioButton.setSelected(true);
//					}else {
//							estRadioButton.setSelected(true);
//					}
//					
//					comboBox.setSelectedItem((String)auxUser.getCurso());
//				}
//				
//			}
		}

		@Override
		public void itemStateChanged(ItemEvent event)
		{

		}

		
	}


}