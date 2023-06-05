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
import uniandes.dpoo.project1.interface1.labels.info_label_subReservation;

public class advanced_filters_panel extends JPanel implements ActionListener{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		app mysubcontroller;
		//buttons
			//air_conditioner
				JRadioButton air_conditioner_true_button;
				JRadioButton air_conditioner_false_button;
			//room type
				JRadioButton room_type_standar;
				JRadioButton room_type_suite;
				JRadioButton room_type_double_suite;
			//heating
				JRadioButton heating_true_button;
				JRadioButton heating_false_button;
			//tv
				JRadioButton tv_true_button;
				JRadioButton tv_false_button;
			//coffee_maker
				JRadioButton coffee_maker_true_button;
				JRadioButton coffee_maker_false_button;
			//dryer
				JRadioButton dryer_true_button;
				JRadioButton dryer_false_button;
			//hair_iron
				JRadioButton hair_iron_true_button;
				JRadioButton hair_iron_false_button;
			//ac_voltage
				JRadioButton ac_voltage_true_button;
				JRadioButton ac_voltage_false_button;
			//usb_a
				JRadioButton usb_a_true_button;
				JRadioButton usb_a_false_button;
			//usb_c
				JRadioButton usb_c_true_button;
				JRadioButton usb_c_false_button;
			//breakfast
				JRadioButton breakfast_true_button;
				JRadioButton breakfast_false_button;
				
				//1st row
				Boolean heating_property;
				Boolean tv_property;
				Boolean air_conditioner_property;
				
				//2nd row
				Boolean coffee_maker_property;
				Boolean dryer_property;
				Boolean hair_iron_property;
				
				//3rd row
				Boolean ac_voltage_property;
				Boolean usb_a_property;
				Boolean usb_c_property;
				
				//4th row 
				Boolean breakfast_property;
				JComboBox<Object> comboBoxRoomSize;
				
				Border compoundBorderbutton;
				
				String room_size;
		public advanced_filters_panel(app mycontroller) {
			mysubcontroller = mycontroller;
			
			//setting this panel characteristics
					//special border
						Border outerborderdropdownlist = BorderFactory.createLineBorder(Color.CYAN, 2);
						Border innerborderdropdownlist = BorderFactory.createEmptyBorder(10, 10, 10, 10);
						Border compoundBorderdropdownlist = BorderFactory.createCompoundBorder(outerborderdropdownlist, innerborderdropdownlist);
				this.setBorder(compoundBorderdropdownlist);
				this.setBounds(45, 75, 750, 420);
				this.setBackground(Color.black);
			
				//label for text to indicate instructions
				String text_to_display = "<html> Now, as the <b><u>basic filters have been alredy chosen</u></b> you´ll have to\"\r\n"
						+ " add the next info required to<br> filter by the advanced filters.\"\r\n"
						+ "<br>The next buttons have the <b><u>advanced filters</u></b>  to search the room expected. \"\r\n"
						+ "<br> Once you finish the process <b><u>please click the show me available rooms</u></b> in order to show\"\r\n"
						+ "<br> you the rooms available that fit for your <b><u>advanced characteristics and needs</u></b>."
						+ "<br> Pd: If a property is not selected we assume that you dont want it.</html>";
				info_label_subReservation instructions_label = new info_label_subReservation(text_to_display);
				
			//Sub Panels for buttons for room characteristics
				//Radio buttons for air_conditioner statements
					air_conditioner_true_button = new JRadioButton();
					air_conditioner_true_button.setFocusable(false);
					air_conditioner_false_button = new JRadioButton();
					air_conditioner_false_button.setFocusable(false);
					//Groupby buttons to choose only one
						ButtonGroup air_conditioner_group = new ButtonGroup();
						air_conditioner_group.add(air_conditioner_true_button);
						air_conditioner_group.add(air_conditioner_false_button);
					//add action listener to the buttons
						air_conditioner_true_button.addActionListener(this);
						air_conditioner_false_button.addActionListener(this);
						
				//Radio buttons for heating
					heating_true_button = new JRadioButton();
					heating_true_button.setFocusable(false);
					heating_false_button = new JRadioButton();
					heating_false_button.setFocusable(false);
					//Groupby buttons to choose only one
						ButtonGroup heating_group = new ButtonGroup();
						heating_group.add(heating_true_button);
						heating_group.add(heating_false_button);
					//add action listener to the buttons
						heating_true_button.addActionListener(this);
						heating_false_button.addActionListener(this);
						
				//Radio buttons for choosing tv
					tv_true_button = new JRadioButton();
					tv_true_button.setFocusable(false);
					tv_false_button = new JRadioButton();
					tv_false_button.setFocusable(false);
					//Groupby buttons to choose only one
						ButtonGroup tv_group = new ButtonGroup();
						tv_group.add(tv_true_button);
						tv_group.add(tv_false_button);
					//add action listener to the buttons
						tv_true_button.addActionListener(this);
						tv_false_button.addActionListener(this);
						
				//Radio buttons for choosing coffee maker
					coffee_maker_true_button = new JRadioButton();
					coffee_maker_true_button.setFocusable(false);
					coffee_maker_false_button = new JRadioButton();
					coffee_maker_false_button.setFocusable(false);
					//Groupby buttons to choose only one
						ButtonGroup coffee_maker_group = new ButtonGroup();
						coffee_maker_group.add(tv_true_button);
						coffee_maker_group.add(tv_false_button);
					//add action listener to the buttons
						coffee_maker_true_button.addActionListener(this);
						coffee_maker_false_button.addActionListener(this);
				
				//Radio buttons for choosing dryer
					dryer_true_button = new JRadioButton();
					dryer_true_button.setFocusable(false);
					dryer_false_button = new JRadioButton();
					dryer_false_button.setFocusable(false);
					//Groupby buttons to choose only one
						ButtonGroup dryer_group = new ButtonGroup();
						dryer_group.add(tv_true_button);
						dryer_group.add(tv_false_button);
					//add action listener to the buttons
						dryer_true_button.addActionListener(this);
						dryer_false_button.addActionListener(this);
				
				//Radio buttons for choosing hair iron
					hair_iron_true_button = new JRadioButton();
					hair_iron_true_button.setFocusable(false);
					hair_iron_false_button = new JRadioButton();
					hair_iron_false_button.setFocusable(false);
					//Groupby buttons to choose only one
						ButtonGroup hair_iron_group = new ButtonGroup();
						hair_iron_group.add(tv_true_button);
						hair_iron_group.add(tv_false_button);
					//add action listener to the buttons
						hair_iron_true_button.addActionListener(this);
						hair_iron_false_button.addActionListener(this);
						
				//Radio buttons for choosing ac_voltage
						ac_voltage_true_button = new JRadioButton();
						ac_voltage_true_button.setFocusable(false);
						ac_voltage_false_button = new JRadioButton();
						ac_voltage_false_button.setFocusable(false);
						//Groupby buttons to choose only one
							ButtonGroup ac_voltage_group = new ButtonGroup();
							ac_voltage_group.add(ac_voltage_true_button);
							ac_voltage_group.add(ac_voltage_false_button);
						//add action listener to the buttons
							ac_voltage_true_button.addActionListener(this);
							ac_voltage_false_button.addActionListener(this);
							
				//Radio buttons for usb_a statements
						usb_a_true_button = new JRadioButton();
						usb_a_true_button.setFocusable(false);
						usb_a_false_button = new JRadioButton();
						usb_a_false_button.setFocusable(false);
						//Groupby buttons to choose only one
							ButtonGroup usb_a_group = new ButtonGroup();
							usb_a_group.add(usb_a_true_button);
							usb_a_group.add(usb_a_false_button);
						//add action listener to the buttons
							usb_a_true_button.addActionListener(this);
							usb_a_false_button.addActionListener(this);
				
				//Radio buttons for usb_c statements
						usb_c_true_button = new JRadioButton();
						usb_c_true_button.setFocusable(false);
						usb_c_false_button = new JRadioButton();
						usb_c_false_button.setFocusable(false);
						//Groupby buttons to choose only one
							ButtonGroup usb_c_group = new ButtonGroup();
							usb_c_group.add(usb_c_true_button);
							usb_c_group.add(usb_c_false_button);
						//add action listener to the buttons
							usb_c_true_button.addActionListener(this);
							usb_c_false_button.addActionListener(this);
				
				//Radio buttons for breakfast statements
						breakfast_true_button = new JRadioButton();
						breakfast_true_button.setFocusable(false);
						breakfast_false_button = new JRadioButton();
						breakfast_false_button.setFocusable(false);
						//Groupby buttons to choose only one
							ButtonGroup breakfast_group = new ButtonGroup();
							breakfast_group.add(breakfast_true_button);
							breakfast_group.add(breakfast_false_button);
						//add action listener to the buttons
							breakfast_true_button.addActionListener(this);
							breakfast_false_button.addActionListener(this);
								
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
					//1st row
					air_conditioner_true_button.setIcon(confirmation_icon);
					air_conditioner_false_button.setIcon(cancelation_icon);	
					
					heating_true_button.setIcon(confirmation_icon);
					heating_false_button.setIcon(cancelation_icon);	
					
					tv_true_button.setIcon(confirmation_icon);
					tv_false_button.setIcon(cancelation_icon);
					
					//2 row
					coffee_maker_true_button.setIcon(confirmation_icon);
					coffee_maker_false_button.setIcon(cancelation_icon);
					
					dryer_true_button.setIcon(confirmation_icon);
					dryer_false_button.setIcon(cancelation_icon);
					
					hair_iron_true_button.setIcon(confirmation_icon);
					hair_iron_false_button.setIcon(cancelation_icon);
					
					//3 row
					ac_voltage_true_button.setIcon(confirmation_icon);
					ac_voltage_false_button.setIcon(cancelation_icon);
					
					usb_a_true_button.setIcon(confirmation_icon);
					usb_a_false_button.setIcon(cancelation_icon);
					
					usb_c_true_button.setIcon(confirmation_icon);
					usb_c_false_button.setIcon(cancelation_icon);
					
					//4 row
					breakfast_true_button.setIcon(confirmation_icon);
					breakfast_false_button.setIcon(cancelation_icon);
					//1st row panel
						JPanel first_row_panel = new JPanel(new BorderLayout());
						first_row_panel.setBounds(45, 170, 600, 50);
						first_row_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
						first_row_panel.setBackground(Color.black);
			//sub panels holders for button groups
				//air_conditioner holder
						String air_conditioner_holder_str = "<html> Do you want <b><u>air_conditioner?</u> </b></html>";
						SubReservation_generic_holder air_conditioner_holder = new SubReservation_generic_holder(air_conditioner_true_button, 
								air_conditioner_false_button, air_conditioner_holder_str);
								
				//heating holder	
						String heating_holder_str = "<html> Do you want <b><u>heating?</u> </b></html>";
						SubReservation_generic_holder heating_holder = new SubReservation_generic_holder(heating_true_button,
								heating_false_button, heating_holder_str);
								
				//tv_holder
						String tv_holder_str = "<html> Do you want <b><u>tv?</u> </b></html>";
						SubReservation_generic_holder tv_holder = new SubReservation_generic_holder(tv_true_button,
								tv_false_button, tv_holder_str);
						
					//adding holders to first row panel
						first_row_panel.add(air_conditioner_holder, BorderLayout.EAST);
						first_row_panel.add(heating_holder, BorderLayout.CENTER);
						first_row_panel.add(tv_holder, BorderLayout.WEST);
					
					//2nd row panel
						JPanel second_row_panel = new JPanel(new BorderLayout());
						second_row_panel.setBounds(45, 170, 600, 50);
						second_row_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
						second_row_panel.setBackground(Color.black);
			//sub panels holders for button groups
				//air_conditioner holder
						String coffee_maker_str = "<html> Do you want <b><u>coffee maker?</u> </b></html>";
						SubReservation_generic_holder coffee_maker_holder = new SubReservation_generic_holder(coffee_maker_true_button, 
								coffee_maker_false_button, coffee_maker_str);
								
				//heating holder	
						String dryer_holder_str = "<html> Do you want <b><u>dryer?</u> </b></html>";
						SubReservation_generic_holder dryer_holder = new SubReservation_generic_holder(dryer_true_button,
								dryer_false_button, dryer_holder_str);
								
				//tv_holder
						String hair_iron_holder_str = "<html> Do you want <b><u>hair iron?</u> </b></html>";
						SubReservation_generic_holder hair_iron_holder = new SubReservation_generic_holder(hair_iron_true_button,
								hair_iron_false_button, hair_iron_holder_str);
						
					//adding holders to first row panel
						second_row_panel.add(coffee_maker_holder, BorderLayout.EAST);
						second_row_panel.add(dryer_holder, BorderLayout.CENTER);
						second_row_panel.add(hair_iron_holder, BorderLayout.WEST);
						
					//2nd row panel
						JPanel third_row_panel = new JPanel(new BorderLayout());
						third_row_panel.setBounds(45, 170, 600, 50);
						third_row_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
						third_row_panel.setBackground(Color.black);
						
			//sub panels holders for button groups
				//ac voltage holder
						String ac_voltage_str = "<html> Do you want <b><u>ac voltage?</u> </b></html>";
						SubReservation_generic_holder ac_voltage_holder = new SubReservation_generic_holder(ac_voltage_true_button, 
								ac_voltage_false_button, ac_voltage_str);
								
				//usb a holder	
						String usb_a_str = "<html> Do you want <b><u>usb a?</u> </b></html>";
						SubReservation_generic_holder usb_a_holder = new SubReservation_generic_holder(usb_a_true_button,
								usb_a_false_button, usb_a_str);
								
				//usb_c holder
						String usb_c_holder_str = "<html> Do you want <b><u>usb c?</u> </b></html>";
						SubReservation_generic_holder usb_c_holder = new SubReservation_generic_holder(usb_c_true_button,
								usb_c_false_button, usb_c_holder_str);
						
					//adding holders to first row panel
						third_row_panel.add(ac_voltage_holder, BorderLayout.EAST);
						third_row_panel.add(usb_a_holder, BorderLayout.CENTER);
						third_row_panel.add(usb_c_holder, BorderLayout.WEST);
				
				JPanel fourth_row_panel = new JPanel(new BorderLayout());
					fourth_row_panel.setBounds(45, 170, 600, 50);
					fourth_row_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
					fourth_row_panel.setBackground(Color.black);
					
				//breakfast holder
				String breakfast_holder_str = "<html> Do you want <b><u>breakfast?</u> </b></html>";
				SubReservation_generic_holder breakfast_holder = new SubReservation_generic_holder(breakfast_true_button,
						breakfast_false_button, breakfast_holder_str);
				//size in m¨2 of room 
				//Radio buttons for choosing bed type
				String [] room_sizes = {">50 mtrs", "100mtrs< and <150mtrs", "150 mtrs< and <200 mtrs", "> 200 mtrs"};
				comboBoxRoomSize = new JComboBox<Object>(room_sizes);
				comboBoxRoomSize.addActionListener(this);
				
				String room_sizes_str = "<html> How big do you want your <b><u>room size?</u> </b></html>";
				SubReservation_generic_holder2 room_sizes_holder = new SubReservation_generic_holder2(room_sizes_str,
						comboBoxRoomSize);
				
			fourth_row_panel.add(breakfast_holder, BorderLayout.EAST);
			fourth_row_panel.add(room_sizes_holder, BorderLayout.WEST);	
		
			Border outerborderbutton = BorderFactory.createLineBorder(Color.CYAN, 2);
			Border innerborderbutton = BorderFactory.createEmptyBorder(3, 3, 3, 3);
			compoundBorderbutton = BorderFactory.createCompoundBorder(outerborderbutton, innerborderbutton);
			
			this.setVisible(false);
			//adding components to the panel	
				this.add(instructions_label);
				this.add(first_row_panel);
				this.add(second_row_panel);
				this.add(third_row_panel);
				this.add(fourth_row_panel);
				

		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//1st row
			if(e.getSource() == tv_true_button) {
				tv_property = true;
				tv_false_button.setBorder(new EmptyBorder(2, 2, 2, 2));
				tv_true_button.setBorder(compoundBorderbutton);
			}
			if(e.getSource() == tv_false_button) {
				tv_property = false;
				tv_true_button.setBorder(new EmptyBorder(2, 2, 2, 2));
				tv_false_button.setBorder(compoundBorderbutton);
			}
			if(e.getSource() == heating_true_button) {
				heating_property = true;
				heating_false_button.setBorder(new EmptyBorder(2, 2, 2, 2));
				heating_true_button.setBorder(compoundBorderbutton);
			}
			if(e.getSource() == heating_false_button) {
				heating_property = false;
				heating_true_button.setBorder(new EmptyBorder(2, 2, 2, 2));
				heating_false_button.setBorder(compoundBorderbutton);
			}
			if(e.getSource() == air_conditioner_true_button) {
				air_conditioner_property = true;
				air_conditioner_false_button.setBorder(new EmptyBorder(2, 2, 2, 2));
				air_conditioner_true_button.setBorder(compoundBorderbutton);
			}
			if(e.getSource() == air_conditioner_false_button) {
				air_conditioner_property = false;
				air_conditioner_true_button.setBorder(new EmptyBorder(2, 2, 2, 2));
				air_conditioner_false_button.setBorder(compoundBorderbutton);
			}
			
			//2nd row
			if(e.getSource() == coffee_maker_true_button) {
				coffee_maker_property = true;
				coffee_maker_false_button.setBorder(new EmptyBorder(2, 2, 2, 2));
				coffee_maker_true_button.setBorder(compoundBorderbutton);
			}
			if(e.getSource() == coffee_maker_false_button) {
				coffee_maker_property = false;
				coffee_maker_true_button.setBorder(new EmptyBorder(2, 2, 2, 2));
				coffee_maker_false_button.setBorder(compoundBorderbutton);
			}
			if(e.getSource() == dryer_true_button) {
				dryer_property = true;
				dryer_false_button.setBorder(new EmptyBorder(2, 2, 2, 2));
				dryer_true_button.setBorder(compoundBorderbutton);
			}
			if(e.getSource() == dryer_false_button) {
				dryer_property = false;
				dryer_true_button.setBorder(new EmptyBorder(2, 2, 2, 2));
				dryer_false_button.setBorder(compoundBorderbutton);
			}
			if(e.getSource() == hair_iron_true_button) {
				hair_iron_property = true;
				hair_iron_false_button.setBorder(new EmptyBorder(2, 2, 2, 2));
				hair_iron_true_button.setBorder(compoundBorderbutton);
			}
			if(e.getSource() == hair_iron_false_button) {
				hair_iron_property = false;
				hair_iron_true_button.setBorder(new EmptyBorder(2, 2, 2, 2));
				hair_iron_false_button.setBorder(compoundBorderbutton);
			}
			
			//3rd row 
			if(e.getSource() == ac_voltage_true_button) {
				ac_voltage_property = true;
				ac_voltage_false_button.setBorder(new EmptyBorder(2, 2, 2, 2));
				ac_voltage_true_button.setBorder(compoundBorderbutton);
			}
			if(e.getSource() == ac_voltage_false_button) {
				ac_voltage_property = false;
				ac_voltage_true_button.setBorder(new EmptyBorder(2, 2, 2, 2));
				ac_voltage_false_button.setBorder(compoundBorderbutton);
			}
			if(e.getSource() == usb_a_true_button) {
				usb_a_property = true;
				usb_a_false_button.setBorder(new EmptyBorder(2, 2, 2, 2));
				usb_a_true_button.setBorder(compoundBorderbutton);
			}
			if(e.getSource() == usb_a_false_button) {
				usb_a_property = false;
				usb_a_true_button.setBorder(new EmptyBorder(2, 2, 2, 2));
				usb_a_false_button.setBorder(compoundBorderbutton);
			}
			if(e.getSource() == usb_c_true_button) {
				usb_c_property = true;
				usb_c_false_button.setBorder(new EmptyBorder(2, 2, 2, 2));
				usb_c_true_button.setBorder(compoundBorderbutton);
			}
			if(e.getSource() == usb_c_false_button) {
				usb_c_property = false;
				usb_c_true_button.setBorder(new EmptyBorder(2, 2, 2, 2));
				usb_c_false_button.setBorder(compoundBorderbutton);
			}
			
			//4th row 
			if(e.getSource() == breakfast_true_button) {
				breakfast_property = true;
				breakfast_false_button.setBorder(new EmptyBorder(2, 2, 2, 2));
				breakfast_true_button.setBorder(compoundBorderbutton);
			}
			if(e.getSource() == breakfast_false_button) {
				breakfast_property = false;
				breakfast_true_button.setBorder(new EmptyBorder(2, 2, 2, 2));
				breakfast_false_button.setBorder(compoundBorderbutton);
			}
			if(e.getSource() == comboBoxRoomSize) {
				String room_size_aux = (String) comboBoxRoomSize.getSelectedItem();
				if(room_size_aux.equals(">50 mtrs")) {
					room_size = "50_100";
				}
				else if(room_size_aux.equals("100mtrs< and <150mtrs")) {
					room_size = "101_149";
				}
				else if(room_size_aux.equals("150 mtrs< and <200 mtrs")) {
					room_size = "150_200";
				}
				else {room_size = "200_1000";}
			}
		}
		
		//1st row
		public boolean getHeatingProperty() {
			if(heating_property ==  null) {heating_property = false;}
			return heating_property;
		}
		public boolean getTvProperty() {
			if(tv_property ==  null) {tv_property = false;}
			return tv_property;
		}
		public boolean getAir_conditionerProperty() {
			if(air_conditioner_property ==  null) {air_conditioner_property = false;}
			return air_conditioner_property;
		}
		
		//2nd row
		public boolean getCoffee_maker_property() {
			if(coffee_maker_property ==  null) {coffee_maker_property = false;}
			return coffee_maker_property;
		}
		public boolean getDryer_property() {
			if(dryer_property ==  null) {dryer_property = false;}
			return dryer_property;
		}
		public boolean getHair_iron_property() {
			if(hair_iron_property ==  null) {hair_iron_property = false;}
			return hair_iron_property;
		}
		
		//3rd row
		public boolean getAc_voltage_property() {
			if(ac_voltage_property ==  null) {ac_voltage_property = false;}
			return ac_voltage_property;
		}
		public boolean getUsb_a_property() {
			if(usb_a_property ==  null) {usb_a_property = false;}
			return usb_a_property;
		}
		public boolean getUsb_c_property() {
			if(usb_c_property ==  null) {usb_c_property = false;}
			return usb_c_property;
		}
		//4th row
		public boolean getBreakfast_property() {
			if(breakfast_property ==  null) {breakfast_property = false;}
			return breakfast_property;
		}
		public String getRoom_size() {
			return room_size;
		}
}

