package com.smart.ioc;

public class Director {
   public void direct(){
	   GeLi geli = new LiuDeHua();
	   MoAttack moAttack = new MoAttack();
	   moAttack.injectGeli(geli);
	   moAttack.cityGateAsk();
   }

	public static void main(String[] args) {
		Director director = new Director();
		director.direct();
	}
}
