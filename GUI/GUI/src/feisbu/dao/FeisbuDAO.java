package feisbu.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


import feisbu.model.Grupo;
import feisbu.model.Usuario;

public class FeisbuDAO {
    private static final String amigos = "fb_amistades1.txt";
    private static final String usuarios = "fb_usuarios.txt";
    
    public Set<Usuario> getDatos(){
        Set<Usuario> usuariosFeisbu = new HashSet<>();
        try (BufferedReader brd = new BufferedReader(new FileReader(usuarios));
        BufferedReader brd2 = new BufferedReader(new FileReader(amigos))) {
            String linea = brd.readLine();
            while (linea != null) {
                String[] partes = linea.split(";");
                String nombre = partes[0];
                String nombreCompleto = partes[1];
                int dia = Integer.parseInt(partes[partes.length-1]);
                int mes = Integer.parseInt(partes[partes.length-2]);
                int anio = Integer.parseInt(partes[partes.length-3]);
                char genero = partes[partes.length-4].charAt(0);
                Usuario usuario = new Usuario(nombre, nombreCompleto,LocalDate.of(anio, mes, dia),genero);
                if(partes.length > 6){
                    for (int i = 2; i < partes.length - 4; i++) {
                        String nombreGrupo = partes[i];
                        Grupo grupo = new Grupo(nombreGrupo);
                        usuario.aniadirGrupo(grupo);
                    }
                }
                usuariosFeisbu.add(usuario);
                linea = brd.readLine();
            }

            String linea2 = brd2.readLine();
            while (linea2 != null) {
                String[] partes = linea2.split(":");
                for (Usuario usuario : usuariosFeisbu) {
                    if(usuario.getNombre().equals(partes[0])){
                        String[] partesAmigos = partes[1].split(";");
                        if(partesAmigos.length > 1){ 
                            for (String string : partesAmigos) {
                                for (Usuario usuario2 : usuariosFeisbu) {
                                    if(string.equals(usuario2.getNombre())){
                                        usuario.aniadirAmigo(usuario2);
                                    }
                                    
                                }
                               
                            }

                        }else{
                            String nombreAmigo = partesAmigos[0];
                            for (Usuario usuario2 : usuariosFeisbu) {
                                if(nombreAmigo.equals(usuario2.getNombre())){
                                    usuario.aniadirAmigo(usuario2);
                                }
                                
                            }
                            
                        }
                    }
                
                }
                linea2 = brd2.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return usuariosFeisbu;
    }
}
