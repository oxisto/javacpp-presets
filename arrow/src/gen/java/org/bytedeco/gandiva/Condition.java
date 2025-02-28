// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.gandiva;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.gandiva.*;


/** \brief A condition expression. */
@Namespace("gandiva") @Properties(inherit = org.bytedeco.arrow.presets.gandiva.class)
public class Condition extends Expression {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Condition(Pointer p) { super(p); }

  public Condition(@SharedPtr Node root) { super((Pointer)null); allocate(root); }
  private native void allocate(@SharedPtr Node root);
}
