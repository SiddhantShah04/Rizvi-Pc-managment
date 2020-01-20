import java.awt.*;
import java.awt.event.*;
import java.sql.*;  
import javax.swing.*;

class Student implements ActionListener {
    JTextField jtf;
    JButton jb1;
    JFrame jfrm;
    JLabel jlp3;
    JPanel jp2; 
	int pc;
    Student(int pcNumber){
		 pc = pcNumber;
		System.out.println(pc);
		
        jfrm = new JFrame();
        jfrm.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        jfrm.setUndecorated(true);
        jfrm.setLayout(new GridLayout(3,1));
        //jfrm.setBackground(Color.GREEN);
        //Header
        JPanel jp0 = new JPanel(new GridLayout(2,1));
        jfrm.add(jp0);
        JLabel jlab = new JLabel(" Pc's managment system",JLabel.CENTER);
        jlab.setFont(new Font("SansSerif",Font.PLAIN,40));

        JLabel jlab1 = new JLabel("Please enter your detail",JLabel.CENTER);
        jlab1.setFont(new Font("SansSerif",Font.PLAIN,25));
        jp0.add(jlab);        
        jp0.add(jlab1);

        FlowLayout f = new FlowLayout();
        JPanel jp1 = new  JPanel(f);
        f.setHgap(35);
        JLabel jlab2 = new JLabel("SIMS.# : ");
        jlab2.setFont(new Font("SansSerif",Font.PLAIN,20));
        jp1.add(jlab2);

        jtf = new JTextField(10);
        jtf.setFont(new Font("SansSerif",Font.PLAIN,20));
        jp1.add(jtf);

        jb1 = new JButton("submit"); 
        jb1.addActionListener(this);
        jp1.add(jb1);
        jfrm.add(jp1);

        jp2 = new JPanel(f);
        jlp3 = new JLabel("Please Enter your correct SIMS number or contact library administration",JLabel.CENTER);
        jlp3.setFont(new Font("SansSerif",Font.PLAIN,15));
        jlp3.setForeground(Color.red);
        jp2.add(jlp3);
        jp2.setVisible(false);
        jfrm.add(jp2);

        jfrm.setAlwaysOnTop(true);
        jfrm.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        int tbText= Integer.parseInt(jtf.getText());
        System.out.println(pc);
	   
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //this local host need to be change to admin ip address;
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login?characterEncoding=latin1","root","admin");  
            PreparedStatement stmt = con.prepareStatement("select * from students where sims=? and pc=?");
            stmt.setInt(1,tbText);
			stmt.setInt(2,pc);
            ResultSet rs = stmt.executeQuery();
            
			if(rs.next()){
                jp2.setVisible(false);
                //rest code to write when students write the correct sims number
                jfrm.setAlwaysOnTop(false);
                jfrm.setVisible(false);
            }else{
                jp2.setVisible(true);
            }
            con.close(); 
        }
        catch(Exception f){
            System.out.println(f);
        }
    }
    public static void main(String args[]){
		try{
            Class.forName("com.mysql.jdbc.Driver");
            //local host is good
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?characterEncoding=latin1","root","admin");  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from pc");  
            if(rs.next() != true){
               
			   JFrame f = new JFrame();
			   
			   JLabel jlb = new JLabel("Please enter your pc number",JLabel.CENTER);
			   jlb.setFont(new Font("SansSerif",Font.PLAIN,20));
			   jlb.setBounds(50,20,300,50);
			   jlb.setForeground(Color.blue);
			   f.add(jlb);
			   
			   JTextField jtf = new JTextField(10);
			   Font font = new Font("SansSerif",Font.PLAIN,20);
			   jtf.setFont(font);
			   
			   jtf.setBounds(110,100,150,40);
			   f.add(jtf);
			   
			   JButton jb  = new JButton("Submit");
			   jb.setBounds(130,170,100,40);
			   
			   f.add(jb);
			   jb.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent e){
					   System.out.println(jtf.getText());
					   try{
							String sql = "insert into pc values(?)";
							PreparedStatement spst = con.prepareStatement(sql);
							spst.setInt(1,Integer.parseInt(jtf.getText()));
							spst.executeUpdate();
							con.close();
					    }
					   catch(Exception a){System.out.println(f);}
					  f.dispose(); 
				    }  
			    });
			   f.setSize(400,300);
			   f.setLocationRelativeTo(null);
			   f.setUndecorated(true);
			   f.setLayout(null);
               f.getContentPane().setBackground(Color.GREEN);
			   f.setVisible(true);	

			}  else{
				
				System.out.println(rs.getInt(1));
				new Student(rs.getInt(1));
			}
		}
			catch(Exception f){
            System.out.println(f);
        }   
       
    }
}

//college pc set classpath=f:\impfiles\folder\mysql-connector.jar;
