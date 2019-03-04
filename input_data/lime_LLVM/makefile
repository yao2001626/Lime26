CLANG=clang
LLC=/usr/local/bin/llc
SRCS=$(wildcard *.c)
LLS=$(SRCS:.c=.ll)
OBJS=$(SRCS:.c=.s)

all: $(OBJS)
%.s :%.ll
	$(LLC)  -O3 $< -march=x86 -o $@
%.ll : %.c
	$(CLANG) -Os -S -fomit-frame-pointer -emit-llvm -c $< 

.PHONY: clean
clean:
	rm -f *.ll *.s
