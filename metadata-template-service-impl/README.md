
### maven setup

The pom.xml sets up various properties files for testing.  Sample maven settings.xml are as follows

```xml


		<profile>
			<id>mdtemplate</id>
			<properties>
				<mdtemplate.public>/zone1/home/mdtemplate</mdtemplate.public>
			</properties>
		</profile>
		
		<profile>
			<id>irods420.irodslocal</id>
			<properties>
				<jargon.test.data.directory>/home/mconway/temp/irodsscratch/</jargon.test.data.directory>
				<jargon.test.irods.admin>rods</jargon.test.irods.admin>
				<jargon.test.irods.admin.password>rods</jargon.test.irods.admin.password>
				<jargon.test.irods.user>test1</jargon.test.irods.user>
				<jargon.test.irods.password>test</jargon.test.irods.password>
				<jargon.test.irods.resource>test1-resc</jargon.test.irods.resource>
				<jargon.test.irods.user2>test2</jargon.test.irods.user2>
				<jargon.test.irods.password2>test</jargon.test.irods.password2>
				<jargon.test.irods.resource2>test1-resc2</jargon.test.irods.resource2>
				<jargon.test.irods.resource3>test1-resc3</jargon.test.irods.resource3>
				<jargon.test.irods.user3>test3</jargon.test.irods.user3>
				<jargon.test.irods.password3>test</jargon.test.irods.password3>
				<jargon.test.kerberos.user />
				<jargon.test.irods.host>irods420.irodslocal</jargon.test.irods.host>
				<jargon.test.irods.port>1247</jargon.test.irods.port>
				<jargon.test.irods.zone>zone1</jargon.test.irods.zone>
				<jargon.test.resource.group>testResourceGroup</jargon.test.resource.group>
				<jargon.test.user.group>jargonTestUg</jargon.test.user.group>
				<jargon.test.irods.userDN>test1DN</jargon.test.irods.userDN>
				<jargon.test.irods.scratch.subdir>jargon-scratch</jargon.test.irods.scratch.subdir>
				<jargon.test.option.exercise.remoteexecstream>true</jargon.test.option.exercise.remoteexecstream>
				<jargon.test.option.exercise.ticket>true</jargon.test.option.exercise.ticket>
				<jargon.test.option.exercise.audit>false</jargon.test.option.exercise.audit>
				<jargon.test.option.exercise.workflow>false</jargon.test.option.exercise.workflow>
				<jargon.test.option.exercise.filesystem.mount>false</jargon.test.option.exercise.filesystem.mount>
				<test.option.mount.basedir>/home/mconway/temp/basedir</test.option.mount.basedir>
				<jargon.test.pam.user>pam</jargon.test.pam.user>
				<jargon.test.pam.password>pam</jargon.test.pam.password>
				<test.option.pam>true</test.option.pam>
				<test.option.ssl.configured>true</test.option.ssl.configured>
				<test.option.distributed.resources>false</test.option.distributed.resources>
				<test.option.registration>false</test.option.registration>
				<test.option.federated.zone>false</test.option.federated.zone>
				<test.option.kerberos>false</test.option.kerberos>
				<test.option.strictACL>false</test.option.strictACL>
				<test.rest.port>8888</test.rest.port>
				<jargon.test.federated.irods.admin>rods</jargon.test.federated.irods.admin>
				<jargon.test.federated.irods.admin.password>test</jargon.test.federated.irods.admin.password>
				<jargon.test.federated.irods.user>test1</jargon.test.federated.irods.user>
				<jargon.test.federated.irods.password>test</jargon.test.federated.irods.password>
				<jargon.test.federated.irods.resource>test1-resc</jargon.test.federated.irods.resource>
				<jargon.test.federated.irods.host>fedzone2</jargon.test.federated.irods.host>
				<jargon.test.federated.irods.port>1247</jargon.test.federated.irods.port>
				<jargon.test.federated.irods.zone>fedzone2</jargon.test.federated.irods.zone>
			</properties>
		</profile>



```


### generating code

## RESTEASY

```
java -jar /home/mconway/javalib/swagger-codegen/swagger-codegen-cli-2.2.1.jar generate \
 -i https://raw.githubusercontent.com/DICE-UNC/irods_rest_services/master/base/base.yaml \
  -l jaxrs-resteasy \
  --model-package org.irods.jargon.rest.base.model \
  --api-package org.irods.jargon.rest.base \
  -o target/codegen


```


## SPRING4

```
java -jar /home/mconway/javalib/swagger-codegen/swagger-codegen-cli-2.2.1.jar generate \
 -i https://raw.githubusercontent.com/irods-contrib/irods_rest_services/master/metadata_templates/swagger.yaml \
  -l spring \
  --model-package org.irods.jargon.rest.mdtemplate.model \
  --api-package org.irods.jargon.rest.mdtemplate \
  -o target/codegen

```