package reflect;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;
/**
 * 	 Class.forName("xxx"),动态加载类的好处,可以通过配置文件加载类,解耦,该类只要实现特定接口即可
 * 	 如下:
 * 		String className = readfromXMlConfig;//从xml 配置文件中获得字符串
		class c = Class.forName(className);
		factory = (ExampleInterface)c.newInstance();
 	 二者区别: 一个是类,一个是对象
 * 	 Class.forName("xxx");  //类
 *   Class.forName("xxx").newInstance(); //对象
 *   
 *   JVM的角度看，我们使用关键字new创建一个类的时候，这个类可以没有被加载。
 *   但是使用newInstance()方法的时候，就必须保证：
 *     1、这个类已经加载；
 *     2、这个类已经连接了。
 *   
 *   new和newInstance()区别
 *     1: new 是关键字,newInstance()是方法
 *     2: newInstance(): 弱类型,低效率,只能调用无参构造。
 *   	  new: 强类型,相对高效,能调用任何public构造
 *   
 */
public class ReflectExercise {
	
	@Test
	public void testName() throws Exception{
		
		//获取类
		Class<?> clazz = Class.forName("reflect.Person"); 
		
		//获取对象
		Person person = (Person)clazz.newInstance();	
		System.out.println(person);
		
		/**  
		 * ------------------------
			MethodName:sayHello
			returnType:void
			参数个数:1
			parameterType:java.lang.String
			------------------------
			MethodName:wait
			returnType:void
			参数个数:2
			parameterType:long
			parameterType:int
			------------------------
			MethodName:wait
			returnType:void
			参数个数:1
			parameterType:long
			------------------------
			MethodName:wait
			returnType:void
			参数个数:0
			------------------------
			MethodName:equals
			returnType:boolean
			参数个数:1
			parameterType:java.lang.Object
			------------------------
			MethodName:toString
			returnType:java.lang.String
			参数个数:0
			------------------------
			MethodName:hashCode
			returnType:int
			参数个数:0
			------------------------
			MethodName:getClass
			returnType:java.lang.Class
			参数个数:0
			------------------------
			MethodName:notify
			returnType:void
			参数个数:0
			------------------------
			MethodName:notifyAll
			returnType:void
			参数个数:0
		 */
		
	
		//获取制定方法
		Method method = clazz.getMethod("sayHello", String.class);
		System.out.println(method.getName());
		
		//获取所有public方法  包括父类public的方法 
		Method[] ms = clazz.getMethods();  
		
		
		//遍历Methods
		for (Method m : ms) {
			System.out.println("-----------Method-------------");
			System.out.println("MethodName:"+m.getName());
			
			//返回值只有一个
			Class<?> returnType = m.getReturnType();
			System.out.println("returnType:"+returnType.getName());
			
			//方法参数可能多个 so 返回参数数组
			Class<?>[] parameterTypes = m.getParameterTypes();
			System.out.println("参数个数:"+parameterTypes.length);
			for (Class<?> parameterType : parameterTypes) {
				System.out.println("parameterType:"+parameterType.getName());
			}
			
			if(m.getName().equals("sayHello")){
				m.invoke(person, new String(m.getName()+" is executing "));
			}
		}
		System.out.println("------------fieldName-----------------");
		
		//注意:获取field 该方法只获取自身public fields,不会有父类的fields
		Field[] fields = clazz.getFields();
		System.out.println(fields.length);
		for (Field f : fields) {
			System.out.println("fieldName:"+f.getName()); 
			//int flag = f.getModifiers()本质是int类型的标志符
			System.out.println("修饰符是否为public:"+Modifier.isPublic(f.getModifiers())); 
		}
		
	}
}




	

