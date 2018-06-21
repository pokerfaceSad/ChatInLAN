/*
 * ClientWindow.java
 *
 * Created on __DATE__, __TIME__
 */

package pokerface.Sad.GUI;

import java.io.IOException;
import java.net.UnknownHostException;

import pokerface.Sad.connect.Client;
import pokerface.Sad.connect.T_ClientReceive;
import pokerface.Sad.connect.T_ClientSend;

/**
 *
 * @author  __USER__
 */
public class ClientWindow extends javax.swing.JFrame {
	Client client = null;

	/** Creates new form ClientWindow */
	public ClientWindow(String serverIP,int port) {
		//在构造方法中初始化内容
		initComponents();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		//连接服务器
		//创建客户端连接
		try {
			client = new Client(serverIP, port);
			client.serverIP = serverIP;
			serverInfo.setText("已连接服务器\nIP : " + serverIP + "\nPort : " + port);
		} catch (Exception e) {
			serverInfo.setText("连接失败\n请检查服务器IP和端口地址");
			return;
		}

		//Thread t_send = new Thread(new T_ClientSend(c1));
		Thread t_receive = new Thread(new T_ClientReceive(client, this));

		//t_send.start();
		t_receive.start();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		sendButton = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		inputTextArea = new javax.swing.JTextArea();
		jScrollPane2 = new javax.swing.JScrollPane();
		msgShowArea = new javax.swing.JTextArea();
		jScrollPane3 = new javax.swing.JScrollPane();
		serverInfo = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel1.setText("\u5ba2\u6237\u7aef");

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

		inputTextArea.setColumns(20);
		inputTextArea.setFont(new java.awt.Font("微软雅黑", 0, 18));
		inputTextArea.setLineWrap(true);
		inputTextArea.setRows(5);
		jScrollPane1.setViewportView(inputTextArea);

		msgShowArea.setColumns(20);
		msgShowArea.setEditable(false);
		msgShowArea.setFont(new java.awt.Font("微软雅黑", 0, 18));
		msgShowArea.setLineWrap(true);
		msgShowArea.setRows(5);
		jScrollPane2.setViewportView(msgShowArea);

		serverInfo.setColumns(20);
		serverInfo.setFont(new java.awt.Font("微软雅黑", 0, 18));
		serverInfo.setLineWrap(true);
		serverInfo.setRows(5);
		jScrollPane3.setViewportView(serverInfo);

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
																						172,
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

	private void sendButtonMouseClicked(java.awt.event.MouseEvent evt) {
		String msg = inputTextArea.getText(); //获取消息内容
		if(!msg.isEmpty())
		{
			client.sendMsg(msg); //发送输入框中内容
			//更新历史消息框
			String oldMsg = msgShowArea.getText();
			String newMsg = oldMsg + "\nClient : " + msg;
			msgShowArea.setText(newMsg);
			inputTextArea.setText("");//清空发送框内容
		}
	}

	private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling co
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ClientWindow("127.0.0.1",12345).setVisible(true);
			}
		});
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
	private javax.swing.JTextArea serverInfo;
	// End of variables declaration//GEN-END:variables

}