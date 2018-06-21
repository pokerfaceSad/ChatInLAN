package pokerface.Sad.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import pokerface.Sad.connect.Client;

public class Test01 {
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		
		Socket s = new Socket("127.0.0.1",10001);
		
		OutputStream os = s.getOutputStream();
		String str = "ab\\\\";
		os.write(str.getBytes());
		
		s.close();
	}
}
