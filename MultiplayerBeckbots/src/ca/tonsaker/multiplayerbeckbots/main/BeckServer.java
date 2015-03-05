package ca.tonsaker.multiplayerbeckbots.main;

import java.io.IOException;
import java.util.Vector;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

public class BeckServer extends Server{
	
	LobbyGUI players;
	String ipAddress;
	int port;
	
	public BeckServer(String ip, String port, LobbyGUI players){
		
		Network.register(this);
		
		this.port = Integer.parseInt(port);
		this.ipAddress = ip;
		this.players = players;
	}
	
	public void startServer() throws IOException{
		this.start();
		this.addListener(new Listener(){
			
			public void received(Connection connect, Object obj){
				System.out.println("------------SERVER: "+obj);
			}
			
		});
		//this.start();
		this.bind(port,port);
	}

	
	public void send(String message){
		this.sendToAllTCP(message);
	}
}
