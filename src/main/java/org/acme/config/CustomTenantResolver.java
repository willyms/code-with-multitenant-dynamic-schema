package org.acme.config;

import io.quarkus.hibernate.orm.PersistenceUnitExtension;
import io.quarkus.hibernate.orm.runtime.tenant.TenantResolver;
import io.vertx.ext.web.RoutingContext;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.util.Optional;

@Slf4j
@Default
@RequestScoped
@PersistenceUnitExtension
public class CustomTenantResolver implements TenantResolver {

    @Inject
    RoutingContext context;

    private final String NAME_SCHEMA_DEFUALT = "public";

    private void postConstruct() {
        log.info("CustomTenantResolver constructed!");
    }

    @Override
    public String getDefaultTenantId() {
        log.info("getDefaultTenantId");
        return NAME_SCHEMA_DEFUALT;
    }

    @Override
    public String resolveTenantId() {
        log.info("resolveTenantId");
        return Optional.ofNullable(context.request().getHeader("x-tenantId")).orElse(getDefaultTenantId());
    }
}
