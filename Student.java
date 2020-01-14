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
    Student(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //this local host need to be change to admin ip address;
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login?characterEncoding=latin1","root","admin");  
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from pc");  
            if(rs.next()){
                //create a frame here for pc number
            }  
                  
             
            con.close();  
        }catch(Exception e){System.out.println(e);}
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
       // System.out.println(i);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //this local host need to be change to admin ip address;
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login?characterEncoding=latin1","root","admin");  
            PreparedStatement stmt = con.prepareStatement("select * from student where sims=?");
            stmt.setInt(1,tbText);
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
        new Student();
    }
}

//college pc set classpath=f:\impfiles\folder\mysql-connector.jar;
