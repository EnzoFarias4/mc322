package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	public Peca[] mapa = new Peca[49];

	Tabuleiro() {
		for(int i = 0;49 > i; i++) {
			mapa[i] = new Peca(' ');
			mapa[i].setI(i/7);
			mapa[i].setJ(i % 7);
			mapa[i].setPossiveis();
		}
		
		for(int i = 2;4 >= i; i++) {
			for(int j = 0;6 >= j; j++) {
				mapa[7*i + j].setTipo('P');
			}
		}
		
		for(int i = 0;6 >= i; i++) {
			for(int j = 2; 4 >= j; j++) {
				mapa[7*i + j].setTipo('P');
			}
		}
		mapa[24].setTipo('-');
	}
	
	void verificar(String comando, char board[][], Toolkit tk) {
		String start = comando.substring(0, 2);
		String end = comando.substring(3);
		int i1 = start.charAt(1) - '1';
		int j1 = start.charAt(0) - 'a';
		if(7*i1 + j1 >= 49 ||
				mapa[7*i1 + j1].getTipo() != 'P') {return;}
		int i2 = end.charAt(1) - '1';
		int j2 = end.charAt(0) - 'a';
		if(7*i2 + j2 >= 49){return ;}
		int k = mapa[7*i1 + j1].permissao(end, mapa[7*i2 + j2].getTipo());
		if(k != -1 &&
				mapa[k].getTipo() == 'P') {
				mapa[k].setTipo('-');
				mapa[7*i1 + j1].setTipo('-');
				mapa[7*i2 + j2].setTipo('P');
		}
		registro(board,tk,comando,k);
	}

	void registro(char board[][],Toolkit tk,String comando,int possivel) {
		String start = comando.substring(0, 2);
		String end = comando.substring(3);
		int i1 = start.charAt(1) - '1';int j1 = start.charAt(0) - 'a';
		int i2 = end.charAt(1) - '1';int j2 = end.charAt(0) - 'a';
		board[i1][j1] = mapa[7*i1 + j1].getTipo();
		board[i2][j2] = mapa[7*i2 + j2].getTipo();
		if(possivel != -1) {board[possivel/7][possivel % 7] = mapa[possivel].getTipo();}
		tk.writeBoard("source: " + start + ";" + " target: " + end, board);
	}
}
