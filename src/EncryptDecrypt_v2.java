import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class EncryptDecrypt_v2 
{
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
	
	//Generates the paddedmessage by adding random padding everytime to message
	public static BigInteger paddedMessage(BigInteger message, File KeyFile)
	{
		BigInteger two = BigInteger.valueOf(2);
		ArrayList<BigInteger> keys = new ArrayList<BigInteger>();
		keys = keyExtraction(KeyFile);
		int w = keys.get(2).intValue();
		int z = keys.get(3).intValue();
		Random rand = new Random();
		BigInteger R = new BigInteger(z, rand);
//		System.out.println(R);
		BigInteger paddedmessage = ((R.multiply(two.pow(w))).add(message));
//		System.out.println(paddedmessage);
		return paddedmessage;
	}
	
	//This function is used to encrypt the given message by the user using the keys stored in the KeyFile.
	public static BigInteger Encryption(BigInteger message, File KeyFile)
	{
		
		//Generates a random number
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
		
		//Generates m' i.e. the paddedmessage before encryption
		BigInteger paddedmessage = paddedMessage(message, KeyFile);
		
		//Performs encryption
		emessage = (r.multiply(P1)).add(paddedmessage.mod(N));
		
		return emessage;
	}
	
	//This function is used to decrypt the given message by the user using the keys stored in the KeyFile.
	public static BigInteger Decryption(BigInteger emessage, File KeyFile)
	{
		BigInteger message;
		BigInteger P1;
		BigInteger two = BigInteger.valueOf(2);
		
		//Takes the required keys for decryption by calling keyExtraction method
		ArrayList<BigInteger> keys = new ArrayList<BigInteger>();
		keys = keyExtraction(KeyFile);
		P1 = keys.get(0);
		int w = keys.get(2).intValue();
		
		//Performs Decryption
		message = (emessage.mod(P1)).mod(two.pow(w));
		
		return message;
	}
}
