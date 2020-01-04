import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Student implements ActionListener {
    Student(){
        JFrame jfrm = new JFrame();
        jfrm.setLocation(180,35);
        jfrm.setSize(940,690); 
        //jfrm.getContentPane().setBackground(Color.GREEN);
        jfrm.setLayout(new FlowLayout());
        jfrm.setVisible(true);

        //Header
        JLabel jlab = new JLabel("Rizvi Library Pc's managment system");
        jlab.setLocation(10,2);
        jlab.setFont(new Font("SansSerif",Font.PLAIN,40));
        jfrm.add(jlab);        

        //title
        JLabel jlab2 = new JLabel("Please enter your details");
        jlab2.setLocation(12,10);
        jlab2.setFont(new Font("SansSerif",Font.PLAIN,15));
        jfrm.add(jlab2);        

    }
    public void actionPerformed(ActionEvent e){

    }
    public static void main(String args[]){
        new Student();
    }
}
