import org.cloudfoundry.runtime.env.CloudEnvironment
import org.cloudfoundry.runtime.env.RdbmsServiceInfo

def cloudEnv = new CloudEnvironment()

dataSource {
    pooled = true
    driverClassName = "org.hsqldb.jdbcDriver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache=true
    cache.use_query_cache=true
    cache.provider_class='net.sf.ehcache.hibernate.EhCacheProvider'
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop','update'
            url = "jdbc:hsqldb:mem:devDB"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:hsqldb:mem:testDb"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            driverClassName = "com.mysql.jdbc.Driver"

            if (cloudEnv.isCloudFoundry()) {
                def dbSvcInfo = cloudEnv.getServiceInfo("petclinic-mysql", RdbmsServiceInfo.class)
                url = dbSvcInfo.url
                username = dbSvcInfo.userName
                password = dbSvcInfo.password
            } else {
                url = "jdbc:postgresql://localhost:5432/petclinic"
            }
        }
    }
}
