package ca.tonsaker.multiplayerbeckbots.main;

import java.awt.Point;
import java.io.IOException;
import java.util.Vector;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class BeckClient extends Client{
	
	protected String username;
	
	protected LobbyGUI players;
	
	protected String ip;
	protected int port;
	
	public BeckClient(String username, String ip, String port, LobbyGUI players){
		super();
		
		Network.register(this);
		
		if(username.trim().equals("")) throw new IllegalArgumentException("Username cannot be only spaces or be empty.");
		if(ip.trim().equals("")) throw new IllegalArgumentException("IP cannot be null.");
		if(port.trim().equals("")) throw new IllegalArgumentException("PORT cannot be null.");
		
		this.username = username.trim();
		this.ip = ip.trim();
		this.port = Integer.parseInt(port);
		
		this.players = players;
		
		this.getKryo().register(String.class);
	}
	
	public void connect() throws IOException{
		System.out.println("Connecting to: "+ip+":"+port);
		this.start();
		this.connect(5000, ip, port);
		this.addListener(new Listener(){
			
			public void received(Connection connect, Object obj){
				System.out.println("------------CLIENT: "+obj);
				if(obj instanceof String) players.addPlayer(obj.toString());
			}
			
		});
		this.sendTCP(username);
		System.out.println("Connected to: "+ip+":"+port);
	}
	
	public void sendCoord(Point coord){
		this.sendTCP(coord);
	}

}
