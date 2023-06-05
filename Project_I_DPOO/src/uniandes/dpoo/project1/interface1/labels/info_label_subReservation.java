package uniandes.dpoo.project1.interface1.labels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class info_label_subReservation extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public info_label_subReservation(String text_to_display) {
		//label for text to indicate instructions
		//set background characteristics
		this.setBackground(Color.black);
		this.setOpaque(true);
		// setting text to the pane in order to choose option
		this.setText(text_to_display);
		this.setHorizontalTextPosition(JLabel.CENTER); //horizontal position of the text in the label
		this.setVerticalTextPosition(JLabel.CENTER); //vertical position of the text in the label
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setForeground(Color.CYAN); //set color for the letters
		this.setFont(new Font("MV Boli", Font.PLAIN, 15));
		this.setBounds(45, 45, 570, 125);
	}
}
