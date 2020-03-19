package org.martin.jsf;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;


/**
 * Configuration class to set Primefaces.
 * @author Martin Tepostillo Jimenez
 *
 */
@Configuration
public class Initializer implements ServletContextInitializer {

  @Override
  public void onStartup(ServletContext sc) throws ServletException {
    sc.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
    sc.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
  }
}