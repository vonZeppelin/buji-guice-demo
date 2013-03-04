package com.example;

import io.buji.oauth.filter.OAuthRolesAuthorizationFilter;

import javax.inject.Inject;

import org.scribe.up.provider.ProvidersDefinition;
import org.scribe.up.provider.impl.TwitterProvider;


/**
 * A subclass of <code>OAuthRolesAuthorizationFilter</code> merely to add injection support.
 * 
 * @author Leonid Bogdanov
 */
public class TwitterAuthorizationFilter extends OAuthRolesAuthorizationFilter {

    /**
     * Injectable constructor.
     * 
     * @param definition the <code>ProvidersDefinition</code> instance
     */
    @Inject
    public TwitterAuthorizationFilter(ProvidersDefinition definition) {
        setProvider(definition.findProvider(TwitterProvider.class.getSimpleName()));
    }

}
