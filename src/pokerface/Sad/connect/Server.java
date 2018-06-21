package pokerface.Sad.connect;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class Server extends ServerSocket{
	public static boolean closeFlag = false;
	public Socket client = null;
	public Server(int port) throws IOException{
		super(port);
		try {
			this.setSoTimeout(5000);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	//服务器端发送消息
	public boolean sendMsg(String msg){
//		BufferedWriter bw = null;
		//获取输出流
		boolean flag = true;
		OutputStream os;
		try {
			os = this.client.getOutputStream();
			msg = msg + '\0';//添加结束标记
			os.write(msg.getBytes("GBK"));
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
			
		}
		return flag;
	}
	//服务器端接收消息
	public String receiveMsg() throws SocketTimeoutException{
		
		InputStreamReader isr = null;
		String msg = null;
		StringBuilder sb = new StringBuilder();
		char c;
		try {
			isr = new InputStreamReader(this.client.getInputStream(),"GBK");
			while((c = (char) isr.read()) != '\0')
			{
				sb.append(c);
			}
		} catch(SocketTimeoutException e){
			throw e;
		} catch (SocketException e) {
				System.out.println("------客户端已断开--------");
				Server.closeFlag = true;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		msg = sb.toString();
		return msg;
	}
	public void closeServer(){
		if(this != null){
			try {
				this.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void acceptClient(){
		
		
		boolean flag = false;
		do {
			try {
				System.out.println("等待客户端连接");
				flag = false;
				this.client =  this.accept();
			} catch (SocketTimeoutException e) {
				flag = true;
			}catch (IOException e) {
				e.printStackTrace();
			}
		} while (flag);
	}
	/*
	public static void main(String[] args){
		//创建服务器端 端口号10000
		Server s1 = null;
		try {
			 s1 = new Server(10000);
		} catch (IOException e) {
			//端口号错误
			e.printStackTrace();
		}
		
		s1.acceptClient();
		System.out.println("------客户端已连接 IP地址 : "+s1.client.getInetAddress().getHostAddress()+"  主机名 : "+s1.client.getInetAddress().getHostName()+"--------");
		
		Thread t_send = new Thread(new T_ServerSend(s1));
		Thread t_receive = new Thread(new T_ServerReceive(s1));
		
		t_send.start();
		t_receive.start();
		
		
	}
	*/
}
