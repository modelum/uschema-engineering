/*
 * generated by Xtext 2.25.0
 */
package es.um.uschema.xtext.orion.ide

import com.google.inject.Guice
import es.um.uschema.xtext.orion.OrionRuntimeModule
import es.um.uschema.xtext.orion.OrionStandaloneSetup
import org.eclipse.xtext.util.Modules2

/**
 * Initialization support for running Xtext languages as language servers.
 */
class OrionIdeSetup extends OrionStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new OrionRuntimeModule, new OrionIdeModule))
	}
	
}
