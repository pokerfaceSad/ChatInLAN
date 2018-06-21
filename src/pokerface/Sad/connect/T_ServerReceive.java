package pokerface.Sad.connect;

import java.net.SocketException;
import java.net.SocketTimeoutException;

import pokerface.Sad.GUI.ServerWindow;

//消息接收线程
public class T_ServerReceive implements Runnable{
	Server server = null;
	ServerWindow window = null;
	public T_ServerReceive(Server server,ServerWindow window){
		this.server = server;
		this.window = window;
	}
	@Override
	public void run() {
		
		while(Server.closeFlag == false){
				try {
					String msg = this.server.receiveMsg();
					//将消息展示在历史消息框中
					if(!msg.isEmpty())
					{
						String oldMsg = this.window.msgShowArea.getText();
						String newMsg = oldMsg + "\nClient : " + msg;
						this.window.msgShowArea.setText(newMsg);
					}
				} catch (SocketTimeoutException e) {
					//读超时，跳出循环
				}
		}
	}
	
	
}