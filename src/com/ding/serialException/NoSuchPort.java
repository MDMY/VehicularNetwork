
/**
 * @author MrDing  E-mail: 13160676651@163.com
 * @version: 2017年3月8日 下午1:03:33
 */


package com.ding.serialException;

public class NoSuchPort extends Exception{
	
	private static final long serialVersionUID = 1L;

	public NoSuchPort() {}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "没有找到与该端口名匹配的串口设备！打开串口操作失败！";
	}
}
