/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule.bestpractices;

public class PositionLiteralsFirstInCaseInsensitiveComparisonsRule extends AbstractPositionLiteralsFirstInComparisons {

    public PositionLiteralsFirstInCaseInsensitiveComparisonsRule() {
        super(".equalsIgnoreCase");
    }

}
