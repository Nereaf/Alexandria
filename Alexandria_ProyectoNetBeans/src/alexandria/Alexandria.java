package alexandria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.clipsrules.jni.*;
import org.apache.commons.text.WordUtils;


public class Alexandria {
    
    public static Environment clips;
    
    
    public static ArrayList<Libro> buscar(String titulo, String autor, String genero, String idioma){
        ArrayList<Libro> libros = new ArrayList<>();
        try {
            titulo = titulo.isEmpty()? "TRUE" : "(eq 1 (regex_match "+ WordUtils.capitalizeFully(titulo.trim()).replace(" ", "_") +" ?f:titulo))";
            autor = autor.isEmpty()? "TRUE" : "(eq 1 (es-miembro "+WordUtils.capitalizeFully(autor.trim()).replace(" ", "_")+" ?f:autores))";
            genero = genero.isEmpty() ? "TRUE" : "(eq 1 (es-miembro "+WordUtils.capitalizeFully(genero.trim()).replace(" ", "_")+" ?f:generos))";
            idioma = idioma.equals("Todos los idiomas") ? "TRUE" : "(eq 1 (es-miembro "+idioma+" ?f:idiomas))";
            for(FactAddressValue numFact : clips.findAllFacts("?f", "Libro", String.format("(and %s (and %s (and %s %s)))",titulo,autor,genero,idioma))){
                String titulo_fin = numFact.getSlotValue("titulo").toString().replaceAll("_", " ");
                String autores_fin = numFact.getSlotValue("autores").toString().replaceAll(" ",", ").replaceAll("_", " ");
                String generos_fin = numFact.getSlotValue("generos").toString().replaceAll(" ",", ").replaceAll("_", " ");
                String idiomas_fin = numFact.getSlotValue("idiomas").toString().replaceAll(" ",", ").replaceAll("_", " ");
                libros.add(new Libro(titulo_fin,
                                    autores_fin.substring(1, autores_fin.length()-1),
                                    generos_fin.substring(1, generos_fin.length()-1),
                                    idiomas_fin.substring(1, idiomas_fin.length()-1),
                                    numFact.getSlotValue("favorito").toString().equals("si")));
            }
        } catch (CLIPSException ex) {
        }
        return libros;
    }

    static void setfavorito(String titulo, Boolean aBoolean) {
        try {
            clips.eval(String.format("(assert (actualizarFav %s %s))",titulo,aBoolean ? "si" : "no"));
            clips.run();
        } catch (CLIPSException ex) {
        }
    }

    static Iterable<String> getGeneros() {
        ArrayList<String> generos = new ArrayList<>();
        try {
            for(FactAddressValue numFact : clips.findAllFacts("?f", "Libro", "TRUE")){
                for(String genero : numFact.getSlotValue("generos").toString().substring(1, numFact.getSlotValue("generos").toString().length()-1).split(" ")){
                    genero = genero.replace("_", " ");
                    if(!generos.contains(genero))
                        generos.add(genero);
                }
            }
        } catch (CLIPSException ex) {
        }
        Collections.sort(generos);
        return generos;
    }

    static Iterable<String> getAutores() {
        ArrayList<String> autores = new ArrayList<>();
        try {
            for(FactAddressValue numFact : clips.findAllFacts("?f", "Libro", "TRUE")){
                for(String autor : numFact.getSlotValue("autores").toString().substring(1, numFact.getSlotValue("autores").toString().length()-1).split(" ")){
                    autor = autor.replace("_", " ");
                    if(!autores.contains(autor))
                        autores.add(autor);
                }
            }
        } catch (CLIPSException ex) {
        }
        Collections.sort(autores);
        return autores;
    }

    static Iterable<Libro> buscarFavoritos() {
        ArrayList<Libro> libros = new ArrayList<>();
        try {
            for(FactAddressValue numFact : clips.findAllFacts("?f", "Libro", "(eq ?f:favorito si)")){
                String titulo_fin = numFact.getSlotValue("titulo").toString().replaceAll("_", " ");
                String autores_fin = numFact.getSlotValue("autores").toString().replaceAll(" ",", ").replaceAll("_", " ");
                String generos_fin = numFact.getSlotValue("generos").toString().replaceAll(" ",", ").replaceAll("_", " ");
                String idiomas_fin = numFact.getSlotValue("idiomas").toString().replaceAll(" ",", ").replaceAll("_", " ");
                libros.add(new Libro(titulo_fin,
                                    autores_fin.substring(1, autores_fin.length()-1),
                                    generos_fin.substring(1, generos_fin.length()-1),
                                    idiomas_fin.substring(1, idiomas_fin.length()-1),
                                    numFact.getSlotValue("favorito").toString().equals("si")));
            }
        } catch (CLIPSException ex) {
        }
        return libros;
    }

    static Iterable<Libro> obtenerRecomendaciones() {
        ArrayList<Libro> libros = new ArrayList<>();
        try {
            //Limpiamos recomendaciones anteriores
            FactAddressValue valLimpieza = clips.findFact("limpieza");
            clips.eval(String.format("(retract %s)",valLimpieza.getFactIndex()));
            clips.eval("(assert (limpieza si))");
            clips.run();
            // Generamos nuevas recomendaciones
            valLimpieza = clips.findFact("limpieza");
            clips.eval(String.format("(retract %s)",valLimpieza.getFactIndex()));
            clips.eval("(assert (limpieza no))");
            clips.run();
            // Checkeamos si no quedan más
            if(clips.findFact("sinRespuesta").getSlotValue("implied").toString().equals("si")){
                return libros;
            }
            for(FactAddressValue numFact : clips.findAllFacts("?f", "Libro", "(eq ?f:recomendado si)")){
                String titulo_fin = numFact.getSlotValue("titulo").toString().replaceAll("_", " ");
                String autores_fin = numFact.getSlotValue("autores").toString().replaceAll(" ",", ").replaceAll("_", " ");
                String generos_fin = numFact.getSlotValue("generos").toString().replaceAll(" ",", ").replaceAll("_", " ");
                String idiomas_fin = numFact.getSlotValue("idiomas").toString().replaceAll(" ",", ").replaceAll("_", " ");
                libros.add(new Libro(titulo_fin,
                                    autores_fin.substring(1, autores_fin.length()-1),
                                    generos_fin.substring(1, generos_fin.length()-1),
                                    idiomas_fin.substring(1, idiomas_fin.length()-1),
                                    numFact.getSlotValue("favorito").toString().equals("si")));
            }

        } catch (CLIPSException ex) {
        }
        return libros;
    }

    static void actualizarPreferencias() {
        try {
            String vetosAutores = String.join(" ", Main.vetosAutores);
            String vetosGeneros = String.join(" ", Main.vetosGeneros);
            String favoritosAutores = String.join(" ", Main.favoritosAutores);
            String favoritosGeneros = String.join(" ", Main.favoritosGeneros);
           
            FactAddressValue valLimpieza = clips.findFact("Usuario");
            clips.eval(String.format("(modify %s (autoresVetados %s))",valLimpieza.getFactIndex(),vetosAutores));
            clips.eval(String.format("(modify %s (generosVetados %s))",valLimpieza.getFactIndex(),vetosGeneros));
            clips.eval(String.format("(modify %s (autoresFavoritos %s))",valLimpieza.getFactIndex(),favoritosAutores));
            clips.eval(String.format("(modify %s (generosFavoritos %s))",valLimpieza.getFactIndex(),favoritosGeneros));
            } catch (CLIPSException ex) {
        }
    }
    
    public static class Regex implements UserFunction{
        @Override
        public PrimitiveValue evaluate(List<PrimitiveValue> list) {
            String primero = list.get(0).getValue().toString();
            String segundo = list.get(1).getValue().toString();
            return segundo.toLowerCase().contains(primero.toLowerCase()) ? new IntegerValue(1) : new IntegerValue(0);
        }
    }
    
    public static void init() {
        try {
            clips = new Environment();
            clips.load("baseHechos.clp");
            clips.addUserFunction("regex_match", new Regex());
            clips.load("reglas.clp");
            clips.reset();
        } catch (Exception e) {
        }
    }

}
