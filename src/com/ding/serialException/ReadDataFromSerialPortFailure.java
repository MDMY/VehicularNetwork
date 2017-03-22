
/**
 * @author MrDing  E-mail: 13160676651@163.com
 * @version: 2017年3月8日 下午1:51:20
 */


package com.ding.serialException;

public class ReadDataFromSerialPortFailure extends Exception{

	private static final long serialVersionUID = 1L;

	public ReadDataFromSerialPortFailure() {}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "从串口读取数据时出错！";
	}
	
}
