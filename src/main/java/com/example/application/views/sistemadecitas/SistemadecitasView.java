package com.example.application.views.sistemadecitas;

import com.example.application.components.avataritem.AvatarItem;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLink;

@PageTitle("Sistema de citas")
@Route(value = "my-view", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class SistemadecitasView extends Composite<VerticalLayout> {

    public SistemadecitasView() {
        H1 h1 = new H1();
        Hr hr = new Hr();
        H3 h3 = new H3();
        Paragraph textMedium = new Paragraph();
        Hr hr2 = new Hr();
        RouterLink routerLink = new RouterLink();
        AvatarItem avatarItem = new AvatarItem();
        AvatarItem avatarItem2 = new AvatarItem();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        h1.setText("Sistemas De Citas - Clinica");
        h1.setWidth("max-content");
        h3.setText("Bienvenido al Sistema de Citas");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h3);
        h3.setWidth("max-content");
        textMedium.setText(
                "Aquí valoramos tu tiempo y esfuerzo, por eso hemos creado una experiencia de citas sencilla y eficiente. Nuestro objetivo es ayudarte a encontrar la cita perfecta en solo unos pocos pasos.");
        textMedium.setWidth("100%");
        textMedium.setHeight("60px");
        textMedium.getStyle().set("font-size", "var(--lumo-font-size-m)");
        routerLink.setText("Creadores");
        routerLink.setRoute(SistemadecitasView.class);
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, routerLink);
        routerLink.setId("min-content");
        avatarItem.setWidth("min-content");
        setAvatarItemSampleData(avatarItem);
        avatarItem2.setWidth("min-content");
        setAvatarItemSampleData(avatarItem2);
        getContent().add(h1);
        getContent().add(hr);
        getContent().add(h3);
        getContent().add(textMedium);
        getContent().add(hr2);
        getContent().add(routerLink);
        getContent().add(avatarItem);
        getContent().add(avatarItem2);
    }

    private void setAvatarItemSampleData(AvatarItem avatarItem) {
        avatarItem.setHeading("Aria Bailey");
        avatarItem.setDescription("Endocrinologist");
        avatarItem.setAvatar(new Avatar("Aria Bailey"));
    }
}
