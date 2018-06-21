package pokerface.Sad.GUI;

import pokerface.Sad.connect.T_ServerReceive;

public class Server {
	static ServerConfigDialog scd = null;
	static ServerWindow window = null;
	public static void main(String[] args) {
		
		//运行服务器配置窗口
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				scd = new ServerConfigDialog();
				scd.setVisible(true);
			}
		});
		
		//等待serverConfigDialog启动并且填入端口后
		while (scd == null || scd.isVisible() == true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//运行服务器主窗口
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				window = new ServerWindow(scd.serverPort);

				window.setVisible(true);

			}
		});
		//阻塞保证窗口先启动再开始接收客户端连接
		System.out.println("等待窗口启动");
		while (window == null) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("窗口启动完成");
		while (true) {
			window.serverInfo.setText("服务器正在运行\n等待客户端连接");

			window.server.acceptClient();

			window.serverInfo.setText("客户端已连接\nIP : "
					+ window.server.client.getInetAddress().getHostAddress()
					+ "\nPort : " + window.server.client.getPort());
			window.server.closeFlag = false;
			Thread t_receive = new Thread(new T_ServerReceive(window.server,
					window));

			t_receive.start();
			while (window.server.closeFlag == false) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
