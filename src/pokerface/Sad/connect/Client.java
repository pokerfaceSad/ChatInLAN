package pokerface.Sad.connect;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class Client extends Socket{
	public static boolean closeFlag = false;
	public String serverIP;
	public Client(String serverAddress, int port) throws UnknownHostException, IOException {
		super(serverAddress,port);
		try {
			this.setSoTimeout(5000);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	public void closeClient(){
		if(this != null){
			try {
				this.close();
			} catch (IOException e) {
				e.printStackTrace();
				//关闭客户端失败
			}
		}else{
			System.err.println("客户端对象为空");
			//客户端对象为空
		}
		
		
	}
	/*
	public static void main(String[] args){
		
		//创建客户端连接
		Client c1 = null;
		String serverIP = "127.0.0.1";
		int port = 10000;
		try {
			c1 = new Client(serverIP,port);
			c1.serverIP = serverIP;
			System.out.println("------已连接到服务器 IP地址 : "+serverIP+"  端口号 : "+port+"--------");
		} catch (UnknownHostException e) {
			e.printStackTrace();
			//服务器IP地址错误
		} catch (IOException e) {
			e.printStackTrace();
			//服务器端口号错误
		}
		
		
		Thread t_send = new Thread(new T_ClientSend(c1));
		Thread t_receive = new Thread(new T_ClientReceive(c1));
		
		t_send.start();
		t_receive.start();
		
		
	}
	
	*/
	//客户端接收消息
	public String receiveMsg() throws SocketTimeoutException{
		InputStreamReader isr = null;
		String msg = null;
		StringBuilder sb = new StringBuilder();
		char c;
		try {
			isr = new InputStreamReader(this.getInputStream(),"GBK");
			while((c = (char) isr.read()) != '\0')
			{
				sb.append(c);
			}
		} catch(SocketTimeoutException e){
			throw e;
		}catch (SocketException e) {
				System.out.println("------服务器已断开--------");
				Server.closeFlag = true;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		msg = sb.toString();
		return msg;
	}
	//客户端发送消息
	public boolean sendMsg(String msg){
		//获取输出流
		boolean flag = true;
		OutputStream os;
		try {
			os = this.getOutputStream();
			msg = msg + '\0';//添加结束标记
			os.write(msg.getBytes("GBK"));
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
			
		}
		
		return true;
	}
}

