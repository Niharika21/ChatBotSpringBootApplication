package org.vaadin.paul.spring.ui.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.paul.spring.MessageBean;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
@PageTitle("Home")
@Route(value= HomeView.ROUTE)
@CssImport("/styles/views/join/join-view.css")
public class HomeView extends VerticalLayout  {
	public static final String ROUTE = " ";
	public HomeView() {
        addClassName(getClass().getSimpleName());

        H1 title = new H1("WELCOME TO COMASSIST CHATBOT PLATFORM");
        title.addClassName(getClass().getSimpleName() + "-title");

        final Button login = new Button("Log In", e -> {
        	UI.getCurrent().navigate("login"); 
        });
        add(new H1(" "));
        final Button signup = new Button("Sign Up", e -> {
        	UI.getCurrent().navigate("register");
        });
        login.setId("LoginButton");
        signup.setId("SignUpButton");
        
        VerticalLayout form = new VerticalLayout(title,login,signup);
        form.setSizeUndefined();
        form.addClassName(getClass().getSimpleName() + "-form");
        add(form);
    }

}
