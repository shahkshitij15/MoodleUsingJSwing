
package java1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;


public class Teacher extends JFrame implements ActionListener 
{
    JLabel l1,l2;
    JTextField t1;
    JPasswordField p1;
    JButton b1,b2;
    
    Teacher()
    {
        l1=new JLabel("Enter login password");
        l2=new JLabel("Enter name");
        t1=new JTextField();
        p1=new JPasswordField();
        b1=new JButton("Login");
        b2=new JButton("Exit");
        
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Teacher");
        setResizable(false);
        
        setLayout(null);
        l2.setBounds(100,100,200,50);
        t1.setBounds(100,150,300,20);
        l1.setBounds(100,190,200,50);
        p1.setBounds(100,250,300,20);
        b1.setBounds(100,300,100,20);
        b2.setBounds(100,350,100,20);
        add(l1);
        add(p1);
        add(b1);
        add(b2);
        add(t1);
        add(l2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            int count=0;
            String name=t1.getText();
            String pass=p1.getText();
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
                String p=rs.getString("password");
                if(name.equalsIgnoreCase(n) && pass.equals(p))
                {
                    JOptionPane.showMessageDialog(this,"Welcome  "+name+"!");
                    count=1;
                    Handler1 h=new Handler1(name);
                    dispose();
                }
            }
            if(count==0)
            JOptionPane.showMessageDialog(this,"Unsuccessfull");
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }
        }
        else
        {
            Menu obj=new Menu();
            obj.addMenu();
        }
    }
}
