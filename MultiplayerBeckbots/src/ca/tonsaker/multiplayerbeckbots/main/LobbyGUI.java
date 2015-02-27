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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
	private JButton btnConnect;
	
	private JList<String> playerList;
	private Vector<String> players;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LobbyGUI frame = new LobbyGUI();
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
	public LobbyGUI() {
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
		contentPane.add(btnConnect);
		
		JLabel lblIpAddress = new JLabel("IP Address:");
		contentPane.add(lblIpAddress);
		
		ipAddressText = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, ipAddressText, 163, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, ipAddressText, -10, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblIpAddress, -11, SpringLayout.WEST, ipAddressText);
		contentPane.add(ipAddressText);
		ipAddressText.setColumns(10);
		
		JButton btnHost = new JButton("Host");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnHost, -3, SpringLayout.NORTH, btnConnect);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblIpAddress, 31, SpringLayout.EAST, btnHost);
		btnHost.addActionListener(this);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnHost, 10, SpringLayout.WEST, contentPane);
		contentPane.add(btnHost);
		
		portTextAddress = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, ipAddressText, -11, SpringLayout.NORTH, portTextAddress);
		sl_contentPane.putConstraint(SpringLayout.EAST, portTextAddress, 0, SpringLayout.EAST, ipAddressText);
		sl_contentPane.putConstraint(SpringLayout.NORTH, portTextAddress, 1, SpringLayout.NORTH, btnConnect);
		sl_contentPane.putConstraint(SpringLayout.WEST, portTextAddress, 80, SpringLayout.EAST, btnConnect);
		contentPane.add(portTextAddress);
		portTextAddress.setColumns(10);
		
		JLabel lblPort = new JLabel("Port:");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblPort, -11, SpringLayout.WEST, portTextAddress);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblIpAddress, -12, SpringLayout.NORTH, lblPort);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPort, 4, SpringLayout.NORTH, btnConnect);
		contentPane.add(lblPort);
		
		JLabel lblConnectedUsers = new JLabel("Connected Users:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblConnectedUsers, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblConnectedUsers, 0, SpringLayout.WEST, btnConnect);
		contentPane.add(lblConnectedUsers);
		
		players = new Vector<String>();
		playerList = new JList<String>(players);
		sl_contentPane.putConstraint(SpringLayout.NORTH, playerList, 6, SpringLayout.SOUTH, lblConnectedUsers);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, playerList, -13, SpringLayout.NORTH, btnHost);
		sl_contentPane.putConstraint(SpringLayout.WEST, playerList, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, playerList, -10, SpringLayout.EAST, contentPane);
		contentPane.add(playerList);
		
		btnStart = new JButton("Start");
		btnStart.setEnabled(false);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnStart, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnStart, 0, SpringLayout.EAST, ipAddressText);
		contentPane.add(btnStart);
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
		// TODO Auto-generated method stub
		
	}
}
