package org.addressbook.book;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FieldsBox extends HBox {

    private static FieldsBox instance;

    private TextField nameField;
    private TextField addressField;
    private TextField address2Field;
    private TextField cityField;
    private TextField stateField;
    private TextField phoneField;
    private Button saveButton;

    private FieldsBox() {
        this.setSpacing(5);
        this.setInstance();
        this.setPlaceholders();
        this.setChildren();
        this.configEvent();
    }

    public static synchronized FieldsBox getInstance() {
        if (instance == null) instance = new FieldsBox();
        return instance;
    }

    private void setInstance() {
        this.nameField = new TextField();
        this.addressField = new TextField();
        this.address2Field = new TextField();
        this.cityField = new TextField();
        this.stateField = new TextField();
        this.phoneField = new TextField();
        this.saveButton = new Button("Salvar");
    }

    private void setPlaceholders() {
        this.nameField.setPromptText("Nome");
        this.addressField.setPromptText("Endereço");
        this.address2Field.setPromptText("Complemento");
        this.cityField.setPromptText("Cidade");
        this.stateField.setPromptText("Estado");
        this.phoneField.setPromptText("Telefone");
    }

    private void configEvent() {
        this.saveButton.setOnMouseClicked(event -> {
            Person person = new Person(
                    this.nameField.getText(),
                    this.addressField.getText(),
                    this.address2Field.getText(),
                    this.cityField.getText(),
                    this.stateField.getText(),
                    this.phoneField.getText()
            );

            FileResolver.getInstance().writeData(person);

            this.nameField.clear();
            this.addressField.clear();
            this.address2Field.clear();
            this.cityField.clear();
            this.stateField.clear();
            this.phoneField.clear();

            AddressTable.getInstance().setItems(FileResolver.getInstance().getData());
        });
    }

    private void setChildren() {
        this.getChildren().addAll(
                this.nameField,
                this.addressField,
                this.address2Field,
                this.cityField,
                this.stateField,
                this.phoneField,
                this.saveButton
        );
    }
}
