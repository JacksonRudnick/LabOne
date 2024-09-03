import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import static java.lang.System.exit;

public class ChangePanel extends JPanel {
	private Purse purse;

	//method to display coins and bills
	public void setPurse(Purse p) {
		purse = p;

		//loop through possible denominations
		for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
			//display image for number of each type of denomination
			for (int i = 0; i < entry.getValue(); i++) {
				//start with image
				Image img = null;

				try {
					//read image
					img = ImageIO.read(new File("images/" + entry.getKey().img()));
				} catch (IOException e) {
					System.out.println(e.getMessage());
					exit(-1);
				}

				//resize image
				if (Objects.equals(entry.getKey().form(), "bill")) {
					img = img.getScaledInstance(120, 60, Image.SCALE_SMOOTH);
				} else {
					img = img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
				}

				//convert image into a label
				JLabel picLabel = new JLabel(new ImageIcon(img));

				this.add(picLabel);
			}
		}

		//repaint and validate graphics for window
		revalidate();
		repaint();
	}
}

