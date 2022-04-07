package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
	String comandos;
	LombrigaAquario lombriga;
	
	Animacao(String comandos)
	{
		int c1, c2, c3;
		c1 = Integer.parseInt(comandos.substring(0, 2));
		c2 = Integer.parseInt(comandos.substring(2, 4));
		c3 = Integer.parseInt(comandos.substring(4, 6));
		this.comandos = comandos.substring(6);
		lombriga = new LombrigaAquario(c3,c2,c1);
	}
	
	String apresenta()
	{
		return lombriga.apresenta();
	}
	
	void passo()
	{
		if(comandos.length() == 0) {return ;}
		char c = comandos.charAt(0);
		comandos = comandos.substring(1);
		switch(c)
		{
		case 'M':lombriga.mover();break;
		case 'V':lombriga.virar();break;
		case 'C':lombriga.crescer();break;
		default:break;
		}
	}
}
