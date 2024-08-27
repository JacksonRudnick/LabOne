import javax.swing.*;
import java.awt.*;

public class ChangePanel extends JPanel {
	private Purse purse;
	private JTextArea changeField;

	ChangePanel() {
		changeField = new JTextArea(9, 30);
		changeField.setEditable(false);
		this.add(changeField);
	}

	public void displayException(String err) {
		changeField.setText(err + "\nPlease make sure what you have entered is a double.");
	}

	public void setPurse(Purse p) {
		purse = p;
		changeField.setText(purse.toString());
	}
}
