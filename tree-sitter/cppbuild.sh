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
        clang++ -I. scanner.cc parser.c -shared -Wl -o tree-sitter-cpp.so
        cp tree-sitter-cpp.dylib ../../lib
        cp ../../../../cpp.h ../../include/tree_sitter
        ;;
    macosx-arm64)
        export PREFIX=..
        export CFLAGS="-arch arm64 -DU_CPLUSPLUS_VERSION=17"
        export LDFLAGS="-arch arm64"
        make -j $MAKEJ
        make install
        cd ../tree-sitter-cpp-0.19.0/src
        clang++ -I. scanner.cc parser.c -dynamiclib -Wl -o tree-sitter-cpp.dylib
        cp tree-sitter-cpp.dylib ../../lib
        cp ../../../../cpp.h ../../include/tree_sitter
        ;;
    macosx-x86_64)
        export CC="clang++"
        export PREFIX=..
        export CFLAGS="-arch x86_64 -DU_CPLUSPLUS_VERSION=17"
        export LDFLAGS="-arch x86_64"
        make -j $MAKEJ
        make install
        cd ../tree-sitter-cpp-0.19.0/src
        clang++ -I. scanner.cc parser.c -dynamiclib -Wl -o tree-sitter-cpp.dylib
        cp tree-sitter-cpp.dylib ../../lib
        cp ../../../../cpp.h ../../include/tree_sitter
        ;;
    *)
        echo "Error: Platform \"$PLATFORM\" is not supported"
        ;;
esac

cd ../..
