	.section	__TEXT,__text,regular,pure_instructions
	.macosx_version_min 10, 12
	.globl	_PQ_empty               ## -- Begin function PQ_empty
_PQ_empty:                              ## @PQ_empty
	.cfi_startproc
## BB#0:
	movl	4(%esp), %ecx
	xorl	%eax, %eax
	cmpl	$0, 24(%ecx)
	sete	%al
	retl
	.cfi_endproc
                                        ## -- End function
	.globl	_PQ_add                 ## -- Begin function PQ_add
_PQ_add:                                ## @PQ_add
	.cfi_startproc
## BB#0:
	pushl	%esi
Lcfi0:
	.cfi_def_cfa_offset 8
	subl	$8, %esp
Lcfi1:
	.cfi_def_cfa_offset 16
Lcfi2:
	.cfi_offset %esi, -8
	movl	20(%esp), %esi
	movl	16(%esp), %eax
	cmpl	$0, 24(%esi)
	movl	%eax, 20(%esi)
	je	LBB1_1
## BB#2:
	movl	$1, 28(%esi)
	jmp	LBB1_3
LBB1_1:
	calll	_PQ_init
	movl	%eax, 24(%esi)
LBB1_3:
	addl	$8, %esp
	popl	%esi
	retl
	.cfi_endproc
                                        ## -- End function
	.globl	_PQ_remove              ## -- Begin function PQ_remove
_PQ_remove:                             ## @PQ_remove
	.cfi_startproc
## BB#0:
	movl	4(%esp), %eax
	movl	$1, 32(%eax)
	movl	16(%eax), %eax
	retl
	.cfi_endproc
                                        ## -- End function
	.globl	_PQ_doAdd               ## -- Begin function PQ_doAdd
_PQ_doAdd:                              ## @PQ_doAdd
	.cfi_startproc
## BB#0:
	pushl	%edi
Lcfi3:
	.cfi_def_cfa_offset 8
	pushl	%esi
Lcfi4:
	.cfi_def_cfa_offset 12
	pushl	%eax
Lcfi5:
	.cfi_def_cfa_offset 16
Lcfi6:
	.cfi_offset %esi, -12
Lcfi7:
	.cfi_offset %edi, -8
	movl	16(%esp), %esi
	movl	16(%esi), %eax
	movl	20(%esi), %ecx
	cmpl	%ecx, %eax
	movl	24(%esi), %edi
	movl	24(%edi), %edx
	jge	LBB3_4
## BB#1:
	testl	%edx, %edx
	movl	%ecx, 20(%edi)
	je	LBB3_2
## BB#3:
	movl	$1, 28(%edi)
	jmp	LBB3_8
LBB3_4:
	testl	%edx, %edx
	movl	%eax, 20(%edi)
	je	LBB3_5
## BB#6:
	movl	$1, 28(%edi)
	jmp	LBB3_7
LBB3_2:
	calll	_PQ_init
	movl	%eax, 24(%edi)
	jmp	LBB3_8
LBB3_5:
	calll	_PQ_init
	movl	%eax, 24(%edi)
LBB3_7:
	movl	20(%esi), %eax
	movl	%eax, 16(%esi)
LBB3_8:
	movl	$0, 28(%esi)
	addl	$4, %esp
	popl	%esi
	popl	%edi
	retl
	.cfi_endproc
                                        ## -- End function
	.globl	_PQ_doRemove            ## -- Begin function PQ_doRemove
_PQ_doRemove:                           ## @PQ_doRemove
	.cfi_startproc
## BB#0:
	movl	4(%esp), %eax
	movl	24(%eax), %ecx
	cmpl	$0, 24(%ecx)
	je	LBB4_1
## BB#2:
	movl	$0, 16(%eax)
	jmp	LBB4_3
LBB4_1:
	movl	$0, 24(%eax)
LBB4_3:
	movl	$0, 32(%eax)
	retl
	.cfi_endproc
                                        ## -- End function

.subsections_via_symbols
