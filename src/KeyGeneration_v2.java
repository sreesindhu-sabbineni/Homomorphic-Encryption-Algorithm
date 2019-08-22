/*This class generates all the keys required to perform all the required operations of FHEv1 and copies the keys to a text file*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class KeyGeneration_v2 
{
	/*This function is called to generate all the keys and copies them to a File. 
	  It takes the keysize, w, z and name of the File to copy all the keys as arguments */
	public static void KeyGeneration_v2(int KeySize, int w, int z, File KeyFile) 
	{
		BigInteger P1,Q,P2,N;
		BigInteger two = BigInteger.valueOf(2);
		
		//Generates P1 which satisfies the condition Q = 2P1+1 is also prime 
		// and also makes sure that the length of P1 is greater than (k+1)(w+z) where k = 5 here
		while(true)
		{
			
			 while(true) {
				 P1 = BigInteger.probablePrime(KeySize, new Random());
			long size = 6*(w+z);
			if(BigInteger.valueOf(size).compareTo(P1) == -1) {
				break;
			}
			 }
			 Q = (two.multiply(P1)).add(BigInteger.ONE);
			if(Q.isProbablePrime(1))
			{
				break;
			}
		}
		
		//Generates P2 and N
		P2 = BigInteger.probablePrime(KeySize, new Random());
		N = P1.multiply(P2);
		
		//Writes the keys generated to the KeyFile 
		// As we are using BufferedWriter, we are converting everything to String and storing it
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(KeyFile));
			bw.write(P1.toString());
			bw.write("\t");
			bw.write(N.toString());
			bw.write("\n");
			bw.write(Integer.toString(w));
			bw.write("\t");
			bw.write(Integer.toString(z));
			bw.close();
			System.out.println("Keys generated successfully and copied to the file");
		} catch (IOException e) {
			System.out.println("Exception occurred while copying keys to the file");
			e.printStackTrace();
		}

	}
}
