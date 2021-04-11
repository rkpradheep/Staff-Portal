package k7;
import javax.swing.*;
import java .awt.event.*;
import java .awt.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import k8.d;
import java.time.*;
public class Details extends JFrame //implements ActionListener
{
Connection c=null;
Statement hj=null;
ResultSet yt=null;
public Details(String g,String y,String h) throws Exception
{
Font fr=new Font("Serif",Font.BOLD,20);
JFrame rg=new JFrame();
setExtendedState(JFrame.MAXIMIZED_BOTH);
ImageIcon img =new ImageIcon("p:\\pp\\last.jpg");
Image ip=img.getImage();
Image pi=ip.getScaledInstance(1400,1000,Image.SCALE_SMOOTH);
img=new ImageIcon(pi);
JLabel qw=new JLabel(img);
JLabel q1=new JLabel("send this records to mail->");
q1.setFont(fr);
q1.setBounds(20,40,300,20);
JLabel q2=new JLabel("comments->");
q2.setBounds(20,80,200,20);
q2.setFont(fr);
qw.setBounds(0,0,1400,1000);
JButton ppi=new JButton("submit");
JButton fin=new JButton("SEND MAIL");
fin.setBounds(250,40,100,20);
JTextArea oi=new JTextArea(10,20);
q1.setForeground(Color.GREEN);
q2.setForeground(Color.GREEN);
oi.setBounds(150,80,200,150);
rg.setSize(1400,1600);
JPanel pp=new JPanel();
pp.setLayout(null);
pp.setSize(1500,1200);
pp.setBounds(400,250,600,350);
pp.setBackground(new Color(0,0,0,60));
ppi.setBounds(150,250,100,20);
pp.add(fin);
pp.add(q1);
pp.add(q2);
pp.add(oi);
pp.add(ppi);
qw.add(pp);
rg.add(qw);
rg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
rg.setVisible(true);
Class.forName("com.mysql.jdbc.Driver");
c=DriverManager.getConnection("jdbc:mysql://localhost:3306/pradheep","root","");
hj=c.createStatement();
String as[]={"01","02","03","04","05","06","07","08","09","10","11","12"};
String hs[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
int i=0;
FileWriter hh = new FileWriter("p:\\pp\\f.txt");
BufferedWriter os=new BufferedWriter(hh);
String ap=" :";
String tt[]={"","NAME: ","FDP: ","CONFERENCE: ","GUEST LECTURE: ","WORKSHOP: ","JOURNAL: ","BOOK PUBLICATION: ","OTHERS: ","DATE: "};
while(i<12)
{
try{
 yt=hj.executeQuery("select name,fdp,conference,guest_lecture,workshop,journal,book_publication,others,date FROM table2 where email= "+"'"+g+"'"+"and date like "+"'"+y+"-"+as[i]+"-%'");
 yt.next();
JOptionPane.showMessageDialog(rg,hs[i]+" Records :"+"\n"+"NAME : "+yt.getString(1)+"\n"+"FDP : "+yt.getString(2)+"\n"+"CONFERENCE : "+yt.getString(3)+"\n"+
"GUEST LECTURE: "+yt.getString(4)+"\n"+"WORKSHOP: "+yt.getString(5)+"\n"+"JOURNAL: "+yt.getString(6)+"\n"+"BOOK PUBLICATION: "+yt.getString(7)+"\n"+"OTHERS: "+yt.getString(8)+"\n"+"DATE: "+yt.getString(9));
os.write(hs[i]);
os.write(ap);
os.newLine();
os.newLine();
for(int j=1;j<=9;j++) 
{
os.write(tt[j]);
os.write(yt.getString(j));
os.newLine();
os.newLine();
}
os.write("-------------------------------");
os.newLine();
os.newLine();
i++;
}
catch(Exception b)
{
//System.out.print(b);
i++;
}
}
os.close();
JOptionPane.showMessageDialog(rg,"Thank You "+h+" for visiting");
fin.addActionListener(new ActionListener() 
{
public void actionPerformed(ActionEvent e) 
{
try
{
new d(g);
}
catch (Exception pp)
{
System.out.print(pp);
} 
}
});
ppi.addActionListener(new ActionListener() 
{
public void actionPerformed(ActionEvent e) 
{
try
{
PreparedStatement ps = c.prepareStatement("insert into table3 values(?,?,?)");
String s1=h;
String s2=oi.getText().toString();
ps.setString(1, s1);
ps.setString(2, s2);
String bn=LocalDateTime.now().toLocalDate().toString();
ps.setString(3,bn);
ps.executeUpdate();
oi.setText("");
}
catch (Exception pp)
{
System.out.print(pp);
} 
}
});
}
}