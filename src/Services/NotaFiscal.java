package Services;

import java.io.File;
import java.io.FileWriter;

public class NotaFiscal {
    
    public static void emitirNota(Pedido pedido){
        
        String diretorio = "C:\\IFSP\\Programação Orientada a Objeto\\PROJETO\\NOTASFISCAIS";
        
        File arquivo;
        
        try{
            
            arquivo = new File(diretorio, "NOTA FISCAL " + pedido.getCliente().getNome().toUpperCase());
            FileWriter escritor = new FileWriter(arquivo);
            
            
            escritor.write(pedido.toString());
            
            escritor.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
}
