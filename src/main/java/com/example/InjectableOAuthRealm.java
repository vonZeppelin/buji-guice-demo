package com.example;

import javax.inject.Inject;
import javax.inject.Named;

import org.scribe.up.provider.ProvidersDefinition;

import io.buji.oauth.OAuthRealm;


/**
 * A subclass of <code>OAuthRealm</code> merely to add injection support.
 * 
 * @author Leonid Bogdanov
 */
public class InjectableOAuthRealm extends OAuthRealm {

    /**
     * {@inheritDoc}
     */
    @Override @Inject
    public void setDefaultRoles(@Named("defaultRoles") String defaultRoles) {
        super.setDefaultRoles(defaultRoles);
    }

    /**
     * {@inheritDoc}
     */
    @Override @Inject
    public void setProvidersDefinition(ProvidersDefinition definition) {
        super.setProvidersDefinition(definition);
    }

}
