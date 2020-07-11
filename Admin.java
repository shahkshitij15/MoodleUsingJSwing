
package java1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Admin extends JFrame implements ActionListener
{
    JLabel l1,l2;
    JPasswordField p1;
    JButton b1,b2;
    String pass="password";
    
    Admin()
    {
        ImageIcon i=new ImageIcon("C:\\Users\\user\\Desktop\\admin.png");
        l1=new JLabel("Enter login password");
       l2=new JLabel(i);
        p1=new JPasswordField();
        b1=new JButton("Login");
        b2=new JButton("Exit");
        
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Admin");
        setResizable(false);
        
        setLayout(null);
        l1.setBounds(100,250,200,50);
        l2.setBounds(0,0,256,256);
        p1.setBounds(100,300,300,20);
        b1.setBounds(100,350,100,20);
        b2.setBounds(300,350,100,20);
        add(l1);
        add(p1);
        add(b1);
        add(b2);
        add(l2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
        if(pass.equals(p1.getText()))
        {
            JOptionPane.showMessageDialog(this,"WELCOME KSHITIJ!!");
            Handler handler = new Handler();
            dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this,"INCORRECT PASSWORD!! PLEASE TRY AGAIN");
        }
        }
        else
        {
            Menu obj=new Menu();
            obj.addMenu();
            dispose();
        }
    }
}

