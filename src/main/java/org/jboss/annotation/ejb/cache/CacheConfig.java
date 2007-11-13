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
package org.jboss.annotation.ejb.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to define the caching configuration for a SFSB
 * 
 * @author <a href="mailto:andrew.rubinger@redhat.com">ALR</a>
 * @version $Revision: $
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(
{ElementType.TYPE})
public @interface CacheConfig {

   // Class Members

   public static final String DEFAULT_CLUSTERED_OBJECT_NAME = "jboss.cache:service=EJB3SFSBClusteredCache";

   public static final int DEFAULT_NONCLUSTERED_MAX_SIZE = 100000;

   public static final int DEFAULT_CLUSTERED_MAX_SIZE = 10000;

   public static final long DEFAULT_IDLE_TIMEOUT_SECONDS = 300;

   public static final long DEFAULT_REMOVAL_TIMEOUT_SECONDS = 0;

   public static final boolean DEFAULT_REPL_IS_PASV = true;

   // Instance Members

   String name() default "";

   int maxSize() default CacheConfig.DEFAULT_NONCLUSTERED_MAX_SIZE;

   long idleTimeoutSeconds() default CacheConfig.DEFAULT_IDLE_TIMEOUT_SECONDS;

   boolean replicationIsPassivation() default CacheConfig.DEFAULT_REPL_IS_PASV;

   long removalTimeoutSeconds() default CacheConfig.DEFAULT_REMOVAL_TIMEOUT_SECONDS;
}
