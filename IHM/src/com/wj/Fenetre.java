package com.wj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Fenetre extends JFrame {

	private JPanel contentPane;
	private JTextField text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre frame = new Fenetre();
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
	public Fenetre() {
		setTitle("Fenetre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = text.getText();
				text.setText(str + "1");
				
			}
		});
		btn1.setBounds(365, 45, 48, 23);
		contentPane.add(btn1);
		
		text = new JTextField();
		text.setBounds(106, 11, 307, 23);
		contentPane.add(text);
		text.setColumns(10);
		
		JButton btnRaz = new JButton("RAZ");
		btnRaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = text.getText();
				text.setText("");
			}
		});
		btnRaz.setBounds(266, 45, 89, 23);
		contentPane.add(btnRaz);
		
		JButton button = new JButton("<-----");
		button.setBounds(123, 73, 89, 23);
		contentPane.add(button);
	}
}
