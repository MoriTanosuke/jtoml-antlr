#!/bin/sh
java -jar antlr-4.0-complete.jar -o src/main/java/de/kopis/jtoml/antlr/impl -package de.kopis.jtoml.antlr.impl src/main/resources/Toml.g4
