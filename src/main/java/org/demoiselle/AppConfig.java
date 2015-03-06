package org.demoiselle;

import javax.validation.constraints.NotNull;

import br.gov.frameworkdemoiselle.configuration.Configuration;

@Configuration(resource = "catalogo")
public class AppConfig {

    //@NotNull
    private String url;

    private Long sessionTimeout = new Long(90 * 60 * 1000);

    private Boolean debug;

    public String getUrl() {
        return url;
    }

    public Boolean isDebug() {
        return debug;
    }

    public Long getSessionTimeout() {
        return sessionTimeout;
    }
}
