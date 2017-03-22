
/**
 * @author MrDing  E-mail: 13160676651@163.com
 * @version: 2017年3月8日 下午1:53:16
 */


package com.ding.serialException;

public class SerialPortInputStreamCloseFailure extends Exception{
	
	private static final long serialVersionUID = 1L;

	public SerialPortInputStreamCloseFailure() {}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "关闭串口对象输入流（InputStream）时出错！";
	}

}