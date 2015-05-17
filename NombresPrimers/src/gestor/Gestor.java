package gestor;

/**
 * @author Yaiza Barrientos, Alberto Montes
 * @subject SC
 * @date 21 feb 2014
 * @exercise Practica 1
 * Generacio de Nombres Primers
 */
public class Gestor {
	protected int num;
	protected int[] primers;
	protected int candidat_primers;
	protected int candidat_resultat;
	protected int index;
	
	public Gestor(int N) {
		num = N;
		primers = new int[num];
		primers[0] = 3;
		candidat_primers = 3;
		candidat_resultat = 5;
		index = 1;
	}
	
	synchronized public int seguent_candidat() {
		candidat_primers += 2;
		if (index >= num) return 0;
		else return candidat_primers;
	}
	
	synchronized public int primer(int index) {
		while (index >= this.index)
			try {wait();} catch(InterruptedException e) {}
		return primers[index];
	}
	
	synchronized public void resultat(int candidat, boolean es_primer) {
		while (candidat != candidat_resultat)
			try {wait();} catch(InterruptedException e) {}
		
		candidat_resultat += 2;
		if (es_primer && index < num) {
			primers[index++] = candidat;
			System.out.println(candidat);
		}
		
		notifyAll();
	}	 
}