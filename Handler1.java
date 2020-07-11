
package java1;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;


public class Handler1 extends JFrame implements ActionListener
{
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6;
    String name;
    Handler1(String name)
    {
        this.name=name;
        l1=new JLabel("TEACHER");
        b6=new JButton("User");
        b1=new JButton("Add Project");
        b2=new JButton("Delete Project");
        b3=new JButton("Give Marks");
        b4=new JButton("Display Students");
        b5=new JButton("Exit");
        
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Teacher");
        setResizable(false);
        
        setLayout(null);
        l1.setFont(new Font("Serif",Font.BOLD,36));
        l1.setBounds(130,10,200,50);
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
          AddCourse ac=new AddCourse();
          dispose();
        }
        else if(e.getSource()==b2)
        {
          DeleteCourse dc=new DeleteCourse();
          dispose();
        }
        else if(e.getSource()==b3)
        {
            GiveMarks gm=new GiveMarks();
            dispose();
        }
        else if(e.getSource()==b4)
        {
           DisplayStudent ds=new DisplayStudent();
           dispose();
        }
        else if(e.getSource()==b6)
        {
           User1 u=new User1(name);
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

class AddCourse extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JTextField t1,t2;
    JTextArea a1;
    JButton b1,b2;
    AddCourse()
    {
        l1=new JLabel("Course");
        l2=new JLabel("Key");
        l3=new JLabel("Question");
        t1=new JTextField();
        t2=new JTextField();
        a1=new JTextArea(5,20);
        b1=new JButton("Add");
        b2=new JButton("Exit");
        
        setLayout(null);
        l1.setBounds(100,100,100,20);
        l2.setBounds(100,140,100,20);
        l3.setBounds(100,180,100,20);
        t1.setBounds(200,100,100,20);
        t2.setBounds(200,140,100,20);
        a1.setBounds(130,200,200,150);
        b1.setBounds(350,350,80,20);
        b2.setBounds(0,350,100,20);
        
        setSize(450, 450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(l1);
        add(l2);
        add(l3);
        add(t1);
        add(t2);
        add(a1);
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
           String name="'"+t1.getText()+"'";
           String id="'"+t2.getText()+"'";
           String q="'"+a1.getText()+"'";
           try
           {
               String myDriver="com.mysql.cj.jdbc.Driver";
                String myUrl="jdbc:mysql://localhost:3306/sampledatabase";
                Class.forName(myDriver);
                Connection con=DriverManager.getConnection(myUrl,"root","Kshitij_1234");
                Statement st=con.createStatement();
                String query="insert into java values("+name+","+q+","+id+")";
                con.setAutoCommit(false);
                int a=st.executeUpdate(query);
                con.commit();
                if(a>0)
                {
                    JOptionPane.showMessageDialog(this,"Successfull");
                    Handler1 h=new Handler1(null);
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
           Handler1 h=new Handler1(null);
           dispose();
       }
    }
    
}

class DeleteCourse extends JFrame implements ActionListener
{

    JLabel l1;
    JTextField t1;
    JButton b1,b2;
    DeleteCourse()
    {
        l1=new JLabel("Id of the course");
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
            String id="'"+t1.getText()+"'";
            try
            {
                String myDriver="com.mysql.cj.jdbc.Driver";
                String myUrl="jdbc:mysql://localhost:3306/sampledatabase";
                Class.forName(myDriver);
                Connection con=DriverManager.getConnection(myUrl,"root","Kshitij_1234");
                Statement st=con.createStatement();
                String query="delete from java where id="+id+"";
                int a=st.executeUpdate(query);
                if(a>0)
                {
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
            Handler1 h=new Handler1(null);
            dispose();
        }
    }
    
}

class GiveMarks extends JFrame implements ActionListener
{
    JLabel l1,l2;
    JButton b1,b2;
    JTextField t1,t2;

    public GiveMarks()
    {
        l1=new JLabel("Name");
        l2=new JLabel("Marks");
        b1=new JButton("Submit");
        b2=new JButton("Exit");
        t1=new JTextField();
        t2=new JTextField();
        
        setLayout(null);
        l1.setBounds(100,100,100,20);
        l2.setBounds(100,140,100,20);
        t1.setBounds(180,100,100,20);
        t2.setBounds(180,140,100,20);
        b1.setBounds(250,250,80,20);
        b2.setBounds(0,250,80,20);
        
        setSize(350,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        add(l1);
        add(l2);
        add(t1);
        add(t2);
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
                String name="'"+t1.getText()+"'";
                String marks="'"+t2.getText()+"'";
                String myDriver="com.mysql.jdbc.Driver";
                String myUrl="jdbc:mysql://localhost:3306/sampledatabase";
                Class.forName(myDriver);
                Connection con=DriverManager.getConnection(myUrl,"root","Kshitij_1234");
                Statement st=con.createStatement();
                String query="UPDATE student SET marks="+marks+" WHERE name="+name+"";
                int a=st.executeUpdate(query);
                if(a>0)
                    JOptionPane.showMessageDialog(this,"Successfull");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else 
        {
            Handler1 h=new Handler1("kshitij");
            dispose();
        }
    }
    
}

class DisplayStudent extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2,b3;
    
    DisplayStudent()
    {
        l1=new JLabel("Name");
           l2=new JLabel("Id");
           l3=new JLabel("Email");
           l4=new JLabel("Phone Number");
           l5=new JLabel("Batch");
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
            DisplayAll1 a=new DisplayAll1();
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
                String query="SELECT * FROM student";
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(query);
                while(rs.next())
                {
                    if(rs.getString("name").equals(name))
                    {
                        String subject=rs.getString("batch");
                        String gender=rs.getString("gender");
                        String age=rs.getString("id");
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
            Handler1 a=new Handler1("kshitij");
            dispose();
        }
    }
    
}

class DisplayAll1 extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5;
    int j=0;
    int i=1;
    JButton b1;
    
    DisplayAll1()
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
            String query="SELECT * FROM student";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                String subject=rs.getString("batch");
                String gender=rs.getString("gender");
                String age=rs.getString("id");
                String name=rs.getString("name");
                String email=rs.getString("email");
                l1=new JLabel("Name:  "+name);
                l2=new JLabel("Age:  "+age);
                l3=new JLabel("Gender:  "+gender);
                l4=new JLabel("Email:  "+email);
                l5=new JLabel("Subject:  "+subject);
                
                JLabel l=new JLabel("Student "+i);
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
        Handler1 h=new Handler1("kshitij");
        dispose();
    }
    
}

class User1 extends JFrame implements ActionListener
{
    String name;
    JLabel l1,l2,l3,l4,l5,l6;
    JButton b1,b2;
    
    User1(String name)
    {
        this.name=name;
        ImageIcon i=new ImageIcon("C:\\Users\\user\\Desktop\\a1.png");
        l1=new JLabel(i);
        l2=new JLabel();
        l3=new JLabel();
        l4=new JLabel();
        l5=new JLabel();
        l6=new JLabel();
       b1=new JButton("Change password");
        b2=new JButton("Exit");
        
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
                String n=rs.getString("name");
                if(n.equalsIgnoreCase(name))
                {
                    String gender=rs.getString("gender");
                    String email=rs.getString("email");
                    String subject=rs.getString("subject");
                    String phone=rs.getString("phone");
                    l2.setText("Name: "+name);
                    l3.setText("Gender: "+gender);
                    l4.setText("Email: "+email);
                    l5.setText("Subject: "+subject);
                    l6.setText("Phone "+phone);
                }
            }
            st.close();
        }
        
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        setLayout(null);
        l1.setBounds(0,0,256,256);
        l2.setBounds(270,100,200,20);
        l3.setBounds(270,140,200,20);
        l4.setBounds(270,180,200,20);
        l5.setBounds(270,220,200,20);
        l6.setBounds(270,260,200,20);
        b2.setBounds(50,370,80,20);
        b1.setBounds(270,370,200,20);
        
        setSize(500,500);
        setVisible(true);
        setTitle("ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
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
            Password p=new Password(name);
            dispose();
        }
        else
        {
        Handler1 h=new Handler1(name);
        this.dispose();
        }
    }
    
}

class Password extends JFrame implements ActionListener
{
    String name;
    JLabel l1,l2,l3;
    JPasswordField t1,t2,t3;
    JButton b1,b2;
    
    Password(String name)
    {
        this.name=name;
        l1=new JLabel("Current Password");
        l2=new JLabel("New Password");
        l3=new JLabel("Confirm Password");
        t1=new JPasswordField();
        t2=new JPasswordField();
        t3=new JPasswordField();
        b1=new JButton("Change");
        b2=new JButton("Exit");
        
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(null);
        l1.setBounds(100,50,200,20);
        t1.setBounds(100,70,200,20);
        l2.setBounds(100,120,200,20);
        t2.setBounds(100,140,200,20);
        l3.setBounds(100,190,200,20);
        t3.setBounds(100,210,200,20);
        b1.setBounds(400,400,80,20);
        b2.setBounds(0,400,80,20);
        
        add(l1);
        add(l2);
        add(l3);
        add(t1);
        add(t2);
        add(t3);
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
               String n="'"+name+"'";
               String pass="'"+t2.getText()+"'";
               if(t1.getText().equals("password")&& t2.getText().equals(t3.getText()))
               {
                   String myDriver="com.mysql.jdbc.Driver";
                    String myUrl="jdbc:mysql://localhost:3306/sampledatabase";
                    Class.forName(myDriver);
                    Connection con=DriverManager.getConnection(myUrl,"root","Kshitij_1234");
                    String query="UPDATE teacher SET password="+pass+" WHERE name="+n+"";
                    Statement st=con.createStatement();
                    int a=st.executeUpdate(query);
                    if(a>0){
                        JOptionPane.showMessageDialog(this,"Password Changed!");
                        User1 u=new User1(name);
                        dispose();
                    }
                }
               else
               {
                   JOptionPane.showMessageDialog(this,"Enter correct password");
                   Password p=new Password(name);
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
           User1 u=new User1(name);
           dispose();
       }
    }
    
}