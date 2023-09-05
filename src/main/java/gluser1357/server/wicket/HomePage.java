package gluser1357.server.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage
extends WebPage {

    public HomePage(final PageParameters parameters)
    throws Exception {

    	// build menu
    	FormPanel p = new FormPanel("mainMenu");
    	add(p);
	 }
}
