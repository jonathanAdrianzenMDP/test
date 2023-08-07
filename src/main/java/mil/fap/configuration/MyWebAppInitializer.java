/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.configuration;
import javax.servlet.Filter;
import mil.fap.controller.filters.SessionFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author Jonathan
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
   
   @Override
   protected Class<?>[] getRootConfigClasses() {
      return new Class[] {WebConfig.class};
   }

   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class[] { WebConfig.class };
   }

   @Override
   protected String[] getServletMappings() {
      return new String[] { "/" };
   }
   
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new SessionFilter()};
    }
}
