package org.jbpm.rest.logger;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;

public class KieAuditLogerListener implements AgendaEventListener {

	List<String> activations = new ArrayList<String>();

	public void matchCreated(MatchCreatedEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void matchCancelled(MatchCancelledEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void beforeMatchFired(BeforeMatchFiredEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void afterMatchFired(AfterMatchFiredEvent event) {
		String rulename = event.getMatch().getRule().getName();
		String millis = Long.toString(System.currentTimeMillis());
		activations.add(rulename + " " + millis);
		//System.out.println("Rule " + rulename + " fired at " + millis);
	}

	public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void agendaGroupPushed(AgendaGroupPushedEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void beforeRuleFlowGroupDeactivated(
			RuleFlowGroupDeactivatedEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void afterRuleFlowGroupDeactivated(
			RuleFlowGroupDeactivatedEvent event) {
		// TODO Auto-generated method stub
		
	}

	public List<String> getActivations() {
		return activations;
	}

	public void setActivations(List<String> activations) {
		this.activations = activations;
	}
	
	
	
}
