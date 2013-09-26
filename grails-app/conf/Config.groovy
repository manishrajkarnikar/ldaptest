// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [
    all:           '*/*',
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'
grails.plugins.springsecurity.useBasicAuth=true

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = ['ldaptest']
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
           'org.codehaus.groovy.grails.web.pages',          // GSP
           'org.codehaus.groovy.grails.web.sitemesh',       // layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping',        // URL mapping
           'org.codehaus.groovy.grails.commons',            // core / classloading
            'org.hibernate',
            'net.sf.ehcache.hibernate',
           'org.codehaus.groovy.grails.orm.hibernate' ,     // hibernate integration
           'org.springframework'
         //   'org.codehaus.groovy.grails.plugins'            // plugins

     //debug 'org.springframework',
       //     'org.codehaus.groovy.grails.plugins'

}

// Active Directory Specific configuration
/*
grails.plugins.springsecurity.userLookup.userDomainClassName = 'ldaptest.User'
grails.plugins.springsecurity.userLookup.authorityJoinClassName = 'ldaptest.UserRole'
grails.plugins.springsecurity.authority.className = 'ldaptest.Role'
grails.plugins.springsecurity.ldap.context.managerDn = 'CN=bindingUser,CN=Partition1,DC=COM'
grails.plugins.springsecurity.ldap.context.managerPassword = 'openA123'
grails.plugins.springsecurity.ldap.context.server = 'ldap://localhost:389'
grails.plugins.springsecurity.ldap.search.base = 'CN=Partition1,DC=COM'
grails.plugins.springsecurity.ldap.authorities.ignorePartialResultException = true // typically needed for Active Directory
grails.plugins.springsecurity.ldap.search.filter="cn={0}" // for Active Directory you need this
//grails.plugins.springsecurity.ldap.search.filter="sAMAccountName={0}" // for Active Directory you need this
grails.plugins.springsecurity.ldap.search.searchSubtree = true
grails.plugins.springsecurity.ldap.auth.hideUserNotFoundExceptions = false
grails.plugins.springsecurity.providerNames = ['ldapAuthProvider', 'anonymousAuthenticationProvider'] // specify this when you want to skip attempting to load from db and only use LDAP
// role-specific LDAP config
grails.plugins.springsecurity.ldap.useRememberMe = false


*/


grails.plugins.springsecurity.userLookup.userDomainClassName = 'ldaptest.User'
grails.plugins.springsecurity.userLookup.authorityJoinClassName = 'ldaptest.UserRole'
grails.plugins.springsecurity.authority.className = 'ldaptest.Role'
grails.plugins.springsecurity.ldap.context.managerDn = 'cn=manishUser,dc=manish,dc=com'
grails.plugins.springsecurity.ldap.context.managerPassword = 'manish'
grails.plugins.springsecurity.ldap.context.server = 'ldaps://localhost:10636'
//grails.plugins.springsecurity.ldap.context.server = 'ldap://localhost:10389'
grails.plugins.springsecurity.ldap.search.base = 'dc=manish,dc=com'
//grails.plugins.springsecurity.ldap.authorities.ignorePartialResultException = true // typically needed for Active Directory
grails.plugins.springsecurity.ldap.search.filter="cn={0}" // for Active Directory you need this
//grails.plugins.springsecurity.ldap.search.filter="sAMAccountName={0}" // for Active Directory you need this
grails.plugins.springsecurity.ldap.search.searchSubtree = true
grails.plugins.springsecurity.ldap.auth.hideUserNotFoundExceptions = false
grails.plugins.springsecurity.providerNames = ['cacheableLdapAuthentionProvider','anonymousAuthenticationProvider'] // specify this when you want to skip attempting to load from db and only use LDAP
// role-specific LDAP config
grails.plugins.springsecurity.ldap.useRememberMe = false

grails.plugins.springsecurity.ldap.authorities.groupSearchBase = 'dc=manish,dc=com'

grails.cache.config={
    cache {
        name 'authCache'
        maxElementsInMemory 10000
        eternal false
        timeToIdleSeconds 6000
        timeToLiveSeconds 6000
        overflowToDisk false
        diskPersistent false
        diskExpiryThreadIntervalSeconds 120
        memoryStoreEvictionPolicy 'LRU'
    }

    cache {
        name 'testCache'
        maxElementsInMemory 10000
        eternal false
        timeToIdleSeconds 6000
        timeToLiveSeconds 6000
        overflowToDisk false
        diskPersistent false
        diskExpiryThreadIntervalSeconds 120
        memoryStoreEvictionPolicy 'LRU'
    }

    defaultCache {
        maxElementsInMemory 10000
        eternal true
        timeToIdleSeconds 120
        timeToLiveSeconds 120
        overflowToDisk true
        maxElementsOnDisk 10000000
        diskPersistent false
        diskExpiryThreadIntervalSeconds 120
        memoryStoreEvictionPolicy 'LRU'
    }

    defaults {
        maxElementsInMemory 10000
        eternal false
        timeToIdleSeconds 6000
        timeToLiveSeconds 6000
        overflowToDisk false
        diskPersistent false
        diskExpiryThreadIntervalSeconds 120
        memoryStoreEvictionPolicy 'LRU'
    }
}
