/* ==========================================
 * jORLib : a free Java OR library
 * ==========================================
 *
 * Project Info:  https://github.com/jkinable/jorlib
 * Project Creator:  Joris Kinable (https://github.com/jkinable)
 *
 * (C) Copyright 2016, by Joris Kinable and Contributors.
 *
 * This program and the accompanying materials are licensed under LGPLv2.1
 *
 */
/* -----------------
 * DFSNodeComparatorTest.java
 * -----------------
 * (C) Copyright 2016, by Joris Kinable and Contributors.
 *
 * Original Author:  Joris Kinable
 * Contributor(s):   -
 *
 * $Id$
 *
 * Changes
 * -------
 *
 */
package org.jorlib.frameworks.columnGeneration.branchAndPrice.bapNodeComparators;

import org.jorlib.frameworks.columnGeneration.branchAndPrice.BAPNode;
import org.jorlib.frameworks.columnGeneration.master.OptimizationSense;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for the DFSNodeComparator
 */
public final class DFSNodeComparatorTest {

    @Test
    public void testDFSNodeComparator(){
        BAPNode bapNode0=new BAPNode<>(0, null, null, null, 4, null); //Node with bound equal to 4
        BAPNode bapNode1=new BAPNode<>(1, null, null, null, 2, null); //Node with bound equal to 2

        DFSbapNodeComparator comparator=new DFSbapNodeComparator();

        Assert.assertEquals(-1, comparator.compare(bapNode1, bapNode0));
        Assert.assertEquals(1, comparator.compare(bapNode0, bapNode1));
    }

}