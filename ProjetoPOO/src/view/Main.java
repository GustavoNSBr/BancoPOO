package view;

import javax.swing.*;

public class Main {

	public static void main(String[] args)
	{
		Janela login = new Janela("Login");
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setSize(310,600);
		login.setVisible(true);
	}

}
