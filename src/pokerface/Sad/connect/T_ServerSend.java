package pokerface.Sad.connect;

import java.io.BufferedReader;
import java.io.IOException;
//消息发送线程
import java.io.InputStreamReader;

public class T_ServerSend implements Runnable{
	Server server = null;
	public T_ServerSend(Server server){
		this.server = server;
	}
	@Override
	public void run() {
		while(Server.closeFlag == false){
			//接收键盘输入
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String msg = null;
			try {
				msg = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(msg.equals("closeServer")){
				Server.closeFlag = true;
			}else{
				
				this.server.sendMsg(msg);
				System.out.println("                      server : "+msg);
			}
		}
	}
	
	
}