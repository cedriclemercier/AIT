package com.example.HW3;

import com.example.HW3.adapter.CsvFormattable;
import com.example.HW3.adapter.TextFormattable;
import com.example.HW3.decorator.Armor;
import com.example.HW3.decorator.Character;
import com.example.HW3.decorator.SwordMan;
import com.example.HW3.decorator.Weapon;
import com.example.HW3.model.CsvAdapterImpl;
import com.example.HW3.model.CsvFormatter;
import com.example.HW3.model.NewLineFormatter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hw3Application {

	public static void main(String[] args) {
		SpringApplication.run(Hw3Application.class, args);

//		String testSpring = "Formatting Line 1. Formatting line 2. Formatting line 3.";
//		TextFormattable newLineformatter = new NewLineFormatter();
//		String resultString = newLineformatter.formatText(testSpring);
//		System.out.println(resultString);
//
//		CsvFormattable csvFormatter = new CsvFormatter();
//		TextFormattable csvAdapter = new CsvAdapterImpl(csvFormatter);
//		String resultCsvString = csvAdapter.formatText(testSpring);
//		System.out.println(resultCsvString);

		// Normal Swordman
		Character swordMan = new SwordMan();
		System.out.println(swordMan.getLore() + " has attack of " + swordMan.attack());

		// Added weapon and armor
		Character decoratedSwordMan = new SwordMan();
		decoratedSwordMan = new Weapon(decoratedSwordMan);
		decoratedSwordMan = new Armor(decoratedSwordMan);
		System.out.println(decoratedSwordMan.getLore() + " has attack of " + decoratedSwordMan.attack());
	}

}
