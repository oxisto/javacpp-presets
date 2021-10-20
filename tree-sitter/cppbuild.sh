#!/bin/bash
# This file is meant to be included by the parent cppbuild.sh script
if [[ -z "$PLATFORM" ]]; then
    pushd ..
    bash cppbuild.sh "$@" zlib
    popd
    exit
fi

TREE_SITTER_VERSION=0.20.0
download https://github.com/tree-sitter/tree-sitter/archive/refs/tags/v$TREE_SITTER_VERSION.tar.gz tree-sitter-$TREE_SITTER_VERSION.tar.gz
mkdir -p $PLATFORM
cd $PLATFORM
tar -xzvf ../tree-sitter-$TREE_SITTER_VERSION.tar.gz
cd tree-sitter-$TREE_SITTER_VERSION

case $PLATFORM in
    linux-x86_64)
        export PREFIX=..
        export CC="gcc -m64 -fPIC"
        make -j $MAKEJ
        make install
        ;;
    macosx-arm64)
        export PREFIX=..
        export CFLAGS="-arch arm64"
        export LDFLAGS="-arch arm64"
        make -j $MAKEJ
        make install
        ;;
    macosx-x86_64)
        export PREFIX=..
        export CFLAGS="-arch x86_64"
        export LDFLAGS="-arch x86_64"
        make -j $MAKEJ
        make install
        ;;
    *)
        echo "Error: Platform \"$PLATFORM\" is not supported"
        ;;
esac

cd ../..
