/*This class performs all the homomorphic operations required for FHEv1 and FHEv2*/

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;

public class HomomorphicOperations {
	
	//It performs homomorphic addition of two cipher texts by using the keys stored in the KeyFile
	public static BigInteger homomorphicAddition(BigInteger emessage1, BigInteger emessage2, File KeyFile)
	{
		BigInteger amessage;
		BigInteger N;
		
		//Takes the required keys for homomorphic addition by calling keyExtraction method
		ArrayList<BigInteger> keys = new ArrayList<BigInteger>();
		keys = EncryptDecrypt.keyExtraction(KeyFile);
		N = keys.get(1);
		
		//Performs homomorphic addition
		amessage = (emessage1.add(emessage2)).mod(N);
		
		return amessage;	
	}
	
	//It performs homomorphic multiplication of two cipher texts by using the keys stored in the KeyFile
	public static BigInteger homomorphicMultiplication(BigInteger emessage1, BigInteger emessage2, File KeyFile)
	{
		BigInteger mmessage;
		BigInteger N;
		
		//Takes the required keys for homomorphic multiplication by calling keyExtraction method
		ArrayList<BigInteger> keys = new ArrayList<BigInteger>();
		keys = EncryptDecrypt.keyExtraction(KeyFile);
		N = keys.get(1);
		
		//Performs homomorphic multiplication
		mmessage = (emessage1.multiply(emessage2)).mod(N);
		
		return mmessage;
	}
	
	//Performs the homomorphic Equality of two cipher texts and returns true if they are equal or False if they are not
	public static boolean homomorphicEquality(BigInteger emessage1, BigInteger emessage2, File KeyFile)
	{
		//Extracts the keys from the KeyFile by calling keyExtraction method 
		//and stores gi's to an arraylist al and T to a biginteger
		ArrayList<BigInteger> al = new ArrayList<BigInteger>();
		BigInteger T;
		ArrayList<BigInteger> keys = new ArrayList<BigInteger>();
		keys = EncryptDecrypt.keyExtraction(KeyFile);
		for(int i = 2; i<keys.size()-1; i++)
		al.add(keys.get(i));
		T = keys.get(keys.size() - 1);
		BigInteger diff;
		
		//Verifies which ciphertext is greater and subtracts them accordingly so that we always get positive value
		if(emessage1.compareTo(emessage2)==1)
			diff = emessage1.subtract(emessage2);
		else
			diff = emessage2.subtract(emessage1);
		
		//Verifies equality and if any one tests is false it returns false 
		//if all tests are passed then it return true
			int i = 0;
			while(i<al.size())
			{
				BigInteger g = al.get(i);
				if(g.modPow(diff, T).equals(BigInteger.ONE))
					i++;
				else
					return false;
			}
		return true;
	}

}
