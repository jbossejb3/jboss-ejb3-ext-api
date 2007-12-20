/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2006, Red Hat Middleware LLC, and individual contributors
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
package org.jboss.ejb3.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.jboss.ejb3.annotation.defaults.ClusteredDefaults;

/**
 * Annotation for specifying that a bean should be clustered
 *
 * @author <a href="mailto:bill@jboss.org">Bill Burke</a>
 * @version $Revision:67157 $
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Clustered
{
   /** 
    * The {@link LoadBalancePolicy} implementation to use for balancing
    * remote bean invocations.
    * <p>
    * Specifying the <code>LoadBalancePolicy</code> interface itself (which
    * is the default value) means the EJB container should pick a sensible
    * default based on the type of the bean.
    * </p>
    * 
    * @return the class of the <code>LoadBalancePolicy</code> implementation, 
    *         or, if it is up to the container to choose an appropriate
    *         policy, the class of the <code>LoadBalancePolicy</code> interface 
    *         itself.
    */
   String loadBalancePolicy() default ClusteredDefaults.LOAD_BALANCE_POLICY_DEFAULT;
   
   /** 
    * The {@link LoadBalancePolicy} implementation to use for balancing
    * remote home invocations.
    * <p>
    * Specifying the <code>LoadBalancePolicy</code> interface itself (which
    * is the default value) means the EJB container should pick a sensible
    * default based on the type of the bean.
    * </p>
    * 
    * @return the class of the <code>LoadBalancePolicy</code> implementation, 
    *         or, if it is up to the container to choose an appropriate
    *         policy, the class of the <code>LoadBalancePolicy</code> interface 
    *         itself.
    */
   String homeLoadBalancePolicy() default ClusteredDefaults.LOAD_BALANCE_POLICY_DEFAULT;

   String partition() default ClusteredDefaults.PARTITION_NAME_DEFAULT;
}
