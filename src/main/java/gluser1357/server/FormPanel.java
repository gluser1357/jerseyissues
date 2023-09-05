package gluser1357.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;

public class FormPanel
extends Panel {

	public FormPanel(String id) {
		super(id);

		Label errors = new Label("errors", "");
		add(errors.setOutputMarkupId(true).setEscapeModelStrings(false));
		
		Form<?> form = new Form<>("form") {};
		add(form); // expected

		MarkupContainer rowPanel = new WebMarkupContainer("rowPanel");
		form.add(rowPanel.setOutputMarkupId(true));

		List<String> rows = new ArrayList<>(Arrays.asList("init"));
		ListView<String> list = new ListView<>("rows", rows) {
			@Override
			protected void populateItem(ListItem<String> item) {
				IModel<String> model = item.getModel();
				RequiredTextField<String> tf = new RequiredTextField<String>("text", model);
				item.add(tf);
			}
		};
		rowPanel.add(list);
		
		addLink("addRow", rowPanel, form, errors, list);
		addLink("addRowWith", rowPanel, form, errors, list); // id evaluated in FirstFilter.java
	}
	
	private void addLink(String id, MarkupContainer rowPanel, Form form, Label errors, ListView<String> lv) {

		AjaxSubmitLink addLink = new AjaxSubmitLink(id, form) {
			@Override
			public void onSubmit(AjaxRequestTarget target) {
				lv.getModelObject().add("new");
				errors.setDefaultModelObject("");
				target.add(rowPanel);
				target.add(errors);
			}

			@Override
			protected void onError(AjaxRequestTarget target) {
				StringBuilder sb = new StringBuilder();
				form.visitChildren(Component.class, new IVisitor<Component, Boolean>() {
					@Override
					public void component(final Component component, final IVisit<Boolean> visit) {
						if (component.hasErrorMessage() && component.isVisibleInHierarchy() && component.isEnabledInHierarchy()) {
							sb.append("id="+component.getId()+": " +component.getFeedbackMessages()+"<br>");
						}
					}
				});
				errors.setDefaultModelObject("<font color='red'>ERRORS:<br>"+sb.toString()+"</font>");
				target.add(errors);
			}
		};
		rowPanel.add(addLink);
	}
}
