package org.addressbook.book;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class TableBox extends VBox {
    private static TableBox instance;

    private final Label label;
    private AddressTable table;
    private final FieldsBox fieldsBox;

    private TableBox() {
        this.label = new Label("Agenda");
        this.label.setFont(new Font("Arial", 40));

        this.table = AddressTable.getInstance();

        this.fieldsBox = FieldsBox.getInstance();

        this.setSpacing(5);
        this.setPadding(new Insets(20, 10, 10, 10));
        this.setFillWidth(true);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(label, table, fieldsBox);
    }

    public AddressTable getTable() {
        return table;
    }

    public synchronized static TableBox getInstance() {
        if (instance == null) {
            instance = new TableBox();
        }
        return instance;
    }
}
