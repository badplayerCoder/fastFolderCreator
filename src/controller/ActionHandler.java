package controller;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class ActionHandler {

	public static void integerHandler(KeyEvent e, JTextField text) {
		String value = text.getText();
		int l = value.length();
		if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
			text.setEditable(true);
		}else
			text.setEditable(false);
	}
	
}
