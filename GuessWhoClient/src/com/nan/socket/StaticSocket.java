package com.nan.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import android.os.Handler;

public class StaticSocket {

	public static Socket socket;
	public static OutputStream os;
	public static Handler handler;
	
	public static ClientThread clientThread;
	
	private StaticSocket(){
		
	}
	
	public static void run(){
		try {
			clientThread = new ClientThread(socket, handler);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		new Thread(clientThread).start();
	}
	
	
}
