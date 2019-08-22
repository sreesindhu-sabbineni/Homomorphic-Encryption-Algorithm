——————————————————————————————————————————————
@Studentname Sree Sindhu Sabbineni
@StudentID 114095937
@class CS 546 Computer Security Lab Assignment #1

Files:
This project contains the below Java files under variant1 and variant2:
1. FHEv1.java — This is the main function for variant1 from which we call every other functions in different classes.
2. FHEv2.java — This is the main function for variant2 from which we call every other functions in different classes.
2. KeyGeneration.java — This function generates all the required keys for FHEv2.java.
3. EncryptDecrypt.java - Handles encryption and decryption methods for FHEv1.java
4. EncryptDecrypt_v2.java - Handles encryption and decryption methods for FHEv2.java
5. HomomorphicOperations.java — Handles homomorphic addition, multiplication and equality operations for both FHEv1 and FHEv2. We do not use equality method for FHEv1.

Execution:

Compiling: 
javac FHEv1.java for variant 1
Javac FHEv2.java for variant 2

	
For FHEv1:
The following functionalities are satisfied. We run the functionalities as below
 Java FHEv1 -k <key size> <KeyFileName>: Generating the encryption/decryption keys (P1,N) and the operational keys (N,g1,g2,T), and write them to a key file. The <key size> is the size(numberofbits)ofP1,P2 andP3,whereN=P1·P2 andT=(2P1+1)·P3.
• java FHEv1 -t <-e <m1> | Cm1 >, <-e <m2> | Cm2 > <KeyFileName>: Read keys from the key file and then test the equality of two ciphers Cm1 and Cm2 . With -e option, encrypt m before the equality testing operation. Outputs the equality test result.
The following functionalities are satisfied.

Output:
Corresponding KeyFiles and output statements. 
