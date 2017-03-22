
/**
 * @author MrDing  E-mail: 13160676651@163.com
 * @version: 2017年3月8日 下午1:55:02
 */


package com.ding.serialException;

public class SerialPortParameterFailure extends Exception{

	
	private static final long serialVersionUID = 1L;

	public SerialPortParameterFailure() {}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "设置串口参数失败！打开串口操作未完成！";
	}
}

