
/**
 * @author MrDing  E-mail: 13160676651@163.com
 * @version: 2017年3月8日 下午1:55:25
 */


package com.ding.serialException;

public class TooManyListeners extends Exception{
	private static final long serialVersionUID = 1L;

	public TooManyListeners() {}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "串口监听类数量过多！添加操作失败！";
	}

}
