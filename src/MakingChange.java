import javax.swing.*;
import java.awt.*;

public class MakingChange {
	public static void main(String[] args) {
		//create frame
		JFrame frame = new JFrame("Making Change");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750, 450);

		//create panel
		RegisterPanel panel = new RegisterPanel();
		panel.setBackground(Color.RED);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));

		//add panel to frame
		frame.add(panel);
		frame.setVisible(true);
	}
}
