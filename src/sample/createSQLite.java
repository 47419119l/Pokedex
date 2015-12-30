package sample;


import java.sql.*;

public class createSQLite {
    /**
     *Metode per crear la BBDD.
     */
    public static void main(String[] args) {
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

}