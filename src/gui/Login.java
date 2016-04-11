package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import model.bo.LoginBO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(5, 19, 1, 237);
		contentPane.add(layeredPane);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(95, 91, 48, 14);
		contentPane.add(lblUsername);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogin.setBounds(183, 39, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(95, 126, 46, 14);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(200, 88, 86, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(200, 123, 86, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		final JLabel lblResult = new JLabel("");
		lblResult.setBounds(95, 221, 242, 14);
		contentPane.add(lblResult);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user =txtUsername.getText();
				String pass=txtPassword.getText();
				LoginBO login=new LoginBO();
				String success="Dang nhap thanh cong";
				String fail="Dang nhap that bai";
				if(login.checkLogin(user, pass)!=null)
				{
					lblResult.setText(success);
				}
				else {
					{
						lblResult.setText(fail);
					}
				}
			}
		});
		btnLogin.setBounds(200, 170, 89, 23);
		contentPane.add(btnLogin);
		
		
	}
}
