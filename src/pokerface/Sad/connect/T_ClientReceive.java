package pokerface.Sad.connect;

import java.net.SocketException;
import java.net.SocketTimeoutException;

import pokerface.Sad.GUI.ClientWindow;

//消息接收线程
public class T_ClientReceive implements Runnable{
	Client client = null;
	ClientWindow window = null;
	public T_ClientReceive(Client client,ClientWindow window ){
		this.client = client;
		this.window = window;
	}
	@Override
	public void run() {
		try {
			client.setSoTimeout(5000);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		while(Client.closeFlag == false){
			try {
				String msg = this.client.receiveMsg();
				if(!msg.isEmpty())
				{
					//将消息展示在历史消息框中
					String oldMsg = this.window.msgShowArea.getText();
					String newMsg = oldMsg + "\nServer : " + msg;
					this.window.msgShowArea.setText(newMsg);
				}
				
			} catch (SocketTimeoutException e) {
			}
		}
	}
	
	
}