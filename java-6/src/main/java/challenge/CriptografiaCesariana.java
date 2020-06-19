package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        return this.criptografarOuDescriptografar(texto, 3);
    }

    @Override
    public String descriptografar(String texto) {
        return this.criptografarOuDescriptografar(texto, 23);
    }

    private String criptografarOuDescriptografar(String texto, int numTroca) {
        if (texto == null)
            throw new NullPointerException();
        if (texto.isEmpty())
            throw new IllegalArgumentException();

        texto = texto.toLowerCase();
        StringBuilder result = new StringBuilder();

        for (char letra : texto.toCharArray()) {
            if (letra != ' ' && !Character.isDigit(letra)) {
                int posicaoOriginalAlfabeto = letra - 'a';
                int novaPosicaoAlfabeto = (posicaoOriginalAlfabeto + numTroca) % 26;
                char novaLetra = (char) ('a' + novaPosicaoAlfabeto);
                result.append(novaLetra);
            } else {
                result.append(letra);
            }
        }

        return result.toString();
    }
}
