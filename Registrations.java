import javax.swing.*;
import java .awt.event.*;
import java .awt.*;
import java.sql.*;
import java.util.*;
import hi.Login;
import k10.ppp;
class Registrations extends JFrame implements ActionListener
{
JButton b1,b2,b3,bb3;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,ll8;
final JTextField num1,num2,num5,num6,num7;
JPasswordField num3,num4,numm;
public Registrations()
{
Font rf=new Font("Serif",Font.BOLD,40);
Font fr=new Font("Serif",Font.BOLD,20);
setExtendedState(JFrame.MAXIMIZED_BOTH);
ImageIcon img =new ImageIcon("p:\\pp\\img19.jpg");
Image ip=img.getImage();
Image pi=ip.getScaledInstance(800,700,Image.SCALE_SMOOTH);
img=new ImageIcon(pi);
JLabel qw=new JLabel(img);
qw.setBounds(0,0,800,700);
b1=new JButton("REGISTER");
b2=new JButton("CLEAR");
b3=new JButton("Log IN");
l1=new JLabel("Name");
l1.setForeground(Color.WHITE);
 num1=new JTextField(20);
l2=new JLabel("Email-ID ");
l2.setForeground(Color.WHITE);
num2=new JTextField(10);
l3=new JLabel("Create Password");
l3.setForeground(Color.WHITE);
 num3=new JPasswordField(4);
 l4=new JLabel("Confirm password");
l4.setForeground(Color.WHITE);
 num4=new JPasswordField(10);
 l5=new JLabel("Country");
l5.setForeground(Color.WHITE);
 num5=new JTextField(10);
l6=new JLabel("State");
l6.setForeground(Color.WHITE);
num6=new JTextField(10);
 l7=new JLabel("Phone Number");
l7.setForeground(Color.WHITE);
num7=new JTextField(10);
l9=new JLabel("Sign UP");
l9.setForeground(Color.WHITE);
l8=new JLabel("Registered users click here ->");
l8.setForeground(Color.GREEN);
l8.setFont(fr);
ll8=new JLabel("Admin Paswword->");
ll8.setForeground(Color.GREEN);
ll8.setFont(fr);
l9.setFont(rf);
bb3=new JButton("IMPORT EXCEL");
l9.setBounds(870 ,25, 190, 100);
l1.setBounds(50, 50, 150, 20);
l2.setBounds(50, 110, 150, 20);
l3.setBounds(50, 170, 150, 20);
l4.setBounds(50, 230, 150, 20);   
l5.setBounds(50, 290, 150, 20);
l6.setBounds(50, 350, 150, 20);
l7.setBounds(50, 410, 150, 20);
l8.setBounds(50, 530, 280, 20);
ll8.setBounds(50, 560, 280, 20);
b3.setBounds(310,530,100,20);
bb3.setBounds(310,560,130,20);
num1.setBounds(190,50,150,20);
num2.setBounds(190, 110, 150, 20);
num3.setBounds(190, 170, 150, 20);
num4.setBounds(190, 230, 150, 20);
num5.setBounds(190, 290, 150, 20);
num6.setBounds(190, 350, 150, 20);
num7.setBounds(190,410,150,20);
b1.setBounds(50, 460, 100, 20);
b2.setBounds(160, 460, 100, 20);
JPanel mn=new JPanel();
mn.setLayout(null);
mn.setSize(400,950);
mn.setBackground(new Color(0,0,0,60));
mn.setBounds(800,75,750,700);
getContentPane().setBackground(Color.BLACK);
JPanel nm=new JPanel();
add(mn);
JLabel lp=new JLabel("WELCOME");
lp.setBounds(380,20,400,60);
lp.setForeground(Color.BLUE);
numm=new JPasswordField(10);
numm.setBounds(220,560,80,20);
setSize(1400,1600);
lp.setFont(fr);
nm.add(lp);
setLayout(null);
mn.add(l1);
add(l9);
mn.add(num1);
mn.add(l2);
mn.add(num2);
mn.add(l3);
mn.add(num3);
mn.add(l4);
mn.add(num4);
mn.add(l5);
mn.add(num5);
mn.add(l6);
mn.add(num6);
mn.add(l7);
mn.add(num7);
mn.add(b1);
mn.add(b2);
mn.add(l8);
mn.add(b3);
mn.add(ll8);
mn.add(bb3);
mn.add(numm);
add(qw);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
setTitle("STAFF MANAGEMENT");
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
bb3.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
if (e.getSource() == b1)
{
int x = 0;
String s1 = num1.getText();
String s2 = num2.getText();
char[] s3 = num3.getPassword();
char[] s4 = num4.getPassword();
String s8 = new String(s3);
String s9 = new String(s4);
String s5 = num5.getText();
String s6 =num6.getText();
String s7 = num7.getText();
if (s8.equals(s9))
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pradheep", "root", "");
PreparedStatement ps = con.prepareStatement("insert into table1 values(?,?,?,?,?,?)");
ps.setString(1, s1);
ps.setString(2, s2);
ps.setString(3, s9);
ps.setString(4, s5);
ps.setString(5,s6);
ps.setString(6, s7);
ps.executeUpdate();
x++;
if (x > 0)
JOptionPane.showMessageDialog(b1, "Data Saved Successfully");
}
catch (Exception ex)
{
System.out.println(ex);
}
}
else
JOptionPane.showMessageDialog(b1,"Data not Saved");
}
else if(e.getSource()==b2)
{
System.out.print("k");
num1.setText("");
num2.setText("");
num3.setText("");
num4.setText("");
num5.setText("");
num6.setText("");
num7.setText("");
}
else if(e.getSource()==b3)
{
try
{
new Login();
}
catch (Exception y)
{
}
}
else if(e.getSource()== bb3)
{
try
{
char[] s33 = numm.getPassword();
String s88 = new String(s33);
if(s88.equals("rkp"))
{
numm.setText("");
JOptionPane.showMessageDialog(bb3,"Records Successfully imported into the database");
new ppp();
}
else
{
numm.setText("");
JOptionPane.showMessageDialog(bb3,"Password Incorrect");
}
}
catch (Exception y)
{
System.out.print(y);
}
}

}
public static void main(String h[])
{
Registrations fg=new Registrations();
}
}