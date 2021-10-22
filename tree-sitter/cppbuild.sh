#!/bin/bash
# This file is meant to be included by the parent cppbuild.sh script
if [[ -z "$PLATFORM" ]]; then
    pushd ..
    bash cppbuild.sh "$@" zlib
    popd
    exit
fi

TREE_SITTER_VERSION=0.20.0
TREE_SITTER_CPP_VERSION=0.19.0
download https://github.com/tree-sitter/tree-sitter/archive/refs/tags/v$TREE_SITTER_VERSION.tar.gz tree-sitter-$TREE_SITTER_VERSION.tar.gz
download https://github.com/tree-sitter/tree-sitter-cpp/archive/refs/tags/v$TREE_SITTER_CPP_VERSION.tar.gz tree-sitter-cpp-$TREE_SITTER_CPP_VERSION.tar.gz

mkdir -p $PLATFORM
cd $PLATFORM
INSTALL_PATH=`pwd`
tar -xzvf ../tree-sitter-$TREE_SITTER_VERSION.tar.gz
tar -xzvf ../tree-sitter-cpp-$TREE_SITTER_CPP_VERSION.tar.gz
cd tree-sitter-$TREE_SITTER_VERSION

case $PLATFORM in
    linux-x86_64)
        export PREFIX=..
        export CC="gcc -m64 -fPIC"
        make -j $MAKEJ
        make install
        cd ../tree-sitter-cpp-0.19.0/src
        export PREFIX=$INSTALL_PATH
        export SONAME_MAJOR=0
        export SONAME_MINOR=0
        export SOEXT=so
	    export SOEXTVER_MAJOR=so.$SONAME_MAJOR
	    export SOEXTVER=so.$SONAME_MAJOR.$SONAME_MINOR
        export LIBDIR=$PREFIX/lib
        clang++ $CFLAGS $LDFLAGS -I. scanner.cc parser.c -dynamiclib -Wl,-soname,$LIBDIR/libtree-sitter-cpp.so.$SONAME_MAJOR -o libtree-sitter-cpp.$SOEXTVER
        cp libtree-sitter-cpp.$SOEXTVER $LIBDIR
        cd $LIBDIR
        ln -sf libtree-sitter-cpp.$SOEXTVER libtree-sitter-cpp.$SOEXT
	    ln -sf libtree-sitter-cpp.$SOEXTVER libtree-sitter-cpp.$SOEXTVER_MAJOR
        cp ../../../cpp.h ../include/tree_sitter
        ;;
    macosx-*)
        export PREFIX=$INSTALL_PATH
        export CFLAGS="-arch arm64 -arch x86_64"
        export LDFLAGS="-arch arm64 -arch x86_64 -Wl,-rpath,@loader_path/"
        make -j $MAKEJ
        make install
        cd ../tree-sitter-cpp-0.19.0/src
        export PREFIX=$INSTALL_PATH
        export SONAME_MAJOR=0
        export SONAME_MINOR=0
        export SOEXT=dylib
	    export SOEXTVER_MAJOR=$SONAME_MAJOR.dylib
	    export SOEXTVER=$SONAME_MAJOR.$SONAME_MINOR.dylib
        export LIBDIR=$PREFIX/lib
        clang++ $CFLAGS $LDFLAGS -I. scanner.cc parser.c -dynamiclib -Wl,-install_name,$LIBDIR/libtree-sitter-cpp.$SONAME_MAJOR.dylib -o libtree-sitter-cpp.$SOEXTVER
        cp libtree-sitter-cpp.$SOEXTVER $LIBDIR
        cd $LIBDIR
        ln -sf libtree-sitter-cpp.$SOEXTVER libtree-sitter-cpp.$SOEXT
	    ln -sf libtree-sitter-cpp.$SOEXTVER libtree-sitter-cpp.$SOEXTVER_MAJOR
        cp ../../../cpp.h ../include/tree_sitter
        ;;
    *)
        echo "Error: Platform \"$PLATFORM\" is not supported"
        ;;
esac

cd ../..
