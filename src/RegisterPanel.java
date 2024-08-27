import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodListener;

public class RegisterPanel extends JPanel {
	Register register;
	JPanel inputPanel;
	JTextField input;
	ChangePanel pursePanel;

	RegisterPanel() {
		register = new Register();
		pursePanel = new ChangePanel();
		inputPanel = new JPanel();
		input = new JTextField(8);

		inputPanel.setBackground(Color.GREEN);
		inputPanel.setPreferredSize(new Dimension(100, 30));

		//input listener for enter key
		input.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				//check for errors with the input box
				double num = 0.0;
				try {
					updatePurse(Double.parseDouble(input.getText()));
				} catch (Exception err) {
					pursePanel.displayException(err.toString());
				};
			}
		});

		inputPanel.add(input);

		pursePanel.setBackground(Color.BLUE);
		pursePanel.setPreferredSize(new Dimension(400, 200));

		this.add(inputPanel);
		this.add(pursePanel);
	}

	public void updatePurse(double amt) {
		pursePanel.setPurse(register.makeChange(amt));
	}
}
