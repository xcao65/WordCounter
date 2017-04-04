package edu.gatech.cs1331.wc;

import java.io.FileNotFoundException;

public class App {
	public static void main(String[] args) throws FileNotFoundException{
		String fileName = args[0];
		WordCounter wc = new WordCounter(fileName);
		System.out.printf("Word counts in %s%n", fileName);

		//System.out.println("wc:" + wc);
		//not wc is null
		//word() is null
		//null.iterator


		for(String word: wc.words()) {
			//foreach loop has type implementing iterable interface
			//cannot implict downcast

			//reference member having null value  wc.words() return null at that version

			System.out.printf("%s: %d%n", word, wc.count(word));
		}
	}
}


//Project root: parent directory of source


/*
1.gradle build
2.java -jar build/libs/wc.jar i-have-a-dream.txt

java -cp build/libs/wc.jar edu.gatech.cs1331.wc.App i-have-a-dream.txt

//put classes in jar file on class path
jar tf build/libs/wc.jar


*/

//rm -rf build
//recursively force  remove

