package pw.bdwsr.rozproszonaprojekt.db.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import pw.bdwsr.rozproszonaprojekt.db.validation.KlientValidator;

public class KlientValidatorTest {
	
	@Test
	public void testValidatePesel() {
		assertTrue(KlientValidator.validatePesel("87082103557"));
	}

	@Test
	public void testValidateImie() {
		assertTrue(KlientValidator.validateImie("Adam"));
		assertTrue(KlientValidator.validateImie("�ukasz"));
		assertTrue(KlientValidator.validateImie("Maciek"));
		assertFalse(KlientValidator.validateImie("122112"));
		assertFalse(KlientValidator.validateImie("Adam5"));
		assertFalse(KlientValidator.validateImie(" Marcin"));
	}

	@Test
	public void testValidateNazwisko() {
		assertTrue(KlientValidator.validateNazwisko("Mr�z"));
		assertTrue(KlientValidator.validateNazwisko("Panasiuk"));
		assertTrue(KlientValidator.validateNazwisko("Bieniek"));
		assertTrue(KlientValidator.validateNazwisko("Mr�z"));
		assertTrue(KlientValidator.validateNazwisko("Mr�z-Bieniek"));
	}

	@Test
	public void testValidateUlicaZamieszkania() {
		assertTrue(KlientValidator.validateUlicaZamieszkania("Ko�ciuszki 12"));
		assertTrue(KlientValidator.validateUlicaZamieszkania("Jana Paw�a 2"));
		assertFalse(KlientValidator.validateUlicaZamieszkania("Ko�ciu&szki"));
	}

	@Test
	public void testValidateNumerDomu() {
		assertTrue(KlientValidator.validateNumerDomu("12"));
		assertTrue(KlientValidator.validateNumerDomu("0"));
		assertFalse(KlientValidator.validateNumerDomu("Dwana�cie"));
	}

	@Test
	public void testValidateNumerMieszkania() {
		assertTrue(KlientValidator.validateNumerMieszkania("12"));
		assertTrue(KlientValidator.validateNumerMieszkania("12c"));
		assertTrue(KlientValidator.validateNumerMieszkania("122A"));
		
		
	}

	@Test
	public void testValidateNumerTelefonu() {
		assertTrue(KlientValidator.validateNumerTelefonu("226712959"));
		
	}

	@Test
	public void testValidateNumerDowoduOsobistego() {
		assertTrue(KlientValidator.validateNumerDowoduOsobistego("ABA123456"));
	}

	@Test
	public void testValidateNumerPaszportu() {
		assertTrue(KlientValidator.validateNumerPaszportu("AA1234567"));
	}

}
