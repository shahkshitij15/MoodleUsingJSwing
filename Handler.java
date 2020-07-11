
package java1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;


public class Handler extends JFrame implements ActionListener
{
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6;
    String password="password";
    
    Handler()
    {
        l1=new JLabel("ADMIN");
        b6=new JButton("User");
        b1=new JButton("Add Teacher");
        b2=new JButton("Edit Details");
        b3=new JButton("Delete");
        b4=new JButton("Display");
        b5=new JButton("Exit");
        
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Admin");
        setResizable(false);
        
        setLayout(null);
        l1.setFont(new Font("Serif",Font.BOLD,36));
        l1.setBounds(200,10,200,50);
        b1.setBounds(100,100,300,50);
        b2.setBounds(100,170,300,50);
        b3.setBounds(100,240,300,50);
        b4.setBounds(100,320,300,50);
        b5.setBounds(100,390,300,50);
        b6.setBounds(400,10,70,50);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        
        add(l1);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
           AddTeacher at=new AddTeacher();
           dispose();
        }
        else if(e.getSource()==b2)
        {
           EditTeacher et=new EditTeacher();
           dispose();
        }
        else if(e.getSource()==b3)
        {
           DeleteTeacher dt=new DeleteTeacher();
           dispose();
        }
        else if(e.getSource()==b4)
        {
           Display d=new Display();
           dispose();
        }
        else if(e.getSource()==b6)
        {
           User u=new User();
           dispose();
        }
        else
        {
            Menu obj=new Menu();
            obj.addMenu();
            dispose();
        }
    }
}

class AddTeacher extends JFrame implements ActionListener
{
    String password="password";
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2;
    static int j=4;
    
    public AddTeacher()
    {
           l1=new JLabel("Name");
           l2=new JLabel("Age");
           l3=new JLabel("Email");
           l4=new JLabel("Phone Number");
           l5=new JLabel("Subject");
           l6=new JLabel("Gender");
           b1=new JButton("Add");
           b2=new JButton("Exit");
           t1=new JTextField();
           t2=new JTextField();
           t3=new JTextField();
           t4=new JTextField();
           t5=new JTextField();
           t6=new JTextField();
           
           setLayout(null);
           l1.setBounds(50,100,150,20);
           l2.setBounds(50,180,150,20);
           l3.setBounds(50,220,150,20);
           l4.setBounds(50,260,150,20);
           l5.setBounds(50,300,150,20);
           l6.setBounds(50,140,150,20);
           t1.setBounds(200,100,200,20);
           t2.setBounds(200,180,200,20);
           t3.setBounds(200,220,200,20);
           t4.setBounds(200,260,200,20);
           t5.setBounds(200,300,200,20);
           t6.setBounds(200,140,200,20);
           b1.setBounds(400,400,80,20);
           b2.setBounds(50,400,80,20);
           
           setSize(500, 500);
           setVisible(true);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
           add(l1);
           add(l2);
           add(l3);
           add(l4);
           add(l5);
           add(t1);
           add(t2);
           add(t3);
           add(t4);
           add(t5);
           add(b1);
           add(b2);
           add(l6);
           add(t6);
           
           b1.addActionListener(this);
           b2.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==b1)
        {
//  // insert into teacher values(12, 'Kshitij', 'abcd@gmail.com',...)
            try
            {
                String name="'"+t1.getText()+"'";
                String email="'"+t3.getText()+"'";
                String gender="'"+t6.getText()+"'";
                String age= "'"+t2.getText()+"'";
                String phone="'"+t4.getText()+"'";
                String subject="'"+t5.getText()+"'";
                String myDriver="com.mysql.cj.jdbc.Driver";
                String myUrl="jdbc:mysql://localhost:3306/sampledatabase";
                Class.forName(myDriver);
                Connection con=DriverManager.getConnection(myUrl,"root","Kshitij_1234");
                Statement st=con.createStatement();
                String query="insert into teacher values("+name+","+email+","+subject+","+gender
                        +","+age+","+phone+", 'password')";
               // con.setAutoCommit(false);
                int a=st.executeUpdate(query);
                //con.commit();
                if(a>0)
                {
                    JOptionPane.showMessageDialog(this,"Successfull");
                    Handler h=new Handler();
                    this.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Unsuccessfull");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
        {
            Handler h=new Handler();
            dispose();
        }
    }
    
}

class EditTeacher extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2,b3;
    String password="password";
    
    public EditTeacher()
    {
           l1=new JLabel("Name");
           l2=new JLabel("Age");
           l3=new JLabel("Email");
           l4=new JLabel("Phone Number");
           l5=new JLabel("Subject");
           l6=new JLabel("Gender");
           b3=new JButton("Submit");
           b1=new JButton("Edit");
           b2=new JButton("Exit");
           t1=new JTextField();
           t2=new JTextField();
           t3=new JTextField();
           t4=new JTextField();
           t5=new JTextField();
           t6=new JTextField();
           
           setLayout(null);
           l1.setBounds(50,100,150,20);
           l2.setBounds(50,180,150,20);
           l3.setBounds(50,220,150,20);
           l4.setBounds(50,260,150,20);
           l5.setBounds(50,300,150,20);
           l6.setBounds(50,140,150,20);
           t1.setBounds(200,100,200,20);
           t2.setBounds(200,180,200,20);
           t3.setBounds(200,220,200,20);
           t4.setBounds(200,260,200,20);
           t5.setBounds(200,300,200,20);
           t6.setBounds(200,140,200,20);
           b1.setBounds(400,400,80,20);
           b2.setBounds(50,400,80,20);
           b3.setBounds(400,100,80,20);
           
           setSize(500, 500);
           setVisible(true);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
           add(l1);
           add(l2);
           add(l3);
           add(l4);
           add(l5);
           add(t1);
           add(t2);
           add(t3);
           add(t4);
           add(t5);
           add(b1);
           add(b2);
           add(b3);
           add(l6);
           add(t6);
           
           b1.addActionListener(this);
           b2.addActionListener(this);
           b3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==b1)
        {
            try{
            String name=t1.getText();
                String myDriver="com.mysql.jdbc.Driver";
                String myUrl="jdbc:mysql://localhost:3306/sampledatabase";
                Class.forName(myDriver);
                Connection con=DriverManager.getConnection(myUrl,"root","Kshitij_1234");
                String query="SELECT * FROM teacher";
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(query);
                while(rs.next())
                {
                    if(rs.getString("name").equals(name))
                    {
                        String subject=rs.getString("subject");
                        String gender=rs.getString("gender");
                        String age=rs.getString("age");
                        String phone=rs.getString("phone");
                        String email=rs.getString("email");
                        t3.setText(email);
                        t6.setText(gender);
                        t2.setText(age);
                        t4.setText(phone); 
                        t5.setText(subject);
                        t1.setText(name);
                    }
                }
                st.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b2)
        {
            Handler h=new Handler();
            dispose();
        }
        else
        {
            try
            {
                String name="'"+t1.getText()+"'";
                String age="'"+t2.getText()+"'";
                String email="'"+t3.getText()+"'";
                String phone="'"+t4.getText()+"'";
                String subject="'"+t5.getText()+"'";
                String gender="'"+t6.getText()+"'";
                String myDriver="com.mysql.jdbc.Driver";
                String myUrl="jdbc:mysql://localhost:3306/sampledatabase";
                Class.forName(myDriver);
                Connection con=DriverManager.getConnection(myUrl,"root","Kshitij_1234");
                String query="UPDATE teacher SET email="+email+",subject="+subject+",gender="+
                        gender+",age="+age+",phone="+phone+" where name="+name+"";
                Statement st=con.createStatement();
                int a=st.executeUpdate(query);
                if(a>0)
                {
                    JOptionPane.showMessageDialog(this,"Successfull!");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
    
}

class DeleteTeacher extends JFrame implements ActionListener
{
    JLabel l1;
    JTextField t1;
    JButton b1,b2;
    DeleteTeacher()
    {
        l1=new JLabel("Name of the teacher");
        t1=new JTextField();
        b1=new JButton("Delete");
        b2=new JButton("Exit");
        
        setLayout(null);
        l1.setBounds(100,100,200,20);
        t1.setBounds(100,140,200,20);
        b1.setBounds(300,300,80,20);
        b2.setBounds(0,300,80,20);
        
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(l1);
        add(t1);
        add(b1);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==b1)
        {
            try
            {
                String text="'"+t1.getText()+"'";
                String myDriver="com.mysql.cj.jdbc.Driver";
                String myUrl="jdbc:mysql://localhost:3306/sampledatabase";
                Class.forName(myDriver);
                Connection con=DriverManager.getConnection(myUrl,"root","Kshitij_1234");
                String query="delete from teacher where name="+text+"";
                Statement st=con.createStatement();
                int a=st.executeUpdate(query);
                if(a>0){
                JOptionPane.showMessageDialog(this,"Deleted");
                Handler h=new Handler();
                dispose();
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
        {
            Handler h=new Handler();
            dispose();
        }
    }
    
}

class Display extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2,b3;
    String password="password";
    
    public Display()
    {
           l1=new JLabel("Name");
           l2=new JLabel("Age");
           l3=new JLabel("Email");
           l4=new JLabel("Phone Number");
           l5=new JLabel("Subject");
           l6=new JLabel("Gender");
           b3=new JButton("Display");
           b1=new JButton("DisplayAll");
           b2=new JButton("Exit");
           t1=new JTextField();
           t2=new JTextField();
           t3=new JTextField();
           t4=new JTextField();
           t5=new JTextField();
           t6=new JTextField();
           
           setLayout(null);
           l1.setBounds(50,100,150,20);
           l2.setBounds(50,180,150,20);
           l3.setBounds(50,220,150,20);
           l4.setBounds(50,260,150,20);
           l5.setBounds(50,300,150,20);
           l6.setBounds(50,140,150,20);
           t1.setBounds(200,100,200,20);
           t2.setBounds(200,180,200,20);
           t3.setBounds(200,220,200,20);
           t4.setBounds(200,260,200,20);
           t5.setBounds(200,300,200,20);
           t6.setBounds(200,140,200,20);
           b1.setBounds(360,400,120,20);
           b2.setBounds(50,400,80,20);
           b3.setBounds(400,100,80,20);
           
           setSize(500, 500);
           setVisible(true);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
           add(l1);
           add(l2);
           add(l3);
           add(l4);
           add(l5);
           add(t1);
           add(t2);
           add(t3);
           add(t4);
           add(t5);
           add(b1);
           add(b2);
           add(b3);
           add(l6);
           add(t6);
           
           b1.addActionListener(this);
           b2.addActionListener(this);
           b3.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==b1)
        {
            DisplayAll a=new DisplayAll();
            a.setComponents();
            dispose();
        }
        else if(ae.getSource()==b3)
        {
            try
            {
                String name=t1.getText();
                String myDriver="com.mysql.jdbc.Driver";
                String myUrl="jdbc:mysql://localhost:3306/sampledatabase";
                Class.forName(myDriver);
                Connection con=DriverManager.getConnection(myUrl,"root","Kshitij_1234");
                String query="SELECT * FROM teacher";
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(query);
                while(rs.next())
                {
                    if(rs.getString("name").equals(name))
                    {
                        String subject=rs.getString("subject");
                        String gender=rs.getString("gender");
                        String age=rs.getString("age");
                        String phone=rs.getString("phone");
                        String email=rs.getString("email");
                        t3.setText(email);
                        t6.setText(gender);
                        t2.setText(age);
                        t4.setText(phone); 
                        t5.setText(subject);
                        t1.setText(name);
                    }
                }
                st.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
        {
            Handler h=new Handler();
            dispose();
        }
    }

}

class DisplayAll extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5;
    int j=0;
    int i=1;
    JButton b1;
    DisplayAll()
    {
        b1=new JButton("Exit");
        
        setLayout(null);
        b1.setBounds(0,300,80,20);
        
        setSize(1000,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        b1.addActionListener(this);
       add(b1);
    }
    
    public void setComponents()
    {
        try
        {
            String myDriver="com.mysql.jdbc.Driver";
            String myUrl="jdbc:mysql://localhost:3306/sampledatabase";
            Class.forName(myDriver);
            Connection con=DriverManager.getConnection(myUrl,"root","Kshitij_1234");
            String query="SELECT * FROM teacher";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                String subject=rs.getString("subject");
                String gender=rs.getString("gender");
                String age=rs.getString("age");
                String name=rs.getString("name");
                String email=rs.getString("email");
                l1=new JLabel("Name:  "+name);
                l2=new JLabel("Age:  "+age);
                l3=new JLabel("Gender:  "+gender);
                l4=new JLabel("Email:  "+email);
                l5=new JLabel("Subject:  "+subject);
                
                JLabel l=new JLabel("Teacher "+i);
                l.setFont(new Font("Serif",Font.BOLD,18));
                l.setBounds(50+j,50,200,20);
                l1.setBounds(50+j,80,300,20);
                l2.setBounds(50+j,120,300,20);
                l3.setBounds(50+j,160,300,20);
                l4.setBounds(50+j,200,300,20);
                l5.setBounds(50+j,240,300,20);
                add(l);
                add(l1);
                add(l2);
                add(l3);
                add(l4);
                add(l5);
                add(b1);
                validate();
                repaint();
                j+=220;
                i+=1;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        Handler h=new Handler();
        dispose();
    }
    
}

class User extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5;
    JButton b1,b2;
    String password;
    User()
    {
        ImageIcon i=new ImageIcon("C:\\Users\\user\\Desktop\\a1.png");
        l1=new JLabel(i);
        l2=new JLabel("Admin: Kshitij Shah");
        l3=new JLabel("Age: 19");
        l4=new JLabel("Email: shahkshitij15@gmail.com");
        l5=new JLabel("College: SPIT");
       // b1=new JButton("Change password");
        b2=new JButton("Exit");
        
        setLayout(null);
        l1.setBounds(0,0,256,256);
        l2.setBounds(270,100,200,20);
        l3.setBounds(270,140,200,20);
        l4.setBounds(270,180,200,20);
        l5.setBounds(270,220,200,20);
        b2.setBounds(50,370,80,20);
        //b1.setBounds(270,370,200,20);
        
        setSize(500,500);
        setVisible(true);
        setTitle("ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        //add(b1);
        add(b2);
        
        //b1.addActionListener(this);
        b2.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
        Handler h=new Handler();
        this.dispose();
        
    }
    
}
