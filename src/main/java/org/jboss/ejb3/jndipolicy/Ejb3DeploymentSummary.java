/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2007, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.ejb3.jndipolicy;

import java.io.Serializable;

/**
 * Summary of an EJB3 deployment in flat properties; used in 
 * determining default JNDI Bindings by a JNDI Binding Policy
 * 
 * @author <a href="mailto:andrew.rubinger@redhat.com">ALR</a>
 * @version $Revision: $
 */
public class Ejb3DeploymentSummary implements Serializable
{
   // Class Members
   private static final long serialVersionUID = 5282914558239425705L;

   // Instance Members

   private String deploymentName;

   private String deploymentScopeBaseName;

   private String ejbName;

   private Class<?> beanClass;

   private boolean isLocal;

   private boolean isStateful;

   private boolean isHome;

   private boolean isService;

   // Accessors / Mutators

   public String getDeploymentName()
   {
      return deploymentName;
   }

   public void setDeploymentName(String deploymentName)
   {
      this.deploymentName = deploymentName;
   }

   public String getEjbName()
   {
      return ejbName;
   }

   public void setEjbName(String ejbName)
   {
      this.ejbName = ejbName;
   }

   public boolean isLocal()
   {
      return isLocal;
   }

   public void setLocal(boolean isLocal)
   {
      this.isLocal = isLocal;
   }

   public boolean isStateful()
   {
      return isStateful;
   }

   public void setStateful(boolean isStateful)
   {
      this.isStateful = isStateful;
   }

   public boolean isHome()
   {
      return isHome;
   }

   public void setHome(boolean isHome)
   {
      this.isHome = isHome;
   }

   public boolean isService()
   {
      return isService;
   }

   public void setService(boolean isService)
   {
      this.isService = isService;
   }

   public String getDeploymentScopeBaseName()
   {
      return deploymentScopeBaseName;
   }

   public void setDeploymentScopeBaseName(String deploymentScopeBaseName)
   {
      this.deploymentScopeBaseName = deploymentScopeBaseName;
   }

   public Class<?> getBeanClass()
   {
      return beanClass;
   }

   public void setBeanClass(Class<?> beanClass)
   {
      this.beanClass = beanClass;
   }

}
