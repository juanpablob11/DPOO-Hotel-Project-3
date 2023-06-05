package uniandes.dpoo.project1.interface1.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import uniandes.dpoo.project1.interface1.app;

public class show_available_rooms_panel extends JPanel implements ActionListener{

		/**
		 * 
		 */
		app mysubcontroller;
		private static final long serialVersionUID = 1L;
		JPanel listPanel;
		JPanel listPanel3;
		JComboBox<Object> comboBoxIdAvailable;

		String id_selected = "0";
		//constructor
		public show_available_rooms_panel(app mycontroller, List<Integer> id_availables) {
			mysubcontroller = mycontroller;
			Border outerborderdropdownlist = BorderFactory.createLineBorder(Color.CYAN, 2);
			Border innerborderdropdownlist = BorderFactory.createEmptyBorder(10, 10, 10, 10);
			Border compoundBorderdropdownlist = BorderFactory.createCompoundBorder(outerborderdropdownlist, innerborderdropdownlist);
			//Big Panel that serves as a border
			this.setLayout(new BorderLayout());
			this.setBorder(compoundBorderdropdownlist);
			this.setBounds(45, 75, 600, 265);
			this.setBackground(Color.black);
			//1st cancellation panel
			JPanel reservationPanel = new JPanel(new BorderLayout());
			JLabel reservation_label = new JLabel();
			reservationPanel.setLayout(new BorderLayout());
			reservationPanel.setBounds(15, 15, 570, 250);
			reservationPanel.add(reservation_label, BorderLayout.CENTER);
			
			//border for the reservation panel
			//reservationPanel.setBorder(compoundBorderdropdownlist);
			
			reservationPanel.setBackground(Color.black);
			reservationPanel.setOpaque(true);
			reservation_label.setLayout(null);
			// setting text to the jpane in order to choose option
			reservation_label.setText("<html> <b>Showing available rooms... </b>"
					+ "<br> -> Please select in the drop down lists the room id that you want for"
					+ " your booking! <br> All the rooms that appear below meet your aforementioned needs! "
					+ "<br> Select the id of the room that you want, if no id is there <br> your request cannot be satisfied"
					+ " because we dont have a room with that <br> characteristics in that dates :( "
					+ " <br> Last but not least, introduce your name, phone and email to close reservation.</html>");
			reservation_label.setHorizontalTextPosition(JLabel.CENTER); //horizontal position of the text in the label
			reservation_label.setVerticalTextPosition(JLabel.CENTER); //vertical position of the text in the label
			reservation_label.setHorizontalAlignment(JLabel.CENTER);
			reservation_label.setForeground(Color.CYAN); //set color for the letters
			reservation_label.setFont(new Font("MV Boli", Font.PLAIN, 15));
			reservation_label.setBounds(55, 50, 250, 150);
			reservationPanel.add(reservation_label, BorderLayout.CENTER);
			
			//add drop down list to the subpanel
			listPanel = new JPanel();
			
			String[] id_available_array = new String[id_availables.size()];
	        for (int i = 0; i < id_availables.size(); i++) {
	            id_available_array[i] = String.valueOf(id_availables.get(i));
	        }
			
			comboBoxIdAvailable = new JComboBox<Object>(id_available_array);
			comboBoxIdAvailable.addActionListener(this);
			
			listPanel.setBackground(Color.black);
			listPanel.setOpaque(true);
			listPanel.add(comboBoxIdAvailable);
			
			reservationPanel.add(listPanel, BorderLayout.SOUTH);
	        this.setVisible(false);
	        //add to main cancellation panel
	        this.add(reservationPanel, BorderLayout.NORTH);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == comboBoxIdAvailable) {
				id_selected = (String) comboBoxIdAvailable.getSelectedItem();
			}
		}
		
		public String getIdSelected() {
			return id_selected;
		}
}
