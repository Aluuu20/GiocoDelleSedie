/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Logger;
import static java.lang.Thread.sleep;
import java.util.Scanner;

/**
 *
 * @author Alu
 */
public class TestGiocoSedie {
    private static Logger logger = Logger.getLogger("GiocoSedie.TestGiocoSedie");//viene usato Logger per registrare i messaggi di log
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         
         System.out.print("Inserisci il numero di partecipanti: ");
        int numPartecipanti = scanner.nextInt();

         
        if (numPartecipanti < 2) {
                   System.out.println("Il numero di partecipanti deve essere almeno 2.");
                   return;
               }

        int numSedie = numPartecipanti - 1; // Una sedia in meno rispetto ai partecipanti

        Posto sedie[] = new Posto[numSedie];//l'oggetto viene inizializzato con il valore di NUMSEDIE

        
        
        
	for (int k = 0; k < sedie.length; k++)
		sedie[k] = new Posto();

	Display display = new Display(sedie);//visualizza lo stato delle sedie


        logger.info("Sto facendo partire il Display.\n");
        System.out.println("Regole del gioco:");
        System.out.println("Ogni riga rappresenta lo stato delle sedie.");
        System.out.println("Lo 0 indica le sedie libere.");
        System.out.println("L * indica le sedie occupate.");
        try {
            Thread.sleep(2000); // Pausa di 2 secondi
        } catch (InterruptedException e) {
            System.out.println("Il thread è stato interrotto!");
        }
        
	display.start();

	Partecipante array[] = new Partecipante[numSedie+1];//viene creato un numero d giocatori maggiore di uno rispetto alle sedie
	for (int i = 0; i < numSedie + 1; i++) {
		array[i] = new Partecipante(sedie);
                //System.out.println("Sto facendo partire il thread n." + array[i].getId());
                logger.info("Sto facendo partire il thread id: " + array[i].getId()+" name: "+array[i].getName()+"\n");
                array[i].start();
                }
	}
    }
 
