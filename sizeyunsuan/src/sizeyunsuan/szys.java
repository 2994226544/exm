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
	public static String yuefen(int a, int b)// ����Լ�֣����ڼ�������
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
		int z = a / y;// ����
		int m = b / y;// ��ĸ
		if (z == 0) {
			return "0";
	                }
		if(m==1) return z+"";
		else
		return biaodashi(z,m);
	}
	
	public static String biaodashi(int a,int b)//�жϲ����ٷ�����Ϊ������
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
public static void main(String[] args)//����������
{
	 Scanner sc= new Scanner(System.in);
	 System.out.println("��ӭʹ�ñ�����");
	 System.out.println("������Ϊ�������Сѧ����������ʽ��");
	 System.out.println("�밴�����������Ŀ");
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
        String expArr[]=new String[2];//�������ɵ���Ŀ
        int a= (int) (random.nextInt(range));//����
    	int b= (int) (random.nextInt(range));//��ĸ
    	int c= (int) (random.nextInt(range));//��һ������
    	int d= (int) (random.nextInt(range));//��һ����ĸ
    	int yunsuanfu;//�����
    	yunsuanfu= (int) (random.nextInt(4));
    	if(b!=0&&d!=0) //��ĸ����Ϊ0ʱ���ɴ��з����ļ����⣬ͬʱ������
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
    		expArr[0]=biaodashi(a,b)+'��'+biaodashi(c,d)+'=';
    		System.out.println(expArr[0]);
    		results[i]=yuefen(fenzi, fenmu);

    	 }
    	if(yunsuanfu==3&&c!=0)
    	 {
    		int fenzi=a*d;
    		int fenmu=b*c;
    		expArr[0]=biaodashi(a,b)+'��'+biaodashi(c,d)+'=';
    		System.out.println(expArr[0]);
    		results[i]=yuefen(fenzi, fenmu);

    	 }
    	if(yunsuanfu==3&&c==0)
    	 {
    		break;
    		/*c=1;
    		int fenzi=a*d;
    		int fenmu=b*c;
    		expArr[0]=biaodashi(a,b)+'��'+biaodashi(c,d)+'=';
    		System.out.println(expArr[0]);
    		results[i]=reductionofFraction(fenzi, fenmu);*/

    	 }

    	}
