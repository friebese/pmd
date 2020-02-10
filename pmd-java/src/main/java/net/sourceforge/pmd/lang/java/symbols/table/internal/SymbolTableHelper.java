/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.symbols.table.internal;

import org.checkerframework.checker.nullness.qual.Nullable;

import net.sourceforge.pmd.lang.java.internal.JavaAstProcessor;
import net.sourceforge.pmd.lang.java.symbols.JClassSymbol;
import net.sourceforge.pmd.lang.java.symbols.SymbolResolver;


/**
 * Object passing around config for {@link AbstractSymbolTable}.
 *
 * @since 7.0.0
 */
final class SymbolTableHelper {

    private final String thisPackage;
    private final SymbolResolver symbolResolver;
    private final SemanticChecksLogger logger;


    SymbolTableHelper(String thisPackage, JavaAstProcessor processor) {

        this.thisPackage = thisPackage;
        this.symbolResolver = processor.getSymResolver();
        this.logger = processor.getLogger();

        assert symbolResolver != null;
        assert thisPackage != null;
    }


    /** Prepend the package name, handling empty package. */
    String prependPackageName(String name) {
        return thisPackage.isEmpty() ? name : thisPackage + "." + name;
    }


    /** @see SymbolResolver#resolveClassOrDefault(String) */
    public JClassSymbol findSymbolCannotFail(String name) {
        return symbolResolver.resolveClassOrDefault(name);
    }

    /** @see SymbolResolver#resolveClassFromCanonicalName(String) */
    @Nullable
    JClassSymbol loadClassOrFail(String fqcn) {
        return symbolResolver.resolveClassFromCanonicalName(fqcn);
    }

    SemanticChecksLogger getLogger() {
        return logger;
    }

    public String getThisPackage() {
        return thisPackage;
    }
}
