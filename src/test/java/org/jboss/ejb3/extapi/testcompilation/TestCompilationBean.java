package org.jboss.ejb3.extapi.testcompilation;

import javax.ejb.ActivationConfigProperty;

import org.jboss.ejb3.annotation.AspectDomain;
import org.jboss.ejb3.annotation.Cache;
import org.jboss.ejb3.annotation.CacheConfig;
import org.jboss.ejb3.annotation.Clustered;
import org.jboss.ejb3.annotation.Consumer;
import org.jboss.ejb3.annotation.CurrentMessage;
import org.jboss.ejb3.annotation.DefaultActivationSpecs;
import org.jboss.ejb3.annotation.DeliveryMode;
import org.jboss.ejb3.annotation.Depends;
import org.jboss.ejb3.annotation.IIOP;
import org.jboss.ejb3.annotation.IgnoreDependency;
import org.jboss.ejb3.annotation.JndiBindingPolicy;
import org.jboss.ejb3.annotation.JndiInject;
import org.jboss.ejb3.annotation.LocalBinding;
import org.jboss.ejb3.annotation.LocalHomeBinding;
import org.jboss.ejb3.annotation.Management;
import org.jboss.ejb3.annotation.MessageProperties;
import org.jboss.ejb3.annotation.PersistenceManager;
import org.jboss.ejb3.annotation.Pool;
import org.jboss.ejb3.annotation.Producer;
import org.jboss.ejb3.annotation.ProducerLocal;
import org.jboss.ejb3.annotation.Producers;
import org.jboss.ejb3.annotation.RemoteBinding;
import org.jboss.ejb3.annotation.RemoteBindings;
import org.jboss.ejb3.annotation.RemoteHomeBinding;
import org.jboss.ejb3.annotation.ResourceAdapter;
import org.jboss.ejb3.annotation.RunAsPrincipal;
import org.jboss.ejb3.annotation.SecurityDomain;
import org.jboss.ejb3.annotation.SerializedConcurrentAccess;
import org.jboss.ejb3.annotation.Service;
import org.jboss.ejb3.annotation.TransactionTimeout;
import org.jboss.ejb3.annotation.defaults.ClusteredDefaults;
import org.jboss.ejb3.annotation.defaults.PersistenceManagerDefaults;
import org.jboss.ejb3.annotation.defaults.PoolDefaults;
import org.jboss.metadata.ejb.jboss.jndipolicy.spi.DefaultJndiBindingPolicy;

/**
 * A Test Object for compilation only to ensure that the 
 * External API does not contain any dependencies
 * outside of itself or the JavaEE EJB API.
 * 
 * May also be used as a brief reference/guide for JBoss
 * Extensions and their use.
 * 
 * @author <a href="mailto:andrew.rubinger@jboss.org">ALR</a>
 * @version $Revision: $
 */
@AspectDomain("test")
@Cache("CacheImpl")
@CacheConfig(name = "CacheConfigName", maxSize = CacheConfig.DEFAULT_NONCLUSTERED_MAX_SIZE, idleTimeoutSeconds = CacheConfig.DEFAULT_IDLE_TIMEOUT_SECONDS, replicationIsPassivation = CacheConfig.DEFAULT_REPL_IS_PASV, removalTimeoutSeconds = CacheConfig.DEFAULT_REMOVAL_TIMEOUT_SECONDS)
@Clustered(loadBalancePolicy = ClusteredDefaults.LOAD_BALANCE_POLICY_DEFAULT, partition = ClusteredDefaults.PARTITION_NAME_DEFAULT)
@Consumer(name = "ConsumerName", activationConfig =
{@ActivationConfigProperty(propertyName = "propertyName", propertyValue = "propertyValue")})
@DefaultActivationSpecs(
{@ActivationConfigProperty(propertyName = "propertyName", propertyValue = "propertyValue")})
@Depends("DependencyON")
@IIOP(interfaceRepositorySupported = false, poa = IIOP.POA_PER_SERVANT)
@JndiBindingPolicy(policy = DefaultJndiBindingPolicy.class)
@LocalBinding(jndiBinding = "localJndiName")
@LocalHomeBinding(jndiBinding = "localHomeJndiName")
@Management(value = Object.class)
@MessageProperties(delivery = DeliveryMode.NON_PERSISTENT, timeToLive = 0, priority = 4)
@PersistenceManager(PersistenceManagerDefaults.PERSISTENCE_MANAGER_IMPLEMENTATION_STATEFUL_SESSION_FILE)
@Pool(value=PoolDefaults.POOL_IMPLEMENTATION_THREADLOCAL,maxSize=PoolDefaults.DEFAULT_POOL_SIZE)
@Producers(
{@Producer(producer = Producer.class, connectionFactory = "", transacted = true, acknowledgeMode = 1)})
@ProducerLocal
@RemoteBindings(@RemoteBinding(jndiBinding="remoteBinding", interceptorStack="",clientBindUrl=""))
@RemoteHomeBinding(jndiBinding="remoteHomeBinding")
@ResourceAdapter("resourceAdaptor")
@RunAsPrincipal("principalName")
@SecurityDomain(value="securityDomain",unauthenticatedPrincipal="unAuthPrincipal")
@SerializedConcurrentAccess
@Service(objectName="ON",name="ServiceName",xmbean="XMBean")
@TransactionTimeout(value=0)
public class TestCompilationBean
{

   @CurrentMessage
   private Object currentMessage;

   @JndiInject(jndiName = "jndiName")
   @IgnoreDependency
   private Object injectedReference;

}
