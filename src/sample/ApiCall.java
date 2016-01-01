package sample;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 47419119l on 10/12/2015.
 */
public class ApiCall {

    private static String jsonPoke;
    private static String jsonMov;
    private static String urlBase ="http://pokeapi.co";

    /**
     *
     * @param urlToRead
     * @return
     * @throws Exception
     */
    public static String getHTML(String urlToRead) throws Exception {

        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    /**
     * Metode per extreure la informació del Json
     * Crida als metodes inserts per anar insrtant l'informació a la BBDD.
     */
    public static void extreureInformacioJson(){

    for(int i=1;i<30;i++) {

        String peticioPeli = urlBase+"/api/v1/pokemon/" + i;

        try {
            //Metemos en una variable String el JSON que nos da el metodo getHTML
            jsonPoke = getHTML(peticioPeli);
            //Creamos un objeto generico que es lo que devuelve el JSON
            Object obj = JSONValue.parse(jsonPoke);

            //Lo pasamos a un objeto simple con la libreria JSONSimple
            JSONObject objJSimple = (JSONObject) obj;


            String idPoke = String.valueOf(i);
            String nombre = (String) objJSimple.get("name");
            //insertat pokemon
            DAOPokemondb.insertPokemon(idPoke, nombre);
            JSONArray arrayJsonMoves = (JSONArray) objJSimple.get("moves");

            for(int y=0; y<arrayJsonMoves.size();y++){

                JSONObject jom = (JSONObject)arrayJsonMoves.get(y);

                String idmov = ((String)jom.get("resource_uri"));
                String namemov = ((String)jom.get("name"));

                jsonMov=getHTML(urlBase+idmov);
                Object objmov = JSONValue.parse(jsonMov);
                JSONObject objSimpleMov = (JSONObject) objmov;
                String descripcion = (String)objSimpleMov.get("description");

                /**
                 * Insertem a la base de dades els moviments
                 */
                DAOPokemondb.insert_poke_mov(idPoke,idmov);
                DAOPokemondb.insertMoves(idmov,namemov,descripcion);


            }
            //Hacemos lo mismo para los tipos
            JSONArray arrayJSONTipos = (JSONArray) objJSimple.get("types");
            String tipo;
            String ids;

            /**
             * Extraiem es tipos de cada un dels pokemon.
             */
            for (int j = 0; j < arrayJSONTipos.size(); j++) {
                JSONObject jb = (JSONObject) arrayJSONTipos.get(j);
                ids = ((String) jb.get("resource_uri"));
                tipo = ((String) jb.get("name"));

                /*
                Inssertem a la BBDD els tipos
                 */
                DAOPokemondb.insertpoke_tipo(idPoke, ids);
                DAOPokemondb.inserttipo(ids, tipo);
            }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
         DAOPokemondb.crearPokemondb();

         extreureInformacioJson();
    }

    }
