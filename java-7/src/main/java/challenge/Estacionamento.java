package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Estacionamento {
    List<Carro> carros = new ArrayList<Carro>();
    private final int NUMERO_VAGAS = 10;
    private final int IDADE_MINIMA = 18;
    private final int IDADE_SENIOR = 55;
    private final int MAXIMO_DE_PONTOS_NA_CARTEIRA = 20;

    public void estacionar(Carro carro) {
        if (carro.getMotorista() == null || carro.getMotorista().getIdade() < IDADE_MINIMA
                || carro.getMotorista().getPontos() > MAXIMO_DE_PONTOS_NA_CARTEIRA) {
            throw new EstacionamentoException("Não pode estacionar, pois não atende os requisitos necessários!");
        } else if (carros.stream().filter(x -> x.getMotorista().getIdade() > IDADE_SENIOR).collect(Collectors.toList())
                .size() == NUMERO_VAGAS) {
            throw new EstacionamentoException("Não há vagas!");
        }

        if (carros.size() < NUMERO_VAGAS) {
            carros.add(carro);
        } else {
            Carro carroResult = carros.stream().filter(x -> x.getMotorista().getIdade() < IDADE_SENIOR).findFirst().get();
            carros.remove(carroResult);
            carros.add(carro);
        }
    }

    public int carrosEstacionados() {
        return carros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        if (carros.contains(carro))
            return true;
        return false;
    }
}
