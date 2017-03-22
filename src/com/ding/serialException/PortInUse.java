
/**
 * @author MrDing  E-mail: 13160676651@163.com
 * @version: 2017年3月8日 下午1:09:39
 */


package com.ding.serialException;

public class PortInUse extends Exception{

	private static final long serialVersionUID = 1L;

	public PortInUse() {}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "端口已被占用！打开串口操作失败！";
	}
}
