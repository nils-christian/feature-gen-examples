package de.rhocas.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import de.rhocas.example.feature.ExampleFeature;
import de.rhocas.example.feature.ExampleFeatureCheckService;

@Component
public class ExampleApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private ExampleFeatureCheckService featureCheckService;
	
	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		System.out.println("First feature active: " + featureCheckService.isFeatureActive(ExampleFeature.FIRST_FEATURE));
		System.out.println("Second feature active: " + featureCheckService.isFeatureActive(ExampleFeature.SECOND_FEATURE));
		System.out.println("Third feature active: " + featureCheckService.isFeatureActive(ExampleFeature.THIRD_FEATURE));
	}

}
