package com.enumDemo;

public class TestEnum {

	// http://www.cnblogs.com/hyl8218/p/5088287.html
	
	
	/**
	 * ��ͨö��ֵ
	 * @author fangyw
	 *
	 */
	public enum ColorEnum{
		red,green,yellow,blue;
	}
	
	
	/**
	 * ö������ͨ����һ������������Ժͷ���������Ϊ����Ӿ�̬�ͷǾ�̬�����Ի򷽷�
	 * @author fangyw
	 *
	 */
	public enum SeasonEnum{
		//ע��ö��д����ǰ�棬����������
		spring,summer,autumn,winter;
		
		private final static String position="test"; //��̬����
		
		//��̬����
		public static SeasonEnum getSeason(String t){  
			if("test".equals(position) && "ddd".equals(t)){
				return spring;
			}else{
				return winter;
			}
		}
	}
	
	
	/**
	 * ʵ�ִ��й�������ö��
	 * @author fangyw
	 *
	 */
	public enum Gender{
		//ͨ�����Ÿ�ֵ,���ұ������һ���вι�������һ������get����������������
        //��ֵ���붼��ֵ�򶼲���ֵ������һ���ָ�ֵһ���ֲ���ֵ���������ֵ����д����������ֵ����Ҳ����
		MAN("man"),WOMEN("women");
		
		private final String value;
		
		//������Ĭ��Ҳֻ����private, �Ӷ���֤���캯��ֻ�����ڲ�ʹ��,��ʱprivate�ɼӿɲ���
		Gender(String value){
			this.value = value;
		}
		public String getValue(){
			return value;
		}
	}
	
	/**
	 * ����״̬
	 * ʵ�ִ��г��󷽷���ö��
	 * @author fangyw
	 *
	 */
	public enum OrderState{
		/** ��ȡ�� */
		CANCEL {public String getName(){return "��ȡ��";}},
		/** ����� */
		WAITCONFIRM {public String getName(){return "�����";}},
		/** �ȴ����� */
		WAITPAYMENT {public String getName(){return "�ȴ�����";}},
		/** ������� */
		ADMEASUREPRODUCT {public String getName(){return "�������";}},
		/** �ȴ����� */
		WAITDELIVER {public String getName(){return "�ȴ�����";}},
		/** �ѷ��� */
		DELIVERED {public String getName(){return "�ѷ���";}},
		/** ���ջ� */
		RECEIVED {public String getName(){return "���ջ�";}};
		
		public abstract String getName();
	}
	
	
	public static void main(String[] args) {
		//ö����һ�����ͣ����ڶ�������������Ʊ����ĸ�ֵ����ֵʱͨ����ö����.ֵ��ȡ��ö���е�ֵ
		ColorEnum colorEnum = ColorEnum.green;
		switch(colorEnum){
		case red:
			System.out.println("color is red");
			break;
		case green:
			System.out.println("color is green");
			break;
		case yellow:
			System.out.println("color is yellow");
			break;
		case blue:
			System.out.println("color is blue");
			break;
		}
		
		//��ȡö�ٵĸ���
		System.out.println("ColorEnumö���е�ֵ��"+ColorEnum.values().length+"��");
		//����ö��
		System.out.println("����ColorEnumö���е�ֵ");
		for(ColorEnum color : ColorEnum.values()){
			System.out.println(color);
		}
		//��ȡö�ٵ�����λ�ã�Ĭ�ϴ�0��ʼ
		System.out.println(ColorEnum.red.ordinal()); 
		System.out.println(ColorEnum.yellow.ordinal());
		System.out.println(ColorEnum.green.ordinal());
		System.out.println(ColorEnum.blue.ordinal());
		
		//ö��Ĭ��ʵ����java.lang.Comparable�ӿ�
		System.out.println(ColorEnum.red.compareTo(ColorEnum.blue));// 0 - 3 = -3
		
		System.out.println("================================");
		String t = "dd";
		System.out.println("����Ϊ��"+SeasonEnum.getSeason(t));
		System.out.println(SeasonEnum.values().length);
		
		System.out.println("================================");
		for(Gender gender :Gender.values()){
			System.out.println(gender.value);
		}
		System.out.println(Gender.MAN.value);
		
		System.out.println("================================");
		for(OrderState order : OrderState.values()){
			System.out.println(order.getName());
		}
		
	}
}
