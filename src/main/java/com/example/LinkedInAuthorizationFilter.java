package com.example;

import javax.inject.Inject;

import org.scribe.up.provider.ProvidersDefinition;
import org.scribe.up.provider.impl.LinkedInProvider;

import io.buji.oauth.filter.OAuthRolesAuthorizationFilter;


/**
 * A subclass of <code>OAuthRolesAuthorizationFilter</code> merely to add injection support.
 * 
 * @author Leonid Bogdanov
 */
public class LinkedInAuthorizationFilter extends OAuthRolesAuthorizationFilter {

    /**
     * Injectable constructor.
     * 
     * @param definition the <code>ProvidersDefinition</code> instance
     */
    @Inject
    public LinkedInAuthorizationFilter(ProvidersDefinition definition) {
        setProvider(definition.findProvider(LinkedInProvider.class.getSimpleName()));
    }

}
