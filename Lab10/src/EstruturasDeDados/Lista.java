// Esta classe eh uma reutilizacao adaptada da implementacao de uma Lista criada para
// o Laboratorio 9 (Estruturas de Dados 2.0)

package EstruturasDeDados;

import Aplicacao.Usuario;
import Aplicacao.Impressora;

public class Lista {
	private Usuario[] vetorDePessoas;
	private int tamanho;
	private int tamanhoVetor;
	private int indexPrimeiro = -1; // comeca como -1 como convencao

	// Implementacao de metodo para retornar elementos sem remove-los
	// ATENCAO : estou assumindo que a lista nao estara vazia quando o metodo for chamado
	public Usuario getFirst() {
		return vetorDePessoas[0];
	}

	public Lista() {
		vetorDePessoas = new Usuario[100];
		for (int i = 0; i < 100; i++) {
			vetorDePessoas[i] = null;
		}
		this.tamanho = 0;
		this.tamanhoVetor = 100;
	}

	public Lista(int tamanhoInicial) {
		vetorDePessoas = new Usuario[tamanhoInicial];
		for (int i = 0; i < tamanhoInicial; i++) {
			vetorDePessoas[i] = null;
		}
		this.tamanho = 0;
		this.tamanhoVetor = tamanhoInicial;
	}

	public void adicionarInicio(Usuario pessoa) {
		int indexNovoPrimeiro;
		if (tamanho > 0) {
			if (indexPrimeiro == 0)
				indexNovoPrimeiro = tamanhoVetor - 1;
			else
				indexNovoPrimeiro = indexPrimeiro - 1;
			vetorDePessoas[indexNovoPrimeiro] = pessoa;
			indexPrimeiro = indexNovoPrimeiro;
			tamanho++;
			confereTamanho();
		} else { // tamanho==0
			tamanho++;
			indexPrimeiro = 0; // comeca como -1 como convencao
			vetorDePessoas[0] = pessoa;
		}
	}

	public void adicionarFim(Usuario pessoa) {
		if (tamanho > 0) {
			int indexDerradeiro = (indexPrimeiro + tamanho - 1) % tamanhoVetor;
			vetorDePessoas[indexDerradeiro + 1] = pessoa;
			tamanho++;
			confereTamanho();
		} else { // tamanho==0
			tamanho++;
			indexPrimeiro = 0; // comeca como -1 como convencao
			vetorDePessoas[0] = pessoa;
		}
	}

	public void adicionar(Usuario pessoa, int pos) {
		if (pos > tamanho || pos < 0)
			Impressora.imprime("Posicao inalcancavel");
		else {
			if (tamanho > 0) {
				int index = (indexPrimeiro + pos) % tamanhoVetor;
				if (index == 0)
					adicionarInicio(pessoa);
				else if (index == tamanho)
					adicionarFim(pessoa);
				else {
					// mover todos a frente dele 1 casa pra frente
					int indexDerradeiro = (indexPrimeiro + tamanho - 1) % tamanhoVetor;
					for (int i = tamanho - pos - 1; i >= 0; i--) {
						int indexDoDeslocado = (index + i) % tamanhoVetor;
						vetorDePessoas[(indexDoDeslocado + 1) % tamanhoVetor] = vetorDePessoas[indexDoDeslocado];
					}
					// adicionar ele
					vetorDePessoas[index] = pessoa;
					tamanho++;
					confereTamanho();
				}
			} else { // tamanho==0
				tamanho++;
				indexPrimeiro = 0; // comeca como -1 como convencao
				vetorDePessoas[0] = pessoa;
			}
		}
	}

	public void removerInicio() {
		if (tamanho == 0)
			Impressora.imprime("Nao existem elementos para serem removidos\n\n");
		else {
			vetorDePessoas[indexPrimeiro] = null;
			indexPrimeiro = (indexPrimeiro + 1) % tamanhoVetor;
			tamanho--;
			if (tamanho == 0)
				indexPrimeiro = -1;
			confereTamanho();
		}
	}

	public void removerFim() {
		if (tamanho == 0)
			Impressora.imprime("Nao existem elementos para serem removidos\n\n");
		else {
			int indexDerradeiro = (indexPrimeiro + tamanho - 1) % tamanhoVetor;
			vetorDePessoas[indexDerradeiro] = null;
			tamanho--;
			if (tamanho == 0)
				indexPrimeiro = -1;
			confereTamanho();
		}
	}

	public void remover(int pos) {
		if (tamanho == 0)
			Impressora.imprime("Nao existem elementos para serem removidos\n\n");
		else {
			if (pos >= tamanho || pos < 0)
				Impressora.imprime("Posicao inalcancavel");
			else {
				int index = (indexPrimeiro + pos) % tamanhoVetor;
				if (index == 0)
					removerInicio();
				else if (index == tamanho)
					removerFim();
				else {
					// mover todos a frente dele 1 casa pra tras
					int indexDerradeiro = (indexPrimeiro + tamanho - 1) % tamanhoVetor;
					for (int i = 0; i < tamanho - pos - 1; i++) {
						int indexDoDeslocado = (index + i) % tamanhoVetor;
						vetorDePessoas[indexDoDeslocado] = vetorDePessoas[(indexDoDeslocado + 1) % tamanhoVetor];
					}
					vetorDePessoas[indexDerradeiro] = null;
					tamanho--;
					if (tamanho == 0)
						indexPrimeiro = -1;
					confereTamanho();
				}
			}
		}
	}

	public int tamanho() {
		return this.tamanho;
	}

	public void limpa() {
		this.tamanho = 0;
		vetorDePessoas = new Usuario[100];
		for (int i = 0; i < 100; i++) {
			vetorDePessoas[i] = null;
		}
		this.tamanhoVetor = 100;
		this.indexPrimeiro = 0;

	}

	public void imprimir() {
		for (int i = 0; i < tamanho; i++) {
			Impressora.imprime(vetorDePessoas[(indexPrimeiro + i) % tamanhoVetor] + " ");
		}
		if (tamanho == 0) {
			Impressora.imprime("(vazia)");
		}
		Impressora.imprime("\n");
	}

	private void confereTamanho() {
		if (tamanho >= 100) {
			if (tamanho == tamanhoVetor)
				aumentaLista();
			else if (tamanho == tamanhoVetor / 4)
				diminuiLista();
		}
	}

	private void aumentaLista() {
		Usuario[] vetorNovo = new Usuario[tamanhoVetor * 2];
		int c = 0;
		for (int i = indexPrimeiro; i < indexPrimeiro + tamanho; i++) {
			vetorNovo[c++] = vetorDePessoas[i % tamanhoVetor];
		}
		vetorDePessoas = vetorNovo;
		tamanhoVetor *= 2;
	}

	private void diminuiLista() {
		Usuario[] vetorNovo = new Usuario[tamanhoVetor / 2];
		int c = 0;
		for (int i = indexPrimeiro; i < indexPrimeiro + tamanho; i++) {
			vetorNovo[c++] = vetorDePessoas[i % tamanhoVetor];
		}
		vetorDePessoas = vetorNovo;
		tamanhoVetor /= 2;

	}

}
