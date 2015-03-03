package ca.tonsaker.multiplayerbeckbots.main;

import java.io.IOException;
import java.util.Vector;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

public class BeckServer extends Server{
	
	Vector<String> players;
	String ipAddress;
	int port;
	
	public BeckServer(String ip, String port, Vector<String> players){
		this.port = Integer.parseInt(port);
		this.ipAddress = ip;
		this.players = players;
		this.start();
	}
	
	public void startServer() throws IOException{
		this.addListener(new Listener(){
			
			public void received(Connection connect, Object obj){
				if(obj instanceof String) players.add(obj.toString());
			}
			
		});
		
		this.getKryo().register(String.class);
		
		this.bind(port,port);
	}

	
	public void send(String message){
		this.sendToAllTCP(message);
	}
}
