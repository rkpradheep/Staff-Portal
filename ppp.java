package k10;
import java.io.*;
import java.time.*;
import java.text.*;
import java.sql.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
public class ppp
{
public ppp() throws Exception
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/pradheep","root", "");
Statement st=null;
String c[]=new String[100];
XSSFWorkbook Book = new XSSFWorkbook(new FileInputStream("p:\\pp\\qq.xlsx"));
XSSFSheet Sheet = Book.getSheet("Sheet1");
int fc=Sheet.getRow(0).getLastCellNum();
String da=LocalDateTime.now().toLocalDate().toString();
for(int i=1;i<=Sheet.getLastRowNum();i+=1)
{
st=con.createStatement();
int ki=0;
for(int j=0;j<=16;j+=2)
{
c[ki++]= (Sheet.getRow(i).getCell(j)).toString();
}
/*
c[5]= (Sheet.getRow(i).getCell(10)).toString();
java.util.Date date=null;
SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
date=sdf.parse(c[5]);
String ans=df.format(date);
*/
if(c[0]!="")
{
st.executeUpdate("insert into table2 values('"+c[0]+"','"+c[1]+"','"+c[2]+"','"+c[3]+"','"+c[4]+"','"+c[5]+"','"+c[6]+"','"+c[7]+"','"+c[8]+"','"+da+"')");
}
}
Book.close();
}
catch(Exception kj)
{
//System.out.print(kj);
}
}
}