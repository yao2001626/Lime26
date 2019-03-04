	.section	__TEXT,__text,regular,pure_instructions
	.macosx_version_min 10, 12
	.globl	_Reducer_reduce1        ## -- Begin function Reducer_reduce1
_Reducer_reduce1:                       ## @Reducer_reduce1
	.cfi_startproc
## BB#0:
	movl	4(%esp), %eax
	movl	8(%esp), %ecx
	movl	%eax, 32(%ecx)
	movl	$1, 24(%ecx)
	retl
	.cfi_endproc
                                        ## -- End function
	.globl	_Reducer_reduce2        ## -- Begin function Reducer_reduce2
_Reducer_reduce2:                       ## @Reducer_reduce2
	.cfi_startproc
## BB#0:
	movl	4(%esp), %eax
	movl	8(%esp), %ecx
	movl	%eax, 36(%ecx)
	movl	$1, 28(%ecx)
	retl
	.cfi_endproc
                                        ## -- End function
	.globl	_Reducer_doReduce       ## -- Begin function Reducer_doReduce
_Reducer_doReduce:                      ## @Reducer_doReduce
	.cfi_startproc
## BB#0:
	movl	4(%esp), %eax
	movl	20(%eax), %ecx
	movl	36(%eax), %edx
	addl	32(%eax), %edx
	testb	$1, 16(%eax)
	jne	LBB2_2
## BB#1:
	movl	%edx, 32(%ecx)
	movl	$1, 24(%ecx)
	jmp	LBB2_3
LBB2_2:
	movl	%edx, 36(%ecx)
	movl	$1, 28(%ecx)
LBB2_3:
	xorl	%ecx, %ecx
	movl	%ecx, 24(%eax)
	movl	%ecx, 28(%eax)
	retl
	.cfi_endproc
                                        ## -- End function
	.globl	_Mapper_map             ## -- Begin function Mapper_map
_Mapper_map:                            ## @Mapper_map
	.cfi_startproc
## BB#0:
	movl	4(%esp), %eax
	movl	8(%esp), %ecx
	movl	%eax, 24(%ecx)
	movl	$1, 20(%ecx)
	retl
	.cfi_endproc
                                        ## -- End function
	.globl	_Mapper_doMap           ## -- Begin function Mapper_doMap
_Mapper_doMap:                          ## @Mapper_doMap
	.cfi_startproc
## BB#0:
	movl	4(%esp), %eax
	movl	16(%eax), %ecx
	movl	24(%eax), %edx
	imull	%edx, %edx
	testb	$1, 28(%eax)
	jne	LBB4_2
## BB#1:
	movl	%edx, 32(%ecx)
	movl	$1, 24(%ecx)
	jmp	LBB4_3
LBB4_2:
	movl	%edx, 36(%ecx)
	movl	$1, 28(%ecx)
LBB4_3:
	movl	$1, 20(%eax)
	retl
	.cfi_endproc
                                        ## -- End function

.subsections_via_symbols
