package com.jdc.life;

import javax.enterprise.context.Dependent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Named;

@Named
@Dependent
public class LifecyclePhaseListener implements PhaseListener{

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		UIViewRoot root = context.getViewRoot();
		System.out.println(String.format("After %s -> View Count is %d", event.getPhaseId().getName(), root.getChildCount()));
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		System.out.println(context.getExternalContext().getRequestServletPath());
		
		UIViewRoot root = context.getViewRoot();
		System.out.println(root.getChildren());
		System.out.println(String.format("Before %s -> View Count is %d", event.getPhaseId().getName(), root.getChildCount()));
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
