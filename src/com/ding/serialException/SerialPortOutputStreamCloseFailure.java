
/**
 * @author MrDing  E-mail: 13160676651@163.com
 * @version: 2017年3月8日 下午1:54:08
 */


package com.ding.serialException;

public class SerialPortOutputStreamCloseFailure extends Exception{

	private static final long serialVersionUID = 1L;

	public SerialPortOutputStreamCloseFailure() {}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "关闭串口对象的输出流（OutputStream）时出错！";
	}
}

