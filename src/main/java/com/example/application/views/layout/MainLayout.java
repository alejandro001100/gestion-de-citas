package com.example.application.views.layout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.router.RouterLink;
import com.example.application.views.crearcita.CrearCitaView;
import com.example.application.views.paciente.PacienteView;
import com.example.application.views.vercitas.VerCitasView;
import com.example.application.views.sistemadecitas.SistemaDeCitasView;
// Asegúrate de importar todas las vistas necesarias aquí.

public class MainLayout extends AppLayout {

    public MainLayout() {
        H1 logo = new H1("Gestión de Citas Médicas");
        logo.addClassNames("text-l", "m-m");

        // El DrawerToggle es opcional y depende de tu diseño
        // DrawerToggle toggle = new DrawerToggle();

        // Header header = new Header(logo, toggle); // Si estás usando DrawerToggle
        addToNavbar(true, logo); // Si no estás usando DrawerToggle

        createDrawer();
    }

    private void createDrawer() {
        Nav nav = new Nav();
        nav.addClassNames("drawer-nav");

        // Asegúrate de que las clases de vista están importadas correctamente para que puedan ser utilizadas aquí.
        nav.add(createRouterLink("Inicio", (Class<? extends Component>) SistemaDeCitasView.class));
        nav.add(createRouterLink("Crear Cita", CrearCitaView.class));
        nav.add(createRouterLink("Ver Citas", VerCitasView.class));
        nav.add(createRouterLink("Gestión de Pacientes", PacienteView.class));
        // Añadir más enlaces a otras vistas según sea necesario.

        addToDrawer(nav);
    }

    private RouterLink createRouterLink(String text, Class<? extends Component> navigationTarget) {
        RouterLink link = new RouterLink(text, navigationTarget);
        link.addClassNames("flex", "items-center", "p-s", "rounded-s", "hover:bg-contrast-5", "focus:outline-none", "focus:bg-contrast-5");
        return link;
    }
}
