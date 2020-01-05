import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Student implements ActionListener {
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

        JTextField jtf = new JTextField(10);
        jtf.setFont(new Font("SansSerif",Font.PLAIN,20));
        jp1.add(jtf);

        JButton jb1 = new JButton("submit"); 
        jp1.add(jb1);
        jfrm.add(jp1);
        jfrm.setVisible(true);

    }
    public void actionPerformed(ActionEvent e){

    }
    public static void main(String args[]){
        new Student();
    }

}
