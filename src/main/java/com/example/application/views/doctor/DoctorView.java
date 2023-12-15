package com.example.application.views.doctor;

import com.example.application.data.entity.Doctor;
import com.example.application.data.service.DoctorService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.example.application.views.layout.MainLayout;


@Route(value = "doctores", layout = MainLayout.class)
@PageTitle("Gestión de Doctores")
public class DoctorView extends VerticalLayout {

    private final DoctorService doctorService;
    private Grid<Doctor> grid = new Grid<>(Doctor.class);

    public DoctorView(DoctorService doctorService) {
        this.doctorService = doctorService;
        setSizeFull();
        configureGrid();

        add(grid);
        updateList();
    }

    private void configureGrid() {
        grid.addClassName("doctor-grid");
        grid.setSizeFull();
        grid.setColumns("nombre", "apellidos", "especialidad");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        // Agrega aquí más configuraciones si es necesario
    }

    private void updateList() {
        grid.setItems(doctorService.findAll());
    }
}
