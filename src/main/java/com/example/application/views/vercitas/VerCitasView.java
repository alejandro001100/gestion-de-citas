package com.example.application.views.vercitas;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Ver Citas")
@Route(value = "ver-citas", layout = MainLayout.class)
@Uses(Icon.class)
public class VerCitasView extends Composite<VerticalLayout> {

    public VerCitasView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        DateTimePicker dateTimePicker = new DateTimePicker();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        textField.setLabel("Paciente");
        textField.setWidth("min-content");
        textField2.setLabel("Doctor");
        textField2.setWidth("min-content");
        textField3.setLabel("Especialidad");
        textField3.setWidth("min-content");
        dateTimePicker.setLabel("Fecha cita");
        dateTimePicker.setWidth("min-content");
        getContent().add(layoutRow);
        layoutRow.add(textField);
        layoutRow.add(textField2);
        layoutRow.add(textField3);
        layoutRow.add(dateTimePicker);
    }
}
