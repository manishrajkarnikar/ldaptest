package ldaptest

import grails.plugin.cache.Cacheable
import org.springframework.cache.CacheManager
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider

class CacheTesterService {
    CacheManager grailsCacheManager
    LdapAuthenticationProvider ldapAuthProvider


    @Cacheable(value='authCache',key='#authentication.principal')
    Authentication execute(Authentication authentication) throws AuthenticationException {
        ldapAuthProvider.authenticate(authentication)
    }

    @Cacheable('testCache')
    def getName(String name) {
       return findName(name)
    }

    def findName(String name){
        if(name=='manish'){
            return 'yyyyyyyy'
        }
        else{
            return 'xxxxxx'
        }
    }

}
