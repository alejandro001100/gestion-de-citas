package com.example.application.views.paciente;

import com.example.application.data.entity.Paciente;
import com.example.application.data.service.PacienteService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.data.binder.Binder;
import com.example.application.views.layout.MainLayout;

@Route(value = "pacientes", layout = MainLayout.class)
@PageTitle("Pacientes")
public class PacienteView extends VerticalLayout {

    private final PacienteService pacienteService;
    private Grid<Paciente> grid = new Grid<>(Paciente.class);
    private TextField nombre = new TextField("Nombre");
    private TextField apellido = new TextField("Apellido");
    private TextField cedula = new TextField("Cédula");
    private TextField edad = new TextField("Edad");
    private Button saveButton = new Button("Guardar");
    private Binder<Paciente> binder = new Binder<>(Paciente.class);

    public PacienteView(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
        addClassName("paciente-view");
        setSizeFull();
        configureGrid();
        configureForm();

        add(grid, createFormLayout());
        updateList();
        binder.bindInstanceFields(this);
    }

    private void configureGrid() {
        grid.addClassName("paciente-grid");
        grid.setSizeFull();
        grid.setColumns("nombre", "apellido", "cedula", "edad");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        grid.asSingleSelect().addValueChangeListener(event ->
                populateForm(event.getValue()));
    }

    private void configureForm() {
        binder.addStatusChangeListener(e -> saveButton.setEnabled(binder.isValid()));
        saveButton.addClickListener(click -> savePaciente());
    }

    private FormLayout createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(nombre, apellido, cedula, edad, saveButton);
        return formLayout;
    }

    private void populateForm(Paciente paciente) {
        binder.setBean(paciente);
    }

    private void savePaciente() {
        Paciente paciente = binder.getBean();
        Paciente savedPaciente = pacienteService.save(paciente); // Guarda el paciente y obtiene el resultado
        updateList();
        Notification.show("Paciente guardado.");
    }

    private void updateList() {
        grid.setItems(pacienteService.findAll());

    }

}

