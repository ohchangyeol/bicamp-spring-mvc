package spring.service.dice.test;

import spring.service.dice.impl.DiceAImpl;
import spring.service.dice.play.Player02;

/*
 * FileName : DiceTestApp01.java
 */
public class DiceTestApp02 {
	
	///Main Method
	public static void main(String[] args){
		
		// ������ �̿�
		Player02 player01 = new Player02(new DiceAImpl());
		player01.playDice(3);
		System.out.println("=======================");
		System.out.println("���õ� �ֻ��� ���� ������ : "+player01.getTotalValue());
		System.out.println("=======================");
		
		
		//setter �̿�
		Player02 player02 = new Player02();
		player02.setDice(new DiceAImpl());
		player02.playDice(3);
		System.out.println("=======================");
		System.out.println("���õ� �ֻ��� ���� ������ : "+player02.getTotalValue());
		System.out.println("=======================");
		
	}
}//end of class
