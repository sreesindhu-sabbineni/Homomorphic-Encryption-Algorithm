/*This class is used for encryption and decryption purpose by extracting keys from the KeyFile*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class EncryptDecrypt {
	
	//This function extracts the keys stored in the KeyFile. It converts the values returned from the File to BigIntegers 
	//and stores them to an ArrayList.
	public static ArrayList<BigInteger> keyExtraction(File KeyFile)
	{
		ArrayList<BigInteger> keys = new ArrayList<BigInteger>();
		try {
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader(KeyFile));
			String line = reader.readLine();
			String[] key;
			while(line!=null) {
				key = line.split("\t");
				for(String k: key)
				{
					keys.add(new BigInteger(k));
				}
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Exception occurred while trying to read keys from the file");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return (keys);
	}

	//This function is used to encrypt the given message by the user using the keys stored in the KeyFile.
	public static BigInteger encryption(BigInteger message, File KeyFile)
	{
		//Generates a random number r
		Random rand = new Random();
		BigInteger r = new BigInteger(32, rand);
		BigInteger emessage;
		BigInteger P1;
		BigInteger N;
		
		//Takes the required keys for encryption by calling the keyExtraction method 
		ArrayList<BigInteger> keys = new ArrayList<BigInteger>();
		keys = keyExtraction(KeyFile);
		P1 = keys.get(0);
		N = keys.get(1);
		
		//Performs encryption
		emessage = (r.multiply(P1)).add(message.mod(N));
		
		return emessage;
	}
	
	//This function is used to decrypt the given message by the user using the keys stored in the KeyFile
	public static BigInteger decryption(BigInteger emessage, File KeyFile)
	{
		BigInteger message;
		BigInteger P1;
		
		//Takes the required keys for decryption by calling the keyExtraction method
		ArrayList<BigInteger> keys = new ArrayList<BigInteger>();
		keys = keyExtraction(KeyFile);
		P1 = keys.get(0);
		
		//Performs decryption
		message = emessage.mod(P1);
		
		return message;
	}
}
