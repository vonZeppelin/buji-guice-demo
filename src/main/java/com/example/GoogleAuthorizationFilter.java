package com.example;

import javax.inject.Inject;

import org.scribe.up.provider.ProvidersDefinition;
import org.scribe.up.provider.impl.GoogleProvider;

import io.buji.oauth.filter.OAuthRolesAuthorizationFilter;


/**
 * A subclass of <code>OAuthRolesAuthorizationFilter</code> merely to add injection support.
 * 
 * @author Leonid Bogdanov
 */
@SuppressWarnings("deprecation")
public class GoogleAuthorizationFilter extends OAuthRolesAuthorizationFilter {

    /**
     * Injectable constructor.
     * 
     * @param definition the <code>ProvidersDefinition</code> instance
     */
    @Inject
    public GoogleAuthorizationFilter(ProvidersDefinition definition) {
        setProvider(definition.findProvider(GoogleProvider.class.getSimpleName()));
    }

}
