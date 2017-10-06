/*
 * Copyright (c) 2015-2017 Carnegie Mellon University.
 *
 * All rights reserved.
 *
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file. See the AUTHORS file for names of contributors.
 */

package edu.cmu.pdlfs.deltafs.jna;

import edu.cmu.pdlfs.deltafs.jna.PlfsDirNativeGeneric.PlfsDir;

import com.sun.jna.LastErrorException;
import com.sun.jna.Native;

// Native access to deltafs plfsdir api on 64-bit platforms.
// where SIZE_T == 8 bytes.
class PlfsDirNative64 {

    static {
        Native.register("deltafs");
    }

    static native int deltafs_plfsdir_set_key_size(PlfsDir dir, long key_size) throws LastErrorException;

    static native int deltafs_plfsdir_set_val_size(PlfsDir dir, long val_size) throws LastErrorException;

    static native int deltafs_plfsdir_put(PlfsDir dir, byte[] key, long key_len, int epoch, byte[] val, long val_len) throws LastErrorException;

}
