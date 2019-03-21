	.section	__TEXT,__text,regular,pure_instructions
	.macosx_version_min 10, 12
	.intel_syntax noprefix
	.globl	_PQ_empty               ## -- Begin function PQ_empty
	.p2align	4, 0x90
_PQ_empty:                              ## @PQ_empty
	.cfi_startproc
## BB#0:
	push	eax
Lcfi0:
	.cfi_def_cfa_offset 8
	mov	eax, dword ptr [esp + 8]
	mov	ecx, dword ptr [esp + 8]
	cmp	dword ptr [ecx + 24], 0
	sete	dl
	and	dl, 1
	movzx	ecx, dl
	mov	dword ptr [esp], eax    ## 4-byte Spill
	mov	eax, ecx
	pop	ecx
	ret
	.cfi_endproc
                                        ## -- End function
	.globl	_PQ_add                 ## -- Begin function PQ_add
	.p2align	4, 0x90
_PQ_add:                                ## @PQ_add
	.cfi_startproc
## BB#0:
	sub	esp, 12
Lcfi1:
	.cfi_def_cfa_offset 16
	mov	eax, dword ptr [esp + 20]
	mov	ecx, dword ptr [esp + 16]
	mov	dword ptr [esp + 8], eax
	mov	eax, dword ptr [esp + 8]
	cmp	dword ptr [eax + 24], 0
	mov	dword ptr [esp + 4], ecx ## 4-byte Spill
	jne	LBB1_2
## BB#1:
	mov	eax, dword ptr [esp + 16]
	mov	ecx, dword ptr [esp + 8]
	mov	dword ptr [ecx + 16], eax
	call	_PQ_init
	mov	ecx, dword ptr [esp + 8]
	mov	dword ptr [ecx + 24], eax
	jmp	LBB1_3
LBB1_2:
	mov	eax, dword ptr [esp + 16]
	mov	ecx, dword ptr [esp + 8]
	mov	dword ptr [ecx + 20], eax
	mov	eax, dword ptr [esp + 8]
	mov	dword ptr [eax + 28], 1
LBB1_3:
	add	esp, 12
	ret
	.cfi_endproc
                                        ## -- End function
	.globl	_PQ_remove              ## -- Begin function PQ_remove
	.p2align	4, 0x90
_PQ_remove:                             ## @PQ_remove
	.cfi_startproc
## BB#0:
	push	eax
Lcfi2:
	.cfi_def_cfa_offset 8
	mov	eax, dword ptr [esp + 8]
	mov	ecx, dword ptr [esp + 8]
	mov	dword ptr [ecx + 32], 1
	mov	ecx, dword ptr [esp + 8]
	mov	ecx, dword ptr [ecx + 16]
	mov	dword ptr [esp], eax    ## 4-byte Spill
	mov	eax, ecx
	pop	ecx
	ret
	.cfi_endproc
                                        ## -- End function
	.globl	_PQ_doAdd               ## -- Begin function PQ_doAdd
	.p2align	4, 0x90
_PQ_doAdd:                              ## @PQ_doAdd
	.cfi_startproc
## BB#0:
	sub	esp, 12
Lcfi3:
	.cfi_def_cfa_offset 16
	mov	eax, dword ptr [esp + 16]
	mov	ecx, dword ptr [esp + 16]
	mov	ecx, dword ptr [ecx + 16]
	mov	edx, dword ptr [esp + 16]
	cmp	ecx, dword ptr [edx + 20]
	mov	dword ptr [esp + 8], eax ## 4-byte Spill
	jge	LBB3_2
## BB#1:
	mov	eax, dword ptr [esp + 16]
	mov	eax, dword ptr [eax + 20]
	mov	ecx, dword ptr [esp + 16]
	mov	ecx, dword ptr [ecx + 24]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	_PQ_add
	jmp	LBB3_3
LBB3_2:
	mov	eax, dword ptr [esp + 16]
	mov	eax, dword ptr [eax + 16]
	mov	ecx, dword ptr [esp + 16]
	mov	ecx, dword ptr [ecx + 24]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	_PQ_add
	mov	eax, dword ptr [esp + 16]
	mov	eax, dword ptr [eax + 20]
	mov	ecx, dword ptr [esp + 16]
	mov	dword ptr [ecx + 16], eax
LBB3_3:
	mov	eax, dword ptr [esp + 16]
	mov	dword ptr [eax + 28], 0
	add	esp, 12
	ret
	.cfi_endproc
                                        ## -- End function
	.globl	_PQ_doRemove            ## -- Begin function PQ_doRemove
	.p2align	4, 0x90
_PQ_doRemove:                           ## @PQ_doRemove
	.cfi_startproc
## BB#0:
	sub	esp, 12
Lcfi4:
	.cfi_def_cfa_offset 16
	mov	eax, dword ptr [esp + 16]
	mov	ecx, dword ptr [esp + 16]
	mov	ecx, dword ptr [ecx + 24]
	mov	dword ptr [esp], ecx
	mov	dword ptr [esp + 8], eax ## 4-byte Spill
	call	_PQ_empty
	cmp	eax, 0
	je	LBB4_2
## BB#1:
	mov	eax, dword ptr [esp + 16]
	mov	dword ptr [eax + 24], 0
	jmp	LBB4_3
LBB4_2:
	mov	eax, dword ptr [esp + 16]
	mov	eax, dword ptr [eax + 24]
	mov	dword ptr [esp], eax
	call	_PQ_remove
	mov	ecx, dword ptr [esp + 16]
	mov	dword ptr [ecx + 16], eax
LBB4_3:
	mov	eax, dword ptr [esp + 16]
	mov	dword ptr [eax + 32], 0
	add	esp, 12
	ret
	.cfi_endproc
                                        ## -- End function

.subsections_via_symbols
