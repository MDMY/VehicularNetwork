
/**
 * @author MrDing  E-mail: 13160676651@163.com
 * @version: 2017��3��8�� ����1:04:12
 */


package com.ding.serialException;

public class NotASerialPort extends Exception{

	private static final long serialVersionUID = 1L;

	public NotASerialPort() {}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "�˿�ָ���豸���Ǵ������ͣ��򿪴��ڲ���ʧ�ܣ�";
	}
}
