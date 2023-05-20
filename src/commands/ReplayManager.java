package commands;



import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;



public class ReplayManager implements ActionListener {

	private static ReplayManager instance;
	public static boolean recording;
	private JTable table;
	private DefaultTableModel model;
	private static ArrayList<ActionListener> commands;
	private static ArrayList<Object[]> rows;
	private static int getRow = 0, maxgetRow = 0;
	private static Object[] row = new Object[7] ;
	private static int registers;
	
	public ReplayManager() {
		commands = new ArrayList<ActionListener>();
		rows = new ArrayList<Object[]>();
		model = new DefaultTableModel();
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model.addColumn("No.");
		model.addColumn("Date");
		model.addColumn("Time");
		model.addColumn("File Name");
		model.addColumn("From line");
		model.addColumn("To line");
		model.addColumn("Text");
		registers = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		JFrame frame = new JFrame("Log Audio");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		frame.setVisible(true);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(table);
		
		scrollPane.setViewportView(table);
		
		table.setFillsViewportHeight(true);
		table.setModel(model);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(32);
		table.getColumnModel().getColumn(1).setPreferredWidth(95);
		table.getColumnModel().getColumn(2).setPreferredWidth(55);
		table.getColumnModel().getColumn(3).setPreferredWidth(156);
		table.getColumnModel().getColumn(4).setPreferredWidth(57);
		scrollPane.setViewportView(table);
		
		
		
		for(Object[] r: rows) {
			if (!existsInTable( table,r))
				model.addRow(r);
		}
			
			
		table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

	        	getRow = (int) table.getValueAt(table.getSelectedRow(), 0) - 1;
	        	
	        	if(maxgetRow < getRow)
	        		maxgetRow = getRow;
	   
	        	replay();
	        }

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub	
			}	
		});
	}

	public String replay() {
	
		System.out.println("registers : "+registers+" getRow: "+getRow);
		if(registers < getRow)
			return "";
		int start = (int) table.getValueAt(getRow,4);
		int lineTo =(int) table.getValueAt(getRow,5);
		String text = (String) table.getValueAt(getRow, 6);
		System.out.println("Replaying" +" "+text+ " from "+ start+" to "+lineTo+".");
		System.out.println("---------------------------");
		
		PlayAudio tmp = (PlayAudio) commands.get(getRow);
		PlayAudio.textArea.setText(text);
		if(start == 0)
			start = 1;
		PlayAudio.txtfields[0].setText(String.valueOf(start));
		PlayAudio.txtfields[1].setText(String.valueOf(lineTo));
		tmp.actionPerformed(null);
		
		return text;
	}
	
	public void startRecording() {
		recording = true;
	}
	
	public void endRecording() {
		recording = false;
	}
	
	public boolean isActionRecording() {
		return recording;
	}

	public static ReplayManager getInstance(){
		if(instance == null)
			instance = new ReplayManager();
		return instance;
	}
	
	public void addCommand(ActionListener command) {
		commands.add(command);
	}
	
	public void  Recording(String date, String time, String fileName, int start, int stop, JTextArea textArea) {
		

		
		System.out.println("registers : "+registers+" getRow: "+getRow);
		if(registers > maxgetRow+1) {
			
			commands.remove(registers);
			return;
		}
		registers ++;
		System.out.println(commands.size());
		System.out.println(date);
		System.out.println(time);
		System.out.println(fileName);
		System.out.println(start);
		System.out.println(stop);
		
		row[0] =  registers;
		row[1] =  date;
		row[2] =  time;
		if(fileName == null)
			row[3] = "null";
		else
			row[3] =  fileName;
		row[4] =  start;
		row[5] =  stop;
		row[6] = textArea.getText();
		
		rows.add(row);
	}
	
	public boolean existsInTable(JTable table, Object[] entry) {

	    // Get row and column count
	    int rowCount = table.getRowCount();
	    int colCount = table.getColumnCount();

	    // Get Current Table Entry
	    String curEntry = "";
	    for (Object o : entry) {
	        String e = o.toString();
	        curEntry = curEntry + " " + e;
	    }

	    // Check against all entries
	    for (int i = 0; i < rowCount; i++) {
	        String rowEntry = "";
	        for (int j = 0; j < colCount; j++)
	            rowEntry = rowEntry + " " + table.getValueAt(i, j).toString();
	   
	        if (rowEntry.equalsIgnoreCase(curEntry)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public Object[] getRowAt(int row) {
		Object[] result = new String[model.getColumnCount()];

	     for (int i = 1; i < model.getColumnCount(); i++) {
	    	 result[i] = model.getValueAt(row, i);
	     }

	     return result;
	}
}
