import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.io.BufferedReader;
import java.io.File;

public class Act7 {
    public static void main(String[] args){
        if (args.length==0) System.out.println("No se ingreso un nombre de archivo");
        else{
            Set<String> palabras = new TreeSet<>();
            Set<String> stop = new TreeSet<>();
            File[] files = {new File("stopwords-es.txt"), new File(args[0])};
            BufferedReader br = null;
            String line;
            String delim = "\\s+|,\\s*|\\.\\s*|\\;\\s*|\\:\\s*|\\!\\s*|\\¡\\s*|\\¿\\s*|\\?\\s*|\\-\\s*|\\[\\s*|\\]\\s*|\\(\\s*|\\)\\s*|\\\"\\s*|\\_\\s*|\\%\\s*|\\+\\s*|\\/\\s*|\\#\\s*|\\$\\s*";
            try{
                br = new BufferedReader(new FileReader(files[0]));
                while((line=br.readLine())!=null){
                    if(line.trim().length()==0) continue;
                    String words[] = line.split(delim);
                    for(String p:words){
                        p = p.toLowerCase().trim();
                        stop.add(p);
                    }
                }
                br = new BufferedReader(new FileReader(files[1]));
                while((line=br.readLine())!=null){
                    if(line.trim().length()==0) continue;
                    String words[] = line.split(delim);
                    for(String p:words){
                        p = p.toLowerCase().trim();
                        if(!stop.contains(p)){
                            palabras.add(p);
                        }
                    }
                }
            }catch(IOException e){
                System.out.println("Excepcion IO");
            }
            System.out.printf("El texto \"%s\" contiene %d palabras diferentes.", args[0], palabras.size());
        }
    }
}