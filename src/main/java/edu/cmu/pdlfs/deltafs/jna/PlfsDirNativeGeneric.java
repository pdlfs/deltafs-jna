/*
 * Copyright (c) 2015-2017 Carnegie Mellon University.
 *
 * All rights reserved.
 *
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file. See the AUTHORS file for names of contributors.
 */

package edu.cmu.pdlfs.deltafs.jna;

import com.sun.jna.LastErrorException;
import com.sun.jna.Native;
import com.sun.jna.PointerType;

// Native access to deltafs plfsdir api.
class PlfsDirNativeGeneric {

    static {
        Native.register("deltafs");
    }

    static native ThreadPool deltafs_tp_init(int num_workers) throws LastErrorException;

    static native int deltafs_tp_pause(ThreadPool tp) throws LastErrorException;

    static native int deltafs_tp_rerun(ThreadPool tp) throws LastErrorException;

    static native int deltafs_tp_close(ThreadPool tp) throws LastErrorException;

    static native PlfsDir deltafs_plfsdir_create_handle(String dir_conf, int dir_mode) throws LastErrorException;

    static native int deltafs_plfsdir_set_thread_pool(PlfsDir dir, ThreadPool tp) throws LastErrorException;

    static native int deltafs_plfsdir_open(PlfsDir dir, String dir_name) throws LastErrorException;

    static native int deltafs_plfsdir_epoch_flush(PlfsDir dir, int epoch) throws LastErrorException;

    static native int deltafs_plfsdir_flush(PlfsDir dir, int epoch) throws LastErrorException;

    static native int deltafs_plfsdir_finish(PlfsDir dir) throws LastErrorException;

    static native int deltafs_plfsdir_free_handle(PlfsDir dir) throws LastErrorException;

    // Opaque handle to a plfsdir
    static class PlfsDir extends PointerType {
    }

    // Opaque handle to a background thread pool
    static class ThreadPool extends PointerType {
    }
}
