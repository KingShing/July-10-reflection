package reflect;
/**
 * 
 * @author yejincheng
 *  用于被反射创建对象  必须要有无参构造函数
 */
class Person{
	public String name;
	
	//如果没有默认构造函数 Class.forName("Person").newInstance()会报 NoSuchMethodException()
	Person(){
	}
	public Person(String name) {
		this.name = name;
	}
	
	public void sayHello(String msg){
		System.out.println(msg);
	}
	
}