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
 Java FHEv1 -k <key size> <KeyFileName>: Generating the encryption/decryption keys (P1,N) and the operational keys (N,g1,g2,T), and write them to a key file. The <key size> is the size(numberofbits)ofP1,P2 andP3,whereN=P1·P2 andT=(2P1+1)·P3.• java FHEv1 -e <m> <KeyFileName>: Read keys from the key file and then encrypting a plain integer m (must be less than the decryption key P1). program outputs Cm (the cipher of m).• java FHEv1 -d <Cm> <KeyFileName>: Read keys from the key file and then decrypting the cipher Cm. program outputs the plaintext m.• java FHEv1 -b <m> <KeyFileName>: Read keys from the key file and then encrypting and decrypting an integer m. The output of this option will be printing the input m, the cipher Cm, and then the decrypted m (each in a different line).• java FHEv1 -a <-e <m1> | Cm1 >, <-e <m2> | Cm2 > <KeyFileName>: Read keys from the key file and then add two ciphers Cm1 and Cm2 . With -e option, encrypt m before the add operation. Outputs the add result.• java FHEv1 -m <-e <m1 > | Cm1 >, <-e <m2 > | Cm2 > <KeyFileName>: Read keys from the key file and then multiply two ciphers Cm1 and Cm2 . With -e option, encrypt m before the multiply operation. Outputs the multiply result.
• java FHEv1 -t <-e <m1> | Cm1 >, <-e <m2> | Cm2 > <KeyFileName>: Read keys from the key file and then test the equality of two ciphers Cm1 and Cm2 . With -e option, encrypt m before the equality testing operation. Outputs the equality test result.For FHEv2:
The following functionalities are satisfied.• java FHEv2 -k <key size> <w> <z> <KeyFileName>: Generating the encryption/decryption keys (P1, N, 2w), the operational key (N), the user-defined constants (w, z), and write them to a key file. Again, the <key size> is the size of P1.• java FHEv2 -p <m> <KeyFileName>: Given a plain integer, this option reads the constants from the key file and then perform a random padding to m. The padded integer is m′(< P1).• java FHEv2 -e <m> <KeyFileName>: Read keys from the key file and then encrypting a plain integer m (must be less than the decryption key 2w). program outputs Cm (the cipher of m).• java FHEv2 -d <Cm> <KeyFileName>: Read keys from the key file and then decrypting the cipher Cm. program outputs the plaintext m.• java FHEv2 -b <m> <KeyFileName>: Read keys from the key file and then encrypting and decrypting an integer m. The output of this option will be printing the input m, the cipher Cm, and then the decrypted m (each in a different line).• java FHEv2 -a <-e <m1> | Cm1 >, <-e <m2> | Cm2 > <KeyFileName>: Read keys from the key file and then add two ciphers Cm1 and Cm2 . With -e option, encrypt m before the add operation. Outputs the add result.• java FHEv2 -m <-e <m1 > | Cm1 >, <-e <m2 > | Cm2 > <KeyFileName>: Read keys from the key file and then multiply two ciphers Cm1 and Cm2 . With -e option, encrypt m before the multiply operation. Outputs the multiply result.

Output:
Corresponding KeyFiles and output statements. 
