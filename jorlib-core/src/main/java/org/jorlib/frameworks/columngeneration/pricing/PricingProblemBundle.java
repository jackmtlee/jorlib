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
package org.jorlib.frameworks.columngeneration.pricing;

import java.util.ArrayList;
import java.util.List;

import org.jorlib.frameworks.columngeneration.colgenmain.AbstractColumn;
import org.jorlib.frameworks.columngeneration.model.ModelInterface;

/**
 * Each pricing problem (PricingProblem) is solved by some algorithm (AbstractPricingProblemSolver).
 * This class is a container which holds all instance of a particular AbstractPricingProblemSolver.
 * Typically, there exists an instance for each pricing problem. The instances are produced by a
 * PricingProblemSolverFactory. This class takes a solver, list of pricing problems and a
 * solverFactory and it produces the necessary solver instances.
 * 
 * @author Joris Kinable
 * @version 13-4-2015
 *
 */
public final class PricingProblemBundle<T extends ModelInterface, U extends AbstractColumn<T, V>,
    V extends AbstractPricingProblem<T, U>>
{

    /** The solver (class) **/
    public final Class<? extends AbstractPricingProblemSolver<T, U, V>> pricingSolver;

    /** The solver instances. The number of instances equals the number of pricing problems **/
    public final List<AbstractPricingProblemSolver<T, U, V>> solverInstances;

    /**
     * Each pricing problem ({@link AbstractPricingProblem}) is solved by some algorithm
     * ({@link AbstractPricingProblemSolver}). This class is a container which holds a single
     * instance of a AbstractPricingProblemSolver for *each* PricingProblem. The instances are
     * produced by a PricingProblemSolverFactory
     * 
     * @param pricingSolver The solver
     * @param pricingProblems List of pricing problems
     * @param solverFactory Factory to produce Solver Instances of the type of the pricingSolver.
     */
    public PricingProblemBundle(
        Class<? extends AbstractPricingProblemSolver<T, U, V>> pricingSolver,
        List<V> pricingProblems, PricingProblemSolverFactory<T, U, V> solverFactory)
    {
        this.pricingSolver = pricingSolver;
        // Create the solver instances
        solverInstances = new ArrayList<>(pricingProblems.size());
        for (V pricingProblem : pricingProblems) {
            solverInstances.add(solverFactory.createSolverInstance(pricingProblem));
        }
    }
}
