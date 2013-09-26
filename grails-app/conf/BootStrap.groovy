import ldaptest.Role
import ldaptest.User
import ldaptest.UserRole

class BootStrap {

    def init = { servletContext ->

        System.setProperty("javax.net.ssl.trustStore", "C:/Users/a540409/Desktop/testCerts/ldapTrustStore.jks")
        System.setProperty("javax.net.ssl.trustStorePassword", "manish");

        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

        def testUser = new User(username: 'me', enabled: true, password: 'password')
        testUser.save(flush: true)

        UserRole.create testUser, adminRole, true

    }
    def destroy = {
    }
}
