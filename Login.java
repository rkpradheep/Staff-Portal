package hi;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import k7.Details;

public class Login extends JFrame implements ActionListener
{
JLabel  l2, l3;
JTextField tf1;
JButton btn1;
JPasswordField p1;
JPanel pp;
public Login() throws Exception
{
setExtendedState(JFrame.MAXIMIZED_BOTH);
ImageIcon img =new ImageIcon("p:\\pp\\aq.jpg");
//C:\\Windows\\Web\\Wallpaper\\Architecture\\img18.jpg
Image ip=img.getImage();
Image pi=ip.getScaledInstance(1400,1000,Image.SCALE_SMOOTH);
img=new ImageIcon(pi);
JLabel qw=new JLabel(img);
JLabel w=new JLabel("Log IN");
w.setBounds(550,30,200,50);
w.setForeground(Color.white);
w.setFont(new Font("Serif",Font.BOLD,40));
qw.add(w);
qw.setBounds(0,0,1400,1000);
setTitle("Login Form in Windows Form");
setVisible(true);
setSize(1400,1600);
setLayout(null);
pp=new JPanel();
pp.setSize(1000,900);
pp.setBounds(400,100,400,300);
pp.setBackground(new Color(0,0,0,60));
setLayout(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
l2 = new JLabel("Email");
l3 = new JLabel("Password");
tf1 = new JTextField();
l2.setBounds(40, 70, 200, 20);
l3.setBounds(40, 120, 200, 20);
tf1.setBounds(130,70, 200, 20);
p1 = new JPasswordField();
btn1 = new JButton("Submit");
p1.setBounds(130, 120, 200, 20);
btn1.setBounds(100, 180,100,20);
l2.setForeground(Color.white);
l3.setForeground(Color.white);
pp.add(l2);
pp.add(tf1);
pp.add(l3);
pp.add(p1);
pp.add(btn1);
pp.setLayout(null);
qw.add(pp);
add(qw);
btn1.addActionListener(this);
}

public void actionPerformed(ActionEvent e) 
{
showData();
}

public void showData()
{
JFrame f1 = new JFrame();
JLabel l,l0,l4;
JButton btn2;
JTextField tf2;
String str1 = tf1.getText();
char[] p = p1.getPassword();
String str2 = new String(p);
try
{
ImageIcon img =new ImageIcon("p:\\pp\\qa.jpg");
Image ip=img.getImage();
Image pi=ip.getScaledInstance(1400,1000,Image.SCALE_SMOOTH);
img=new ImageIcon(pi);
JLabel qw=new JLabel(img);
qw.setBounds(0,0,1400,1000);
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pradheep", "root", "");
PreparedStatement ps = con.prepareStatement("select * from table1 where email=? and password=?");
ps.setString(1, str1);
ps.setString(2, str2);
ResultSet rs = ps.executeQuery();
if (rs.next())
{
f1.setVisible(true);
f1.setSize(1400, 1600);
f1.setLayout(null);
l=new JLabel();
l0 = new JLabel("you are succefully logged in..");
l0.setForeground(Color.green);
l0.setFont(new Font("Serif", Font.BOLD, 30));
l0.setBounds(90, 80, 500, 80);
l4=new JLabel("ENTER THE YEAR TO DISPLAY DETAILS");
l4.setForeground(Color.white);
l4.setFont(new Font("Serif", Font.BOLD, 10));
l4.setBounds(50,170, 500, 30);
tf2=new JTextField();
tf2.setBounds(300,175,80,20);
btn2=new JButton("submit");
btn2.setBounds(100, 230, 100, 20);
JPanel mn=new JPanel();
mn.setLayout(null);
mn.setSize(400,950);
mn.setBackground(new Color(0,0,0,60));
mn.setBounds(400,75,750,700);
mn.add(l);
mn.add(l0);
mn.add(l4);
mn.add(tf2);
mn.add(btn2);
qw.add(mn);
l.setText("Welcome " + rs.getString(1));
l.setForeground(Color.red);
l.setFont(new Font("Serif", Font.BOLD, 30));
l.setBounds(50, 50, 400, 40);
mn.add(l);
f1.add(qw);
btn2.addActionListener(new ActionListener() 
{
public void actionPerformed(ActionEvent e) 
{
try
{
Details ob=new Details(rs.getString(2),tf2.getText(),rs.getString(1));
}
catch (Exception pp)
{
} 
}
});
}
else
{
JOptionPane.showMessageDialog(null,"Incorrect email-Id or password..Try Again with correct detail");
}
}
catch (Exception ex)
{
System.out.println(ex);
}
}
/*public static void main(String arr[]) throws Exception
{
new Login();
}*/
}