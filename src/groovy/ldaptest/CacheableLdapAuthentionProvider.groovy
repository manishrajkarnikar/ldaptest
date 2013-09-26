package ldaptest

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.springframework.cache.CacheManager
import org.springframework.context.MessageSource
import org.springframework.context.MessageSourceAware
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider

class CacheableLdapAuthentionProvider implements AuthenticationProvider, MessageSourceAware {
    LdapAuthenticationProvider ldapAuthenticationProvider
    CacheManager cacheManager
    CacheTesterService cacheTesterService
    GrailsApplication grailsApplication




    Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // this gets cached looks like
        cacheTesterService.getName('manish')
        // this does not get cached
        cacheTesterService.execute(authentication)
      //  grailsApplication.mainContext.cacheableLdapAuthentionProvider.execute(authentication)
    }

    @Override
    boolean supports(Class<? extends Object> authentication) {
        ldapAuthenticationProvider.supports(authentication)
    }
     /*
    @Cacheable(value='authCache',key='#authentication.principal')
    Authentication execute(Authentication authentication) throws AuthenticationException {
        ldapAuthenticationProvider.authenticate(authentication)
    }
     */
    @Override
    void setMessageSource(MessageSource messageSource) {
        ldapAuthenticationProvider.setMessageSource(messageSource)
    }
}
