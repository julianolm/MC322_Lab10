package Aplicacao;

import java.util.Calendar;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	private boolean somenteAno;

	public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		somenteAno = false;
	}

	public String toString() {
		String dt;
		if (!somenteAno) {
			String stringDia = Integer.toString(dia);
			String stringMes = Integer.toString(mes);
			if (dia < 10)
				stringDia = "0" + stringDia;
			if (mes < 10)
				stringMes = "0" + stringMes;

			dt = "(" + stringDia + "/" + stringMes + "/" + ano + ")";
		} else {
			dt = Integer.toString(ano);
		}
		return dt;
	}

	
	//PARA TESTES
	public static void main(String args[]) {
		System.out.println(Calendar.JANUARY);
	}

}