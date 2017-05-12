package com.ws.spring.aop;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class HijackAroundMethod implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		
		System.out.println("Method name : "+arg0.getMethod().getName());
		System.out.println("Method arguments : "+Arrays.toString(arg0.getArguments()));
		//same with before
		System.out.println("HijackAroundMethod : Before method hijacked!");
		
		try {
			//proceed to original method call
			Object result = arg0.proceed();
			//same with after
			System.out.println("HijackAroundMethod : After hijacked!");
			return result;
		} catch (IllegalArgumentException e) {
			// same with ThrowsAdvice
			System.out.println("HijackAroundMethod : Throw exception hijacked!");
			throw e;
		}
	}

}
