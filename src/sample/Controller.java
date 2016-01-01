package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Controller {
    @FXML
    ListView ListPokemon = new ListView();
    @FXML
    ListView llistaMov = new ListView();
    @FXML
    ListView listtype = new ListView();
    @FXML
    ImageView ImagePokemon;
    @FXML
    Text nomPokemon,nom;
    @FXML
    Label descrip;

    Image image;

    ObservableList<String> items = FXCollections.observableArrayList();
    /**
     * Metode que crida a la funció que s'ha d'executar al iniciar l'aplicació
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public void initialize() throws IOException, SAXException, ParserConfigurationException {
        iniciar();
    }

    /**
     * Metode que s'executa per defecte
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public void iniciar() throws IOException, SAXException, ParserConfigurationException {
        /**
         * Omplir llistat de pokemons.
         */
        ListPokemon.setVisible(true);
        ObservableList<String> items = FXCollections.observableArrayList();
        DAOPokemondb.llistatPokemon(items);
        ListPokemon.setItems(items);

        /*
        Cridem al metode omplirInfo.
         */
        omplirInfo (1);
    }

    /**
     * Funció per omplir imatges
     * @param imagePokemon
     * @param nom
     */
    public void omplirImatge(ImageView imagePokemon,String nom){

        image = new Image(nom);
        imagePokemon.setImage(image);
        imagePokemon.setPreserveRatio(true);
        imagePokemon.setSmooth(true);
        imagePokemon.setCache(true);

    }

    /**
     * Metode quan sel·lecionem un pokemon ens ompli els camps amb a informaació necessaria.
     * @param event
     */
    public void escollirPoke(Event event) {
        ListPokemon.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                /*
                Extreiem el id de pokemon sel·lecionat.
                 */
                int id = ListPokemon.getSelectionModel().getSelectedIndex() +1;
                /*
                Cridem a la funcio omplirInfo
                 */
                omplirInfo(id);
            }
        });{

        }
    }

    /**
     * Quan apretem amb e ratolí a un moviment extreu la seva informació
     * @param event
     */
    public void escollitMove(Event event) {

        llistaMov.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                /*
                Treiem el nom del movimnt sel·lecionat
                 */
                String nomMov = llistaMov.getSelectionModel().getSelectedItems().toString().replaceAll("\n", "").replaceAll("]","").substring(1);
                /*
                Cridem a la funcio per omplir la info
                 */
                infoMov(nomMov);
            }
        });
    }

    /**
     * Metode per extreure la informació del move sel·lecionat.
     * @param nomMov
     */
    public void infoMov(String nomMov){

        String [] move;
        move = DAOPokemondb.extreuMov(nomMov);
        nom.setText(move[0]);
        descrip.setText(move[1]);
    }

    /**
     * Escriu la informació del pokemon sel·lecionat als caps que li correspon.
     * @param i
     */
    public void omplirInfo (int i){
        /**
         * Omplir llista de moviments
         */
        llistaMov.setVisible(true);
        ObservableList <String> itemsMov = FXCollections.observableArrayList();
        DAOPokemondb.llistatMov(itemsMov,i);
        llistaMov.setItems(itemsMov);

        /*
        Omplir llistat de tipos.
         */
        listtype.setVisible(true);
        ObservableList <String> itemsType = FXCollections.observableArrayList();
        DAOPokemondb.llistatTipo(itemsType,i);
        listtype.setItems(itemsType);

        /*
        Cridem a metode per omplir imatges
         */
        omplirImatge(ImagePokemon,i+".png");
        /**
         *Extreiem le nom del pokemon selecionat.
         */
        nomPokemon.setText(DAOPokemondb.nomPokemon(""+i));

        /*
        Extreiem el nom del primer move de la llista.
         */
        items = llistaMov.getItems();
        String moveName=  items.get(0).toString().replaceAll("\n", "");
        infoMov(moveName);

    }
}
