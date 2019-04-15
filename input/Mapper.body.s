	.section	__TEXT,__text,regular,pure_instructions
	.macosx_version_min 10, 12
	.intel_syntax noprefix
	.globl	_Mapper_map             ## -- Begin function Mapper_map
	.p2align	4, 0x90
_Mapper_map:                            ## @Mapper_map
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
	mov	dword ptr [esi + 24], ecx
	mov	ecx, dword ptr [esp + 8]
	mov	dword ptr [ecx + 20], 1
	mov	dword ptr [esp + 4], eax ## 4-byte Spill
	mov	dword ptr [esp], edx    ## 4-byte Spill
	add	esp, 16
	pop	esi
	ret
	.cfi_endproc
                                        ## -- End function
	.globl	_Mapper_doMap           ## -- Begin function Mapper_doMap
	.p2align	4, 0x90
_Mapper_doMap:                          ## @Mapper_doMap
	.cfi_startproc
## BB#0:
	push	esi
Lcfi3:
	.cfi_def_cfa_offset 8
	sub	esp, 40
Lcfi4:
	.cfi_def_cfa_offset 48
Lcfi5:
	.cfi_offset esi, -8
	mov	eax, dword ptr [esp + 52]
	mov	ecx, dword ptr [esp + 48]
	mov	edx, 2
	mov	dword ptr [esp + 32], eax
	mov	eax, dword ptr [esp + 48]
	mov	eax, dword ptr [eax + 28]
	mov	dword ptr [esp + 28], edx ## 4-byte Spill
	cdq
	mov	esi, dword ptr [esp + 28] ## 4-byte Reload
	idiv	esi
	cmp	edx, 0
	mov	dword ptr [esp + 24], ecx ## 4-byte Spill
	jne	LBB1_2
## BB#1:
	mov	eax, dword ptr [esp + 48]
	mov	eax, dword ptr [eax + 24]
	mov	ecx, dword ptr [esp + 48]
	imul	eax, dword ptr [ecx + 24]
	mov	ecx, dword ptr [esp + 48]
	mov	ecx, dword ptr [ecx + 16]
	mov	edx, dword ptr [esp + 32]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	mov	dword ptr [esp + 8], edx
	call	_Reducer_reduce1
	jmp	LBB1_3
LBB1_2:
	mov	eax, dword ptr [esp + 48]
	mov	eax, dword ptr [eax + 24]
	mov	ecx, dword ptr [esp + 48]
	imul	eax, dword ptr [ecx + 24]
	mov	ecx, dword ptr [esp + 48]
	mov	ecx, dword ptr [ecx + 16]
	mov	edx, dword ptr [esp + 32]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	mov	dword ptr [esp + 8], edx
	call	_Reducer_reduce2
LBB1_3:
	mov	eax, dword ptr [esp + 48]
	mov	dword ptr [eax + 20], 0
	add	esp, 40
	pop	esi
	ret
	.cfi_endproc
                                        ## -- End function

.subsections_via_symbols
