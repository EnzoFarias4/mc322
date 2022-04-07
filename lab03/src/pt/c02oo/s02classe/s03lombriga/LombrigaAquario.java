package pt.c02oo.s02classe.s03lombriga;

public class LombrigaAquario {
	int head;
	int tamanholo;
	int tamanhoaq;
	int d = 1;
	
	LombrigaAquario(int h,int tlo,int taq){
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
				x > tamanhoaq)
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
		if (d > 0)
		{
			for(int i = 1;tamanhoaq >= i;i++)
			{
				if(i == head) {
					s += 'O';
					i++;
					while(head + d*tamanholo >= i)
					{
						s += '@';
						i++;
					}
					i--;
					}
				else
				{
				s += '#';
				}
			}
		}
		else
		{
			for(int i = 1;tamanhoaq >= i;i++)
			{
				if(i == head + d*tamanholo) {
					while(head > i)
					{
						s += '@';
						i++;
					}
					s += 'O';
				}
				else
				{
				s += '#';
				}
			}
		}
		return s;
	}
}
		

