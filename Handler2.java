
package java1;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class Handler2 extends JFrame implements ActionListener 
{
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6;
    String name;
    Handler2(String name)
    {
        this.name=name;
        l1=new JLabel("STUDENT");
        b1=new JButton("Join Course");
        b2=new JButton("Submit Project");
        b3=new JButton("View Project");
        b4=new JButton("Display Grade");
        b5=new JButton("Exit");
        b6=new JButton("User");
        
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("STUDENT");
        setResizable(false);
        
        setLayout(null);
        l1.setFont(new Font("Serif",Font.BOLD,36));
        l1.setBounds(160,10,200,50);
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
           joinCourse jc=new joinCourse();
           dispose();
        }
        else if(e.getSource()==b2)
        {
           SubmitProject sp=new SubmitProject();
           dispose();
        }
        else if(e.getSource()==b3)
        {
            ViewProject vp=new ViewProject();
            dispose();
        }
        else if(e.getSource()==b4)
        {
            DisplayGrade dg=new DisplayGrade(name);
            dispose();
        }
        else if(e.getSource()==b6)
        {
            Profile p=new Profile(name);
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
    
     class joinCourse extends JFrame implements ActionListener
     {
         JLabel l1,l2;
         JTextField t1;
         JPasswordField p1;
         JButton b1,b2;
         
         joinCourse()
         {
             l1=new JLabel("Enter the course name");
             l2=new JLabel("Enter the enrollment key");
             t1=new JTextField();
             p1=new JPasswordField();
             b1=new JButton("Submit");
             b2=new JButton("Exit");
             
             setLayout(null);
             l1.setBounds(100,100,200,20);
             t1.setBounds(100,130,200,20);
             l2.setBounds(100,180,200,20);
             p1.setBounds(100,210,200,20);
             b1.setBounds(250,250,80,20);
             b2.setBounds(0,250,80,20);
             
             setSize(350, 350);
             setVisible(true);
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             
             add(l1);
             add(l2);
             add(t1);
             add(p1);
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
               String course=t1.getText();
               String key=p1.getText();
               if(course.equalsIgnoreCase("java") && key.equals("1234"))
               {
                   JOptionPane.showMessageDialog(this,"You have successfully "
                           + "joined the course");
               }
           }
           else
           {
               Handler2 h=new Handler2("kshitij");
               dispose();
           }
        }
         
     }
     
     class SubmitProject extends JFrame implements ActionListener
     {
         JLabel l1;
         JTextArea a1;
         JButton b1,b2;
         
         SubmitProject()
         {
             l1=new JLabel("Enter the code here");
             a1=new JTextArea(5,30);
             b1=new JButton("Submit");
             b2=new JButton("Exit");
             
             setLayout(null);
             l1.setBounds(50,50,200,20);
             a1.setBounds(50,90,200,150);
             b1.setBounds(250,250,80,20);
             b2.setBounds(0,250,80,20);
             
             setSize(350,350);
             setVisible(true);
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             
             add(l1);
             add(a1);
             add(b1);
             add(b2);
             
             b2.addActionListener(this);
         }

        @Override
        public void actionPerformed(ActionEvent ae)
        {
              Handler2 h=new Handler2("kshitij");
              dispose();
        }
         
     }
     
     class ViewProject extends JFrame implements ActionListener
     {
         JLabel l1,l2,l3;
         JTextField t1,t2;
         JTextArea a1;
         JButton b1,b2;
         
         ViewProject()
         {
             l1=new JLabel("Experiment No");
             l2=new JLabel("Name");
             l3=new JLabel("Qustion");
             t1=new JTextField();
             t2=new JTextField();
             a1=new JTextArea(5,20);
             b1=new JButton("Get");
             b2=new JButton("Exit");
             
             setLayout(null);
            l1.setBounds(100,100,100,20);
            l2.setBounds(100,140,100,20);
            l3.setBounds(100,180,100,20);
            t1.setBounds(200,100,100,20);
            t2.setBounds(200,140,100,20);
            a1.setBounds(130,200,230,150);
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
                try
                {
                    String i=t1.getText();
                    String myDriver="com.mysql.jdbc.Driver";
                    String myUrl="jdbc:mysql://localhost:3306/sampledatabase";
                    Class.forName(myDriver);
                    Connection con=DriverManager.getConnection(myUrl,"root","Kshitij_1234");
                    String query="SELECT * FROM java";
                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery(query);
                    while(rs.next())
                    {
                        String id=rs.getString("id");
                        if(id.equals(i))
                        {
                            String name=rs.getString("name");
                            String question=rs.getString("question");
                            t2.setText(name);
                            a1.setText(question);
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
                Handler2 h=new Handler2("kshitij");
                dispose();
            }
        }
         
     }
     
     class DisplayGrade extends JFrame
     {
         String name;
         DisplayGrade(String name)
         {
             this.name=name;
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
                    if(rs.getString("name").equals(name))
                    {
                        String marks=rs.getString("marks");
                        JOptionPane.showMessageDialog(this,"Marks obtained are: "+marks);
                        Handler2 h=new Handler2("kshitij");
                        dispose();
                    }
                }
             }
             catch(Exception e)
             {
                 System.out.println(e);
             }
         }
         
     }
     
     class Profile extends JFrame implements ActionListener
     {
         String name;
        JLabel l1,l2,l3,l4,l5,l6,l7;
        JButton b1,b2;
         Profile(String name)
         {
             this.name=name;
             ImageIcon i=new ImageIcon("C:\\Users\\user\\Desktop\\a1.png");
             l1=new JLabel(i);
             l2=new JLabel();
             l3=new JLabel();
            l4=new JLabel();
            l5=new JLabel();
            l6=new JLabel();
            l7=new JLabel("Department: IT");
            b1=new JButton("Change password");
             b2=new JButton("Exit");
             
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
                String n=rs.getString("name");
                if(n.equalsIgnoreCase(name))
                {
                    String gender=rs.getString("gender");
                    String email=rs.getString("email");
                    String subject=rs.getString("id");
                    String phone=rs.getString("batch");
                    l2.setText("Name: "+name);
                    l3.setText("Gender: "+gender);
                    l4.setText("Email: "+email);
                    l5.setText("Id: "+subject);
                    l6.setText("Batch: "+phone);
                }
            }
            st.close();
        }
             catch(Exception e1)
             {
                 System.out.println(e1);
             }
             
             setLayout(null);
        l1.setBounds(0,0,256,256);
        l2.setBounds(270,100,200,20);
        l3.setBounds(270,140,200,20);
        l4.setBounds(270,180,200,20);
        l5.setBounds(270,220,200,20);
        l6.setBounds(270,260,200,20);
        l7.setBounds(270,300,200,20);
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
        add(l7);
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
                Password1 p=new Password1(name);
                dispose();
            }
            else
            {
                Handler2 h=new Handler2(name);
                dispose();
            }
        }
         
     }

class Password1 extends JFrame implements ActionListener
{
    String name;
    JLabel l1,l2,l3;
    JPasswordField t1,t2,t3;
    JButton b1,b2;
    
    Password1(String name)
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
                    String query="UPDATE student SET password="+pass+" WHERE name="+n+"";
                    Statement st=con.createStatement();
                    int a=st.executeUpdate(query);
                    if(a>0){
                        JOptionPane.showMessageDialog(this,"Password Changed!");
                        Profile u=new Profile(name);
                        dispose();
                    }
                }
               else
               {
                   JOptionPane.showMessageDialog(this,"Enter correct password");
                   Password1 p=new Password1(name);
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
           Profile u=new Profile(name);
           dispose();
       }

    }
    
}
    

