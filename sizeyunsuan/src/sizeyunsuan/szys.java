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
