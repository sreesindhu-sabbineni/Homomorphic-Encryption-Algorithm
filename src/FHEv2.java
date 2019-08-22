/* This class calls all other required classes to perform necessary operations for FHEv2 
 based on the arguments given by the user in the command line */

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

public class FHEv2 {

	public static void main(String[] args) throws IOException 
	{
		String option = args[0];
		File KeyFile = null;
		switch(option)
		{
		case "-k":{
			KeyFile = new File(args[4]);
			int w = Integer.parseInt(args[2]);
			int z = Integer.parseInt(args[3]);
			if(!KeyFile.exists())
				KeyFile.createNewFile();
			KeyGeneration_v2.KeyGeneration_v2(Integer.parseInt(args[1]),w, z, KeyFile);
			break;
		}
		case "-p":{
			KeyFile = new File(args[2]);
			BigInteger message = new BigInteger(args[1]);
			EncryptDecrypt_v2.paddedMessage(message, KeyFile);
			break;
		}
		
		case "-e":{
			KeyFile = new File(args[2]);
			BigInteger message = new BigInteger(args[1]);
			System.out.println(EncryptDecrypt_v2.Encryption(message, KeyFile));
			break;
		}
		
		case "-d":{
			KeyFile = new File(args[2]);
			BigInteger emessage = new BigInteger(args[1]);
			System.out.println(EncryptDecrypt_v2.Decryption(emessage, KeyFile));
			break;
		}
		
		case "-b":{
			BigInteger message = new BigInteger(args[1]);
			KeyFile = new File(args[2]);
			BigInteger emessage = EncryptDecrypt_v2.Encryption(message, KeyFile);
			System.out.println(emessage);
			System.out.println(EncryptDecrypt_v2.Decryption(emessage, KeyFile));
			break;
		}
		
		case "-a":{
			BigInteger message1 = new BigInteger(args[1]);
			BigInteger message2 = new BigInteger(args[2]);
			KeyFile = new File(args[3]);
			BigInteger emessage1 = EncryptDecrypt_v2.Encryption(message1, KeyFile);
			BigInteger emessage2 = EncryptDecrypt_v2.Encryption(message2, KeyFile);
			System.out.println(HomomorphicOperations.homomorphicAddition(emessage1, emessage2, KeyFile));
			break;
		}
		
		case "-m":{
			BigInteger message1 = new BigInteger(args[1]);
			BigInteger message2 = new BigInteger(args[2]);
			KeyFile = new File(args[3]);
			BigInteger emessage1 = EncryptDecrypt_v2.Encryption(message1, KeyFile);
			BigInteger emessage2 = EncryptDecrypt_v2.Encryption(message2, KeyFile);
			System.out.println(HomomorphicOperations.homomorphicMultiplication(emessage1, emessage2, KeyFile));
			break;
		}
		}
	}

}
