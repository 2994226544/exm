package sizeyunsuan;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile; 
public class szys {
	private static Random random = new Random();
	public static int range;
	public static String yuefen(int a, int b)// 分数约分，用在计算结果中
	{
		int y = 1;
		for (int i = a; i >= 1; i--)
	 {
			if (a % i == 0 && b % i == 0)
	  {
				y = i;
				break;
	  }
	 }
		int z = a / y;// 分子
		int m = b / y;// 分母
		if (z == 0) {
			return "0";
	                }
		if(m==1) return z+"";
		else
		return biaodashi(z,m);
	}
	
	public static String biaodashi(int a,int b)//判断并将假分数化为带分数
	{
		if(a>=b)
		{
			int c;
			c=a/b;
			int d;
			d=a%b; 
			{
			if(d==0)
			 {
				return c+"";
			 }
			  return c+"'"+d+"/"+b;
		    }
		 }
		 return a+"/"+b;
	 }
	
public static void main(String[] args)//主函数部分
{
	 Scanner sc= new Scanner(System.in);
	 System.out.println("欢迎使用本程序！");
	 System.out.println("本程序为随机生成小学四则运算表达式！");
	 System.out.println("请按任意键生成题目");
	 Scanner input = new Scanner(System.in);
	 String str = input.next();
     range=100;
     int num= 10;
     int rightcount[]=new int[num+2];
 	int wrongcount[]=new int[num+2];
 	int gradecount[]=new int[num+2];
 	int right1=0;
	int wrong1=0;
	int grade1=0;
	String[] results=new String[num];int i;
     for( i=0;i<num;i++)
     { 
        String expArr[]=new String[2];//定义生成的题目
        int a= (int) (random.nextInt(range));//分子
    	int b= (int) (random.nextInt(range));//分母
    	int c= (int) (random.nextInt(range));//另一个分子
    	int d= (int) (random.nextInt(range));//另一个分母
    	int yunsuanfu;//运算符
    	yunsuanfu= (int) (random.nextInt(4));
    	if(b!=0&&d!=0) //分母均不为0时生成带有分数的计算题，同时计算结果
    	{
    	if(yunsuanfu==0) 
    	 {
    		int fenzi=a*d+b*c;
    		int fenmu=b*d;
    		expArr[0]=biaodashi(a,b)+'+'+biaodashi(c,d)+'=';
    		System.out.println(expArr[0]);
    		results[i]=yuefen(fenzi, fenmu);

    	 }
    	if(yunsuanfu==1&&a*d-b*c>=0)
    	 {
    		int fenzi=a*d-b*c;
    		int fenmu=b*d;
    		expArr[0]=biaodashi(a,b)+'-'+biaodashi(c,d)+'=';
    		System.out.println(expArr[0]);
    		results[i]=yuefen(fenzi, fenmu);

    	 }
    	if(yunsuanfu==1&&a*d-b*c<0) 
    	 {
    		int fenzi=b*c-a*d;
    		int fenmu=b*d;
    		expArr[0]=biaodashi(a,b)+'-'+biaodashi(c,d)+'=';
    		System.out.println(expArr[0]);
    		results[i]=yuefen(fenzi, fenmu);

    	 }
    	if(yunsuanfu==2) 
    	 {
    		int fenzi=a*c;
    		int fenmu=b*d;
    		expArr[0]=biaodashi(a,b)+'×'+biaodashi(c,d)+'=';
    		System.out.println(expArr[0]);
    		results[i]=yuefen(fenzi, fenmu);

    	 }
    	if(yunsuanfu==3&&c!=0)
    	 {
    		int fenzi=a*d;
    		int fenmu=b*c;
    		expArr[0]=biaodashi(a,b)+'÷'+biaodashi(c,d)+'=';
    		System.out.println(expArr[0]);
    		results[i]=yuefen(fenzi, fenmu);

    	 }
    	if(yunsuanfu==3&&c==0)
    	 {
    		break;
    		/*c=1;
    		int fenzi=a*d;
    		int fenmu=b*c;
    		expArr[0]=biaodashi(a,b)+'÷'+biaodashi(c,d)+'=';
    		System.out.println(expArr[0]);
    		results[i]=reductionofFraction(fenzi, fenmu);*/

    	 }

    	}
    	else //分母至少一个为0时生成只含有整式的运算式，同时计算结果
    	{
    		b=1; d=1;
    	    if(yunsuanfu==0)
    	 {
    		int fenzi=a*d+b*c;
    		int fenmu=b*d;
    		expArr[0]=a+"+"+c+"=";
    		System.out.println(expArr[0]);
    		results[i]=yuefen(fenzi, fenmu);

    	 }
    	if(yunsuanfu==1&&a*d-b*c>=0) 
    	 {
    		int fenzi=a*d-b*c;
    		int fenmu=b*d;
    		expArr[0]=a+"-"+c+"=";
    		System.out.println(expArr[0]);
    		results[i]=yuefen(fenzi, fenmu);

    	 }
    	if(yunsuanfu==1&&a*d-b*c<0)
    	 {
    		int fenzi=b*c-a*d;
    		int fenmu=b*d;
    		expArr[0]=c+"-"+a+"=";
    		System.out.println(expArr[0]);
    		results[i]=yuefen(fenzi, fenmu);

    	 }
    	if(yunsuanfu==2)
    	 {
    		int fenzi=a*c;
    		int fenmu=b*d;
    		expArr[0]=c+"×"+a+"=";
    		System.out.println(expArr[0]);
    		results[i]=yuefen(fenzi, fenmu);

    	 }
    	if(yunsuanfu==3&&c!=0)
    	 {
    		int fenzi=a*d;
    		int fenmu=b*c;
    		expArr[0]=a+"÷"+c+"=";
    		System.out.println(expArr[0]);
    		results[i]=yuefen(fenzi, fenmu);

    	 }
    	if(yunsuanfu==3&&c==0)
    	 {
    		break;
    		/*c=1;
    		int fenzi=a*d;
    		int fenmu=b*c;
    		expArr[0]=a+"÷"+c+"=";
    		System.out.println(expArr[0]);
    		results[i]=reductionofFraction(fenzi, fenmu);*/

    	 }

    	}
        FileWriter fw = null;
        try {

            File f=new File("Exersies.txt");//题目写入
            fw = new FileWriter(f, true);
        } catch (IOException e) 
         {
        	e.printStackTrace();
         }
        if(expArr[0]!=null)
        {
        PrintWriter pw = new PrintWriter(fw);
        pw.println(i+1+"."+expArr[0]);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
         } catch (IOException e) 
         {
        	e.printStackTrace();
         }
        }
        FileWriter fn = null;
        try {

                File f=new File("Answer.txt");//答案写入
                fn = new FileWriter(f, true);
            } catch (IOException e)
            {
            	e.printStackTrace();
            }
        if(expArr[0]!=null)
        {
            PrintWriter pn = new PrintWriter(fn);
            pn.println(i+1+"."+results[i]);
            pn.flush();
            try {
                fn.flush();
                pn.close();
                fn.close();
            } catch (IOException e)
            {
            	e.printStackTrace();
            }
        }
    	}
         FileWriter fo = null;
         try {

             File f=new File("Your_answers.txt");//答案输入
             fo = new FileWriter(f, true);
         } catch (IOException e) 
         {
        	 e.printStackTrace();
         }
         try {
             fo.flush();
             fo.close();
         } catch (IOException e)
         {
         	e.printStackTrace();
         }
         System.out.println("请在Your_answers.txt中写入答案");
         System.out.println("请输入ok提交答案");
         Scanner sc1=new Scanner(System.in);
         String submit=sc1.nextLine();
    	 if(submit.equals("ok"))
    	 {
         String array[]=new String[num];

         try
         {   
        	int k=0;
    		FileReader fr = new FileReader("Your_answers.txt");
    		BufferedReader br = new BufferedReader(fr);
    		String s ;
    		while((s = br.readLine())!=null)//读取输入的答案
    		{
    		array[k]=s;	k++;
    				}
    		br.close();
    		fr.close();		
    		}catch(IOException e)
                {
    				System.out.println("指定文件不存在");
    			}
        for(int j=0;j<num;j++)
        {
         	if(array[j].equals(results[j]))//验证答案，统计正确和错误的个数
         	{

         		rightcount[j]=j+1;
         		right1++;
         		grade1=right1*10;
         	}
         	else 
         	{

         		wrongcount[j]=j+1;
         		wrong1++;
         	}
         	grade1=right1*10;
         }
        FileWriter fg = null;
        try  //反馈正确与错误题目的信息
           {    
               File f=new File("Grade.txt");
                fg = new FileWriter(f, true);
           } catch (IOException e) 
            {
            	e.printStackTrace();
            }
            PrintWriter pg = new PrintWriter(fg);
            pg.println(" ");
            pg.print("Correct:"+right1+"(正确题号");
            for (int j = 0; j <= num; j++) {
    			if (rightcount[j] != 0) {
    				 pg.print(rightcount[j] + ",");
    			}
    		}
            pg.println(")");
            pg.print("Wrong:"+wrong1+"(错误题号");
            for (int j = 0; j <= num; j++) {
    			if (wrongcount[j] != 0) {
    				 pg.print(wrongcount[j] + ",");
    			}
    		}
            pg.println(")"); 
            pg.print("GRADE:"+grade1);
            pg.flush();
            try {
                fg.flush();
                pg.close();
                fg.close();
            } catch (IOException e) 
            {
            	e.printStackTrace();
            }
            }System.out.println("成绩已经生成请在文件中查看。");
             System.out.println("感谢你的使用！");
    }
    }

