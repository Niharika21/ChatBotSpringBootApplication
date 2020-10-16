package org.vaadin.paul.spring.ui.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.paul.spring.MessageBean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Push
@Route
//@PWA(name = "Project Base for Vaadin Flow with Spring", shortName = "Project Base")
public class MainView extends VerticalLayout {
    public MainView(@Autowired MessageBean bean) {
    	add(new H1("CHOOSE BOT INTERFACE MODE"));
        final Button button = new Button("Multiple Bot", e -> {
            Notification.show(bean.getMessage());

            final UI ui = UI.getCurrent();
            showChat();
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(() -> {
                doHeavyStuff();
                ui.access(() -> {
                	
                    Notification.show("Calculation done");
                });
            });
        });
        final Button button1 = new Button("Single Bot", e -> {
            showChat();
        });
        add(button1);

        // simple link to the logout endpoint provided by Spring Security
        Element logoutLink = ElementFactory.createAnchor("logout", "Logout");
        getElement().appendChild(logoutLink);
    }

    private void showChat() {
		// TODO Auto-generated method stub
    	UI.getCurrent().navigate("chat");
		
	}

	private void doHeavyStuff() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            // ignore
        }
    }
}
