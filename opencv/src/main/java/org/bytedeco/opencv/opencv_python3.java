/*
 * Copyright (C) 2019-2021 Samuel Audet
 *
 * Licensed either under the Apache License, Version 2.0, or (at your option)
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation (subject to the "Classpath" exception),
 * either version 2, or any later version (collectively, the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     http://www.gnu.org/licenses/
 *     http://www.gnu.org/software/classpath/license.html
 *
 * or as provided in the LICENSE.txt file that accompanied this code.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bytedeco.opencv;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;

import org.bytedeco.opencv.presets.*;

/**
 * This is only a placeholder to facilitate loading the {@code opencv_python3} module with JavaCPP.
 * <p>
 * Call {@code PySys_SetPath(opencv_python3.cachePackages())} after calling {@code Py_Initialize()}.
 *
 * @author Samuel Audet
 */
@Properties(
    inherit = {
        opencv_aruco.class,
        opencv_bgsegm.class,
        opencv_bioinspired.class,
        opencv_face.class,
        opencv_img_hash.class,
        opencv_structured_light.class,
        opencv_text.class,
        opencv_tracking.class,
        opencv_xfeatures2d.class,
        opencv_ximgproc.class,
        opencv_xphoto.class,
        opencv_videostab.class,
        opencv_superres.class,
        opencv_stitching.class,
        opencv_saliency.class,
        opencv_quality.class,
        opencv_dnn_superres.class,
        opencv_intensity_transform.class,
        opencv_mcc.class,
        opencv_rapid.class,
        opencv_barcode.class,
        opencv_wechat_qrcode.class,
    },
    value = {
        @Platform(preload = {"opencv_cuda@.4.5", "opencv_cudaarithm@.4.5", "opencv_cudafilters@.4.5", "opencv_cudaimgproc@.4.5",
                             "opencv_cudacodec@.4.5", "opencv_cudaobjdetect@.4.5", "opencv_cudabgsegm@.4.5", "opencv_cudastereo@.4.5",
                             "opencv_cudaoptflow@.4.5", "opencv_cudawarping@.4.5", "opencv_cudalegacy@.4.5"}),
        @Platform(value = "windows", preload = {"opencv_cuda454", "opencv_cudaarithm454", "opencv_cudafilters454", "opencv_cudaimgproc454",
                             "opencv_cudacodec454", "opencv_cudaobjdetect454", "opencv_cudabgsegm454", "opencv_cudastereo454",
                             "opencv_cudaoptflow454", "opencv_cudawarping454", "opencv_cudalegacy454"}),
    }
)
public class opencv_python3 {
    static { Loader.load(); }

    private static File packageFile = null;

    /** Returns {@code Loader.cacheResource("/org/bytedeco/opencv/" + Loader.getPlatform() + extension + "/python/")}. */
    public static synchronized File cachePackage() throws IOException {
        if (packageFile != null) {
            return packageFile;
        }
        Loader.load(org.bytedeco.cpython.global.python.class);
        String path = Loader.load(opencv_core.class);
        if (path != null) {
            path = path.replace(File.separatorChar, '/');
            int i = path.indexOf("/org/bytedeco/opencv/" + Loader.getPlatform());
            int j = path.lastIndexOf("/");
            packageFile = Loader.cacheResource(path.substring(i, j) + "/python/");
        }
        return packageFile;
    }

    /** Returns {@code {numpy.cachePackages(), opencv.cachePackage()}}. */
    public static File[] cachePackages() throws IOException {
        File[] path = org.bytedeco.numpy.global.numpy.cachePackages();
        path = Arrays.copyOf(path, path.length + 1);
        path[path.length - 1] = cachePackage();
        return path;
    }
}
