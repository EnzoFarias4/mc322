package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {
	public static void main(String args[])
	{
		Toolkit tk = Toolkit.start();
		String lombrigas[] = tk.recuperaLombrigas();
		
		for(int i = 0;lombrigas.length > i; i++)
		{
			Animacao animacao = new Animacao(lombrigas[i]);
			tk.gravaPasso("=====");
			tk.gravaPasso(animacao.apresenta());
			while(animacao.comandos.length() > 0)
			{
				animacao.passo();
				tk.gravaPasso(animacao.apresenta());
			}
		}
		tk.stop();
	}
}
