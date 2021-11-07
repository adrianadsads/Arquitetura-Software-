package notas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.plaf.FileChooserUI;
import javax.swing.text.TextAction;

public class Interface extends JFrame {
	
	JTextArea AreaDeTexto;
	JButton  botao;
	
	public Interface() {
		
		AreaDeTexto = new JTextArea();
		botao = new JButton("Salva");
		
		add(AreaDeTexto, "Center");
		add(botao, "South");
			
		botao.addActionListener (new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileC = new JFileChooser();
				fileC.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int i= fileC.showSaveDialog(null);
				
				if (i==1){
			         JOptionPane.showMessageDialog(null,"Não foi escolhido nome de arquivo",
			        		 "Alerta", JOptionPane.ERROR_MESSAGE);
			       } else {
			           File arquivo = fileC.getSelectedFile();
			        
			           FileWriter arq;
					try {
					
						arq = new FileWriter(arquivo.getAbsolutePath());
						PrintWriter gravarArquivo = new PrintWriter(arq);
						
						gravarArquivo.printf(" ");
						gravarArquivo.printf(AreaDeTexto.getText() + "%n");
					
						arq.close();
						
						JOptionPane.showMessageDialog(null, " O arquivo " + arquivo.getName() + " foi salvo com sucesso! ",
				        		 "Alerta" + arquivo.getName(), JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
			           
			       }
				
			}
			
		}
		
	);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		setVisible(true);		
 }
}
