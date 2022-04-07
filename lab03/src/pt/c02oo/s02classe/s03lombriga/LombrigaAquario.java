package pt.c02oo.s02classe.s03lombriga;

public class LombrigaAquario {
	int head;
	int tamanholo;
	int tamanhoaq;
	int d = 1;
	
	LombrigaAquario(int h,int tlo,int taq){
		if(0 >= taq || taq > 15) {
			System.out.println("Aquario invalido");
			return ;
		}
		this.tamanhoaq = taq;
		if(0 >= tlo){
		System.out.println("Lombriga não existe");
		return ;
		}
		int min = tlo > taq ? taq : tlo;
		this.tamanholo =  min - 1;
		if(1 > h) {
		System.out.println("Lombriga fora do aquario, repetir");
		return ;
		}
		this.head = (h + tlo) > taq ? 1 : h;
	}
	
	void crescer()
	{
		int x = head + d*(tamanholo + 1);
		if(1 > x || 
				x >= 15)
		{return ;}
		tamanholo++;
	}
	
	void virar()
	{
		head += d*tamanholo;
		d = -d;
	}
	
	void mover()
	{
		if(head == 1 || head == tamanhoaq)
		{
			virar();
			return ;
		}
		
		head -= d;
	}
	
	String apresenta()
	{
		String s = "";
		int l, t;
		l = d > 0 ? head : head + d*tamanholo;
		t = l == head ? head + d*tamanholo : head;
		for(int i = 1;l > i;i++)
		{
			s += '#';
		}
		s += l == head ? '0' : '@';
		for(int i = l + 1;t > i;i++)
		{
			s += '@';
		}
		s += t == head ? '0' : '@';
		for(int i = t + 1;tamanhoaq >= i;i++)
		{
			s += '#';
		}
		return s;
	}	
}
