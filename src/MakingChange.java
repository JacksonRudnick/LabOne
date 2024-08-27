import javax.swing.*;
import java.awt.*;

public class MakingChange {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Making Change");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 200);

		RegisterPanel panel = new RegisterPanel();
		panel.setBackground(Color.RED);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));

		frame.add(panel);
		frame.setVisible(true);
	}
}
