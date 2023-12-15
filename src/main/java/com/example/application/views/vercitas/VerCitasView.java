package com.example.application.views.vercitas;

import com.example.application.data.entity.Cita;
import com.example.application.data.service.CitaService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.H3;
import com.example.application.views.layout.MainLayout;


@Route(value = "ver-citas", layout = MainLayout.class)
@PageTitle("Ver Citas")
public class VerCitasView extends VerticalLayout {

    private final CitaService citaService;
    private Grid<Cita> grid = new Grid<>(Cita.class);

    public VerCitasView(CitaService citaService) {
        this.citaService = citaService;
        addClassName("ver-citas-view");
        setSizeFull();
        configureGrid();

        H3 heading = new H3("Listado de Citas");
        add(heading, grid);
        updateList();
    }

    private void configureGrid() {
        grid.addClassName("cita-grid");
        grid.setSizeFull();
        grid.setColumns("fechaHora", "paciente.nombre", "doctor.nombre", "especialidad");
        // Si necesitas formatear la fecha u obtener datos de entidades relacionadas, tendrás que configurarlo aquí.
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void updateList() {
        grid.setItems(citaService.findAll());
    }
}
