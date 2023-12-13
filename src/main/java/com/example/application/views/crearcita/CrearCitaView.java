package com.example.application.views.crearcita;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Crear Cita")
@Route(value = "crear-cita", layout = MainLayout.class)
@Uses(Icon.class)
public class CrearCitaView extends Composite<VerticalLayout> {

    public CrearCitaView() {
        TextField textField = new TextField();
        DateTimePicker dateTimePicker = new DateTimePicker();
        Select select = new Select();
        Select select2 = new Select();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        textField.setLabel("Cedula");
        textField.setWidth("min-content");
        dateTimePicker.setLabel("Fecha");
        dateTimePicker.setWidth("min-content");
        select.setLabel("Doctor");
        select.setWidth("min-content");
        setSelectSampleData(select);
        select2.setLabel("Especialidad");
        select2.setWidth("min-content");
        setSelectSampleData(select2);
        getContent().add(textField);
        getContent().add(dateTimePicker);
        getContent().add(select);
        getContent().add(select2);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setSelectSampleData(Select select) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        select.setItems(sampleItems);
        select.setItemLabelGenerator(item -> ((SampleItem) item).label());
        select.setItemEnabledProvider(item -> !Boolean.TRUE.equals(((SampleItem) item).disabled()));
    }
}
