
/**
 * @author MrDing  E-mail: 13160676651@163.com
 * @version: 2017年3月8日 下午1:04:12
 */


package com.ding.serialException;

public class NotASerialPort extends Exception{

	private static final long serialVersionUID = 1L;

	public NotASerialPort() {}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "端口指向设备不是串口类型！打开串口操作失败！";
	}
}
