package Suburbia;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Suburbia extends JFrame implements ActionListener{

	boolean BoolLocalGame = false, BoolHost = false;
	private JButton ButtonHost, ButtonJoin, ButtonExit, ButtonLocal, ButtonInternet, ButtonBack;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Suburbia rectObj = new Suburbia();
	}
	
	public Suburbia()
	{
		ButtonHost = new JButton("Host");
		ButtonHost.addActionListener(this);
		ButtonJoin = new JButton("Join");
		ButtonJoin.addActionListener(this);
		ButtonExit = new JButton("Exit");
		ButtonExit.addActionListener(this);
		ButtonLocal = new JButton("LAN Game");
		ButtonLocal.addActionListener(this);
		ButtonInternet = new JButton("Internet Game");
		ButtonInternet.addActionListener(this);
		ButtonBack = new JButton("Back");
		ButtonBack.addActionListener(this);
		
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(5, 2));
		pane.add(ButtonHost);
		pane.add(ButtonJoin);
		pane.add(ButtonExit);

		setTitle("Suburbia");
		setSize(1280, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == ButtonHost || e.getSource() == ButtonJoin)
		{
			Container pane = getContentPane();
			pane.remove(ButtonHost);
			pane.remove(ButtonJoin);
			pane.remove(ButtonExit);
			pane.add(ButtonLocal);
			pane.add(ButtonInternet);
			pane.add(ButtonBack);
			BoolHost = e.getSource() == ButtonHost;
		}
	}
}

	
