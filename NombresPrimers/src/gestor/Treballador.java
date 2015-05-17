package gestor;

/**
 * @author Yaiza Barrientos, Alberto Montes
 * @subject SC
 * @date 21 feb 2014
 * @exercise Practica 1
 * Generacio de Nombres Primers
 */
public class Treballador extends Thread{
	protected int[] primers;
	protected int ultim_index;
	protected Gestor gestor;
	
	Treballador(int N, Gestor g){
		primers = new int[N];
		primers[0] = 3;
		ultim_index = 0;
		gestor = g;
	}
	public void run(){
		//System.out.println(currentThread());
		
		while (true){
			int candidat, i;
			boolean es_primer;
			
			//-----
			candidat = gestor.seguent_candidat();
			
			if(candidat == 0)  break;
			es_primer = true;
			i = 0;
			while(es_primer && (primers[i] * primers[i] <= candidat)){
				if(candidat % primers[i] == 0) es_primer=false;
				else {
					i++;
					if(i>ultim_index) {
						int primer;
						
						//-----
						primer = gestor.primer(i);
						
						ultim_index++;
						primers[ultim_index] = primer;
					}
				}
			}
			
			//-------
			gestor.resultat(candidat, es_primer);			
		}	
	}
}
