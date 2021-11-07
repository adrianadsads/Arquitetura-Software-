import java.util.Scanner;

public class Cifras {
	
	public static void main(String[] args) {
	
	Scanner inicio= new Scanner(System.in);	
	System.out.println("Digite a mensagem");
	String mensagem= inicio.nextLine();
	System.out.println("A mensagem é:" + mensagem);
	System.out.println("digite a senha: ");
	String senha= inicio.nextLine();
	System.out.println("A mensagem criptografada e dscriptografada com código Cesar é: "+mensagem);
	
	char array[] = mensagem.toCharArray();
	
	for (int i= 0; i< array.length; i++ ) {	
		array[i]=(char)(array[i]+(char)5);
	}
   String encriptar =String.valueOf(array);
   
   System.out.println(encriptar);
   
   char arrayD[] = encriptar.toCharArray();
   
   for(int i= 0; i<arrayD.length; i++) {
	   arrayD[i] =(char)(arrayD[i]-(char)5);
   }
   String descriptar = String.valueOf(arrayD);
   
   System.out.println(descriptar);
	}
		

}