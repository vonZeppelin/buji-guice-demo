package com.example;

import static com.google.inject.name.Names.named;

import java.util.Arrays;

import javax.inject.Singleton;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.apache.shiro.guice.web.ShiroWebModule;
import org.scribe.up.provider.OAuthProvider;
import org.scribe.up.provider.ProvidersDefinition;
import org.scribe.up.provider.impl.*;

import com.google.inject.*;
import com.google.inject.servlet.GuiceServletContextListener;


/**
 * Configures Guice modules.
 * 
 * @author Leonid Bogdanov
 */
public class AppInitializer extends GuiceServletContextListener {

    private ServletContext servletContext;

    /**
     * {@inheritDoc}
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContext = servletContextEvent.getServletContext();
        super.contextInitialized(servletContextEvent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Injector getInjector() {
        Module shiroModule = new ShiroWebModule(servletContext) {

            @Override
            @SuppressWarnings("unchecked")
            protected void configureShiroWeb() {
                final String ROLE_USER = "ROLE_USER";
                bind(String.class).annotatedWith(named("failureURL")).toInstance("/error.jsp");
                bind(String.class).annotatedWith(named("defaultRoles")).toInstance(ROLE_USER);
                bindRealm().to(InjectableOAuthRealm.class).in(Singleton.class);

                Key<FacebookAuthorizationFilter> facebook = Key.get(FacebookAuthorizationFilter.class);
                addFilterChain("/facebook/**", facebook, config(facebook, ROLE_USER));
                Key<GoogleAuthorizationFilter> google = Key.get(GoogleAuthorizationFilter.class);
                addFilterChain("/google/**", google, config(google, ROLE_USER));
                Key<LinkedInAuthorizationFilter> linkedin = Key.get(LinkedInAuthorizationFilter.class);
                addFilterChain("/linkedin/**", linkedin, config(linkedin, ROLE_USER));
                Key<TwitterAuthorizationFilter> twitter = Key.get(TwitterAuthorizationFilter.class);
                addFilterChain("/twitter/**", twitter, config(twitter, ROLE_USER));
                Key<YahooAuthorizationFilter> yahoo = Key.get(YahooAuthorizationFilter.class);
                addFilterChain("/yahoo/**", yahoo, config(yahoo, ROLE_USER));
                addFilterChain("/shiro-oauth", Key.get(InjectableOAuthFilter.class));
                addFilterChain("/logout", LOGOUT);
                addFilterChain("/**", ANON);
            }

            @Provides @Singleton @SuppressWarnings("deprecation")
            private ProvidersDefinition getProvidersDefinition() {
                FacebookProvider facebook = new FacebookProvider();
                facebook.setKey("145278422258960");
                facebook.setSecret("be21409ba8f39b5dae2a7de525484da8");

                GoogleProvider google = new GoogleProvider();
                google.setKey("anonymous");
                google.setSecret("anonymous");

                LinkedInProvider linkedin = new LinkedInProvider();
                linkedin.setKey("dhqyfw16b62f");
                linkedin.setSecret("ZgxTVtqkLmRjYHKw");

                TwitterProvider twitter = new TwitterProvider();
                twitter.setKey("CoxUiYwQOSFDReZYdjigBA");
                twitter.setSecret("2kAzunH5Btc4gRSaMr7D7MkyoJ5u1VzbOOzE8rBofs");

                YahooProvider yahoo = new YahooProvider();
                yahoo.setKey("dj0yJmk9aEhFZVM1dmJBSXpQJmQ9WVdrOVRWQnVjRUpJTlRZbWNHbzlNVEF4TmpBd05UQTJNZy0tJnM9Y29uc3VtZXJzZWNyZXQmeD00Yw--");
                yahoo.setSecret("ce0914bc2f5cff2a862eccdf33e690425fce8006");

                ProvidersDefinition definition = new ProvidersDefinition();
                definition.setBaseUrl("http://localhost:8080/shiro-oauth");
                definition.setProviders(Arrays.<OAuthProvider>asList(facebook, google, linkedin, twitter, yahoo));
                return definition;
            }

        };
        return Guice.createInjector(ShiroWebModule.guiceFilterModule(), shiroModule);
    }

}
