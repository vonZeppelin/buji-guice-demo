package com.example;

import javax.inject.Inject;

import org.scribe.up.provider.ProvidersDefinition;
import org.scribe.up.provider.impl.YahooProvider;

import io.buji.oauth.filter.OAuthRolesAuthorizationFilter;


/**
 * A subclass of <code>OAuthRolesAuthorizationFilter</code> merely to add injection support.
 * 
 * @author Leonid Bogdanov
 */
public class YahooAuthorizationFilter extends OAuthRolesAuthorizationFilter {

    /**
     * Injectable constructor.
     * 
     * @param definition the <code>ProvidersDefinition</code> instance
     */
    @Inject
    public YahooAuthorizationFilter(ProvidersDefinition definition) {
        setProvider(definition.findProvider(YahooProvider.class.getSimpleName()));
    }

}
