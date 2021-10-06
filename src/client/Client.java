package client;

import java.lang.reflect.Constructor;

import utils.Message;
import utils.Peer;

public class Client implements Peer{
	private ClientOperation op; //need to later add exception handling
	
	public Client() {
		
	}
	
	
	@Override
	public void send(Peer target, Message msg) {
		target.onRecv(msg);
	}

	@Override
	public void onRecv(Message msg) {
		try {
			Class c = Class.forName(msg.getOperationName());
			Constructor constructor = c.getConstructor(); //this warning need to be solved later
			op = (ClientOperation)constructor.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		op.operate(this, msg);
	}

}
