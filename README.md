# just-gif-it

upload video files using spring boot 2.0

springboot-starter-devtools maven dependency - server auto restart and deploy the changes if any build changes found.spring boot uses two types of class loaders one is load all class files which are present in classpath and the other one will load only changed class files.
Spring boot is not spring boot without auto configurations.

@EnableAutoConfiguration - annotation enables configurations ..if you dont need those auto configurations exclude them using exclude property inside annotation with full qualified class names.

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,...})
@SpringbootApplication(exclude={classnames with fully qualified name,..,})


we can exclude them using application.properties as well like below

spring.autoconfigure.exclude = class names with comma separated.
List of spring boot common application properties :
https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html

@ConditionalOnMissingBean - PropertySourcesPlaceholderConfigurer class is not auto configured and which is not present in application context..so we can define our own bean and annotate with missingbean annotation so springboot autoconfigure this before autoconfigurations.

Completely custom auto configuration : Remove @EnableAutoConfiguration and manually configure an array of auto configuration classes with @Configuration annotation and @Import annotations.

ex:
@Configuration
@Import({DispatcherServletAutoConfiguration.class,...})
public class JustGifItApplication{
}

https://www.baeldung.com/spring-boot-custom-auto-configuration

using @ConditionalOn annotation :
Spring 4 introduced conditional configuration.
A single condition that must be matched in order for a component to be registered.

spring-data-rest-hal-browser maven dependency:

