package uniandes.dpoo.project1.interface1.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import uniandes.dpoo.project1.interface1.app;
import uniandes.dpoo.project1.interface1.buttons.exit_button;
import uniandes.dpoo.project1.interface1.labels.info_label_subReservation;

public class sub_reservation_panel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	app mysubcontroller;
	//buttons
		//balcony
			JRadioButton balcony_true_button;
			JRadioButton balcony_false_button;
		//room type
			JRadioButton room_type_standar;
			JRadioButton room_type_suite;
			JRadioButton room_type_double_suite;
		//kitchen
			JRadioButton kitchen_true_button;
			JRadioButton kitchen_false_button;
		//view
			JRadioButton view_true_button;
			JRadioButton view_false_button;
		//bed type
			JComboBox<Object> comboBoxBedtype;
			JComboBox<Object> comboBoxroom_type;
		//choosing number of beds
			JComboBox<Object> comboBoxBeds;
			
			Boolean kitchen_property;
			Boolean view_property;
			Boolean balcony_property;
			int num_beds;
			String room_type;
			String beds_type;
			
			Border compoundBorderdropdownlist;
			Border compoundBorderbutton;
	public sub_reservation_panel(app mycontroller) {
		mysubcontroller = mycontroller;
		
		//setting this panel characteristics
				//special border
					Border outerborderdropdownlist = BorderFactory.createLineBorder(Color.CYAN, 2);
					Border innerborderdropdownlist = BorderFactory.createEmptyBorder(10, 10, 10, 10);
					compoundBorderdropdownlist = BorderFactory.createCompoundBorder(outerborderdropdownlist, innerborderdropdownlist);
			this.setBorder(compoundBorderdropdownlist);
			this.setBounds(45, 75, 700, 330);
			this.setBackground(Color.black);
		
			//label for text to indicate instructions
			String text_to_display = "<html> Now, as the <b><u>dates have been alredy chosen</u></b> you´ll have to"
					+ " add the next info required to<br> filter by all the rooms of the hotel."
					+ "<br>The next buttons and boxes have the <b><u>filters</u></b>  to search the room expected. "
					+ "<br> Once you finish the process <b><u>please click the next step button</u></b> in order to show"
					+ "<br> you the rooms available that fit for your <b><u>characteristics and needs</u></b>."
					+ "<br> Pd: If a property of kitchen, balcony or view is not selected we assume that you dont want it.</html>";
			info_label_subReservation instructions_label = new info_label_subReservation(text_to_display);
			
		//Sub Panels for buttons for room characteristics
			//Radio buttons for balcony statements
				balcony_true_button = new JRadioButton();
				balcony_true_button.setFocusable(false);
				balcony_false_button = new JRadioButton();
				balcony_false_button.setFocusable(false);
				//Groupby buttons to choose only one
					ButtonGroup balcony_group = new ButtonGroup();
					balcony_group.add(balcony_true_button);
					balcony_group.add(balcony_false_button);
				//add action listener to the buttons
					balcony_true_button.addActionListener(this);
					balcony_false_button.addActionListener(this);
					
			//Radio buttons for choosing room type
					String [] room_type_group = {"estándar", "suite", "suite doble"};
					comboBoxroom_type = new JComboBox<Object>(room_type_group);
					comboBoxroom_type.addActionListener(this);
					
			//Radio buttons for choosing bed type
					String [] bed_types = {"king", "queen", "individual", "doble"};
					comboBoxBedtype = new JComboBox<Object>(bed_types);
					comboBoxBedtype.addActionListener(this);
					
			//Radio buttons for kitchen
				kitchen_true_button = new JRadioButton();
				kitchen_true_button.setFocusable(false);
				kitchen_false_button = new JRadioButton();
				kitchen_false_button.setFocusable(false);
				//Groupby buttons to choose only one
					ButtonGroup kitchen_group = new ButtonGroup();
					kitchen_group.add(kitchen_true_button);
					kitchen_group.add(kitchen_false_button);
				//add action listener to the buttons
					kitchen_true_button.addActionListener(this);
					kitchen_false_button.addActionListener(this);
					
			//Radio buttons for choosing view
				view_true_button = new JRadioButton();
				view_true_button.setFocusable(false);
				view_false_button = new JRadioButton();
				view_false_button.setFocusable(false);
				//Groupby buttons to choose only one
					ButtonGroup view_group = new ButtonGroup();
					view_group.add(view_true_button);
					view_group.add(view_false_button);
				//add action listener to the buttons
					view_true_button.addActionListener(this);
					view_false_button.addActionListener(this);
				
			//getting the minimum and maxim number of beds per rooms to filter 
				int min_integer = mysubcontroller.min_beds_per_rooms();
				int max_integer = mysubcontroller.max_beds_per_rooms();
				Integer[] numbersArray = new Integer[max_integer - min_integer + 1];
			    for (int i = min_integer; i <= max_integer; i++) {
			          numbersArray[i - min_integer] = i;
			      }
			//combo box for choosing number of beds
				comboBoxBeds= new JComboBox<Object>(numbersArray);
				comboBoxBeds.addActionListener(this);
			
			//add icon to the buttons
				// resize reservation icon
				ImageIcon confirmation_icon = new ImageIcon("data/images/check.png");
				Image confirmation_image = confirmation_icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
				confirmation_icon = new ImageIcon(confirmation_image);

				// resize cancellation icon
				ImageIcon cancelation_icon = new ImageIcon("data/images/x.png");
				Image cancelation_image = cancelation_icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
				cancelation_icon = new ImageIcon(cancelation_image);

				// set icons for JRadioButtons
				balcony_true_button.setIcon(confirmation_icon);
				balcony_false_button.setIcon(cancelation_icon);	
				
				kitchen_true_button.setIcon(confirmation_icon);
				kitchen_false_button.setIcon(cancelation_icon);	
				
				view_true_button.setIcon(confirmation_icon);
				view_false_button.setIcon(cancelation_icon);	
				//1st row panel
					JPanel first_row_panel = new JPanel(new BorderLayout());
					first_row_panel.setBounds(45, 170, 600, 50);
		//sub panels holders for button groups
			//balcony holder
					String balcony_holder_str = "<html> Do you want <b><u>balcony?</u> </b></html>";
					SubReservation_generic_holder balcony_holder = new SubReservation_generic_holder(balcony_true_button, 
							balcony_false_button, balcony_holder_str);
							
			//kitchen holder	
					String kitchen_holder_str = "<html> Do you want <b><u>kitchen?</u> </b></html>";
					SubReservation_generic_holder kitchen_holder = new SubReservation_generic_holder(kitchen_true_button,
							kitchen_false_button, kitchen_holder_str);
							
			//view_holder
					String view_holder_str = "<html> Do you want <b><u>view?</u> </b></html>";
					SubReservation_generic_holder view_holder = new SubReservation_generic_holder(view_true_button,
							view_false_button, view_holder_str);

				//adding holders to first row panel
					first_row_panel.add(balcony_holder, BorderLayout.EAST);
					first_row_panel.add(kitchen_holder, BorderLayout.CENTER);
					first_row_panel.add(view_holder, BorderLayout.WEST);
					
				//2nd row panel
					JPanel second_row_panel = new JPanel(new BorderLayout());
					second_row_panel.setBounds(0,0,150,150);
					second_row_panel.setBackground(Color.black);
				//room type holder
					String room_type_holder_str = "<html> Please introduce the <b><u>room type</u> </b></html>";
					SubReservation_generic_holder2 room_type_holder = new SubReservation_generic_holder2(room_type_holder_str,
							comboBoxroom_type);
				//number beds holder
					String num_beds_holder_str = "<html> Please introduce the <b><u># of beds</u> </b></html>";
					SubReservation_generic_holder2 num_beds_holder = new SubReservation_generic_holder2(num_beds_holder_str,
							comboBoxBeds);
				//beds type holder
					String beds_type_holder_str = "<html> Please introduce the <b><u>bed type</u> </b></html>";
					SubReservation_generic_holder2 beds_type_holder = new SubReservation_generic_holder2(beds_type_holder_str,
							comboBoxBedtype);
					beds_type_holder.setBorder(new EmptyBorder(10, 0, 15, 0));
				//adding holders to second row panel
					second_row_panel.add(room_type_holder, BorderLayout.EAST);
					second_row_panel.add(num_beds_holder, BorderLayout.WEST);
					//second_row_panel.add(beds_type_holder, BorderLayout.SOUTH);
			
		this.setVisible(false);
		//adding components to the panel	
			this.add(instructions_label);
			this.add(first_row_panel);
			this.add(second_row_panel);
			this.add(beds_type_holder);
			
			Border outerborderbutton = BorderFactory.createLineBorder(Color.CYAN, 2);
			Border innerborderbutton = BorderFactory.createEmptyBorder(3, 3, 3, 3);
			compoundBorderbutton = BorderFactory.createCompoundBorder(outerborderbutton, innerborderbutton);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == view_true_button) {
			view_property = true;
			view_false_button.setBorder(new EmptyBorder(2, 2, 2, 2));
			view_true_button.setBorder(compoundBorderbutton);
		}
		if(e.getSource() == view_false_button) {
			view_property = false;
			view_true_button.setBorder(new EmptyBorder(2, 2, 2, 2));
			view_false_button.setBorder(compoundBorderbutton);
		}
		if(e.getSource() == kitchen_true_button) {
			kitchen_property = true;
			kitchen_false_button.setBorder(new EmptyBorder(2, 2, 2, 2));
			kitchen_true_button.setBorder(compoundBorderbutton);
		}
		if(e.getSource() == kitchen_false_button) {
			kitchen_property = false;
			kitchen_true_button.setBorder(new EmptyBorder(2, 2, 2, 2));
			kitchen_false_button.setBorder(compoundBorderbutton);
		}
		if(e.getSource() == balcony_true_button) {
			balcony_property = true;
			balcony_false_button.setBorder(new EmptyBorder(2, 2, 2, 2));
			balcony_true_button.setBorder(compoundBorderbutton);
		}
		if(e.getSource() == balcony_false_button) {
			balcony_property = false;
			balcony_true_button.setBorder(new EmptyBorder(2, 2, 2, 2));
			balcony_false_button.setBorder(compoundBorderbutton);
		}
		if(e.getSource() == comboBoxBeds) {
			num_beds = (int) comboBoxBeds.getSelectedItem();
		}
		if(e.getSource() == comboBoxroom_type) {
			room_type = (String) comboBoxroom_type.getSelectedItem();
		}
		if(e.getSource() == comboBoxBedtype) {
			beds_type = (String) comboBoxBedtype.getSelectedItem();
		}
	}
	public boolean getKitchenProperty() {
		if(kitchen_property ==  null) {kitchen_property = false;}
		return kitchen_property;
	}
	public boolean getViewProperty() {
		if(view_property ==  null) {view_property = false;}
		return view_property;
	}
	public boolean getBalconyProperty() {
		if(balcony_property ==  null) {balcony_property = false;}
		return balcony_property;
	}
	public int getNumBedsProperty() {
		return num_beds;
	}
	public String getRoom_typeProperty() {
		return room_type;
	}
	public String getBeds_typeProperty() {
		return beds_type;
	}
}
