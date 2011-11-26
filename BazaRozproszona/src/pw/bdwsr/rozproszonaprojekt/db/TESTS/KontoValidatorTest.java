package pw.bdwsr.rozproszonaprojekt.db.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import pw.bdwsr.rozproszonaprojekt.db.validation.KontoValidator;

public class KontoValidatorTest {

	@Test
	public void testValidateNrKonta() {
		assertTrue(KontoValidator.validateNrKonta("11222233334444555566667777"));
	}

	@Test
	public void testValidateSrodki() {
		assertTrue(KontoValidator.validateSrodki(120.0));
	}

	@Test
	public void testValidateIdRodzajuKonta() {
		fail("Not yet implemented");
	}

}
