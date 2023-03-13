package main.exameninterfaces;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {
    @FXML
    private BorderPane borderPaneMain;
    @FXML
    private TableView tableViewMain;
    @FXML
    private TableColumn nombreColumn;
    @FXML
    private TableColumn apellidosColumn;
    @FXML
    private TableColumn adColumn;
    @FXML
    private TableColumn sgeColumn;
    @FXML
    private TableColumn diColumn;
    @FXML
    private TableColumn pmdmColumn;
    @FXML
    private TableColumn pspColumn;
    @FXML
    private TableColumn eieColumn;
    @FXML
    private TableColumn hlcColumn;
    @FXML
    private TextField nombreTextField;
    @FXML
    private TextField apellidosTextField;
    @FXML
    private TextField adTextField;
    @FXML
    private TextField sgeTextField;
    @FXML
    private TextField diTextField;
    @FXML
    private TextField pmdmTextField;
    @FXML
    private TextField pspTextField;
    @FXML
    private TextField eieTextField;
    @FXML
    private TextField hlcTextField;
    @FXML
    private Button insertButton;
    @FXML
    private Button descargarButton;
    @FXML
    private Button salirButton;
    @FXML
    private Label infoNombreLabel;
    @FXML
    private Label infoNotaMediaLabel;
    @FXML
    private Label infoSuspensosLabel;

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        ArrayList<Alumno> alumnosLista = new ArrayList<>();
        alumnosLista.add(new Alumno("Juan", "Gómez", 6, 7, 8, 9, 5, 6, 7));
        alumnosLista.add(new Alumno("María", "Pérez", 5, 6, 7, 8, 9, 6, 10));
        alumnosLista.add(new Alumno("Pedro", "García", 4, 5, 6, 7, 8, 5, 6));
        ObservableList<Alumno> alumnos = FXCollections.observableArrayList(alumnosLista);

        tableViewMain.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Alumno alumno = (Alumno) newValue;
                String nombreCompleto = "Nombre: "+ alumno.getNombre() + " " + alumno.getApellidos();
                infoNombreLabel.setText(nombreCompleto);

                double notaMedia = alumno.getNotaMedia();
                if (notaMedia >= 0) {
                    infoNotaMediaLabel.setText("Nota media: " + notaMedia);
                } else {
                    infoNotaMediaLabel.setText("No tiene todas las asignaturas aprobadas.");
                }

                int numSuspensos = alumno.getNumModulosSuspensos();
                if (numSuspensos > 0) {
                    infoSuspensosLabel.setText("Suspensos: " + numSuspensos);
                } else {
                    infoSuspensosLabel.setText("No tiene ningun suspenso");
                }
            }
        });


        nombreColumn.setCellValueFactory(new PropertyValueFactory("nombre"));
        apellidosColumn.setCellValueFactory(new PropertyValueFactory("apellidos"));
        adColumn.setCellValueFactory(new PropertyValueFactory("ad"));
        adColumn.setCellFactory(column -> {
            TableCell<Alumno, Integer> celda = new TableCell<Alumno, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : item.toString());
                }
            };
            Tooltip tooltip = new Tooltip("Acceso a datos");
            celda.setOnMouseEntered(event -> {
                if (!celda.isEmpty()) {
                    Bounds bounds = celda.localToScreen(celda.getBoundsInLocal());
                    tooltip.show(celda, bounds.getMaxX(), bounds.getMinY());
                }
            });
            celda.setOnMouseExited(event -> {
                tooltip.hide();
            });
            return celda;
        });
        sgeColumn.setCellValueFactory(new PropertyValueFactory("sge"));
        sgeColumn.setCellFactory(column -> {
            TableCell<Alumno, Integer> celda = new TableCell<Alumno, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : item.toString());
                }
            };
            Tooltip tooltip = new Tooltip("Sistemas de gestion empresarial");
            celda.setOnMouseEntered(event -> {
                if (!celda.isEmpty()) {
                    Bounds bounds = celda.localToScreen(celda.getBoundsInLocal());
                    tooltip.show(celda, bounds.getMaxX(), bounds.getMinY());
                }
            });
            celda.setOnMouseExited(event -> {
                tooltip.hide();
            });
            return celda;
        });
        diColumn.setCellValueFactory(new PropertyValueFactory("di"));
        diColumn.setCellFactory(column -> {
            TableCell<Alumno, Integer> celda = new TableCell<Alumno, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : item.toString());
                }
            };
            Tooltip tooltip = new Tooltip("Desarrollo de interfaces");
            celda.setOnMouseEntered(event -> {
                if (!celda.isEmpty()) {
                    Bounds bounds = celda.localToScreen(celda.getBoundsInLocal());
                    tooltip.show(celda, bounds.getMaxX(), bounds.getMinY());
                }
            });
            celda.setOnMouseExited(event -> {
                tooltip.hide();
            });
            return celda;
        });
        pmdmColumn.setCellValueFactory(new PropertyValueFactory("pmdm"));
        pmdmColumn.setCellFactory(column -> {
            TableCell<Alumno, Integer> celda = new TableCell<Alumno, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : item.toString());
                }
            };
            Tooltip tooltip = new Tooltip("Programacion multimedia y dispositivos moviles");
            celda.setOnMouseEntered(event -> {
                if (!celda.isEmpty()) {
                    Bounds bounds = celda.localToScreen(celda.getBoundsInLocal());
                    tooltip.show(celda, bounds.getMaxX(), bounds.getMinY());
                }
            });
            celda.setOnMouseExited(event -> {
                tooltip.hide();
            });
            return celda;
        });
        pspColumn.setCellValueFactory(new PropertyValueFactory("psp"));
        pspColumn.setCellFactory(column -> {
            TableCell<Alumno, Integer> celda = new TableCell<Alumno, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : item.toString());
                }
            };
            Tooltip tooltip = new Tooltip("Programacion de servicios y procesos");
            celda.setOnMouseEntered(event -> {
                if (!celda.isEmpty()) {
                    Bounds bounds = celda.localToScreen(celda.getBoundsInLocal());
                    tooltip.show(celda, bounds.getMaxX(), bounds.getMinY());
                }
            });
            celda.setOnMouseExited(event -> {
                tooltip.hide();
            });
            return celda;
        });
        eieColumn.setCellValueFactory(new PropertyValueFactory("eie"));
        eieColumn.setCellFactory(column -> {
            TableCell<Alumno, Integer> celda = new TableCell<Alumno, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : item.toString());
                }
            };
            Tooltip tooltip = new Tooltip("Empresas e iniciativa emprendedora");
            celda.setOnMouseEntered(event -> {
                if (!celda.isEmpty()) {
                    Bounds bounds = celda.localToScreen(celda.getBoundsInLocal());
                    tooltip.show(celda, bounds.getMaxX(), bounds.getMinY());
                }
            });
            celda.setOnMouseExited(event -> {
                tooltip.hide();
            });
            return celda;
        });
        hlcColumn.setCellValueFactory(new PropertyValueFactory("hlc"));
        hlcColumn.setCellFactory(column -> {
            TableCell<Alumno, Integer> celda = new TableCell<Alumno, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : item.toString());
                }
            };
                Tooltip tooltip = new Tooltip("Hora de libre configuracion");
            celda.setOnMouseEntered(event -> {
                if (!celda.isEmpty()) {
                    Bounds bounds = celda.localToScreen(celda.getBoundsInLocal());
                    tooltip.show(celda, bounds.getMaxX(), bounds.getMinY());
                }
            });
            celda.setOnMouseExited(event -> {
                tooltip.hide();
            });
            return celda;
        });

        tableViewMain.getStylesheets().add(this.getClass().getResource("/main/exameninterfaces/PrincipalCSS.css").toExternalForm());
        tableViewMain.setItems(alumnos);

        tableViewMain.getSelectionModel().clearAndSelect(0);
    }
    @FXML
    public void onInsertButtonClick (ActionEvent actionEvent) {
    }
    @FXML
    public void onDescargarButtonClick (ActionEvent actionEvent) {
    }

    @FXML
    public void onSalirButtonClick (ActionEvent actionEvent) {
    }
}