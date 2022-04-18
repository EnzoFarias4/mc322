package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
	private int i;
	private int j;
	private char tipo;
	private int[] possiveis = new int[8];
	
	Peca(char tipo) {
		this.tipo = tipo;
	}
	
	void setI(int i){
		if(6 >= i && 
				i >= 0) {
			this.i = i;
		}
	}
	
	void setJ(int j) {
		if(6 >= j && 
				j >= 0) {
			this.j = j;
		}
	}
	
	void setPossiveis() {
		possiveis[0] = 7*i + j - 14;
		possiveis[2] = 7*i + j - 2;
		possiveis[4] = 7*i + j + 2;
		possiveis[6] = 7*i + j + 14;
		possiveis[1] = 7*i + j - 7;
		possiveis[3] = 7*i + j - 1;	
		possiveis[5] = 7*i + j + 1;
		possiveis[7] = 7*i + j + 7;
	}
	
	void setTipo(char tipo) {
		switch(tipo) {
		case ' ':
		case 'P':
		case '-':this.tipo = tipo;
		default: break;
		}
	}
	
	int getI() {
		return this.i;
	}
	
	int getJ() {
		return this.j;
	}
	
	char getTipo() {
		return this.tipo;
	}
	
	int permissao(String end, char endtipo) {
		int i2, j2;		
		i2 = end.charAt(1) - '1';
		j2 = end.charAt(0) - 'a';
		
		if(7*i2 + j2 >= 49) {return -1;}
		
		switch(endtipo) {
		case 'P':
		case ' ':return -1;
		case '-':break;
		default:return -1;
		}
		
		int d = -1;
		for(int i = 0; 8 > i; i += 2) {
			if(possiveis[i] == 7*i2 + j2) {
				d = i;
				break;
			}
		}
		if(d == -1) {return d;}
		return possiveis[d + 1];
	}
}
