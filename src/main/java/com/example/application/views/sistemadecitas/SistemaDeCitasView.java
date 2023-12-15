package com.example.application.views.sistemadecitas;

import com.example.application.data.entity.Cita;
import com.example.application.data.service.CitaService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.example.application.views.layout.MainLayout;


@Route(value = "", layout = MainLayout.class) // Página de inicio de la aplicación
@PageTitle("Sistema de Citas")
public class SistemaDeCitasView extends VerticalLayout {

    private final CitaService citaService;
    private Grid<Cita> grid = new Grid<>(Cita.class);
    private Button addCitaBtn = new Button("Nueva Cita");

    public SistemaDeCitasView(CitaService citaService) {
        this.citaService = citaService;
        setSizeFull();
        configureGrid();
        configureToolbar();

        H3 heading = new H3("Dashboard de Citas");
        add(heading, configureToolbar(), grid);
        updateList();
    }

    private void configureGrid() {
        grid.addClassName("cita-grid");
        grid.setSizeFull();
        grid.setColumns("fechaHora", "paciente.nombre", "doctor.nombre", "especialidad");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        // Agrega aquí más configuraciones si es necesario
    }

    private HorizontalLayout configureToolbar() {
        addCitaBtn.addClickListener(e -> addCitaBtn.getUI().ifPresent(ui -> ui.navigate("crear-cita")));

        HorizontalLayout toolbar = new HorizontalLayout(addCitaBtn);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void updateList() {
        grid.setItems(citaService.findAll());
    }
}

