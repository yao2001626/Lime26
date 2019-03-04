	.section	__TEXT,__text,regular,pure_instructions
	.macosx_version_min 10, 12
	.globl	_Node_add               ## -- Begin function Node_add
_Node_add:                              ## @Node_add
	.cfi_startproc
## BB#0:
	pushl	%edi
Lcfi0:
	.cfi_def_cfa_offset 8
	pushl	%esi
Lcfi1:
	.cfi_def_cfa_offset 12
	pushl	%eax
Lcfi2:
	.cfi_def_cfa_offset 16
Lcfi3:
	.cfi_offset %esi, -12
Lcfi4:
	.cfi_offset %edi, -8
	movl	20(%esp), %esi
	movl	16(%esp), %edi
	cmpl	$0, 24(%esi)
	je	LBB0_1
## BB#2:
	movl	16(%esi), %eax
	cmpl	%edi, %eax
	jle	LBB0_4
## BB#3:
	movl	%edi, (%esp)
	calll	_Node_init
	movl	%eax, 24(%esi)
	movl	16(%esi), %eax
	movl	%eax, (%esp)
	calll	_Node_init
	movl	%eax, 28(%esi)
	movl	%edi, 16(%esi)
	jmp	LBB0_6
LBB0_1:
	movl	$1, 32(%esi)
	movl	%edi, 20(%esi)
	jmp	LBB0_6
LBB0_4:
	jge	LBB0_6
## BB#5:
	movl	%eax, (%esp)
	calll	_Node_init
	movl	%eax, 24(%esi)
	movl	%edi, (%esp)
	calll	_Node_init
	movl	%eax, 28(%esi)
LBB0_6:
	addl	$4, %esp
	popl	%esi
	popl	%edi
	retl
	.cfi_endproc
                                        ## -- End function
	.globl	_Node_has               ## -- Begin function Node_has
_Node_has:                              ## @Node_has
	.cfi_startproc
## BB#0:
	pushl	%esi
Lcfi5:
	.cfi_def_cfa_offset 8
Lcfi6:
	.cfi_offset %esi, -8
	movl	12(%esp), %eax
	movl	8(%esp), %ecx
	jmp	LBB1_1
LBB1_2:                                 ##   in Loop: Header=BB1_1 Depth=1
	cmpl	%ecx, %edx
	jge	LBB1_4
## BB#3:                                ##   in Loop: Header=BB1_1 Depth=1
	movl	28(%eax), %esi
LBB1_4:                                 ##   in Loop: Header=BB1_1 Depth=1
	movl	%esi, %eax
LBB1_1:                                 ## =>This Inner Loop Header: Depth=1
	movl	16(%eax), %edx
	movl	24(%eax), %esi
	testl	%esi, %esi
	jne	LBB1_2
## BB#5:
	xorl	%eax, %eax
	cmpl	%ecx, %edx
	sete	%al
	popl	%esi
	retl
	.cfi_endproc
                                        ## -- End function
	.globl	_Node_addToChild        ## -- Begin function Node_addToChild
_Node_addToChild:                       ## @Node_addToChild
	.cfi_startproc
## BB#0:
	pushl	%esi
Lcfi7:
	.cfi_def_cfa_offset 8
	subl	$8, %esp
Lcfi8:
	.cfi_def_cfa_offset 16
Lcfi9:
	.cfi_offset %esi, -8
	movl	16(%esp), %esi
	movl	20(%esi), %eax
	cmpl	16(%esi), %eax
	jle	LBB2_1
## BB#2:
	movl	28(%esi), %ecx
	jmp	LBB2_3
LBB2_1:
	movl	24(%esi), %ecx
LBB2_3:
	movl	%ecx, 4(%esp)
	movl	%eax, (%esp)
	calll	_Node_add
	movl	$0, 32(%esi)
	addl	$8, %esp
	popl	%esi
	retl
	.cfi_endproc
                                        ## -- End function

.subsections_via_symbols
