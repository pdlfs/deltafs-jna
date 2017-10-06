/*
 * Copyright (c) 2015-2017 Carnegie Mellon University.
 *
 * All rights reserved.
 *
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file. See the AUTHORS file for names of contributors.
 */

package edu.cmu.pdlfs.deltafs.jna;

// Interface to a deltafs plfsdir thread pool.
public class PlfsDirThreadPool {

    private PlfsDirNativeGeneric.ThreadPool threadPool;
    private int numWorkers;

    public PlfsDirThreadPool(int numWorkers) {
        this.threadPool = PlfsDirNativeGeneric.deltafs_tp_init(numWorkers);
        this.numWorkers = numWorkers;
    }

    public void pause() {
        assert this.threadPool != null;
        PlfsDirNativeGeneric.deltafs_tp_pause(this.threadPool);
    }

    public void rerun() {
        assert this.threadPool != null;
        PlfsDirNativeGeneric.deltafs_tp_rerun(this.threadPool);
    }

    public void close() {
        assert this.threadPool != null;
        PlfsDirNativeGeneric.deltafs_tp_close(this.threadPool);
        this.threadPool = null;
    }

    // Internal to package code. External code should ignore.
    PlfsDirNativeGeneric.ThreadPool getNative() {
        assert this.threadPool != null;
        return this.threadPool;
    }
}
