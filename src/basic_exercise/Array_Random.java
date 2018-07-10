package basic_exercise;


import static org.junit.Assert.*;

import java.util.Random;
import java.util.Scanner;

import org.junit.Test;
@SuppressWarnings("all")
public class Array_Random {
	
	//1)定义一个含有五个元素的数组,并为每个元素赋值,求数组中所有元素的最小值

	@Test
	public void t1() throws Exception {
		int[] arr = {1,2,3,0,5};
		int min = arr[0];
		for (int i : arr) {
			if(min>=i) min =i;
		}
		System.out.println(min);
		
	}
	
	//2)定义一个长度为3的一维数组,给每个元素赋值. (要求数组中每个元素的值是0-9的随机数)
	//遍历数组打印每个元素的值

	@Test
	public void t2() throws Exception {
		Random r = new Random();
		int arr[] = new int[3];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=r.nextInt(9);
			System.out.println(arr[i]);
		}
	}
	
	//3
	/**
	 * 已知数组int[] nums = {5,10,15},,要求创建一个新数组
		新数组的长度和已知数组相同
		新数组每个元素的值 是已知数组对应位置元素的2倍
		在控制台中打印新数组的所有元素

	 */
	
	@Test
	public void t3() throws Exception {
		int[] nums = {5,10,15};
		int [] arr = new int[nums.length];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]=2*nums[i];
			System.out.println(arr[i]);
		}
	}
	
	
	
	//4)
	/**
	 * 	键盘录入一个整数，创建一个该长度的数组，为每一个元素赋值为1-10的随机整数
	 * ，最后打印数组中所有值大于5且为偶数的元素.

	 * @throws Exception
	 */
	@Test
	public void t4() throws Exception {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int arr[] = new int[n];
		Random r = new Random();
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]= r.nextInt(9)+1;
			if(arr[i]%2==0&&arr[i]>=5) {
				System.out.println(arr[i]);
			}
		}
		
	}
	
	//5)
	/**
	 * 看程序 说结果
	 */
	@Test
	public void t5() throws Exception {
		int[] arr1 = {1,2,3,4,5};
		int[] temp1 = arr1;
		int[] temp2 = arr1;
		System.out.println("通过temp1取出数组值: ");// ...
		
		for(int i = 0;i<temp1.length;i++) {
			System.out.print(temp1[i]+" ");// 1 2 3 4 5
		}
		System.out.println();
		System.out.println("通过temp2取出数组值: ");// ...
		for(int i = 0;i<temp2.length;i++) {
			System.out.print(temp2[i]+" "); //1 2 3 4 5
		}
		System.out.println();
		temp1[2] = 9;             //update
		
		System.out.println("通过temp1取出数组值: "); // ...
		for(int i = 0;i<temp1.length;i++) {
			System.out.print(temp1[i]+" "); //1 2 9 3 4 5  
		}
		System.out.println();
		System.out.println("通过temp2取出数组值: ");// ...
		for(int i = 0;i<temp2.length;i++) {
			System.out.print(temp2[i]+" ");// 1 2 9  4 5
		}
		System.out.println();
		
	

	}
	
	
	
	
	
	//6)
	/**
	 * 看程序 说结果
	 */
	
	@Test
	public void t6() throws Exception {
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {5,6,7};
		int[] temp = arr1;
		System.out.println("通过temp取出arr1中的元素: ");// ...
		
		for(int i = 0;i<temp.length;i++) {
			System.out.print(temp[i]+" ");// 1 2 3 4 5
		}
		
		temp = arr2;
		
		System.out.println("通过temp取出arr2中的元素: ");// ...
		
		for(int i = 0;i<temp.length;i++) {
			System.out.print(temp[i]+" "); // 5 6 7
		}

		
	}
	
	//7)
	/**
	 * 将数字1-10保存到一个长度为10的一维数组中
		定义一个新数组,长度为3,取出原来数组中随机三个元素(不考虑是否重复)
		给新数组的元素赋值
		求新数组所有元素的和

	 */
	@Test
	public void t7() throws Exception {
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		int a[] = new int[3];
		//
		for (int i = 0; i < a.length; i++) {
			a[i]=arr[new Random().nextInt(10)];
		}
		//
		int sum = 0 ;
		for (int i : a) {
			sum+=i;
		}
		System.out.println(sum);
	}
	
	//8)
	/**
	 *  1.键盘录入班级人数
		2.根据录入的班级人数创建数组
		3.利用随机数产生0-100的成绩(包含0和100)
		4.要求:
			(1)打印该班级的不及格人数
			(2)打印该班级的平均分
			(3)演示格式如下:
				请输入班级人数:
				键盘录入:100
				控制台输出:
					不及格人数:19
					班级平均分:87

	 */
	

	@Test
	public void t8() throws Exception {
		int a = new Scanner(System.in).nextInt();
		int arr[] = new int[a];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(100);
		}
		int sum = 0;
		int count = 0;
		for (int j : arr) {
			sum+=j;
			if(j<60)
				count++;
		}
		String msg = "不及格人数:"+count+"\r"+"班级平均分:"+sum/a;
		System.out.println(msg);
	}
		
}
