package com.example;

import javax.inject.Inject;
import javax.inject.Named;

import org.scribe.up.provider.ProvidersDefinition;

import io.buji.oauth.OAuthFilter;


/**
 * A subclass of <code>InjectableOAuthFilter</code> merely to add injection support.
 * 
 * @author Leonid Bogdanov
 */
public class InjectableOAuthFilter extends OAuthFilter {

    /**
     * {@inheritDoc}
     */
    @Override @Inject
    public void setFailureUrl(@Named("failureURL") String failureUrl) {
        super.setFailureUrl(failureUrl);
    }

    /**
     * {@inheritDoc}
     */
    @Override @Inject
    public void setProvidersDefinition(ProvidersDefinition definition) {
        super.setProvidersDefinition(definition);
    }

}
