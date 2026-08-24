package com.mycompany.msaresource.config;
import jakarta.annotation.security.DeclareRoles;
import jakarta.ws.rs.ApplicationPath;
import org.eclipse.microprofile.auth.LoginConfig;

@LoginConfig(authMethod="MP-JWT")
@DeclareRoles({"chief","hacker"})
@ApplicationPath("rest")
public class BootStrap extends jakarta.ws.rs.core.Application {
}
