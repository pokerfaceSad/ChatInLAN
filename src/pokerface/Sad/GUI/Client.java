package pokerface.Sad.GUI;

public class Client {
	
	static ClientConfigDialog ccd = null;
	static ClientWindow window = null;
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				ccd = new ClientConfigDialog();
				ccd.setVisible(true);
			}
		});
		
		while(ccd == null || ccd.isVisible() == true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				window = new ClientWindow(ccd.serverIP,ccd.serverPort);
				window.setVisible(true);
			}
		});
	}
	
}
