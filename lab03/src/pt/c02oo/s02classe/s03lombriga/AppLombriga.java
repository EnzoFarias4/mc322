package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {
	public static void main(String args[])
	{
		Animacao s = new Animacao("080403MCMVM");
		while(s.comandos.length() != 0)
		{
			System.out.println(s.apresenta());
			s.passo();
		}
		System.out.println(s.apresenta());
	}
}
