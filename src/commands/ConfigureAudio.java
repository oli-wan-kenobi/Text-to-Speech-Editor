package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Document;

public class ConfigureAudio implements ActionListener {

	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	
	private Document document;
	
	public ConfigureAudio() {
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		document = Document.getInstance();
		
		String[] default_values = document.getDefaultValues();
		
		JFrame frame = new JFrame("Speech Configuration");
		frame.setBounds(100, 100, 300, 150);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		textField = new JTextField();
		textField.setBounds(147, 0, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(true);
		textField.setText(default_values[0]);
		textField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!textField.getText().equals(default_values[0])) {
					System.out.println("Volume changed from "+default_values[0]+" to "+ textField.getText());
					
					document.setConfigValues("volume",textField.getText());
				}
			}
			
		});
		textField.setVisible(true);
		
		JLabel volumeLabel = new JLabel("Volume");
		volumeLabel.setBounds(25, 3, 46, 14);
		frame.getContentPane().add(volumeLabel);
		
		JLabel rateLabel = new JLabel("Rate");
		rateLabel.setBounds(25, 28, 46, 14);
		frame.getContentPane().add(rateLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 25, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(true);
		textField_1.setText(default_values[1]);
		textField_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!textField_1.getText().equals(default_values[0])) {
					System.out.println("Rate changed from "+default_values[0]+" to "+ textField_1.getText());
					
					document.setConfigValues("rate",textField_1.getText());
				}
			}
			
		});
		textField_1.setVisible(true);
		
		JLabel pitchLabel = new JLabel("Pitch");
		pitchLabel.setBounds(25, 53, 46, 14);
		frame.getContentPane().add(pitchLabel);
		pitchLabel.setVisible(true);
		
		textField_2 = new JTextField();
		textField_2.setBounds(147, 56, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEditable(true);
		textField_2.setText(default_values[2]);
		textField_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!textField_2.getText().equals(default_values[0])) {
					System.out.println("Pitch changed from "+default_values[0]+" to "+ textField_2.getText());
					
					document.setConfigValues("pitch",textField_2.getText());
				}
			}
		});
		textField_2.setVisible(true);
	}

}
