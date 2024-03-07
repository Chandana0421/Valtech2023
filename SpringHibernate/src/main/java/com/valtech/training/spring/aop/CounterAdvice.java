package com.valtech.training.spring.aop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.aop.MethodBeforeAdvice;

public class CounterAdvice implements MethodBeforeAdvice {

	private Map<String, Integer> counters = new HashMap<String, Integer>();

	@Override
	public void before(Method method, Object[] args, Object arg2) throws Throwable {
		// method - the actual method we're trying to invoke
		// arg1 - the args/obj passed to this method
		// arg2 - object on which this method will be executed

//		for (int i = 0; i < args.length; i++) {
//			int a = (Integer) args[i];
//			args[i] = a%2 == 0 ? a: -a;
//		}
		String methodName = method.getName();
		System.out.println("Method being called is " + methodName);
		System.out.println("Arguements is " + ArrayUtils.toString(args));

		if (counters.containsKey(methodName)) {
			counters.put(methodName, counters.get(methodName));
		} else {
			counters.put(methodName, 1);
		}

		System.out.println(counters);
	}

	public void loadCounters() {
		//or write in db
		// Deserialization
		try {
			File file = new File("counters.txt");
			if(file.exists()) {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("counters.txt"));
				counters = (Map<String,Integer>) ois.readObject();
				ois.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Loading counters..." + counters);
	}

	public void saveCounters() {
		// Serialization

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("counters.txt")));
			oos.writeObject(counters);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Saving counters..." + counters);
	}

}
