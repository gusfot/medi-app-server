package com.medi.hs.common;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.Test;

public class Aes256CipherTest {
	
	@Test
	public void testEncode() {
//		String key = "abcdefghijklmnopqrstuvwxyz123456";

		String plainText = "12345";
		String encodeText = "";
		String decodeText = "";
		// Encrypt
		
		try {
			encodeText = AES256Cipher.encode(plainText);
		} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		System.out.println("AES256_Encode : "+encodeText);
		 

	}
	
	
	@Test
	public void decode() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		
//		String encodeText = "YDXQegrHpMmOE/LXVfz55w==";
		String encodeText = "2u6cA51g5z8QrXErD/r5Ew==";
		
		String decodeText = AES256Cipher.decode(encodeText);
		System.out.println("AES256_Decode : "+decodeText);
	}
	
	
	@Test
	public void testEencode() {
		
		String plainText = "dlfnthtj1!";
		
		String encodedText = "";
		try {
			encodedText = AES256Cipher.encode(plainText);
			System.out.println("AES256_Encode : "+encodedText);
		} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}