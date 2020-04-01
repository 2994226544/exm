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
