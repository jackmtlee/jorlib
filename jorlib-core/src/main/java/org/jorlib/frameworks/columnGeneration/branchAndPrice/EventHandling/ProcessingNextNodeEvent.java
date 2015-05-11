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
 * ProcessingNextNodeEvent.java
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
package org.jorlib.frameworks.columnGeneration.branchAndPrice.EventHandling;

import org.jorlib.frameworks.columnGeneration.branchAndPrice.BAPNode;

import java.util.EventObject;

/**
 * Event generated when branch and price starts processing a new node
 *
 * @author Joris Kinable
 * @version 5-5-2015
 */
public class ProcessingNextNodeEvent extends EventObject{

    /** Node which will be processed **/
    public final BAPNode node;
    /** Number of nodes currently waiting in the queue **/
    public final int nodesInQueue;
    /** Best integer solution obtained so far **/
    public final int globalUB;

    /**
     * Creates a new ProcessingNextNodeEvent
     * @param source Generator of the event
     * @param node Node which will be processed
     * @param nodesInQueue Number of nodes currently in the queue
     * @param globalUB Best integer solution found thus far
     */
    public ProcessingNextNodeEvent(Object source, BAPNode node, int nodesInQueue, int globalUB){
        super(source);
        this.node=node;
        this.nodesInQueue=nodesInQueue;
        this.globalUB=globalUB;
    }
}
