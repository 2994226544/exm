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
