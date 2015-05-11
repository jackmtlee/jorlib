/* ==========================================
 * jORLib : a free Java OR library
 * ==========================================
 *
 * Project Info:  https://github.com/jkinable/jorlib
 * Project Creator:  Joris Kinable (https://github.com/jkinable)
 *
 * (C) Copyright 2015, by Joris Kinable and Contributors.
 *
 * This program and the accompanying materials are licensed under GPLv3
 *
 */
/* -----------------
 * PricingProblemBunddle.java
 * -----------------
 * (C) Copyright 2015, by Joris Kinable and Contributors.
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
package org.jorlib.frameworks.columnGeneration.pricing;

import java.util.ArrayList;
import java.util.List;

import org.jorlib.frameworks.columnGeneration.colgenMain.AbstractColumn;

/**
 * Each pricing problem (PricingProblem) is solved by some algorithm (PricingProblemSolver). This class is a container which holds
 * a single instance of a PricingProblemSolver for *each* PricingProblem. The instances are produced by a PricingProblemSolverFactory
 * 
 * @author Joris Kinable
 * @version 13-4-2015
 *
 */
public final class PricingProblemBundle<T, U extends AbstractColumn<T,U,V>, V extends AbstractPricingProblem<T>> {
	public final Class<? extends PricingProblemSolver<T, U, V>> pricingSolver;
	public final List<PricingProblemSolver<T, U, V>> solverInstances;
	
	/**
	 * Each pricing problem (PricingProblem) is solved by some algorithm (PricingProblemSolver). This class is a container which holds
	 * a single instance of a PricingProblemSolver for *each* PricingProblem. The instances are produced by a PricingProblemSolverFactory
	 * @param pricingSolver The solver for which the instances need to be created
	 * @param pricingProblems List of pricing problems
	 * @param solverFactory Factory to produce Solver Instances
	 */
	public PricingProblemBundle(Class<? extends PricingProblemSolver<T, U, V>> pricingSolver, 
			List<V> pricingProblems, 
			PricingProblemSolverFactory<T, U, V> solverFactory){
		this.pricingSolver=pricingSolver;
		//Create the solver instances
		solverInstances=new ArrayList<>(pricingProblems.size());
		for(V pricingProblem : pricingProblems){
			solverInstances.add(solverFactory.createSolverInstance(pricingProblem));
		}
	}
}
