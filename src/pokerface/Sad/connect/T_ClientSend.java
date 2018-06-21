package pokerface.Sad.connect;

import java.io.BufferedReader;
import java.io.IOException;
//消息发送线程
import java.io.InputStreamReader;

public class T_ClientSend implements Runnable{
	Client client = null;
	public T_ClientSend(Client client){
		this.client = client;
	}
	@Override
	public void run() {
		while(Client.closeFlag == false){
			
			//接收键盘输入
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String msg = null;
			try {
				msg = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(msg.equals("closeClient")){
				Client.closeFlag = true;
			}else{
				this.client.sendMsg(msg);
				System.out.println("                      client : "+msg);
			}
		}
	}
	
	
}