package org.addressbook.book;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AddressTable extends TableView {

    private static AddressTable instance;

    private TableColumn name;
    private TableColumn address;
    private TableColumn address_2;
    private TableColumn city;
    private TableColumn state;
    private TableColumn phone;

    private AddressTable() {
        this.setEditable(true);
        this.setWidth(900);

        this.name = new TableColumn("Nome");
        this.address = new TableColumn("Endereço");
        this.address_2 = new TableColumn("Complemento");
        this.city = new TableColumn("Cidade");
        this.state = new TableColumn("Estado");
        this.phone = new TableColumn("Telefone");

        this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        this.name.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.address.setCellValueFactory(new PropertyValueFactory<>("address"));
        this.address_2.setCellValueFactory(new PropertyValueFactory<>("address_2"));
        this.city.setCellValueFactory(new PropertyValueFactory<>("city"));
        this.state.setCellValueFactory(new PropertyValueFactory<>("state"));
        this.phone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        this.setItems(FileResolver.getInstance().getData());

        this.getColumns().addAll(name, address, address_2, city, state, phone);

    }

    public static synchronized AddressTable getInstance() {
        if (instance == null) {
            instance = new AddressTable();
        }
        return instance;
    }
}
