package spring.service.dice.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.dice.play.Player02;

/*
 * FileName : DiceTestApp01.java
 */
public class DiceTestAppUserSpring {
	
	///Main Method
	public static void main(String[] args){
		
		
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("./src/main/resources/config/diceservice.xml"));
		
		// 생성자 이용
		Player02 player01 = (Player02) factory.getBean("player01");
		player01.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player01.getTotalValue());
		System.out.println("=======================\n\n");
		
		Player02 player02 = (Player02) factory.getBean("player02");
		player02.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player02.getTotalValue());
		System.out.println("=======================\n\n");
		
		
		Player02 player03 = (Player02) factory.getBean("player03");
		player03.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player03.getTotalValue());
		System.out.println("=======================\n\n");
		
		Player02 player04 = (Player02) factory.getBean("player04");
		player04.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player04.getTotalValue());
		System.out.println("=======================\n\n");
		//setter 이용

		
	}
}//end of class
