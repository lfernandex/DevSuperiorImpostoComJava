package desafioImpostoJava;

import java.util.Locale;
import java.util.Scanner;

public class Main {
	
   public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		/* Variaveis parte: 1 */
		double salarioAnual, servico, capital, medico, educacao;

		/*Variaveis parte: 2 */
		double salario, pct1, pct2, pct3, impSalario, impCapital, impServico;
		
		/*Variaveis parte: 3 */
		double gastosDedutiveis, impDevido, impBruto1, impBruto2;
		
		/*Parte: 1*/
		System.out.println("Renda anual com salário: ");
		salarioAnual = sc.nextDouble();
		System.out.println("Renda anual com prestação de serviço: ");
		servico = sc.nextDouble();
		System.out.println("Renda anual com ganho de capital: ");
		capital = sc.nextDouble();
		System.out.println("Gastos medicos: ");
		medico = sc.nextDouble();
		System.out.println("Gastos educacionais: ");
		educacao = sc.nextDouble();
		
		/*Parte: 2 */
		salario = salarioAnual / 12;
		
		if(salario <= 3000.00) {
			pct1 = 0;
		}
		else if (salario <= 5000.00) {
			pct1 = 10;
		}
		else {
			pct1 = 20;
		}
		
		impSalario = salarioAnual * pct1 /100;
			
		if (servico > 0) {
			pct2 = 15;
			impServico = servico * pct2 /100;
		}
		else {
			pct2 = 0;
			impServico = 0;
		}
			
		if (capital > 0) {
			pct3 = 20;
		}
		else {
			pct3 = 0;
		}
		
		impCapital = capital * pct3 /100;
		
		/*Parte: 3*/
		
		impBruto1 = impSalario + impServico + impCapital;
		
		impBruto2 = impBruto1 * 30 / 100;
		
		gastosDedutiveis = medico + educacao;
		
		System.out.println("Relatório de imposto de renda");
		System.out.println();
		
		System.out.println("Consolidado de renda:");
		System.out.printf("Imposto sobre salario %.2f%n", impSalario);
		System.out.printf("Imposto sobre servico %.2f%n", impServico);
		System.out.printf("Imposto sobre capital %.2f%n", impCapital);
		System.out.println();

		System.out.println("Deduções:");
		System.out.printf("Maximo dedutivel: %.2f%n", impBruto2);
		System.out.printf("Gastos dedutivel: %.2f%n", gastosDedutiveis);
		System.out.println();
		
		System.out.println("Resumo:");
		System.out.printf("Imposto bruto total: %.2f%n", impBruto1);
		
		if (gastosDedutiveis < impBruto2) {
			System.out.printf("Abatimento: %.2f%n", gastosDedutiveis);
		}
		else {
			System.out.printf("Abatimento: %.2f%n", impBruto2);
		}
		
		if (gastosDedutiveis < impBruto2) {
			impDevido = impBruto1 - gastosDedutiveis;
			System.out.printf("Imposto devido: %.2f%n", impDevido);
		}
		else {
			impDevido = impBruto1 - impBruto2;
			System.out.printf("Imposto devido: %.2f%n", impDevido);
			}
		
		sc.close();
	}

}
