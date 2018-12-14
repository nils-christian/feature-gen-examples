package de.rhocas.example;

import de.rhocas.example.feature.ExampleFeature;
import de.rhocas.example.feature.ExampleFeatureCheckService;
import de.rhocas.example.variant.Variant1;
import de.rhocas.example.variant.Variant2;

public class ExampleApplication {

	public static void main( final String[] args ) {
		final ExampleFeatureCheckService featureCheckService = createFeatureCheckService( args );

		System.out.println( "First feature active: " + featureCheckService.isFeatureActive( ExampleFeature.FIRST_FEATURE ) );
		System.out.println( "Second feature active: " + featureCheckService.isFeatureActive( ExampleFeature.SECOND_FEATURE ) );
		System.out.println( "Third feature active: " + featureCheckService.isFeatureActive( ExampleFeature.THIRD_FEATURE ) );
	}

	private static ExampleFeatureCheckService createFeatureCheckService( final String[] args ) {
		if ( args.length == 0 ) {
			return ExampleFeatureCheckService.empty();
		} else if ( args[0].equals( "Variant1" ) ) {
			return ExampleFeatureCheckService.of( Variant1.class );
		} else if ( args[0].equals( "Variant2" ) ) {
			return ExampleFeatureCheckService.of( Variant2.class );
		} else {
			throw new IllegalArgumentException( "Invalid variant specified (" + args[0] + ")" );
		}
	}

}
