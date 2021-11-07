package demoCriptografia2;

import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		// ler texto do usuario
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("digite alguma coisa: ");
		
		String texto = entrada.nextLine();
		
		System.out.println("voce digitou: " + texto);
		
		// criptografar texto do usuario
		
		String textoCifrado = criptografarSemSenha(texto);
		
		// exibir o texto criptografado
		
		System.out.println("seu texto cifrado eh: " + textoCifrado);
		
		// decifrar o texto criptografado
		
		String textoDecifrado=criptografarSemSenha(textoCifrado);
		
		// exibir o texto decifrado
		
		System.out.println("seu texto decifrado eh: " + textoDecifrado);
		
		// pedir senha para o usuario
		
		System.out.print("digite uma senha por favor: ");
		String senha= entrada.nextLine();
		
		// criptografar com senha usando cifra de cesar
		
		int deslocamento = senha.length();
		textoCifrado = criptografarCaesar(texto, deslocamento);
		
		// exibir o texto cifrado
		
		System.out.println("texto cifrado com caesar: "+textoCifrado);
		
		// decifrar
		
		textoDecifrado = criptografarCaesar(textoCifrado, 26-deslocamento);
		
		// exibir o texto decifrado

		System.out.println("texto decifrado com caesar: "+textoDecifrado);
		
	}
	

	private static String criptografarCaesar(String texto, int deslocamento) {
		
		StringBuilder escrivao= new StringBuilder();

		for(int i=0; i<texto.length();i++) {

			if(Character.isAlphabetic(texto.charAt(i))) {

				if (Character.isUpperCase(texto.charAt(i))) 
				{ 
					char ch = (char)(((int)texto.charAt(i) + 
							deslocamento - 65) % 26 + 65); 
					escrivao.append(ch); 
				} 
				else
				{ 
					char ch = (char)(((int)texto.charAt(i) + 
							deslocamento - 97) % 26 + 97); 
					escrivao.append(ch);  	
				}
			} else {			
				escrivao.append(texto.charAt(i));
			}

		}
		return escrivao.toString();
	}

	private static String criptografarSemSenha(String texto) {
		
		StringBuilder escrivao = new StringBuilder();
		
		String textoCifrado="";
		
		for(int i=0; i < texto.length()-1;i+=2) {
			escrivao.append(texto.charAt(i+1));
			escrivao.append(texto.charAt(i));			
		}
		
		textoCifrado = escrivao.toString();
		
		return textoCifrado;
	}
	

}
