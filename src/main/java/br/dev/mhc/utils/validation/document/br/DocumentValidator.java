package br.dev.mhc.utils.validation.document.br;

import static java.util.Objects.isNull;

public class DocumentValidator {

    private static final int[] weightSsn = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] weightTin = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    private static int calculate(final String str, final int[] weight) {
        int sum = 0;
        for (int i = str.length() - 1, digit; i >= 0; i--) {
            digit = Integer.parseInt(str.substring(i, i + 1));
            sum += digit * weight[weight.length - str.length() + i];
        }
        sum = 11 - sum % 11;
        return sum > 9 ? 0 : sum;
    }

    /**
     * Validates whether the provided CPF is valid according to Brazilian CPF rules.
     * @param cpf The CPF normalized to be validated
     * @return true if the CPF is valid, or false if it is null, empty, or invalid
     */
    public static boolean isValidCPF(final String cpf) {
        if (isNull(cpf) || (cpf.length() != 11) || cpf.matches(cpf.charAt(0) + "{11}")) {
            return false;
        }
        final int digit1 = calculate(cpf.substring(0, 9), weightSsn);
        final int digit2 = calculate(cpf.substring(0, 9) + digit1, weightSsn);
        return cpf.equals(cpf.substring(0, 9) + digit1 + digit2);
    }

    /**
     * Validates whether the provided CNPJ is valid according to Brazilian CNPJ rules.
     * @param cnpj The CNPJ normalized to be validated
     * @return true if the CNPJ is valid; false if it is null, empty, or invalid
     */
    public static boolean isValidCNPJ(final String cnpj) {
        if (isNull(cnpj) || (cnpj.length() != 14) || cnpj.matches(cnpj.charAt(0) + "{14}")) {
            return false;
        }
        final int digit1 = calculate(cnpj.substring(0, 12), weightTin);
        final int digit2 = calculate(cnpj.substring(0, 12) + digit1, weightTin);
        return cnpj.equals(cnpj.substring(0, 12) + digit1 + digit2);
    }

}
