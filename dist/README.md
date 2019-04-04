# Lime Compiler Version 0.0.1

## To build the `limec`:
	run `bash build.sh` (it need sudo password to add 'limec' to /usr/bin)

## Usage of `limec`:

```
usage: limec [-h] [-d INPUT_DIR] [-o OUTPUT] [-L CLANG_OPTIONS]
             [-l LLC_OPTIONS] [-S]
             input

Lime compiler version 0.0.1. Antlr4 && LLVM: For X86 (Shucai
yaos4@mcmaster.ca)

positional arguments:
  input                 The input lime source file

optional arguments:
  -h, --help            show this help message and exit
  -d INPUT_DIR, --input-dir INPUT_DIR
                        input folder which contains lime source code
  -o OUTPUT, --output OUTPUT
                        the output file name
  -L CLANG_OPTIONS, --clang-options CLANG_OPTIONS
                        Compile options for clang: default: -S -emit-llvm
                        -fomit-frame-pointer
  -l LLC_OPTIONS, --llc-options LLC_OPTIONS
                        Compile options for llc: default: -O0 -march=x86
                        -x86-asm-syntax=intel
  -S, --no-silence      Display the commands executed

```

