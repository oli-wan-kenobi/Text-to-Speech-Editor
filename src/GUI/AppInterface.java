package GUI;


import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import commands.CommandsFactory;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class AppInterface {

	private JFrame frame;
	private JTextField textField_2;
	private JTextField textField_1;
	
	public JToolBar toolBar;
	public JButton buttons[];
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppInterface window = new AppInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppInterface() {
		frame = new JFrame("AdvancedTextToSpeechEditor");
		frame.setBounds(1000, 300, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CommandsFactory commands_factory = new CommandsFactory();
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu file_Menu = new JMenu(" File ");
		menuBar.add(file_Menu);
		
		
		JMenu open_Menu = new JMenu("Open");
		file_Menu.add(open_Menu);
		
		JMenuItem open_Atbash = new JMenuItem("with Atbash");
		ActionListener open_Atbash_listener = commands_factory.createCommand("OpenDocument","Atbash",textArea,null,null,null);
		open_Atbash.addActionListener(open_Atbash_listener);
		open_Menu.add(open_Atbash);
		
		JMenuItem open_Rot_13 = new JMenuItem("with Rot-13");
		ActionListener open_Rot_13_listener = commands_factory.createCommand("OpenDocument","Rot-13",textArea,null,null,null);
		open_Rot_13.addActionListener(open_Rot_13_listener);
		open_Menu.add(open_Rot_13);
		
		JMenuItem open_default = new JMenuItem("None");
		ActionListener open_default_listener = commands_factory.createCommand("OpenDocument","None",textArea,null,null,null);
		open_default.addActionListener(open_default_listener);
		open_Menu.add(open_default);
		
		
		JMenu save_Menu = new JMenu("Save");
		file_Menu.add(save_Menu);
		
		JMenuItem save_Atbash = new JMenuItem("with Atbash");
		ActionListener save_Atbash_listener = commands_factory.createCommand("SaveDocument","Atbash",textArea,null,null,null);
		save_Atbash.addActionListener(save_Atbash_listener);
		save_Menu.add(save_Atbash);
		
		JMenuItem save_Rot_13 = new JMenuItem("with Rot-13");
		ActionListener save_Rot_13_listener = commands_factory.createCommand("SaveDocument","Rot-13",textArea,null,null,null);
		save_Rot_13.addActionListener(save_Rot_13_listener);
		save_Menu.add(save_Rot_13);
		
		JMenuItem save_default = new JMenuItem("None");
		ActionListener save_default_listener = commands_factory.createCommand("SaveDocument","None",textArea,null,null,null);
		save_default.addActionListener(save_default_listener);
		save_Menu.add(save_default);
		
		JMenuItem closeMenuItem = new JMenuItem("Close");
		ActionListener closeMenuItemListener = commands_factory.createCommand("CloseDocument","",textArea,null,null,null);
		closeMenuItem.addActionListener(closeMenuItemListener);
		file_Menu.add(closeMenuItem);
		
		toolBar = new JToolBar();
		toolBar.setEnabled(false);
		toolBar.setVisible(false);
		toolBar.setFloatable(false);
		
		textField_1 = new JTextField();
		textField_2 = new JTextField();
		JTextField[] txtfields = {textField_1,textField_2};
		
		JButton play = new JButton(" Play ");
		play.setEnabled(true);
		ActionListener playButtonListener = commands_factory.createCommand("PlayAudio","",textArea,null,null,txtfields);
		play.addActionListener(playButtonListener);
		
		JButton replay = new JButton(" Replay ");
		replay.setEnabled(true);
		ActionListener replayButtonListener = commands_factory.createCommand("ReplayAudio","",textArea,null,null,null);
		replay.addActionListener(replayButtonListener);
		
		
		JButton record = new JButton(" Record ");
		ActionListener recordButtonListener = commands_factory.createCommand("RecordAudio","",textArea,null,null,null);
		record.addActionListener(recordButtonListener);
		record.setEnabled(true);
		
		
		JButton config = new JButton(" Config ");
		ActionListener configButtonListener = commands_factory.createCommand("ConfigureAudio","",textArea,null,null,null);
		config.addActionListener(configButtonListener);
		config.setEnabled(true);
		
		buttons = new JButton[] {play,replay,record,config};
		JButton audio = new JButton("Audio");
		ActionListener audioButtonListener = commands_factory.createCommand("AudioCommand","",textArea,toolBar,buttons,null);
		audio.addActionListener(audioButtonListener);
		menuBar.add(audio);
		
		menuBar.add(toolBar);	
		toolBar.add(play);
		
		JLabel lblNewLabel = new JLabel("  From Line: ");
		toolBar.add(lblNewLabel);
		
		toolBar.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("  To: ");
		toolBar.add(lblNewLabel_1);
		
		toolBar.add(textField_2);
		toolBar.add(replay);
		toolBar.add(record);
		toolBar.add(config);		
		
		JLabel lblNewLabel_2 = new JLabel("                                                                           ");
		lblNewLabel_2.setEnabled(true);
		lblNewLabel_2.setVisible(true);
		
		toolBar.add(lblNewLabel_2);
		
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
	}
}