package ca.tonsaker.multiplayerbeckbots.main;

import java.awt.Point;
import java.io.IOException;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class BeckClient extends Client{
	
	protected String username;
	
	protected String ip;
	protected int port;
	
	public BeckClient(String username, String ip, String port){
		super();
		
		if(username.trim().equals("")) throw new IllegalArgumentException("Username cannot be only spaces or be empty.");
		if(ip.trim().equals("")) throw new IllegalArgumentException("IP cannot be null.");
		if(port.trim().equals("")) throw new IllegalArgumentException("PORT cannot be null.");
		
		this.username = username.trim();
		this.ip = ip.trim();
		this.port = Integer.parseInt(port);
	}
	
	public void connect() throws IOException{
		this.connect(5000, ip, port);
		this.addListener(new Listener(){
			
			public void received(Connection connect, Object obj){
				
			}
			
		});
	}
	
	public void sendCoord(Point coord){
		this.sendTCP(coord);
	}

}
