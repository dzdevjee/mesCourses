package com.lamine.application;

import java.io.IOException;
import java.net.*;

public class ThreadClient extends Thread {
    private Socket socketClient;

    public ThreadClient(Socket socketClient) {
        this.socketClient = socketClient;
    }

    public void run() {
    	ControleurServeur.setMessage("Bonjour, je suis le thread client: " + socketClient.getInetAddress());
        try {
			socketClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}