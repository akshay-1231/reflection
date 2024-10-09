package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;

class Test {
	private String s;

	public Test() {
		s = "hello world ";

	}

	public void method1() {
		System.out.println("the String is" + s);

	}

	public void method2(int n) {
		System.out.println("the number is" + n);
	}

	private void method3() {
		System.out.println("private method invoke");
	}
}

public class ReflectionDemo {

	public static void main(String[] args) throws Exception {
		Test obj = new Test();
		Class cls = obj.getClass();
		System.out.println("the name is " + cls.getName());
		// getting constructor of class through
		Constructor constructor = cls.getConstructor();
		System.out.println("the name of constructor is" + constructor.getName());
		System.out.println("the public method of class are");
		Method[] methods = cls.getMethods();
		for (Method a : methods)
			System.out.println(a.getName());
		System.out.println("=======================");
		Method methodcall1 = cls.getDeclaredMethod("method2", int.class);
		methodcall1.invoke(obj, 22);

		Field field = cls.getDeclaredField("s");
		field.setAccessible(true);
		field.set(obj, "JAVA");
		Method methodcall2 = cls.getDeclaredMethod("method1");
		methodcall2.invoke(obj);

		Method methodcall3 = cls.getDeclaredMethod("method3");
		methodcall3.setAccessible(true);
		methodcall3.invoke(obj);
	}

}
