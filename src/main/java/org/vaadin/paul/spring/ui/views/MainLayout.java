package org.vaadin.paul.spring.ui.views;

import com.vaadin.flow.component.applayout.AppLayout; 
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
@CssImport("./styles/chat-view.css")
@Push
public class MainLayout extends AppLayout {
public MainLayout() {
	createHeader();
	createDrawer();
}
private void createHeader() {
	H1 logo=new H1("Hello");
	logo.addClassName("logo");
	HorizontalLayout header=new HorizontalLayout(new DrawerToggle(), logo);
	header.addClassName("header");
	header.setWidth("100%");
	header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
	addToNavbar(header);
}
private void createDrawer() {
	RouterLink listLink =new RouterLink("End Session", MainView.class);
	RouterLink Link1 =new RouterLink("Restart Session", ChatView.class);
	RouterLink Link2 =new RouterLink("Bot Training", MainView.class);
	RouterLink Link3 =new RouterLink("System Performance", MainView.class);
	RouterLink Link4 =new RouterLink("Logout", LoginView.class);
	Link1.setHighlightCondition(HighlightConditions.sameLocation());
	Link2.setHighlightCondition(HighlightConditions.sameLocation());
	Link3.setHighlightCondition(HighlightConditions.sameLocation());
	Link4.setHighlightCondition(HighlightConditions.sameLocation());
    addToDrawer(new VerticalLayout(listLink));
    addToDrawer(new VerticalLayout(Link1));
    addToDrawer(new VerticalLayout(Link2));
    addToDrawer(new VerticalLayout(Link3));
    addToDrawer(new VerticalLayout(Link4));
}


}
