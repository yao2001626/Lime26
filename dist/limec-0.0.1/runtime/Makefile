CC = gcc
AS = nasm
targets = main.o atomic_instr.o local_queue.o global_queue.o scheduler.o switch_to.o alpha.o 
CFLAGS = -m32 -lpthread -fomit-frame-pointer

all: ../Lime_Runtime_LockFree.a

../Lime_Runtime_LockFree.a: $(targets)
	ar -rcs --target=elf32-i386 $@ $^

.c.o:
	gcc $(CFLAGS) -c $< -o $@ 
	
.s.o:
	nasm -f elf32 $< -o $@
	
clean:
	rm -rf *.o
