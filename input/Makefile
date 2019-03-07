
all: PQ LOT MR


PQ: PQ.lime
	java -jar Lime4-compiler.jar -stg ../lime.stg PQ.lime
	clang -S -emit-llvm -fomit-frame-pointer -o PQ.ll PQ.c
	llc -O0 -march=x86 -x86-asm-syntax=intel -o PQ.body.s PQ.ll
	python3 Merge.py PQ

LOT: LOT.lime  
	java -jar Lime4-compiler.jar -stg ../lime.stg LOT.lime
	clang -S -emit-llvm -fomit-frame-pointer -o Node.ll Node.c
	llc -O0 -march=x86 -x86-asm-syntax=intel -o Node.body.s Node.ll
	python3 Merge.py LOT

MR: MR.lime 
	java -jar Lime4-compiler.jar -stg ../lime.stg MR.lime 
	clang -S -emit-llvm -fomit-frame-pointer -o Mapper.ll Mapper.c
	llc -O0 -march=x86 -x86-asm-syntax=intel -o Mapper.body.s Mapper.ll
	clang -S -emit-llvm -fomit-frame-pointer -o Reducer.ll Reducer.c
	llc -O0 -march=x86 -x86-asm-syntax=intel -o Reducer.body.s Reducer.ll
	python3 Merge.py MR

.PHONY: clean

clean:
	rm -f *.ll *.s *.c *.json