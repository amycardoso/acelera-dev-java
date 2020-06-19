package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {					
		return salarioBase <= 1039 ? 0 : Math.round(calcularIrfp(calcularInss(salarioBase)));
	}

	private double calcularInss(double salarioBase) {
		if (salarioBase > 4000) {
			return salarioBase * (1 - 0.11);
		} else if (salarioBase > 1500) {
			return salarioBase * (1 - 0.09);
		}

		return salarioBase * (1 - 0.08);
	}

	private double calcularIrfp(double descInss) {
		if  (descInss > 6000) {
			return descInss  * (1 - 0.15);
		}else if (descInss > 3000){
			return descInss  * (1 - 0.075);
		}
		
		return descInss;
	}

}