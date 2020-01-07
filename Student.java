import java.awt.*;
import java.awt.event.*;
import java.sql.*;  
import javax.swing.*;

class Student implements ActionListener {
    JTextField jtf;
    JButton jb1;
    Student(){
        JFrame jfrm = new JFrame();
       
        jfrm.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        jfrm.setUndecorated(true);
        jfrm.setLayout(new GridLayout(3,1));
        //jfrm.setBackground(Color.GREEN);

        //Header
        JPanel jp0 = new JPanel(new GridLayout(2,1));
        jfrm.add(jp0);
        JLabel jlab = new JLabel("Rizvi Library Pc's managment system",JLabel.CENTER);
        jlab.setFont(new Font("SansSerif",Font.PLAIN,40));

        JLabel jlab1 = new JLabel("Please enter your details",JLabel.CENTER);
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
        jfrm.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){

        System.out.println(jtf.getText());
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login?characterEncoding=latin1","root","admin");  
            Statement stmt=con.createStatement(); 
            ResultSet rs = stmt.executeQuery("select * from student");
            while(rs.next()){
                System.out.println(rs.getInt(1));
                if(rs.getInt(1)){
                    
                }
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
