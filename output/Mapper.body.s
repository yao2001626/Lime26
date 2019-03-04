	.section	__TEXT,__text,regular,pure_instructions
	.macosx_version_min 10, 12
	.globl	_Mapper_map             ## -- Begin function Mapper_map
_Mapper_map:                            ## @Mapper_map
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
	movl	%edi, 28(%rsi)
	movl	$1, 24(%rsi)
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_Mapper_doMap           ## -- Begin function Mapper_doMap
_Mapper_doMap:                          ## @Mapper_doMap
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
	pushq	%rbx
	pushq	%rax
Lcfi6:
	.cfi_offset %rbx, -24
	movq	%rdi, %rbx
	movl	28(%rbx), %edi
	imull	%edi, %edi
	movq	16(%rbx), %rsi
	testb	$1, 32(%rbx)
	jne	LBB1_2
## BB#1:
	xorl	%eax, %eax
	callq	_Reducer_reduce1
	jmp	LBB1_3
LBB1_2:
	xorl	%eax, %eax
	callq	_Reducer_reduce2
LBB1_3:
	movl	$1, 24(%rbx)
	addq	$8, %rsp
	popq	%rbx
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function

.subsections_via_symbols
