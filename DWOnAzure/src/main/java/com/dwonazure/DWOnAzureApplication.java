package com.dwonazure;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.dwonazure.resources.HelloResource;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;


public class DWOnAzureApplication extends Application<DWOnAzureConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DWOnAzureApplication().run(args);
    }

    @Override
    public String getName() {
        return "DWOnAzure";
    }

    @Override
    public void initialize(final Bootstrap<DWOnAzureConfiguration> bootstrap) {
        // TODO: application initialization
	bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                                                   new EnvironmentVariableSubstitutor(false)
                )
			);	
    }

    @Override
    public void run(final DWOnAzureConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
	environment.jersey().register(new HelloResource());
    }

}
