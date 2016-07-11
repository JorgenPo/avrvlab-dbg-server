package avr_debug_server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Messenger {
	static Message readMessage(Socket s){
		try {
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			Message message = (Message) ois.readObject();
			return message;
		} catch (IOException | ClassNotFoundException e) {
			return null;
		}
	}
	
	static void writeMessage(Socket s, Message mess){
		try {
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(mess);
		} catch (IOException e) {
		}
	}
	
	static SimpleReserveItem readSimpleReserveItem(Socket s){
		try {
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			SimpleReserveItem item = (SimpleReserveItem) ois.readObject();
			return item;
		} catch (IOException | ClassNotFoundException e) {
			return null;
		}		
	}

	static void writeSimpleReserveItem(Socket s, SimpleReserveItem item){
		try {
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(item);
		} catch (IOException e) {
		}		
	}
}
