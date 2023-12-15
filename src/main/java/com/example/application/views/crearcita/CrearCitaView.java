package com.example.application.views.crearcita;

import com.example.application.data.entity.Cita;
import com.example.application.data.entity.Paciente;
import com.example.application.data.entity.Doctor;
import com.example.application.data.service.CitaService;
import com.example.application.data.service.PacienteService;
import com.example.application.data.service.DoctorService;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.notification.Notification;
import com.example.application.views.layout.MainLayout;


import java.util.List;

@Route(value = "crear-cita", layout = MainLayout.class)
@PageTitle("Crear Cita")
public class CrearCitaView extends VerticalLayout {

    private DateTimePicker fechaHoraPicker = new DateTimePicker("Fecha y hora de la cita");
    private ComboBox<Paciente> pacienteComboBox = new ComboBox<>("Paciente");
    private ComboBox<Doctor> doctorComboBox = new ComboBox<>("Doctor");
    private Button saveButton = new Button("Guardar cita");

    private final CitaService citaService;
    private final PacienteService pacienteService;
    private final DoctorService doctorService;

    public CrearCitaView(CitaService citaService, PacienteService pacienteService, DoctorService doctorService) {
        this.citaService = citaService;
        this.pacienteService = pacienteService;
        this.doctorService = doctorService;

        // Configura los ComboBox con los datos de los pacientes y doctores
        pacienteComboBox.setItems(pacienteService.findAll());
        pacienteComboBox.setItemLabelGenerator(Paciente::getNombreCompleto); // Asumiendo que hay un método getNombreCompleto en Paciente

        doctorComboBox.setItems(doctorService.findAll());
        doctorComboBox.setItemLabelGenerator(Doctor::getNombreCompleto); // Asumiendo que hay un método getNombreCompleto en Doctor
        saveButton.addClickListener(e -> saveCita());

        FormLayout formLayout = new FormLayout();
        formLayout.add(fechaHoraPicker, pacienteComboBox, doctorComboBox, saveButton);

        add(formLayout);
    }

    private void saveCita() {
        Cita cita = new Cita();
        cita.setFechaHora(fechaHoraPicker.getValue());
        cita.setPaciente(pacienteComboBox.getValue());
        cita.setDoctor(doctorComboBox.getValue());


        try {
            citaService.save(cita);
            Notification.show("Cita guardada con éxito");
        } catch (Exception e) {
            Notification.show("Error al guardar la cita: " + e.getMessage(), 5000, Notification.Position.MIDDLE);
        }
    }
}
