package Aplicacao;

import java.lang.Math;

public class Posicao {
	private int coordenadaX;
	private int coordenadaY;

	public Posicao(int x, int y) {
		coordenadaX = x;
		coordenadaY = y;
	}

	public int getX() {
		return coordenadaX;
	}

	public int getY() {
		return coordenadaY;
	}

	public static int calculaDistancia(Posicao pos1, Posicao pos2) {
		int x1 = pos1.coordenadaX;
		int x2 = pos2.coordenadaX;
		int y1 = pos1.coordenadaY;
		int y2 = pos2.coordenadaY;
		int distancia = (int) Math.sqrt( Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) );
		return distancia;
	}
	
	public String toString() {
		return "(" + coordenadaX + "," + coordenadaY + ")";
	}
}
