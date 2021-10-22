package org.bytedeco.treesitter.presets;

import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;
import org.bytedeco.javacpp.tools.*;

@Properties(value = { @Platform(value = { "linux", "macosx" }, 
include = { "<tree_sitter/parser.h>", "<tree_sitter/api.h>", "<tree_sitter/cpp.h>" }, link = {"tree-sitter", "tree-sitter-cpp"}
), }, target = "org.bytedeco.treesitter", global = "org.bytedeco.treesitter.global.treesitter")
public class treesitter implements InfoMapper {
    static {
        Loader.checkVersion("org.bytedeco", "treesitter");
    }

    public void map(InfoMap infoMap) {
        infoMap.put(new Info("TSSymbol").cppTypes("uint16_t"));
    }
}
