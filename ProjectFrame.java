package Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class MyFrame extends JFrame {
	
	private Container c;
	private ImageIcon icon;
	
    MyFrame()
	{
        frameComponents();
    }

    public void frameComponents() 
	{
        c = this.getContentPane();
        c.setLayout(null);

	    logocomponents();
	  
	    Labelone lb = new Labelone(c);
	   
	    setTitle("WELCOME TO AIUB FACULTY CONSULTING SLOT BOOKING SYSTEM");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
	
	public void logocomponents() {
        icon = new ImageIcon(getClass().getResource("images.png"));
        setIconImage(icon.getImage());
    }
}

class StudentFrame extends JFrame {
	
	private Container c;
	private String studentName;
	private String studentId;
	
    StudentFrame(String studentName, String studentId) 
	{
		this.studentName = studentName;
		this.studentId = studentId;
		StudentFrameComponents();
	}

	public void StudentFrameComponents(){
		c = this.getContentPane();
		c.setLayout(null);
		
        setTitle("Student Panel");
        setSize(750, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel courseLabel = new JLabel(" COURSE : ");
		courseLabel.setBounds(250, 30, 100, 35);
		c.add(courseLabel);

		JTextField courseField = new JTextField();
		courseField.setBounds(325, 30, 200, 30);
		c.add(courseField);
			
		JLabel teacherLable = new JLabel(" TEACHER : ");
		teacherLable.setBounds(245, 45, 100, 80);
		c.add(teacherLable);
			
        JTextField teacherField = new JTextField();
		teacherField.setBounds(320, 70, 200, 30);
		c.add(teacherField);
			
		JLabel dateLabel = new JLabel(" DATE :");
		dateLabel.setBounds(255, 60, 140, 130);
		c.add(dateLabel);

		JTextField dateField = new JTextField();
		dateField.setBounds(315, 110, 200, 30);
		c.add(dateField);
			
		JLabel timeLabel = new JLabel(" TIME :");
		timeLabel.setBounds(255, 100, 140, 130);
		c.add(timeLabel);

		JTextField timeField = new JTextField();
		timeField.setBounds(315, 150, 200, 30);
		c.add(timeField);

        JLabel typeLabel = new JLabel(" TYPE : ");
        typeLabel.setBounds(260, 185, 100, 30);
        c.add(typeLabel);

        JRadioButton onlineBtn = new JRadioButton("Online");
        onlineBtn.setBounds(325, 185, 90, 30);
        c.add(onlineBtn);

        JRadioButton offlineBtn = new JRadioButton("Offline");
        offlineBtn.setBounds(420, 185, 90, 30);
        c.add(offlineBtn);

        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(onlineBtn);
        typeGroup.add(offlineBtn);
			
		JButton addSlotBtn = new JButton("Add Slot");
		addSlotBtn.setBounds(290, 230, 120, 35);
		c.add(addSlotBtn);

		JButton showAllBtn = new JButton("Show All");
		showAllBtn.setBounds(430, 230, 120, 35);
		c.add(showAllBtn);
			
		JTextArea outputArea = new JTextArea();

		JScrollPane scroll = new JScrollPane(outputArea);
		scroll.setBounds(100, 290, 550, 150);
		c.add(scroll);

		addSlotBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Consultation c1;

                if(onlineBtn.isSelected()) {
                    c1 = new OnlineConsultation();
                }
                else if(offlineBtn.isSelected()) {
                    c1 = new OfflineConsultation();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please select consultation type");
                    return;
                }

                Student s1 = new Student(studentName, "", studentId, "");

                Faculty f1 = new Faculty(teacherField.getText(), "", "F101", "");

                Slot slot1 = new Slot(courseField.getText(), dateField.getText(), timeField.getText());

                Booking b1 = new Booking("B101", s1, f1, slot1, c1);

                b1.insertInfo();

                JOptionPane.showMessageDialog(null, "Slot Added Successfully");
            }
        });

		showAllBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					File file = new File("./Data/bookingdata.txt");

					if (!file.exists()) {
						outputArea.setText("No Booking Found.");
						return;
					}

					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);

					String line;
					String data = "";

					while((line = br.readLine()) != null) {
						data = data + line + "\n";
					}

					br.close();
					fr.close();

					outputArea.setText(data);
					outputArea.setCaretPosition(0);
				}
				catch(IOException ioe) {
					outputArea.setText("File reading error.");
				}
			}
		});

        setVisible(true);
    }
}

class FacultyFrame extends JFrame {
	private Container c;
	
	FacultyFrame() 
	{
		FacultyFrameComponents();
	}

   public void FacultyFrameComponents() 
   {     
        c = this.getContentPane();
        c.setLayout(null);
   
        setTitle("Faculty Panel");
        setSize(750, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton showAllBtn = new JButton("Show All");
		showAllBtn.setBounds(180, 10, 100, 35);
		c.add(showAllBtn);

        JButton acceptBtn = new JButton("Accept");
        acceptBtn.setBounds(300, 10, 100, 35);
        c.add(acceptBtn);

        JButton declineBtn = new JButton("Decline");
        declineBtn.setBounds(420, 10, 100, 35);
        c.add(declineBtn);
			
		JTextArea outputArea = new JTextArea();

		JScrollPane scroll = new JScrollPane(outputArea);
		scroll.setBounds(100, 75, 550, 300);
		c.add(scroll);

		showAllBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					File file = new File("./Data/bookingdata.txt");

					if (!file.exists()) {
						outputArea.setText("No Booking Found.");
						return;
					}

					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);

					String line;
					String data = "";

					while((line = br.readLine()) != null) {
						data = data + line + "\n";
					}

					br.close();
					fr.close();

					outputArea.setText(data);
					outputArea.setCaretPosition(0);
				}
				catch(IOException ioe) {
					outputArea.setText("File reading error.");
				}
			}
		});

        acceptBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter fw = new FileWriter("./Data/bookingdata.txt", true);
                    fw.write("Status: ACCEPTED\n");
                    fw.write("------------------------------\n");
                    fw.flush();
                    fw.close();

                    JOptionPane.showMessageDialog(null, "Booking Accepted");
                }
                catch(IOException ioe) {
                    JOptionPane.showMessageDialog(null, "File writing error.");
                }
            }
        });

        declineBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter fw = new FileWriter("./Data/bookingdata.txt", true);
                    fw.write("Status: DECLINED\n");
                    fw.write("------------------------------\n");
                    fw.flush();
                    fw.close();

                    JOptionPane.showMessageDialog(null, "Booking Declined");
                }
                catch(IOException ioe) {
                    JOptionPane.showMessageDialog(null, "File writing error.");
                }
            }
        });

        setVisible(true);
    }
}

class Labelone{
	private JLabel userLabel, passLabel;
	private JRadioButton studentBtn, facultyBtn;
    private ButtonGroup group;
	private JButton loginBtn;

	Labelone(Container c){
	    userLabel = new JLabel();
		userLabel.setText("ENTER YOUR NAME : ");
	    userLabel.setBounds(300,20,150,30);
		
        JTextField nameField = new JTextField();
        nameField.setBounds(440, 25, 150, 30);
        c.add(nameField);
		c.add(userLabel);
		
		passLabel = new JLabel();
	    passLabel.setText("ENTER YOUR ID  : ");
		passLabel.setBounds(300,80,150,30);
		
        JTextField idField = new JTextField();
        idField.setBounds(420, 85, 150, 30);
        c.add(idField);
        c.add(passLabel);
		
        studentBtn = new JRadioButton("Student");
        studentBtn.setBounds(300, 130, 100, 30);
        c.add(studentBtn);

        facultyBtn = new JRadioButton("Faculty");
		facultyBtn.setBounds(430, 130, 100, 30);
		c.add(facultyBtn);

		group = new ButtonGroup();
		group.add(studentBtn);
		group.add(facultyBtn);
		
		loginBtn = new JButton("LOGIN");
		loginBtn.setBounds(400, 180, 120, 35);
		c.add(loginBtn);
		
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (studentBtn.isSelected()) {
					new StudentFrame(nameField.getText(), idField.getText());
				}
				else if (facultyBtn.isSelected()) {
					new FacultyFrame();
				}
			}
		});
	}
}

public class ProjectFrame {
    public static void main(String[] args) {
       new MyFrame();
    }
}