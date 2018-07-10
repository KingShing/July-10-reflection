package basic_exercise;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import org.junit.Test;
/**
 *   遇到的问题
 *   
 *   int a = 012;
 *   System.out.println(a) //10  java数据以0开头是八进制
 *
 * @author yejincheng
 *
 */

@SuppressWarnings("all")
public class Basic_case {

	//1)
	/**定义一个方法 能接受一个整数(这个整数大于3)打印0到这个整数(包含)之间的所有的偶数
		如 接受的数字是6则调用完方法打印出来的偶数是 0 2 4 6
		如 接受的数字是 5则调用完方法打印出来的偶数是 0 2 4

	 * @throws Exception
	 */
	
	public void oneMethod(int a) {
		for (int i = 0; i < a; i++) {
			if(i%2==0) {
				System.out.println(i+"");
			}
			
		}
	}
	@Test
	public void t1() throws Exception {
		oneMethod(5);
	}
	
	//2)
	/**
	 * 随机产生两个整数,随机数的范围均是[1,100],定义方法求这两个整数的和并打印和值

	 */
	public int getSum(int a,int b) {
		return a+b;
	}
	@Test
	public void t2() throws Exception {
		Random r = new Random();
		int a = r.nextInt(100)+1;
		int b = r.nextInt(100)+1;
		int sum = getSum(a,b);
		System.out.println(sum);
		
	}
	
	//3)
	/**
	 * 有如下数组int[] arr={10,20};
		定义一个方法求两个数字的和(方法参数为两个int类型),使用这个方法求出数组这两个元素相加的结果并打印

	 */
	
	public int getSum1(int a,int b) {
		System.out.println(a+b);
		return a+b;
	}
	
	@Test
	public void t3() throws Exception {
		int [] arr = {10,20};
		int sum = getSum(arr[0],arr[1]);
		System.out.println(sum);
		
	}
	
	//4)
	/**
	 * 主方法中给定数组int[] arr= {10,20,30,40,50,60};定义一个方法可以接受这个给定的数组
		并返回这个数组中元素的最小值

	 */
	public int getMinArr(int [] arr) {
		int min = arr[0];
		for (int i : arr) {
			min = min>=i? i:min;
		}
		return min;
	}
	
	@Test
	public void T4() throws Exception {
		int res = getMinArr(new int[]{10,20,30,40,50});
		System.out.println(res);
	}
	
	
	//5)
	/**
	 *  有定义一个方法,可以接受一个整数,
		如果为[90,100]这个范围方法返回’A’
		如果为[80,90)这个范围方法返回’B’
		如果为[70,80)这个范围方法返回’C’
		如果为[60,70)这个范围方法返回’D’
		如果为[0,60)这个范围方法返回’E’
		整数不在以上范围的返回’F’

	 */
	
	
	public char getChar(int a) {
		char res = ' ';
		if(a>=90&&a<=100){
			res = 'A';
		}else if(a>=80&&a<90) {
			res = 'B';
		}else if(a>=70&&a<80) {
			res = 'C';
		}else if(a>=60&&a<70) {
			res = 'D';
		}else if(a>=0&&a<60) {
			res = 'E';
		}else {
			res = 'F';
		}
		return res;
	}
	
	@Test
	public void t5() throws Exception {
		System.out.println(getChar(34));
	}
	
	
	//6)
	/**
	 * 主方法中给定数组int[] arr= {10,20,30,40,50,60};这个数组没有重复元素.
	 * 定义一个方法可以接受这个给定的数组并返回这个数组中最大元素值的索引值

	 */
	public int getMaxArr(int [] arr) {
			int index = 0;
			for (int i = 0; i < arr.length; i++) {
				index = arr[i]>=arr[index]? i:index;
			}
			return index;
		}
	
	@Test
	public void t6() throws Exception {
		int res = getMaxArr(new int[]{10,20,30,40,50,60});
		System.out.println(res);
	}
	
	
	//7)
	/**
	 * 分析以下需求，并用代码实现
	1.键盘录入长方形的长和宽
		定义方法计算该长方形的周长,并在main方法中打印周长
	2.键盘录入长方形的长和宽
		定义方法计算该长方形的面积,并在main方法中打印面积
	3.键盘录入圆的半径
		定义方法计算该圆的周长,并在main方法中打印周长
	4.键盘录入圆的半径
		定义方法计算该圆的面积,并在main方法中打印面积

	 */
	public double getArea(double ...value) {
		if(value.length==1) {
			System.out.println("Area is "+3.0/4*value[0]*value[0]*Math.PI);
			return 3.0/4*value[0]*value[0]*Math.PI;
		}else if(value.length==2){
			System.out.println("Area is "+value[0]*value[1]);
			return value[0]*value[1];
		}else {
			throw new RuntimeException("参数个数错误");
		}
	}

	
	public double getPerimeter(double ...value) {
		if(value.length==1) {
			System.out.println("perimeter is "+ Math.PI*2*value[0]);
			return Math.PI*2*value[0];
		}else if(value.length==2) {
			System.out.println("perimeter is "+ 2*(value[0]+value[1]));
			return 2*(value[0]+value[1]);
		}else {
			throw new RuntimeException("参数个数错误");
		}
	}
	
	@Test
	public void t7() throws Exception {
		getArea(2);
		getPerimeter(2);
		
		getArea(2,1);
		getPerimeter(2,1);
		
		getPerimeter(4,8,8); //java.lang.RuntimeException: 参数个数错误
		


	}
	
	
	//8)
	/**
	 * 	1.定义一个方法equals(int[] arr1,int[] arr2),功能:比较两个数组是否相等(长度和内容均相等则认为两个数组是相同的)
		2.定义一个方法fill(int[] arr,int value),功能:将数组arr中的所有元素的值改为value
		3.定义一个方法fill(int[] arr,int fromIndex,int toIndex,int value),功能:
			将数组arr中的元素从索引fromIndex开始到toIndex(不包含toIndex)对应的值改为value
		4.定义一个方法copyOf(int[] arr, int newLength),功能:将数组arr中的newLength个元素拷贝到新数组中,
			并将新数组返回,从索引为0开始
		5.定义一个方法copyOfRange(int[] arr,int from, int to),功能:
			将数组arr中从索引from(包含from)开始到索引to结束(不包含to)的元素复制到新数组中,并将新数组返回

	 */
	public boolean equals(int arr1[],int arr2[]) {
		 	if (arr1 == arr2)
		 			return true;
		 	if(arr1.length != arr2.length)
		 			return false;
		 	for (int i = 0; i < arr2.length; i++) {
	    	   if (arr1[i]!=arr2[i])
	    		   return false;
	       		}
	       return true;
	}
	
	public int[] fill(int[] arr,int value) {
		for (int i = 0; i < arr.length; i++) {
				arr[i]=value;
			}
		return arr;
	}
	
	public int[] fill(int[] arr,int fromIndex,int toIndex,int value){
		if(fromIndex<0||toIndex>=arr.length)
			throw new RuntimeException(" parameter is error ! ");
		for (int i = fromIndex; i < toIndex; i++) {
			arr[i] = value;
		}
		return arr;
	}
	
	
	public int[] copyOf(int[] arr, int newLength) {
		if(newLength>arr.length)
			throw new RuntimeException(" parameter is error ! ");
		int[] a = new int[newLength];
		for (int i = 0; i < a.length; i++) {
			a[i] = arr[i];
		}
		return a;
	}
	
	public int[] copyOfRange(int[] arr,int from, int to) {
		int a[]  = new int[to-from];
		for (int j=0,i = from; i < to; i++,j++) {
			a[j] = arr[i];
		}
		return a;
	}
	
	@Test
	public void t8() throws Exception {
		int arr1[] = new int[] {1,2,3,4,5,6,7}; 
		int arr2[] = new int[] {-1,0,1,2,3,4,5,6};
		boolean res = equals(arr1, arr2);
		System.out.println(res);
		System.out.println("----------------");
		
		int[] fill = fill(arr1,5);
		for (int i : fill) {
			System.out.println(i);
		}
		System.out.println("------------------");
		
		int[] fill2 = fill(arr2, 2, 5, 3);
		for (int i : fill2) {
			System.out.println(i);
		}
		System.out.println("------------------");
		
		
		int[] copyOf = copyOf(arr1, 3);
		for (int i : copyOf) {
			System.out.println(i);
		}
		System.out.println("----------------");
		
		int[] copyOfRange = copyOfRange(arr2, 2, 4);
		for (int i : copyOfRange) {
			System.out.println(i);
		}
		System.out.println("-------------------");
		
 		
	}
	//9)
	/**
	 * 定义一个方法,去打印指定两个年份之间所有的闰年年份
		如:将2000和2005传入方法,方法执行完毕会打印出这段之间的所有闰年年份
		2000和2004
		提示:
		计算公历年闰年的算法: 四年一闰，百年不闰，四百年再闰
		翻译:
		满足如下任意一条即使如年
		年份是整百数的必须是400的倍数才是闰年
		其他年份能被4的是闰年
		实例: 2000 是整百数,并且是400的倍数所以是闰年; 2004年是4的倍数是闰年
		2100 是整百的倍数但不是400的倍数,所以不是闰年

	 */
	public void printYear(int a,int b) {
		for (int i = a; i <= b; i++) {
			 if((i%400==0&&i%100==0)||i%4==0){
				String msg = i+"是整百数,并且是400的倍数或者能被四整除所以是闰年";
				System.out.println(msg);
			}else {
				System.out.println(i+"不是闰年!");
			}
		}
	}
	@Test
	public void t9() throws Exception {
		printYear(2000,2005);
	}
	
	
	//10)
	/**
	 * 	1.键盘录入一个整数(正数或者负数都可以,但是符号位不算有效的数字位)
		2.定义一个方法,该方法的功能是计算该数字是几位数字,并将位数返回
		3.在main方法中打印该数字是几位数
		4.演示格式如下:
		(1)演示一:
			请输入一个整数:1234
			控制台输出:1234是4位数字
		(2)演示二:
			请输入一个整数:-34567
			控制台输出:-34567是5位数字
	 */
	
	public int show(int a) {
		int b = Math.abs(a);
		System.out.println(a+"是"+String.valueOf(b).length()+"位数字");
		return String.valueOf(b).length();
	}
	
	@Test
	public void t10() throws Exception {
		show(1234);  
		show(-34567);
	}	
}
