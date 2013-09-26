import ldaptest.CacheableLdapAuthentionProvider

// Place your Spring DSL code here
beans = {
    //cacheableLdapAuthentionProvider(CacheableLdapAuthentionProvider, ref('ldapAuthenticator'), ref('ldapAuthoritiesPopulator')) {
    cacheableLdapAuthentionProvider(CacheableLdapAuthentionProvider) {
       // userDetailsContextMapper = ref('ldapUserDetailsMapper')
       // hideUserNotFoundExceptions = true // true
       // useAuthenticationRequestCredentials =true // true
        ldapAuthenticationProvider=ref('ldapAuthProvider')
        cacheTesterService=ref('cacheTesterService')
        grailsApplication=ref('grailsApplication')
        cacheManager=ref('grailsCacheManager')

    }
}
