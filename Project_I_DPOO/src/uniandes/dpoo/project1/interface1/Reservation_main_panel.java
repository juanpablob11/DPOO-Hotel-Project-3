package uniandes.dpoo.project1.interface1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

import uniandes.dpoo.project1.interface1.buttons.capture_dates_button;
import uniandes.dpoo.project1.interface1.buttons.exit_button;
import uniandes.dpoo.project1.interface1.buttons.go_back_reservation_center_button;
import uniandes.dpoo.project1.interface1.labels.background_label;
import uniandes.dpoo.project1.interface1.labels.upper_label;
import uniandes.dpoo.project1.interface1.panels.UserPanel;
import uniandes.dpoo.project1.interface1.panels.advanced_filters_panel;
import uniandes.dpoo.project1.interface1.panels.button_panel_holder;
import uniandes.dpoo.project1.interface1.panels.show_available_rooms_panel;

public class Reservation_main_panel extends JFrame  implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//instantation of buttons and icons for buttons
	app mycontroller = new app();
		JLayeredPane layeredPane;

		//images
		ImageIcon reservation_icon;
		ImageIcon cancelation_icon;

		//labels
		uniandes.dpoo.project1.interface1.labels.info_label info_label;
		
		//buttons
		capture_dates_button capture_dates_button;
		JRadioButton reservation;
		JRadioButton cancelation;
		exit_button exitbutton;
		go_back_reservation_center_button exitbutton1;
		
		//panels
		button_panel_holder panel;
		uniandes.dpoo.project1.interface1.panels.reservation_panel reservation_panel;
		uniandes.dpoo.project1.interface1.panels.cancelation_panel cancelation_panel;
		uniandes.dpoo.project1.interface1.panels.sub_reservation_panel sub_reservation_panel;
		
		//global variables
		Integer first_year = 2023;
		Integer second_year = 2023;
		Integer first_month = 0;
		Integer second_month = 0;
		Integer first_day;
		Integer second_day;
		
		Boolean kitchen_property;
		Boolean view_property;
		Boolean balcony_property;
		Integer num_beds;
		String room_type;
		String beds_type;
		
		exit_button capture_info;
		exit_button capture_info2;
		exit_button filter_advanced;
		
		advanced_filters_panel advanced_filters_panel;
		
		String initialDate, finalDate;
		Boolean tv_property, heating_property, air_conditioner_property,
		coffee_maker_property, dryer_property, hair_iron_property,
		ac_voltage_property, usb_a_property, usb_c_property,
		breakfast_property;
		String meters_square;
		
		show_available_rooms_panel show_available_rooms_panel;
		List<Integer> id_available;
		
		exit_button show_available_rooms;
		
		UserPanel UserPanel;
		
		String userName, userMail, userPhone;
		Integer selected_id;
		
	//constructor
	public Reservation_main_panel() throws FileNotFoundException, IOException{
		mycontroller.loadfiles();
	
		//Attributes of the JPanel
		this.setTitle("Reservation center-Hotel App-"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closing mode
		this.setResizable(false);
		this.setSize(1000,600);
		this.setVisible(true);
		
		//Setting icon for the principal window
		ImageIcon imageforwindow = new ImageIcon("data/images/reservation_icon.jpg"); //creating an imgicon object
		this.setIconImage(imageforwindow.getImage()); //setting the icon to the actual panel with this
		
		//Setting background color
		//this.getContentPane().setBackground(new Color(60,34,0));
		
		//JLayeredPane for the background to appear behind everything
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 50, 1000, 650);
		//Jlabels
			//upper_label
			upper_label upper_label = new upper_label();
			upper_label.setVisible(true);
			//Label for background picture
			background_label background_label = new background_label();
			layeredPane.add(background_label, JLayeredPane.DEFAULT_LAYER);
			
		//Radio buttons with pictures
				reservation = new JRadioButton();
				reservation.setFocusable(false);
				cancelation = new JRadioButton();
				cancelation.setFocusable(false);
				//Groupby buttons to choose only one
					ButtonGroup group = new ButtonGroup();
					group.add(reservation);
					group.add(cancelation);
				//add actionlistener to the buttons
					reservation.addActionListener(this);
					cancelation.addActionListener(this); 
				//add icon to the buttons
					// resize reservation icon
					ImageIcon reservation_icon = new ImageIcon("data/images/reserved_button.jpg");
					Image reservation_image = reservation_icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
					reservation_icon = new ImageIcon(reservation_image);

					// resize cancellation icon
					ImageIcon cancelation_icon = new ImageIcon("data/images/cancelation_button.jpg");
					Image cancelation_image = cancelation_icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
					cancelation_icon = new ImageIcon(cancelation_image);

					// set icons for JRadioButtons
					reservation.setIcon(reservation_icon);
					cancelation.setIcon(cancelation_icon);

					//add buttons to the panel
					JPanel buttonPanel = new JPanel();
					buttonPanel.add(reservation);
					buttonPanel.add(cancelation);
					buttonPanel.setBackground(Color.black);
					buttonPanel.setOpaque(true);
					
				//creating a panel to add buttons and then add the panel to the layeredPane
				//creating a label to write text in the upper part   
					panel = new button_panel_holder(buttonPanel);	
				layeredPane.add(panel, JLayeredPane.DRAG_LAYER);
				
			//adding label to write instructions and info for reservation
				info_label = new uniandes.dpoo.project1.interface1.labels.info_label();
				layeredPane.add(info_label, JLayeredPane.DRAG_LAYER);
		
			//return to last frame button
			String go_to_reservation_center = "Exit from Reservation Center";
			exitbutton = new exit_button(go_to_reservation_center);
			exitbutton.addActionListener(e -> this.setVisible(false));
			layeredPane.add(exitbutton, JLayeredPane.DRAG_LAYER);
			
			//return to reservation center from booking module with a button
			exitbutton1 = new go_back_reservation_center_button();
			exitbutton1.addActionListener(this);
			exitbutton1.setVisible(false);
			layeredPane.add(exitbutton1, JLayeredPane.DRAG_LAYER);
			
			//Reservation part
				//reservation panel
					reservation_panel = new uniandes.dpoo.project1.interface1.panels.reservation_panel(mycontroller);
					layeredPane.add(reservation_panel, JLayeredPane.DRAG_LAYER);
				//capturing the first dates with the button
					capture_dates_button = new capture_dates_button();
					capture_dates_button.addActionListener(this);
					layeredPane.add(capture_dates_button, JLayeredPane.DRAG_LAYER);
					
					String message_to_capture = "Show me the available rooms";
					capture_info = new exit_button(message_to_capture);
					capture_info.setBounds(80, 450, 260, 40);
					capture_info.addActionListener(this);
					capture_info.setVisible(false);
					layeredPane.add(capture_info, JLayeredPane.DRAG_LAYER);
					
					String message_to_capture2 = "Use advanced filters";
					capture_info2 = new exit_button(message_to_capture2);
					capture_info2.setBounds(450, 450, 200, 40);
					capture_info2.addActionListener(this);
					capture_info2.setVisible(false);
					layeredPane.add(capture_info2, JLayeredPane.DRAG_LAYER);
					
					String message_to_filter_advanced = "Show me available rooms with advanced filters";
					filter_advanced = new exit_button(message_to_filter_advanced);
					filter_advanced.setBounds(450, 510, 300, 40);
					filter_advanced.addActionListener(this);
					filter_advanced.setVisible(false);
					layeredPane.add(filter_advanced, JLayeredPane.DRAG_LAYER);
					
					//showing new panel for choosing the characteristics of your room
					sub_reservation_panel = new uniandes.dpoo.project1.interface1.panels.sub_reservation_panel(mycontroller);
					layeredPane.add(sub_reservation_panel, JLayeredPane.DRAG_LAYER);
					
					advanced_filters_panel = new advanced_filters_panel(mycontroller);
					layeredPane.add(advanced_filters_panel, JLayeredPane.DRAG_LAYER);
					
					String message_to_show_available_rooms = "Finish process of reservation";
					show_available_rooms = new exit_button(message_to_show_available_rooms);
					show_available_rooms.setBounds(350, 450, 270, 40);
					show_available_rooms.addActionListener(this);
					show_available_rooms.setVisible(false);
					layeredPane.add(show_available_rooms, JLayeredPane.DRAG_LAYER);
					
					UserPanel = new UserPanel();
					UserPanel.setVisible(false);
					layeredPane.add(UserPanel, JLayeredPane.DRAG_LAYER);
		//Cancellation part
			//Cancellation panel
			cancelation_panel = new uniandes.dpoo.project1.interface1.panels.cancelation_panel(mycontroller);
		layeredPane.add(cancelation_panel, JLayeredPane.DRAG_LAYER);
		//adding all components to frame
		this.add(upper_label);
		this.add(layeredPane);
		
	}
	
	//action performed function for functionality
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == reservation) {
			//Disappearing all main components to make space for reservation components
			info_label.setVisible(false);
			exitbutton.setVisible(false);
			panel.setVisible(false);
			//return to reservation center from booking module with a button
			exitbutton1.setVisible(true);
			reservation_panel.setVisible(true);
			capture_dates_button.setVisible(true);
		}
		if (e.getSource() == cancelation) {
			//Disappearing all main components to make space for cancellation components
			info_label.setVisible(false);
			exitbutton.setVisible(false);
			panel.setVisible(false);
			//return to reservation center from booking module with a button
			exitbutton1.setVisible(true);
			if(cancelation_panel != null) {
			cancelation_panel.setVisible(true);
			}
		}
		if(e.getSource() == exitbutton1) {
			info_label.setVisible(true);
			exitbutton.setVisible(true);
			panel.setVisible(true);
			exitbutton1.setVisible(false);
			if(reservation_panel != null) {
			reservation_panel.setVisible(false);
			}
			if(cancelation_panel != null) {
			cancelation_panel.setVisible(false);
			capture_dates_button.setVisible(false);
			}
		}
		if(e.getSource() == capture_dates_button) {
			//getting info from buttons
				first_year = reservation_panel.getFirstYear();
				second_year = reservation_panel.getSecondYear();
				first_month = reservation_panel.getFirstMonth();
				second_month = reservation_panel.getSecondMonth();
				first_day = reservation_panel.getFirstDay();
				second_day = reservation_panel.getSecondDay();
				
			//hiding old labels and showing the new ones
				if(first_day == null || second_day == null) {
					JOptionPane.showMessageDialog(null, "You can´t continue without selecting all the dates info",
							"Dates Error", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					initialDate = first_year + "-" + (first_month+1) + "-" + (first_day+1);
					finalDate = second_year + "-" + (second_month+1) + "-" + (second_day+1);
				if(reservation_panel != null) {
					reservation_panel.setVisible(false);
					}
				exitbutton1.setVisible(false);
				sub_reservation_panel.setVisible(true);
				capture_dates_button.setVisible(false);
				
				capture_info.setVisible(true);
				capture_info2.setVisible(true);
			}
		}
		if(e.getSource() == capture_info2) { //USE ADVANCED FILTERS BUTTON 
			//getting info from buttons
			kitchen_property = sub_reservation_panel.getKitchenProperty();
			view_property = sub_reservation_panel.getViewProperty();
			balcony_property = sub_reservation_panel.getBalconyProperty();
				num_beds = sub_reservation_panel.getNumBedsProperty();
				room_type = sub_reservation_panel.getRoom_typeProperty();
				beds_type = sub_reservation_panel.getBeds_typeProperty();
			//hiding old labels and showing the new ones
				if(num_beds == null || room_type == null || beds_type == null || kitchen_property == null ||
					view_property == null || balcony_property == null) {
					JOptionPane.showMessageDialog(null, "You can´t continue with advanced filtering "
							+ "without selecting all basic properties to filter your room",
							"Properties Error", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					//CHECK LINES 274 UNTIL 278!!!!!!!!!!!!!!!!!!!!!!!!!!!	
				if(sub_reservation_panel != null) {
					sub_reservation_panel.setVisible(false);
					}
				advanced_filters_panel.setVisible(true);
				filter_advanced.setVisible(true);
				capture_info.setVisible(false);
				capture_info2.setVisible(false);
			}
				
		}
		if(e.getSource() == filter_advanced) { //show available rooms with advanced filters
			tv_property = advanced_filters_panel.getTvProperty();
			heating_property = advanced_filters_panel.getHeatingProperty();
			air_conditioner_property = advanced_filters_panel.getAir_conditionerProperty();
			coffee_maker_property = advanced_filters_panel.getCoffee_maker_property();
			dryer_property = advanced_filters_panel.getDryer_property();
			hair_iron_property = advanced_filters_panel.getHair_iron_property();
			ac_voltage_property = advanced_filters_panel.getAc_voltage_property();
			usb_a_property = advanced_filters_panel.getUsb_a_property();
			usb_c_property = advanced_filters_panel.getUsb_c_property();
			breakfast_property = advanced_filters_panel.getBreakfast_property();
			meters_square = advanced_filters_panel.getRoom_size();
			
			if(meters_square == null ) {
					JOptionPane.showMessageDialog(null, "You can´t continue with advanced filtering "
							+ "without selecting all basic properties to filter your room",
							"Properties Error", JOptionPane.INFORMATION_MESSAGE);
				}
			else {
				advanced_filters_panel.setVisible(false);
				filter_advanced.setVisible(false);
				show_available_rooms.setVisible(true);
				
			 id_available = mycontroller.getRoomsAvailableAdvanced(initialDate, finalDate, room_type,
					kitchen_property, view_property, balcony_property, beds_type,
					num_beds, tv_property, heating_property, air_conditioner_property,
					coffee_maker_property, dryer_property, hair_iron_property,
					ac_voltage_property, usb_a_property, usb_c_property,
					breakfast_property, meters_square);
			 
			 show_available_rooms_panel = new show_available_rooms_panel(mycontroller, id_available);
				layeredPane.add(show_available_rooms_panel, JLayeredPane.DRAG_LAYER);
				show_available_rooms.setVisible(true);
				show_available_rooms_panel.setVisible(true);
				UserPanel.setVisible(true);
			}
		}
		if(e.getSource() == capture_info) { //show available rooms without advanced filters
			reservation_panel.setVisible(false);
			capture_info.setVisible(false);
			capture_info2.setVisible(false);
			if(sub_reservation_panel != null) {
				sub_reservation_panel.setVisible(false);
				}
			
			//getting info from buttons
			 kitchen_property = sub_reservation_panel.getKitchenProperty();
			 view_property = sub_reservation_panel.getViewProperty();
			 balcony_property = sub_reservation_panel.getBalconyProperty();
				num_beds = sub_reservation_panel.getNumBedsProperty();
				room_type = sub_reservation_panel.getRoom_typeProperty();
				beds_type = sub_reservation_panel.getBeds_typeProperty();
			//hiding old labels and showing the new ones
				if(num_beds == null || room_type == null || beds_type == null || kitchen_property == null ||
					view_property == null || balcony_property == null) {
					JOptionPane.showMessageDialog(null, "You can´t continue with advanced filtering "
							+ "without selecting all basic properties to filter your room",
							"Properties Error", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
				id_available = mycontroller.getRoomsAvailableBasic(initialDate, finalDate, room_type,
					kitchen_property, view_property, balcony_property, beds_type, num_beds);
				
				show_available_rooms_panel = new show_available_rooms_panel(mycontroller, id_available);
				layeredPane.add(show_available_rooms_panel, JLayeredPane.DRAG_LAYER);
				show_available_rooms.setVisible(true);
				show_available_rooms_panel.setVisible(true);
				UserPanel.setVisible(true);
				}
		}
		if(e.getSource() == show_available_rooms) {
			userName = UserPanel.getName();
			userMail = UserPanel.getMail();
			userPhone = UserPanel.getPhone();
			selected_id = Integer.parseInt(show_available_rooms_panel.getIdSelected());
			
			mycontroller.createNewBooking(initialDate, finalDate,
					userName, userMail, userPhone, selected_id);
			JOptionPane.showMessageDialog(null, "Congrats, we´ll wait you " + userName + " with phone " + userPhone +
					". We also hope good vacations in our hotel!",
					"Successful reservation", JOptionPane.INFORMATION_MESSAGE);
			show_available_rooms_panel.setVisible(false);
			UserPanel.setVisible(false);
			show_available_rooms.setVisible(false);
			
			info_label.setVisible(true);
			exitbutton.setVisible(true);
			panel.setVisible(true);
		}
	}
	
}
