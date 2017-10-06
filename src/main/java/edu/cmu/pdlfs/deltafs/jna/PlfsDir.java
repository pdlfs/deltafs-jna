/*
 * Copyright (c) 2015-2017 Carnegie Mellon University.
 *
 * All rights reserved.
 *
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file. See the AUTHORS file for names of contributors.
 */

package edu.cmu.pdlfs.deltafs.jna;

// Interface to a deltafs plfsdir.
public class PlfsDir {

    private PlfsDirNativeGeneric.PlfsDir dir;
    private String dirName;

    public PlfsDir(String dirConf, String dirName, int dirMode) {
        this.dir = PlfsDirNativeGeneric.deltafs_plfsdir_create_handle(dirConf, dirMode);
        this.dirName = dirName;
    }

    public void setThreadPool(PlfsDirThreadPool threadPool) {
        assert this.dir != null;
        assert threadPool != null;
        PlfsDirNativeGeneric.deltafs_plfsdir_set_thread_pool(this.dir, threadPool.getNative());
    }

    public void setKeySize(int keySize) {
        assert this.dir != null;
        assert keySize != 0;
        PlfsDirNative64.deltafs_plfsdir_set_key_size(dir, keySize);
    }

    public void setValSize(int valSize) {
        assert this.dir != null;
        assert valSize != 0;
        PlfsDirNative64.deltafs_plfsdir_set_val_size(dir, valSize);
    }

    public void open() {
        assert this.dir != null;
        PlfsDirNativeGeneric.deltafs_plfsdir_open(dir, dirName);
    }

    public void put(byte[] key, int epoch, byte[] val) {
        assert this.dir != null;
        assert key != null;
        assert key.length != 0;
        assert val != null;
        assert val.length != 0;
        PlfsDirNative64.deltafs_plfsdir_put(this.dir, key, key.length, epoch, val, val.length);
    }

    public void flush(int epoch) {
        assert this.dir != null;
        PlfsDirNativeGeneric.deltafs_plfsdir_flush(this.dir, epoch);
    }

    public void epochFlush(int epoch) {
        assert this.dir != null;
        PlfsDirNativeGeneric.deltafs_plfsdir_epoch_flush(this.dir, epoch);
    }

    public void finish() {
        assert this.dir != null;
        PlfsDirNativeGeneric.deltafs_plfsdir_finish(this.dir);
    }

    public void close() {
        PlfsDirNativeGeneric.deltafs_plfsdir_free_handle(this.dir);
        this.dir = null;
    }

    // Internal to package code. External code should ignore.
    PlfsDirNativeGeneric.PlfsDir getNative() {
        assert this.dir != null;
        return this.dir;
    }
}
