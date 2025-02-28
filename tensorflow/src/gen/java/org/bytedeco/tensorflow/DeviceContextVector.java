// Targeted by JavaCPP version 1.5.6: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;

@Name("std::vector<tensorflow::DeviceContext*>") @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class DeviceContextVector extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DeviceContextVector(Pointer p) { super(p); }
    public DeviceContextVector(DeviceContext value) { this(1); put(0, value); }
    public DeviceContextVector(DeviceContext ... array) { this(array.length); put(array); }
    public DeviceContextVector()       { allocate();  }
    public DeviceContextVector(long n) { allocate(n); }
    private native void allocate();
    private native void allocate(@Cast("size_t") long n);
    public native @Name("operator =") @ByRef DeviceContextVector put(@ByRef DeviceContextVector x);

    public boolean empty() { return size() == 0; }
    public native long size();
    public void clear() { resize(0); }
    public native void resize(@Cast("size_t") long n);

    @Index(function = "at") public native DeviceContext get(@Cast("size_t") long i);
    public native DeviceContextVector put(@Cast("size_t") long i, DeviceContext value);

    public native @ByVal Iterator insert(@ByVal Iterator pos, DeviceContext value);
    public native @ByVal Iterator erase(@ByVal Iterator pos);
    public native @ByVal Iterator begin();
    public native @ByVal Iterator end();
    @NoOffset @Name("iterator") public static class Iterator extends Pointer {
        public Iterator(Pointer p) { super(p); }
        public Iterator() { }

        public native @Name("operator ++") @ByRef Iterator increment();
        public native @Name("operator ==") boolean equals(@ByRef Iterator it);
        public native @Name("operator *") @Const DeviceContext get();
    }

    public DeviceContext[] get() {
        DeviceContext[] array = new DeviceContext[size() < Integer.MAX_VALUE ? (int)size() : Integer.MAX_VALUE];
        for (int i = 0; i < array.length; i++) {
            array[i] = get(i);
        }
        return array;
    }
    @Override public String toString() {
        return java.util.Arrays.toString(get());
    }

    public DeviceContext pop_back() {
        long size = size();
        DeviceContext value = get(size - 1);
        resize(size - 1);
        return value;
    }
    public DeviceContextVector push_back(DeviceContext value) {
        long size = size();
        resize(size + 1);
        return put(size, value);
    }
    public DeviceContextVector put(DeviceContext value) {
        if (size() != 1) { resize(1); }
        return put(0, value);
    }
    public DeviceContextVector put(DeviceContext ... array) {
        if (size() != array.length) { resize(array.length); }
        for (int i = 0; i < array.length; i++) {
            put(i, array[i]);
        }
        return this;
    }
}

