/* This class calls all other required classes to perform necessary operations for FHEv1 
 based on the arguments given by the user in the command line */

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

public class FHEv1 {

	public static void main(String[] args) throws IOException 
	{
		String option = args[0];
		File KeyFile = null;
		switch(option)
		{
		case "-k":{
			KeyFile = new File(args[2]);
			if(!KeyFile.exists())
			KeyFile.createNewFile();
			KeyGeneration.keyGeneration(Integer.parseInt(args[1]), KeyFile);
			break;
		}
		
		case "-e":{
			BigInteger message = new BigInteger(args[1]);
			KeyFile = new File(args[2]);
			System.out.println(EncryptDecrypt.encryption(message, KeyFile));
			break;
		}
		
		case "-d":{
			BigInteger emessage = new BigInteger(args[1]);
			KeyFile = new File(args[2]);
			System.out.println(EncryptDecrypt.decryption(emessage, KeyFile));
			break;
		}
		
		case "-b":{
			BigInteger message = new BigInteger(args[1]);
			KeyFile = new File(args[2]);
			BigInteger emessage = (EncryptDecrypt.encryption(message, KeyFile));
			System.out.println(emessage);
			System.out.println(EncryptDecrypt.decryption(emessage, KeyFile));
			break;
		}
		
		case "-a":{
			BigInteger message1 = new BigInteger(args[1]);
			BigInteger message2 = new BigInteger(args[2]);
			KeyFile = new File(args[3]);
			BigInteger emessage1 = (EncryptDecrypt.encryption(message1, KeyFile));
			BigInteger emessage2 = (EncryptDecrypt.encryption(message2, KeyFile));
			System.out.println(HomomorphicOperations.homomorphicAddition(emessage1, emessage2, KeyFile));
			break;
		}
		
		case "-m":{
			BigInteger message1 = new BigInteger(args[1]);
			BigInteger message2 = new BigInteger(args[2]);
			KeyFile = new File(args[3]);
			BigInteger emessage1 = (EncryptDecrypt.encryption(message1, KeyFile));
			BigInteger emessage2 = (EncryptDecrypt.encryption(message2, KeyFile));
			System.out.println(HomomorphicOperations.homomorphicMultiplication(emessage1, emessage2, KeyFile));
			break;
		}
		
		case "-t":{
			BigInteger message1 = new BigInteger(args[1]);
			BigInteger message2 = new BigInteger(args[2]);
			KeyFile = new File(args[3]);
			BigInteger emessage1 = (EncryptDecrypt.encryption(message1, KeyFile));
			BigInteger emessage2 = (EncryptDecrypt.encryption(message2, KeyFile));
			boolean isEqual = HomomorphicOperations.homomorphicEquality(emessage1, emessage2, KeyFile);
			if(isEqual)
				System.out.println("The two values are equal");
			else
				System.out.println("The two values are not equal");
		}
		}
	}

}
