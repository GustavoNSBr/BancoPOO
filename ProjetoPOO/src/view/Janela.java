package view;

import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.UsuarioDAOImp;
import model.Usuario;

import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.awt.event.ItemEvent;


public class Janela extends JFrame
{

	private final JTextField userField;
	private final JPasswordField passwordField;
	private final JLabel userLabel;
	private final JLabel passwordLabel;
	private final JButton entrarButton;
	private final JButton cadastrarButton;
	private final JCheckBox checkBox;
	private final JRadioButton profRadioButton;
	private final JRadioButton estRadioButton;
	private final JComboBox<String> comboBox;
	private final JLabel iconLabel;
	UsuarioDAOImp userDAO;

	public Janela(String titulo)
	{
		super(titulo);

		setLayout(new FlowLayout());

		Font fonte = new Font("Dialog", Font.PLAIN, 22);

		userLabel = new JLabel("Usuário: ");
		userLabel.setFont(fonte);

		passwordLabel = new JLabel("Senha: ");
		passwordLabel.setFont(fonte);
	
		userField = new JTextField("usuario",10);
		passwordField = new JPasswordField("senha",10);

		entrarButton = new JButton("Acessar");
		cadastrarButton = new JButton("Cadastrar");
		
		checkBox = new JCheckBox("Lembrar-me");	

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

		ImageIcon icon = new ImageIcon("../Universidade/img/docente.png");
		Image img = icon.getImage().getScaledInstance(256,256,Image.SCALE_SMOOTH);

		iconLabel = new JLabel(new ImageIcon(img));

		add(iconLabel);
		add(userLabel);
		add(userField);
		add(passwordLabel);
		add(passwordField);
		add(entrarButton);
		add(cadastrarButton);
		add(profRadioButton);
		add(estRadioButton);
		add(checkBox);
		add(comboBox);
		
		try {
			userDAO = new UsuarioDAOImp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		ComponentsHandler handler = new ComponentsHandler();
		entrarButton.addActionListener(handler);
		cadastrarButton.addActionListener(handler);
		estRadioButton.addItemListener(handler);
		profRadioButton.addItemListener(handler);
		checkBox.addItemListener(handler);
		

	}

	private class ComponentsHandler implements ActionListener, ItemListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource()==cadastrarButton)
			{
				Usuario user = 
						new Usuario(userField.getText(),
									passwordField.getText(),
									(profRadioButton.isSelected())? "Docente":"Discente",
									(checkBox.isSelected())? true:false,
									(String)comboBox.getSelectedItem());
				if(userDAO.adicionaUser(user));
				{
					JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso!");
				}
										
			}		
			
			if(event.getSource()==entrarButton)
			{
				Usuario auxUser = userDAO.getUser(userField.getText());
				
				if(userField.getText().equals(auxUser.getUser()) &&  passwordField.getText().equals(auxUser.getSenha()))
				{
					
					JOptionPane.showMessageDialog(null, "Usário com acesso permitido!");
					if(auxUser.getPerfil().equals("Docente"))
					{ 
							profRadioButton.setSelected(true);
					}else {
							estRadioButton.setSelected(true);
					}
					
					checkBox.setSelected(auxUser.isLembrar());
					comboBox.setSelectedItem((String)auxUser.getCurso());
				}
				
			}
		}

		@Override
		public void itemStateChanged(ItemEvent event)
		{

		}
	}


}