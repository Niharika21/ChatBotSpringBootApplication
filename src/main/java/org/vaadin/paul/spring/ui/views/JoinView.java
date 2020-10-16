package org.vaadin.paul.spring.ui.views;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Tag("sa-Welcome-view")
@Route(value = JoinView.ROUTE)
@PageTitle("join")
//@Route("join")
@CssImport("/styles/views/join/join-view.css")
//@RouteAlias(value = "")

public class JoinView extends VerticalLayout {
	public static final String ROUTE = "join";

    public JoinView() {
        addClassName(getClass().getSimpleName());

        H1 title = new H1("NICKNAME");
        title.addClassName(getClass().getSimpleName() + "-title");

        TextField nickname = new TextField();
        nickname.addClassName(getClass().getSimpleName() + "-nickname");
        nickname.setPlaceholder("Enter your username...");
        VerticalLayout form = new VerticalLayout(title, nickname);
        Button enter = new Button("Enter", event -> enter(nickname.getValue(),form));
        enter.addClassName(getClass().getSimpleName() + "-enter");
        enter.addClickShortcut(Key.ENTER);

        
         form.add(enter);
        form.setSizeUndefined();
        form.addClassName(getClass().getSimpleName() + "-form");
        add(form);
    }

    private void enter(String nickname, VerticalLayout form) {
        if (nickname.trim().isEmpty()) {
            Notification.show("Enter a nickname");
        } else {
        	H1 bots=new H1("SELECT BOT");
        	final Button button_alice = new Button("Alice", e -> {
        	      VaadinSession.getCurrent().setAttribute("nickname", nickname);
                  UI.getCurrent().navigate(ChatView_MultipleBots.class, "alice");
            });
        	//add(button_alice);
        	final Button button_pandora = new Button("Pandora", e -> {
      	      VaadinSession.getCurrent().setAttribute("nickname", nickname);
                UI.getCurrent().navigate(ChatView_MultipleBots.class, "Pandora");
          });
      	//add(button_pandora);
      	final Button button_Alice2 = new Button("Alice2", e -> {
  	      VaadinSession.getCurrent().setAttribute("nickname", nickname);
            UI.getCurrent().navigate(ChatView_MultipleBots.class, "Alice2");
      });
  	//add(button_Alice2);
form.add(bots);
form.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
  	HorizontalLayout botsLayout = new HorizontalLayout(button_alice,button_pandora,button_Alice2);
	//botsLayout.setWidth("250px");
    botsLayout.setSizeFull();
    botsLayout.setDefaultVerticalComponentAlignment(Alignment.CENTER);
    botsLayout.addClassName("botLayout");
    form.add(botsLayout);
      
        }
    }

}
