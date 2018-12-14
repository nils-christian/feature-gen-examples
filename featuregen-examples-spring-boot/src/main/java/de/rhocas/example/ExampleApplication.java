package de.rhocas.example;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import de.rhocas.example.feature.ExampleFeatureCheckService;
import de.rhocas.example.variant.Variant1;
import de.rhocas.example.variant.Variant2;

@SpringBootApplication
public class ExampleApplication {

	public static void main( final String[] args ) {
		new SpringApplicationBuilder( ExampleApplication.class )
				.logStartupInfo( false )
				.bannerMode( Mode.OFF )
				.run( args );
	}

	@Bean
	@Profile( "Variant1" )
	public ExampleFeatureCheckService variant1FeatureCheckService() {
		return ExampleFeatureCheckService.of( Variant1.class );
	}

	@Bean
	@Profile( "Variant2" )
	public ExampleFeatureCheckService variant2FatureCheckService() {
		return ExampleFeatureCheckService.of( Variant2.class );
	}

	@Bean
	@Profile( "default" )
	public ExampleFeatureCheckService defaultFeatureCheckService() {
		return ExampleFeatureCheckService.empty();
	}

}
