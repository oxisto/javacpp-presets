// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import org.bytedeco.arrow.Function;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief Abstract file system API */
@Namespace("arrow::fs") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class FileSystem extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FileSystem(Pointer p) { super(p); }


  public native @StdString String type_name();

  /** EXPERIMENTAL: The IOContext associated with this filesystem. */
  
  ///
  public native @Const @ByRef IOContext io_context();

  /** Normalize path for the given filesystem
   * 
   *  The default implementation of this method is a no-op, but subclasses
   *  may allow normalizing irregular path forms (such as Windows local paths). */
  public native @ByVal StringResult NormalizePath(@StdString String path);
  public native @ByVal StringResult NormalizePath(@StdString BytePointer path);

  public native @Cast("bool") boolean Equals(@Const @ByRef FileSystem other);

  /** Get info for the given target.
   * 
   *  Any symlink is automatically dereferenced, recursively.
   *  A nonexistent or unreachable file returns an Ok status and
   *  has a FileType of value NotFound.  An error status indicates
   *  a truly exceptional condition (low-level I/O error, etc.). */
  public native @ByVal FileInfoResult GetFileInfo(@StdString String path);
  public native @ByVal FileInfoResult GetFileInfo(@StdString BytePointer path);
  /** Same, for many targets at once. */
  
  ///
  public native @ByVal FileInfoVectorResult GetFileInfo(@Const @ByRef StringVector paths);
  /** Same, according to a selector.
   * 
   *  The selector's base directory will not be part of the results, even if
   *  it exists.
   *  If it doesn't exist, see {@code FileSelector::allow_not_found}. */
  public native @ByVal FileInfoVectorResult GetFileInfo(@Const @ByRef FileSelector select);

  /** EXPERIMENTAL: async version of GetFileInfo */
  
  ///
  public native @ByVal FileInfoVectorFuture GetFileInfoAsync(@Const @ByRef StringVector paths);

  /** EXPERIMENTAL: streaming async version of GetFileInfo
   * 
   *  The returned generator is not async-reentrant, i.e. you need to wait for
   *  the returned future to complete before calling the generator again. */
  
  ///
  public native @ByVal @Cast("arrow::fs::FileInfoGenerator*") Pointer GetFileInfoGenerator(@Const @ByRef FileSelector select);

  /** Create a directory and subdirectories.
   * 
   *  This function succeeds if the directory already exists. */
  public native @ByVal Status CreateDir(@StdString String path, @Cast("bool") boolean recursive/*=true*/);
  public native @ByVal Status CreateDir(@StdString String path);
  public native @ByVal Status CreateDir(@StdString BytePointer path, @Cast("bool") boolean recursive/*=true*/);
  public native @ByVal Status CreateDir(@StdString BytePointer path);

  /** Delete a directory and its contents, recursively. */
  
  ///
  public native @ByVal Status DeleteDir(@StdString String path);
  public native @ByVal Status DeleteDir(@StdString BytePointer path);

  /** Delete a directory's contents, recursively.
   * 
   *  Like DeleteDir, but doesn't delete the directory itself.
   *  Passing an empty path ("" or "/") is disallowed, see DeleteRootDirContents. */
  
  ///
  public native @ByVal Status DeleteDirContents(@StdString String path);
  public native @ByVal Status DeleteDirContents(@StdString BytePointer path);

  /** EXPERIMENTAL: Delete the root directory's contents, recursively.
   * 
   *  Implementations may decide to raise an error if this operation is
   *  too dangerous. */
  // NOTE: may decide to remove this if it's deemed not useful
  public native @ByVal Status DeleteRootDirContents();

  /** Delete a file. */
  
  ///
  public native @ByVal Status DeleteFile(@StdString String path);
  public native @ByVal Status DeleteFile(@StdString BytePointer path);
  /** Delete many files.
   * 
   *  The default implementation issues individual delete operations in sequence. */
  
  ///
  public native @ByVal Status DeleteFiles(@Const @ByRef StringVector paths);

  /** Move / rename a file or directory.
   * 
   *  If the destination exists:
   *  - if it is a non-empty directory, an error is returned
   *  - otherwise, if it has the same type as the source, it is replaced
   *  - otherwise, behavior is unspecified (implementation-dependent). */
  
  ///
  public native @ByVal Status Move(@StdString String src, @StdString String dest);
  public native @ByVal Status Move(@StdString BytePointer src, @StdString BytePointer dest);

  /** Copy a file.
   * 
   *  If the destination exists and is a directory, an error is returned.
   *  Otherwise, it is replaced. */
  public native @ByVal Status CopyFile(@StdString String src, @StdString String dest);
  public native @ByVal Status CopyFile(@StdString BytePointer src, @StdString BytePointer dest);

  /** Open an input stream for sequential reading. */
  
  ///
  public native @ByVal InputStreamResult OpenInputStream(
        @StdString String path);
  public native @ByVal InputStreamResult OpenInputStream(
        @StdString BytePointer path);
  /** Open an input stream for sequential reading.
   * 
   *  This override assumes the given FileInfo validly represents the file's
   *  characteristics, and may optimize access depending on them (for example
   *  avoid querying the file size or its existence). */
  public native @ByVal InputStreamResult OpenInputStream(@Const @ByRef FileInfo info);

  /** Open an input file for random access reading. */
  
  ///
  public native @ByVal RandomAccessFileResult OpenInputFile(
        @StdString String path);
  public native @ByVal RandomAccessFileResult OpenInputFile(
        @StdString BytePointer path);
  /** Open an input file for random access reading.
   * 
   *  This override assumes the given FileInfo validly represents the file's
   *  characteristics, and may optimize access depending on them (for example
   *  avoid querying the file size or its existence). */
  public native @ByVal RandomAccessFileResult OpenInputFile(
        @Const @ByRef FileInfo info);

  /** EXPERIMENTAL: async version of OpenInputStream */
  public native @ByVal InputStreamFuture OpenInputStreamAsync(
        @StdString String path);
  public native @ByVal InputStreamFuture OpenInputStreamAsync(
        @StdString BytePointer path);
  /** EXPERIMENTAL: async version of OpenInputStream */
  public native @ByVal InputStreamFuture OpenInputStreamAsync(
        @Const @ByRef FileInfo info);

  /** EXPERIMENTAL: async version of OpenInputFile */
  public native @ByVal RandomAccessFileFuture OpenInputFileAsync(
        @StdString String path);
  public native @ByVal RandomAccessFileFuture OpenInputFileAsync(
        @StdString BytePointer path);
  /** EXPERIMENTAL: async version of OpenInputFile */
  
  ///
  public native @ByVal RandomAccessFileFuture OpenInputFileAsync(
        @Const @ByRef FileInfo info);

  /** Open an output stream for sequential writing.
   * 
   *  If the target already exists, existing data is truncated. */
  public native @ByVal OutputStreamResult OpenOutputStream(
        @StdString String path,
        @SharedPtr @Cast({"const arrow::KeyValueMetadata*", "std::shared_ptr<const arrow::KeyValueMetadata>"}) KeyValueMetadata metadata);
  public native @ByVal OutputStreamResult OpenOutputStream(
        @StdString BytePointer path,
        @SharedPtr @Cast({"const arrow::KeyValueMetadata*", "std::shared_ptr<const arrow::KeyValueMetadata>"}) KeyValueMetadata metadata);
  
  ///
  public native @ByVal OutputStreamResult OpenOutputStream(@StdString String path);
  public native @ByVal OutputStreamResult OpenOutputStream(@StdString BytePointer path);

  /** Open an output stream for appending.
   * 
   *  If the target doesn't exist, a new empty file is created. */
  public native @ByVal OutputStreamResult OpenAppendStream(
        @StdString String path,
        @SharedPtr @Cast({"const arrow::KeyValueMetadata*", "std::shared_ptr<const arrow::KeyValueMetadata>"}) KeyValueMetadata metadata);
  public native @ByVal OutputStreamResult OpenAppendStream(
        @StdString BytePointer path,
        @SharedPtr @Cast({"const arrow::KeyValueMetadata*", "std::shared_ptr<const arrow::KeyValueMetadata>"}) KeyValueMetadata metadata);
  public native @ByVal OutputStreamResult OpenAppendStream(@StdString String path);
  public native @ByVal OutputStreamResult OpenAppendStream(@StdString BytePointer path);
}
