package kr.or.ddit.encrypt.sha;

import static org.junit.Assert.*;

import org.junit.Test;

public class KISA_SHA256_Test {

	@Test
	public void encryptTest() {
		/***Given***/
		String pass = "brownpass";

		/***When***/
		String encrypt = KISA_SHA256.encrypt(pass);
		System.out.println(encrypt);

		/***Then***/
		assertEquals("f01471c38113db263f9a532d8b6c054af31bf653aeea92d1c284cdd022b9", encrypt);
	}

}
