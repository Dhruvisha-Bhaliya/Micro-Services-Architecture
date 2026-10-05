package com.mycompany.stockapplication.config;
import jakarta.annotation.security.DeclareRoles;
import jakarta.ws.rs.ApplicationPath;
import org.eclipse.microprofile.auth.LoginConfig;

//@SuppressWarnings({"EmptyClass", "SuppressionAnnotation"})
@LoginConfig(authMethod = "MP-JWT")
@DeclareRoles({"STOCKUSER"})
@ApplicationPath("rest")
public class BootStrap extends jakarta.ws.rs.core.Application {
}
