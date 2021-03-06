/*
 * ServerWindow.java
 *
 * Created on __DATE__, __TIME__
 */

package pokerface.Sad.GUI;

import java.io.IOException;
import java.net.SocketException;

import pokerface.Sad.connect.Server;
import pokerface.Sad.connect.T_ServerReceive;

/**
 *
 * @author  __USER__
 */
public class ServerWindow extends javax.swing.JFrame {

	Server server = null;

	/** Creates new form ServerWindow */
	public ServerWindow(int port) {
		initComponents();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		//创建服务器
		try {
			server = new Server(port);

		} catch (IOException e) {
			serverInfo.setText("服务器启动失败\n请检查网络连接");
			e.printStackTrace();
			//TODO
			return;
		}

	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane2 = new javax.swing.JScrollPane();
		msgShowArea = new javax.swing.JTextArea();
		jScrollPane1 = new javax.swing.JScrollPane();
		inputTextArea = new javax.swing.JTextArea();
		jScrollPane3 = new javax.swing.JScrollPane();
		serverInfo = new javax.swing.JTextArea();
		sendButton = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(3);

		msgShowArea.setColumns(20);
		msgShowArea.setEditable(false);
		msgShowArea.setFont(new java.awt.Font("微软雅黑", 0, 18));
		msgShowArea.setLineWrap(true);
		msgShowArea.setRows(5);
		jScrollPane2.setViewportView(msgShowArea);

		inputTextArea.setColumns(20);
		inputTextArea.setFont(new java.awt.Font("微软雅黑", 0, 18));
		inputTextArea.setLineWrap(true);
		inputTextArea.setRows(5);
		jScrollPane1.setViewportView(inputTextArea);

		serverInfo.setColumns(20);
		serverInfo.setFont(new java.awt.Font("微软雅黑", 0, 18));
		serverInfo.setLineWrap(true);
		serverInfo.setRows(5);
		jScrollPane3.setViewportView(serverInfo);

		sendButton.setText("\u53d1\u9001");
		sendButton.setActionCommand("jButton1");
		sendButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				sendButtonMouseClicked(evt);
			}
		});
		sendButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sendButtonActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel1.setText("\u670d\u52a1\u5668");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						jScrollPane2)
																				.addComponent(
																						jScrollPane1,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						369,
																						Short.MAX_VALUE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jScrollPane3,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						161,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						sendButton,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						161,
																						Short.MAX_VALUE)))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(134,
																		134,
																		134)
																.addComponent(
																		jLabel1)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel1)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING,
												false)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jScrollPane3,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		243,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		sendButton,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		44,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														javax.swing.GroupLayout.Alignment.LEADING,
														layout.createSequentialGroup()
																.addComponent(
																		jScrollPane2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		427,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jScrollPane1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(20, 20, 20)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling co
	}

	private void sendButtonMouseClicked(java.awt.event.MouseEvent evt) {
		String msg = inputTextArea.getText(); //获取消息内容
		if (!msg.isEmpty()) {
			server.sendMsg(msg); //发送输入框中内容
			//更新历史消息框
			String oldMsg = msgShowArea.getText();
			String newMsg = oldMsg + "\nServer : " + msg;
			msgShowArea.setText(newMsg);
			inputTextArea.setText("");//清空发送框内容
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static ServerWindow window = null;
	public static boolean isWindowStarted = false;

	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				window = new ServerWindow(10000);

				window.setVisible(true);
				isWindowStarted = true;

			}
		});
		//阻塞保证窗口先启动再开始接收客户端连接
		System.out.println("等待窗口启动");
		while (isWindowStarted == false) {
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

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTextArea inputTextArea;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	public javax.swing.JTextArea msgShowArea;
	private javax.swing.JButton sendButton;
	javax.swing.JTextArea serverInfo;
	// End of variables declaration//GEN-END:variables

}