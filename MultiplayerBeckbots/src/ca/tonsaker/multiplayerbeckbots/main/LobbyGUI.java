package ca.tonsaker.multiplayerbeckbots.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Vector;

public class LobbyGUI extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 319090513125602064L;
	private JPanel contentPane;
	private JTextField ipAddressText;
	private JTextField portTextAddress;
	private JButton btnStart;
	private JButton btnHost;
	private JButton btnConnect;
	
	private JList<String> playerList;
	private Vector<String> players;
	private JTextField textField;
	private JLabel lblUsername;
	
	/**
	 * Create the frame.
	 */
	public LobbyGUI() {
		try { 
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		    e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		btnConnect = new JButton("Connect");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnConnect, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnConnect, -10, SpringLayout.SOUTH, contentPane);
		btnConnect.addActionListener(this);
		contentPane.add(btnConnect);
		
		JLabel lblIpAddress = new JLabel("IP Address:");
		contentPane.add(lblIpAddress);
		
		ipAddressText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblIpAddress, 3, SpringLayout.NORTH, ipAddressText);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblIpAddress, -6, SpringLayout.WEST, ipAddressText);
		sl_contentPane.putConstraint(SpringLayout.WEST, ipAddressText, 163, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, ipAddressText, -10, SpringLayout.EAST, contentPane);
		contentPane.add(ipAddressText);
		ipAddressText.setColumns(10);
		
		btnHost = new JButton("Host");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnHost, 0, SpringLayout.WEST, btnConnect);
		btnHost.addActionListener(this);
		contentPane.add(btnHost);
		
		portTextAddress = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, ipAddressText, -6, SpringLayout.NORTH, portTextAddress);
		sl_contentPane.putConstraint(SpringLayout.NORTH, portTextAddress, 1, SpringLayout.NORTH, btnConnect);
		sl_contentPane.putConstraint(SpringLayout.EAST, portTextAddress, -10, SpringLayout.EAST, contentPane);
		contentPane.add(portTextAddress);
		portTextAddress.setColumns(10);
		
		JLabel lblPort = new JLabel("Port:");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblPort, 69, SpringLayout.EAST, btnConnect);
		sl_contentPane.putConstraint(SpringLayout.WEST, portTextAddress, 11, SpringLayout.EAST, lblPort);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPort, 4, SpringLayout.NORTH, btnConnect);
		contentPane.add(lblPort);
		
		JLabel lblConnectedUsers = new JLabel("Connected Users:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblConnectedUsers, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblConnectedUsers, 0, SpringLayout.WEST, btnConnect);
		contentPane.add(lblConnectedUsers);
		
		players = new Vector<String>();
		playerList = new JList<String>(players);
		sl_contentPane.putConstraint(SpringLayout.WEST, playerList, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, playerList, -5, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnHost, 6, SpringLayout.SOUTH, playerList);
		sl_contentPane.putConstraint(SpringLayout.NORTH, playerList, 16, SpringLayout.SOUTH, lblConnectedUsers);
		contentPane.add(playerList);
		
		btnStart = new JButton("Start");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnStart, -4, SpringLayout.NORTH, lblConnectedUsers);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnStart, 0, SpringLayout.EAST, ipAddressText);
		btnStart.setEnabled(false);
		btnStart.addActionListener(this);
		contentPane.add(btnStart);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, playerList, -6, SpringLayout.NORTH, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, ipAddressText);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField, -6, SpringLayout.NORTH, ipAddressText);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -10, SpringLayout.EAST, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblUsername = new JLabel("Username:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblIpAddress, -5, SpringLayout.WEST, lblUsername);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblUsername, 3, SpringLayout.NORTH, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblUsername, -6, SpringLayout.WEST, textField);
		contentPane.add(lblUsername);
	}
	
	public void addPlayer(String playerName){
		players.add(playerName);
	}

	public void removePlayer(String playerName){
		players.remove(playerName);
	}
	
	public void removeAllPlayers(){
		players.removeAllElements();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == btnConnect){
			BeckClient bClient = new BeckClient(this.textField.getText(), this.ipAddressText.getText(), this.portTextAddress.getText(), players);
			try {
				bClient.connect();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else if(src == btnHost){
			BeckServer bServ = new BeckServer(this.ipAddressText.getText(), this.portTextAddress.getText(), players);
			try {
				bServ.startServer();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else if(src == btnStart){
			
		}
	}
}
