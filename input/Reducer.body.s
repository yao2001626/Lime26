	.section	__TEXT,__text,regular,pure_instructions
	.macosx_version_min 10, 12
	.intel_syntax noprefix
	.globl	_Reducer_reduce1        ## -- Begin function Reducer_reduce1
	.p2align	4, 0x90
_Reducer_reduce1:                       ## @Reducer_reduce1
	.cfi_startproc
## BB#0:
	push	esi
Lcfi0:
	.cfi_def_cfa_offset 8
	sub	esp, 16
Lcfi1:
	.cfi_def_cfa_offset 24
Lcfi2:
	.cfi_offset esi, -8
	mov	eax, dword ptr [esp + 32]
	mov	ecx, dword ptr [esp + 28]
	mov	edx, dword ptr [esp + 24]
	mov	dword ptr [esp + 8], ecx
	mov	ecx, dword ptr [esp + 24]
	mov	esi, dword ptr [esp + 8]
	mov	dword ptr [esi + 32], ecx
	mov	ecx, dword ptr [esp + 8]
	mov	dword ptr [ecx + 24], 1
	mov	dword ptr [esp + 4], eax ## 4-byte Spill
	mov	dword ptr [esp], edx    ## 4-byte Spill
	add	esp, 16
	pop	esi
	ret
	.cfi_endproc
                                        ## -- End function
	.globl	_Reducer_reduce2        ## -- Begin function Reducer_reduce2
	.p2align	4, 0x90
_Reducer_reduce2:                       ## @Reducer_reduce2
	.cfi_startproc
## BB#0:
	push	esi
Lcfi3:
	.cfi_def_cfa_offset 8
	sub	esp, 16
Lcfi4:
	.cfi_def_cfa_offset 24
Lcfi5:
	.cfi_offset esi, -8
	mov	eax, dword ptr [esp + 32]
	mov	ecx, dword ptr [esp + 28]
	mov	edx, dword ptr [esp + 24]
	mov	dword ptr [esp + 8], ecx
	mov	ecx, dword ptr [esp + 24]
	mov	esi, dword ptr [esp + 8]
	mov	dword ptr [esi + 36], ecx
	mov	ecx, dword ptr [esp + 8]
	mov	dword ptr [ecx + 28], 1
	mov	dword ptr [esp + 4], eax ## 4-byte Spill
	mov	dword ptr [esp], edx    ## 4-byte Spill
	add	esp, 16
	pop	esi
	ret
	.cfi_endproc
                                        ## -- End function
	.globl	_Reducer_doReduce       ## -- Begin function Reducer_doReduce
	.p2align	4, 0x90
_Reducer_doReduce:                      ## @Reducer_doReduce
	.cfi_startproc
## BB#0:
	sub	esp, 28
Lcfi6:
	.cfi_def_cfa_offset 32
	mov	eax, dword ptr [esp + 36]
	mov	ecx, dword ptr [esp + 32]
	mov	dword ptr [esp + 24], eax
	mov	eax, dword ptr [esp + 32]
	cmp	dword ptr [eax + 16], 1
	mov	dword ptr [esp + 20], ecx ## 4-byte Spill
	jne	LBB2_2
## BB#1:
	mov	eax, dword ptr [esp + 32]
	mov	eax, dword ptr [eax + 32]
	mov	ecx, dword ptr [esp + 32]
	add	eax, dword ptr [ecx + 36]
	mov	dword ptr [esp], eax
	call	_print
	mov	eax, dword ptr [esp + 32]
	mov	dword ptr [eax + 32], 0
	mov	eax, dword ptr [esp + 32]
	mov	dword ptr [eax + 36], 0
	jmp	LBB2_6
LBB2_2:
	mov	eax, 2
	mov	ecx, dword ptr [esp + 32]
	mov	ecx, dword ptr [ecx + 16]
	mov	dword ptr [esp + 16], eax ## 4-byte Spill
	mov	eax, ecx
	cdq
	mov	ecx, dword ptr [esp + 16] ## 4-byte Reload
	idiv	ecx
	cmp	edx, 0
	jne	LBB2_4
## BB#3:
	mov	eax, dword ptr [esp + 32]
	mov	eax, dword ptr [eax + 32]
	mov	ecx, dword ptr [esp + 32]
	add	eax, dword ptr [ecx + 36]
	mov	ecx, dword ptr [esp + 32]
	mov	ecx, dword ptr [ecx + 20]
	mov	edx, dword ptr [esp + 24]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	mov	dword ptr [esp + 8], edx
	call	_Reducer_reduce1
	jmp	LBB2_5
LBB2_4:
	mov	eax, dword ptr [esp + 32]
	mov	eax, dword ptr [eax + 32]
	mov	ecx, dword ptr [esp + 32]
	add	eax, dword ptr [ecx + 36]
	mov	ecx, dword ptr [esp + 32]
	mov	ecx, dword ptr [ecx + 20]
	mov	edx, dword ptr [esp + 24]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	mov	dword ptr [esp + 8], edx
	call	_Reducer_reduce2
LBB2_5:
	jmp	LBB2_6
LBB2_6:
	mov	eax, dword ptr [esp + 32]
	mov	dword ptr [eax + 24], 0
	mov	eax, dword ptr [esp + 32]
	mov	dword ptr [eax + 28], 0
	add	esp, 28
	ret
	.cfi_endproc
                                        ## -- End function

.subsections_via_symbols
