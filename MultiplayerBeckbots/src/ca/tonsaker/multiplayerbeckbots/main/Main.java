package ca.tonsaker.multiplayerbeckbots.main;

import java.awt.EventQueue;
import java.awt.Rectangle;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;

import becker.robots.City;
import becker.robots.CityView;

public class Main extends CityView{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3776663428596446549L;

	Connection[] clients;
	City mainCity;
	
	protected Main(City city, Rectangle roads, int simSize) {
		super(city, roads, simSize);
		this.mainCity = city;
	}
	
	public void addPlayers(Client c){
		//c.se
	}

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

}
