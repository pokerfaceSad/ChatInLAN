package pokerface.Sad.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import pokerface.Sad.connect.Client;
import pokerface.Sad.connect.Server;

public class Test00 {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		//字符流和字节流
		ServerSocket ss = new ServerSocket(10001);
		
		Socket s = ss.accept();
		
		InputStream is = s.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		byte[] buf = new byte[20];
		int Len = is.read(buf);
		for (int i = 0; i < buf.length; i++) {
			System.out.print((char) buf[i]);
			System.out.print(" ");
		}   
		byte b = '\0';
		char c = '\0';
//		int c = 1;
//		//每次接收一个字符 即两个字节
//		while((c = isr.read()) != -1){
//			System.out.println((char)c);
//		}
		ss.close();
		
	}
}
