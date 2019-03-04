	.section	__TEXT,__text,regular,pure_instructions
	.macosx_version_min 10, 12
	.globl	_Reducer_reduce1        ## -- Begin function Reducer_reduce1
_Reducer_reduce1:                       ## @Reducer_reduce1
	.cfi_startproc
## BB#0:
	pushq	%rbp
Lcfi0:
	.cfi_def_cfa_offset 16
Lcfi1:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Lcfi2:
	.cfi_def_cfa_register %rbp
	movl	%edi, 40(%rsi)
	movl	$1, 32(%rsi)
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_Reducer_reduce2        ## -- Begin function Reducer_reduce2
_Reducer_reduce2:                       ## @Reducer_reduce2
	.cfi_startproc
## BB#0:
	pushq	%rbp
Lcfi3:
	.cfi_def_cfa_offset 16
Lcfi4:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Lcfi5:
	.cfi_def_cfa_register %rbp
	movl	%edi, 44(%rsi)
	movl	$1, 36(%rsi)
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_Reducer_doReduce       ## -- Begin function Reducer_doReduce
_Reducer_doReduce:                      ## @Reducer_doReduce
	.cfi_startproc
## BB#0:
	pushq	%rbp
Lcfi6:
	.cfi_def_cfa_offset 16
Lcfi7:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Lcfi8:
	.cfi_def_cfa_register %rbp
	movl	44(%rdi), %eax
	addl	40(%rdi), %eax
	movq	24(%rdi), %rcx
	testb	$1, 16(%rdi)
	jne	LBB2_2
## BB#1:
	movl	%eax, 40(%rcx)
	movl	$1, 32(%rcx)
	jmp	LBB2_3
LBB2_2:
	movl	%eax, 44(%rcx)
	movl	$1, 36(%rcx)
LBB2_3:
	movq	$0, 32(%rdi)
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function

.subsections_via_symbols
