/* ==========================================
 * jORLib : Java Operations Research Library
 * ==========================================
 *
 * Project Info:  http://www.coin-or.org/projects/jORLib.xml
 * Project Creator:  Joris Kinable (https://github.com/jkinable)
 *
 * (C) Copyright 2015-2016, by Joris Kinable and Contributors.
 *
 * This program and the accompanying materials are licensed under LGPLv2.1
 * as published by the Free Software Foundation.
 */
package org.jorlib.demo.frameworks.columngeneration.tspbap.cg.master.cuts;

import java.util.Set;

import org.jorlib.demo.frameworks.columngeneration.tspbap.cg.master.TSPMasterData;
import org.jorlib.demo.frameworks.columngeneration.tspbap.model.TSP;
import org.jorlib.frameworks.columngeneration.master.cutGeneration.AbstractCutGenerator;
import org.jorlib.frameworks.columngeneration.master.cutGeneration.AbstractInequality;

/**
 * Class representing a subtour inequality: The number of edges entering/leaving the cutSet must be
 * at least 2, otherwise there is a subtour within the cutSet
 *
 * @author Joris Kinable
 * @version 13-4-2015
 *
 */
public final class SubtourInequality
    extends AbstractInequality<TSP, TSPMasterData>
{

    /** Vertices in the cut set **/
    public final Set<Integer> cutSet;

    public SubtourInequality(AbstractCutGenerator<TSP, TSPMasterData> maintainingGenerator, Set<Integer> cutSet)
    {
        super(maintainingGenerator);
        this.cutSet = cutSet;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        else if (!(o instanceof SubtourInequality))
            return false;
        SubtourInequality other = (SubtourInequality) o;
        return this.cutSet.equals(other.cutSet);
    }

    @Override
    public int hashCode()
    {
        return cutSet.hashCode();
    }

}
