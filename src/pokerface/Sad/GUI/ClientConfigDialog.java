/*
 * ClientConfigDialog.java
 *
 * Created on __DATE__, __TIME__
 */

package pokerface.Sad.GUI;

/**
 *
 * @author  __USER__
 */
public class ClientConfigDialog extends javax.swing.JFrame {

	public String serverIP = null;
	public Integer serverPort = null;

	/** Creates new form ClientConfigDialog */
	public ClientConfigDialog() {
		initComponents();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		portInputArea = new javax.swing.JFormattedTextField();
		jButton1 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		IPInputArea = new javax.swing.JFormattedTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		portInputArea
				.setText("\u8bf7\u8f93\u5165\u670d\u52a1\u5668\u7aef\u53e3\u53f7");
		portInputArea.setFont(new java.awt.Font("微软雅黑", 0, 18));
		portInputArea.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				portInputAreaMouseClicked(evt);
			}
		});
		portInputArea.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				portInputAreaActionPerformed(evt);
			}
		});
		portInputArea.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				portInputAreaFocusGained(evt);
			}
		});

		jButton1.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jButton1.setText("\u786e\u5b9a");
		jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton1MouseClicked(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel1.setText("\u5ba2\u6237\u7aef\u914d\u7f6e");

		IPInputArea.setText("\u8bf7\u8f93\u5165\u670d\u52a1\u5668IP");
		IPInputArea.setFont(new java.awt.Font("微软雅黑", 0, 18));
		IPInputArea.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				IPInputAreaMouseClicked(evt);
			}
		});
		IPInputArea.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				IPInputAreaActionPerformed(evt);
			}
		});
		IPInputArea.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				IPInputAreaFocusGained(evt);
			}
		});

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
																.addComponent(
																		jLabel1))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(26, 26,
																		26)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																								.addComponent(
																										IPInputArea)
																								.addComponent(
																										portInputArea,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										177,
																										javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(51,
																										51,
																										51)
																								.addComponent(
																										jButton1)))))
								.addContainerGap(41, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel1)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										44, Short.MAX_VALUE)
								.addComponent(IPInputArea,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(portInputArea,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(34, 34, 34)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void portInputAreaFocusGained(java.awt.event.FocusEvent evt) {
		portInputArea.setText("");
	}

	private void IPInputAreaFocusGained(java.awt.event.FocusEvent evt) {
		
	}

	//GEN-END:initComponents

	//GEN-END:initComponents

	//GEN-END:initComponents

	//GEN-END:initComponents

	//GEN-END:initComponents

	//GEN-END:initComponents

	//GEN-END:initComponents

	private void IPInputAreaActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void IPInputAreaMouseClicked(java.awt.event.MouseEvent evt) {
		IPInputArea.setText("");
	}

	private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
		String port = portInputArea.getText();
		String IP = IPInputArea.getText();
		if (!port.isEmpty() && !IP.isEmpty()) {
			try {
				if (!IP.matches("((25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))")) {
					IPInputArea.setText("IP地址格式错误");
				} else {
					this.serverIP = IP;
				}
				this.serverPort = new Integer(port);
				this.setVisible(false);
			} catch (NumberFormatException e) {
				portInputArea.setText("端口格式错误");
			}
		}
	}

	private void portInputAreaActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void portInputAreaMouseClicked(java.awt.event.MouseEvent evt) {
		portInputArea.setText("");
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ClientConfigDialog().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JFormattedTextField IPInputArea;
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JFormattedTextField portInputArea;
	// End of variables declaration//GEN-END:variables

}