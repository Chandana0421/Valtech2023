package com.valtech.training.spring.aop;

import org.aopalliance.intercept.MethodInvocation;

public class AllInOneAdvice implements org.aopalliance.intercept.MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		System.out.println("All in one "+ mi.getMethod().getName());
		Object[] args = mi.getArguments();
		for (int i = 0; i < args.length; i++) {
			int j =(Integer)args[i];
			args[i] = j<0?  -j:j;
		}
		Integer ret =(Integer) mi.proceed();
		return ret<0? -ret:ret;
	}
	

}
