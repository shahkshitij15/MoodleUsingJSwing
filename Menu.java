
package java1;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener
{
    JButton b1,b2,b3,b4;
    JLabel jl;
    
    Menu()
    {
        ImageIcon i=new ImageIcon("C:\\Users\\user\\Desktop\\moodle.png");
        jl=new JLabel(i);
        b1=new JButton("ADMIN");
        b2=new JButton("TEACHER");
        b3=new JButton("STUDENT");
        b4=new JButton("EXIT");
        jl.setFont(new Font("Serif",Font.BOLD,36));
        
        
        setTitle("MOODLE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1000,1000);
        setResizable(false);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }
    public void addMenu()
    {
        setLayout(null);
        
        jl.setBounds(0,0,1000,250);
        b1.setBounds(300,200,350,50);
        b2.setBounds(300,300,350,50);
        b3.setBounds(300,400,350,50);
        b4.setBounds(300,500,350,50);
      
        add(jl);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            Admin a=new Admin();
            dispose();
        }
        else if(e.getSource()==b2)
        {
            Teacher t=new Teacher();
            dispose();
        }
        else if(e.getSource()==b3)
        {
            Student s=new Student();
            dispose();
        }
        else
        {
            System.exit(0);
        }
    }
    
}
