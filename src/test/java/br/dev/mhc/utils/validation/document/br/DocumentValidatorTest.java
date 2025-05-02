package br.dev.mhc.utils.validation.document.br;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class DocumentValidatorTest {

    @Test
    void constructorShouldThrowException() throws Exception {
        Constructor<DocumentValidator> constructor = DocumentValidator.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, constructor::newInstance);
        assertInstanceOf(UnsupportedOperationException.class, exception.getCause());
        assertEquals("Utility class", exception.getCause().getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "74296212010",
            "98896940001",
            "75433011054",
            "66783523004",
            "27062024082",
            "54441202083"
    })
    void isValidCPF_whenCpfIsValid_shouldReturnTrue(String cpf) {
        assertTrue(DocumentValidator.isValidCPF(cpf), "cpf should be valid: " + cpf);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "71557478000165",
            "12281852000183",
            "57328878000178",
            "69705686000112",
            "82033498000153",
            "45770581000189",
            "12345678900",
            "22222222222",
            "abc",
            ""
    })
    void isValidCPF_whenCpfIsInvalid_shouldReturnFalse(String cpf) {
        assertFalse(DocumentValidator.isValidCPF(cpf), "CPF should be invalid: " + cpf);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "742.962.120-10",
            "988.969.400-01",
            "754.330.110-54",
            "667.835.230-04",
            "270.620.240-82",
            "544.412.020-83"
    })
    void isValidCPF_whenCpfIsValidButNonNormalized_shouldReturnFalse(String cpf) {
        assertFalse(DocumentValidator.isValidCPF(cpf), "CPF non normalized should be invalid: " + cpf);
    }

    @Test
    void isValidCPF_whenCpfIsNull_shouldBeReturnFalse() {
        assertFalse(DocumentValidator.isValidCPF(null), "CPF null should be invalid"); ;
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "71557478000165",
            "12281852000183",
            "57328878000178",
            "69705686000112",
            "82033498000153",
            "45770581000189"
    })
    void isValidCNPJ_whenCnpjIsValid_shouldReturnTrue(String cnpj) {
        assertTrue(DocumentValidator.isValidCNPJ(cnpj), "CNPJ should be valid: " + cnpj);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "74296212010",
            "98896940001",
            "75433011054",
            "66783523004",
            "27062024082",
            "54441202083",
            "71557478000100",
            "11111111111111",
            "abc",
            ""
    })
    void isValidCNPJ_whenCnpjIsInvalid_shouldReturnFalse(String cnpj) {
        assertFalse(DocumentValidator.isValidCNPJ(cnpj), "CNPJ should be invalid: " + cnpj);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "71.557.478/0001-65",
            "12.281.852/0001-83",
            "57.328.878/0001-78",
            "69.705.686/0001-12",
            "82.033.498/0001-53",
            "45.770.581/0001-89"
    })
    void isValidCNPJ_whenCnpjIsValidButNonNormalized_shouldReturnFalse(String cnpj) {
        assertFalse(DocumentValidator.isValidCNPJ(cnpj), "CNPJ non normalized should be invalid: " + cnpj);
    }

    @Test
    void isValidCNPJ_whenCnpjIsNull_shouldBeReturnFalse() {
        assertFalse(DocumentValidator.isValidCNPJ(null), "CNPJ null should be invalid"); ;
    }

}
