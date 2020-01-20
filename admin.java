import java.awt.*;
import java.awt.event.*;
import java.sql.*;  
import javax.swing.*;

class admin{
	admin(){
		
		//colors
		Color b = new Color(131, 111, 255);
		//font
		Font font = new Font("SansSerif",Font.PLAIN,20);
		
		
		JFrame f = new JFrame();
		
		JPanel jp = new JPanel();
		jp.setBounds(120,110,660,550);
		jp.setLayout(null);
		//jp button and textarea
		JLabel jlb = new JLabel("Pc number");
		jlb.setBounds(180,50,100,30);
		jlb.setFont(font);
     	jlb.setForeground(Color.white);
		jp.add(jlb);
		
		JTextField jtf = new JTextField(2);
		jtf.setFont(font);
		jtf.setBounds(380,50,150,30);
		jp.add(jtf);
		
		JLabel jlb2 = new JLabel("SIMS number");
		jlb2.setBounds(180,120,200,30);
		jlb2.setFont(font);
     	jlb2.setForeground(Color.white);
		jp.add(jlb2);
		
		JTextField jtf2 = new JTextField(2);
		jtf2.setFont(font);
		jtf2.setBounds(380,120,150,30);
		jp.add(jtf2);
		
		
		JButton jb3 = new JButton("Submit");
		jb3.setFont(font);
		jb3.setBackground(Color.blue);
		jb3.setForeground(Color.white);
		jb3.setBounds(400,200,150,30);
		jp.add(jb3);
		
		
		JButton jb4 = new JButton("Cancle");
		jb4.setFont(font);
		jb4.setBackground(Color.red);
		jb4.setForeground(Color.white);
		jb4.setBounds(180,200,150,30);
		jp.add(jb4);
		
		jp.setBackground(b);
		jp.setVisible(false);
		f.add(jp);
		
		
		
		JPanel jp2 = new JPanel();
		jp2.setBounds(120,110,660,550);
		jp2.setLayout(null);
		jp2.setVisible(false);
		jp2.setBackground(b);
		
		
		JLabel jlb4 = new JLabel("Pc number");
		jlb4.setBounds(180,50,100,30);
		jlb4.setFont(font);
     	jlb4.setForeground(Color.white);
		jp2.add(jlb4);
		
		JTextField jtf4 = new JTextField(2);
		jtf4.setFont(font);
		jtf4.setBounds(380,50,150,30);
		jp2.add(jtf4);
		
		
		JButton jb5 = new JButton("Submit");
		jb5.setFont(font);
		jb5.setBackground(Color.blue);
		jb5.setForeground(Color.white);
		jb5.setBounds(380,150,150,30);
		jp2.add(jb5);
		
		JButton jb6 = new JButton("Cancle");
		jb6.setFont(font);
		jb6.setBackground(Color.red);
		jb6.setForeground(Color.white);
		jb6.setBounds(180,150,150,30);
		jp2.add(jb6);
		
		f.add(jp2);
		
		
		
		
		JLabel l = new JLabel("RIZVI COLLEGE",JLabel.CENTER);
		l.setFont(new Font("SansSerif",Font.PLAIN,35));
		l.setBounds(220,5,300,50);
	    l.setForeground(Color.white);
		f.add(l);
		
		JLabel l1 = new JLabel("Pc's Management System",JLabel.CENTER);
		l1.setFont(new Font("SansSerif",Font.PLAIN,20));
		l1.setBounds(225,50,300,50);
		l1.setForeground(Color.white);
		f.add(l1);
		
		JButton jb = new JButton("Register");
		jb.setBounds(5,150,100,40);
		f.add(jb);
		jb.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent e){
					   
						jp.setVisible(true);			   
					}  
			    });
		
		JButton jb2 = new JButton("See Details");
		jb2.setBounds(5,250,100,40);
		f.add(jb2);
		jb2.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent e){
					  
					    jp.setVisible(false);
						jp2.setVisible(true);
					
					}  
			    });
		
		
		f.setSize(800,700);
   	    f.setLocationRelativeTo(null);
	    //f.setUndecorated(true);
    	f.setLayout(null);
        f.getContentPane().setBackground(b);
	    f.setVisible(true);
	
	}
	public static void main(String args[]){
		new admin();
	}
	
}