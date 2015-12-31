package sample;

import javafx.collections.ObservableList;

import java.sql.*;

/**
 * Created by shengbin on 2015/12/31.
 */
public class DAOPokemondb {

    /**
     *Metode per crear la BBDD.
     */
    public static void crearPokemondb(){
        {
            Connection c = null;
            Statement stmt = null;

            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:pokemon.db");
                System.out.println("La BBDD ha sigut creada");

                stmt = c.createStatement();
                /*
                    Creo les taules i les executo.
                    Taula amb els pokemons.
                 */
                String sql_pokemon = "CREATE TABLE POKEMONS " +
                        "(ID TEXT PRIMARY KEY     NOT NULL," +
                        " NAME TEXT    NOT NULL)";

                stmt.executeUpdate(sql_pokemon);
                /**
                 * Enllaça els pokemons amb els ses tipus
                 */
                String sql_pok_tip = "CREATE TABLE POK_TIP " +
                        "(ID_POK INT    NOT NULL," +
                        " ID_TIPO   TEXT    NOT NULL," +
                        " PRIMARY KEY(ID_POK,ID_TIPO))";

                stmt.executeUpdate(sql_pok_tip);
                /**
                 * Taula amb es diferents tipos de pokemon
                 */
                String sql_TIPO = "CREATE TABLE TIPO " +
                        "(ID TEXT  PRIMARY KEY NOT NULL," +
                        " NAME   TEXT    NOT NULL)";

                stmt.executeUpdate(sql_TIPO);
                /**
                 * Taula que enllaça els movimets amb els pokemons
                 */
                String sql_pok_mov = "CREATE TABLE POK_MOV " +
                        "(ID_POK INT    NOT NULL," +
                        " ID_MOVE   TEXT    NOT NULL," +
                        " PRIMARY KEY(ID_POK,ID_POK))";

                stmt.executeUpdate(sql_pok_mov);

                /**
                 * Taula per el moviments de cada pokemon
                 */
                String sql_moves = "CREATE TABLE MOVES " +
                        "(ID TEXT  PRIMARY KEY NOT NULL," +
                        " DESCRIPTION TEXT NOT NULL,"+
                        " NAME TEXT    NOT NULL)";

                stmt.executeUpdate(sql_moves);



            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("Taules creades correctament.");
        }

    }
    /**
     * Metode per insertar pokemons.
     * @param ID
     * @param NAME
     */
    public static void insertPokemon(String ID, String NAME) {

        Connection c = null;
        Statement stmt = null;
        try {

            /*
            Conectem amb la BBDD
             */
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pokemon.db");


            /*
            Fem el insert.
             */
            String sql_insert = "INSERT INTO POKEMONS" +
                    " (ID,NAME) VALUES" +
                    " (?, ?);";

            PreparedStatement preparedStatement = c.prepareStatement(sql_insert);
            preparedStatement.setString(1, ID);
            preparedStatement.setString(2, NAME);

            /*
            Executem el insert.
             */
            preparedStatement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.print("");
        }

    }

    /**
     * Metode per insertar moves
     * @param ID
     * @param NAME
     * @param DESCRIPTION
     */
    public static void insertMoves(String ID, String NAME, String DESCRIPTION) {

        Connection c = null;
        Statement stmt = null;
        try {

            /*
            Conectem amb la BBDD
             */
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pokemon.db");


            /*
            Fem el insert.
             */
            String sql_insert = "INSERT INTO MOVES" +
                    " (ID,DESCRIPTION,NAME) VALUES" +
                    " (?, ?,?);";

            PreparedStatement preparedStatement = c.prepareStatement(sql_insert);
            preparedStatement.setString(1, ID);
            preparedStatement.setString(2, DESCRIPTION);
            preparedStatement.setString(3, NAME);

            /*
            Executem el insert.
             */
            preparedStatement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.print("");
        }

    }

    /**
     * Metode per insertar la relacio pokemon moves
     * @param ID_POK
     * @param ID_MOVE
     */
    public static void insert_poke_mov(String ID_POK,String ID_MOVE){

        Connection c = null;
        Statement stmt = null;
        try {

            /*
            Conectem amb la BBDD
             */
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pokemon.db");

            /*
            Fem el insert.
             */
            String sql_insert = "INSERT INTO POK_MOV" +
                    " (ID_POK,ID_MOVE) VALUES" +
                    " (?, ?);";

            PreparedStatement preparedStatement = c.prepareStatement(sql_insert);
            preparedStatement.setString(1, ID_POK);
            preparedStatement.setString(2, ID_MOVE);

            /*
            Executem el insert.
             */
            preparedStatement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.print("");
        }
    }

    /**
     * Metode per insertar la relacio pokemons tipos
     * @param ID_poke
     * @param ID_tipo
     */
    public static void insertpoke_tipo(String ID_poke, String ID_tipo) {

        Connection c = null;
        Statement stmt = null;
        try {

            /*
            Conectem amb la BBDD
             */
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pokemon.db");

            /*
            Fem el insert.
             */
            String sql_insert = "INSERT INTO POK_TIP" +
                    " (ID_POK,ID_TIPO) VALUES" +
                    " (?, ?);";

            PreparedStatement preparedStatement = c.prepareStatement(sql_insert);
            preparedStatement.setString(1, ID_poke);
            preparedStatement.setString(2, ID_tipo);

            /*
            Executem el insert.
             */
            preparedStatement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.print("");
        }

    }

    /**
     * Metode per insertar tipos de Pokemons
     * @param ID_poke
     * @param name
     */
    public static void inserttipo(String ID_poke, String name) {


        Connection c = null;
        Statement stmt = null;
        try {

            /*
            Conectem amb la BBDD
             */
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pokemon.db");

            /*
            Fem el insert.
             */
            String sql_insert = "INSERT INTO TIPO" +
                    " (ID,NAME) VALUES" +
                    " (?, ?);";

            PreparedStatement preparedStatement = c.prepareStatement(sql_insert);
            preparedStatement.setString(1, ID_poke);
            preparedStatement.setString(2, name);

            /*
            Executem el insert.
             */
            preparedStatement.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.print("");
        }
    }

    /**
     * Llista els pokemons que hi ha al BBDD
     * @param list
     */
    public static void llistatPokemon(ObservableList list){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pokemon.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM POKEMONS;" );
            while ( rs.next() ) {

                String name = rs.getString("NAME");
                list.add("\n"+name+"\n");

            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public static void llistatMov(ObservableList list){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pokemon.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM  MOVES;" );
            while ( rs.next() ) {

                String name = rs.getString("NAME");
                String descrip=rs.getString("DESCRIPTION");


               list.add(name+"\n\n"+descrip);

            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    /**
     * Llistat del tipos depenent del pokemon que sigui.
     * @param id
     * @return
     */
    public static String llistatTipo(String id){
        String names = null;
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pokemon.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM  TIPO;" );
            while ( rs.next() ) {

                String name = rs.getString("NAME");
                names= name+"\n"+name;
                System.out.println(name);

                // list.add(name+"\n   +"+descrip);

            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return names;
    }

    /**
     * Extreure un pokemon en concret depenent del seu id
     * @param id
     * @return
     */
    public static String nomPokemon(String id){
       String nom=null;
       Connection c = null;
       Statement stmt = null;
       try {
           Class.forName("org.sqlite.JDBC");
           c = DriverManager.getConnection("jdbc:sqlite:pokemon.db");
           c.setAutoCommit(false);
           stmt = c.createStatement();

           String sqlselect ="SELECT * FROM  POKEMONS WHERE ID = ?" ;
           PreparedStatement preparedStatement = c.prepareStatement(sqlselect);
           preparedStatement.setString(1, id);
           ResultSet rs = preparedStatement.executeQuery(sqlselect);
           while ( rs.next() ) {

               String name = rs.getString("NAME");

               System.out.println(name);

               // list.add(name+"\n   +"+descrip);

           }
           rs.close();
           stmt.close();
           c.close();
       } catch ( Exception e ) {
           System.err.println( e.getClass().getName() + ": " + e.getMessage() );
           System.exit(0);
       }
       return nom;
   }
    public static void main(String[] args)
    {

    }
}
