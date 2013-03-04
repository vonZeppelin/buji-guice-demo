package com.example;

import javax.inject.Inject;

import org.scribe.up.provider.ProvidersDefinition;
import org.scribe.up.provider.impl.FacebookProvider;

import io.buji.oauth.filter.OAuthRolesAuthorizationFilter;


/**
 * A subclass of <code>OAuthRolesAuthorizationFilter</code> merely to add injection support.
 * 
 * @author Leonid Bogdanov
 */
public class FacebookAuthorizationFilter extends OAuthRolesAuthorizationFilter {

    /**
     * Injectable constructor.
     * 
     * @param definition the <code>ProvidersDefinition</code> instance
     */
    @Inject
    public FacebookAuthorizationFilter(ProvidersDefinition definition) {
        setProvider(definition.findProvider(FacebookProvider.class.getSimpleName()));
    }

}
