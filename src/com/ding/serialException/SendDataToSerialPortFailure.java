
/**
 * @author MrDing  E-mail: 13160676651@163.com
 * @version: 2017年3月8日 下午1:52:13
 */


package com.ding.serialException;

public class SendDataToSerialPortFailure extends Exception{

	private static final long serialVersionUID = 1L;

	public SendDataToSerialPortFailure() {}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "往串口发送数据失败！";
	}
}

