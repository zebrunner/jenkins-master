import jenkins.model.*
jenkins = Jenkins.instance

def qps_plugins = [
'ace-editor':'1.1',
'ansicolor':'0.7.3',
'ant':'1.11',
'antisamy-markup-formatter':'2.1',
'apache-httpcomponents-client-4-api':'4.5.10-2.0',
'authentication-tokens':'1.4',
'bouncycastle-api':'2.18',
'build-name-setter':'2.1.0',
'build-timeout':'1.20',
'build-user-vars-plugin':'1.6',
'categorized-view':'1.10',
'command-launcher':'1.5',
'config-file-provider':'3.7.0',
'copyartifact':'1.45.3',
'credentials':'2.3.14',
'credentials-binding':'1.24',
'docker-commons':'1.17',
'docker-workflow':'1.25',
'durable-task':'1.35',
'email-ext':'2.79',
'embeddable-build-status':'2.0.3',
'extensible-choice-parameter':'1.7.0',
'external-monitor-job':'1.7',
'generic-webhook-trigger':'1.72',
'git-client':'3.5.1',
'github':'1.32.0',
'git-server':'1.9',
'global-variable-string-parameter':'1.2',
'gradle':'1.36',
'h2-api':'1.4.199',
'handlebars':'1.1.1',
'hidden-parameter':'0.0.4',
'htmlpublisher':'1.25',
'http_request':'1.8.27',
'jackson2-api':'2.12.0',
'javadoc':'1.6',
'jaxb':'2.3.0.1',
'jdk-tool':'1.4',
'jobConfigHistory':'2.26',
'job-dsl':'1.77',
'jquery-detached':'1.2.1',
'jsch':'0.1.55.2',
'ldap':'2.0',
'lockable-resources':'2.10',
'mailer':'1.32.1',
'mapdb-api':'1.0.9.0',
'matrix-project':'1.18',
'momentjs':'1.1.1',
'next-build-number':'1.6',
'ownership':'0.13.0',
'pam-auth':'1.6',
'parameterized-trigger':'2.39',
'pipeline-aws':'1.42',
'pipeline-build-step':'2.13',
'pipeline-github-lib':'1.0',
'pipeline-graph-analysis':'1.10',
'pipeline-input-step':'2.12',
'pipeline-maven':'3.9.3',
'pipeline-milestone-step':'1.3.1',
'pipeline-model-api':'1.7.2',
'pipeline-model-definition':'1.7.2',
'pipeline-model-extensions':'1.7.2',
'pipeline-stage-step':'2.5',
'pipeline-stage-tags-metadata':'1.7.2',
'pipeline-utility-steps':'2.6.1',
'plain-credentials':'1.7',
'PrioritySorter':'3.6.0',
'random-string-parameter':'1.0',
'rebuild':'1.31',
'resource-disposer':'0.14',
'scm-api':'2.6.4',
'script-security':'1.75',
'slack':'2.44',
'sonar':'2.12',
'ssh-credentials':'1.18.1',
'ssh-slaves':'1.31.2',
'structs':'1.20',
'subversion':'2.13.2',
'swarm':'3.24',
'timestamper':'1.11.8',
'token-macro':'2.12',
'variant':'1.3',
'view-job-filters':'2.3',
'windows-slaves':'1.7',
'workflow-aggregator':'2.6',
'workflow-api':'2.40',
'workflow-cps-global-lib':'2.17',
'workflow-job':'2.40',
'workflow-multibranch':'2.22',
'workflow-scm-step':'2.11',
'ws-cleanup':'0.38'
]


def install_plugins(plugins_map){
	def entries = plugins_map.entrySet()
	entries.each { entry ->
	  println "${entry.key}:${entry.value}"
	  def plugin = jenkins.instance.updateCenter.getPlugin(entry.key, new hudson.util.VersionNumber(entry.value))
	  if (plugin != null) {
	    plugin.deploy()
	  } else {
	    println("ERROR! Unable to get plugin ${entry.key}:${entry.value}!")
	  }
	}
}


println "Installing qps-infra plugins required for jenkins:"
install_plugins(qps_plugins)
