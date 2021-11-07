
package encriptar;


//Cifras de Cesar//
import java.util.Scanner;


public class Cesar {

 private String mensagem;
 private  int senha;
 private static char [] alfabeto = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
 

 public Cesar() {
	 super();
	  	 
}
public Cesar(String mensagem, int senha) {
	super();
	this.mensagem=mensagem;
	this.senha=senha;
}

public String getMensagem() {
	return mensagem;
}

public void setMensagem(String mensagem) {
	this.mensagem = mensagem;
}
public int getSenha() {
	return senha;
}

public void setSenha(int senha) {
	this.senha = senha;
}

public static char[] getAlfabeto() {
	return alfabeto;
}

public static void setAlfabeto(char[] alfabeto) {
	Cesar.alfabeto = alfabeto;
}
//Leitura dos dados.//
public void lerDados() {
		
	Scanner sc = new Scanner (System.in);

	System.out.println("Digite a mensagem");
	setMensagem(sc.nextLine().toUpperCase());
	
    
	System.out.println("Digite a senha");
    setSenha(sc.nextInt());
    
    sc.close();
    
    //Método de cifrar a mensagem//
    	
}
	
public char[] encriptar() {
	
	char[] novaMensagem = new char[getMensagem().length()];
	for(int i=0; i<getMensagem().length(); i++) {
		
		if(getMensagem().charAt(i)==' ') {
			novaMensagem[i]=getMensagem().charAt(i);
			
		}else {
			for(int j=0; j<getAlfabeto().length; j++) {
				
				if(getMensagem().charAt(i)==getAlfabeto()[j]) {
					if(getSenha()<0) {
						novaMensagem[i]=getAlfabeto()[(j+getSenha()+getAlfabeto().length)%getAlfabeto().length];
						j=getAlfabeto().length;
					}else {
						novaMensagem[i]=getAlfabeto()[(j+getSenha()%getAlfabeto().length)];
						j=getAlfabeto().length;
				
	                }
					
				}else {
					novaMensagem[i]=getMensagem().charAt(i);
				}
			}
		}
	}
return novaMensagem;
}
//Método de descifrar mensagem//	
public char[] descriptar() {

char[] novaMensagem = new char[getMensagem().length()];
for(int i=0; i<getMensagem().length(); i++) {
	
	if(getMensagem().charAt(i)==' ') {
		novaMensagem[i]=getMensagem().charAt(i);
		
	}else {
		for(int j=0; j<getAlfabeto().length; j++) {
			
			if(getMensagem().charAt(i)==getAlfabeto()[j]) {
				if(j<getSenha()) {
					novaMensagem[i]=getAlfabeto()[(j-getSenha()+getAlfabeto().length)%getAlfabeto().length];
					j=getAlfabeto().length;
				}else {
					novaMensagem[i]=getAlfabeto()[(j-getSenha()%getAlfabeto().length)];
					j=getAlfabeto().length;
			
                }
				
			}else {
				novaMensagem[i]=getMensagem().charAt(i);
			}
		}
	}
}
return novaMensagem;
  }
}
