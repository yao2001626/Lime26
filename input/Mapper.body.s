	.section	__TEXT,__text,regular,pure_instructions
	.macosx_version_min 10, 12
	.intel_syntax noprefix
	.globl	_Mapper_map             ## -- Begin function Mapper_map
	.p2align	4, 0x90
_Mapper_map:                            ## @Mapper_map
	.cfi_startproc
## BB#0:
	sub	esp, 12
Lcfi0:
	.cfi_def_cfa_offset 16
	mov	eax, dword ptr [esp + 20]
	mov	ecx, dword ptr [esp + 16]
	mov	dword ptr [esp + 8], eax
	mov	eax, dword ptr [esp + 16]
	mov	edx, dword ptr [esp + 8]
	mov	dword ptr [edx + 24], eax
	mov	eax, dword ptr [esp + 8]
	mov	dword ptr [eax + 20], 1
	mov	dword ptr [esp + 4], ecx ## 4-byte Spill
	add	esp, 12
	ret
	.cfi_endproc
                                        ## -- End function
	.globl	_Mapper_doMap           ## -- Begin function Mapper_doMap
	.p2align	4, 0x90
_Mapper_doMap:                          ## @Mapper_doMap
	.cfi_startproc
## BB#0:
	sub	esp, 28
Lcfi1:
	.cfi_def_cfa_offset 32
	mov	eax, dword ptr [esp + 32]
	mov	ecx, 2
	mov	edx, dword ptr [esp + 32]
	mov	edx, dword ptr [edx + 28]
	mov	dword ptr [esp + 24], eax ## 4-byte Spill
	mov	eax, edx
	cdq
	idiv	ecx
	cmp	edx, 0
	jne	LBB1_2
## BB#1:
	mov	eax, dword ptr [esp + 32]
	mov	eax, dword ptr [eax + 24]
	mov	ecx, dword ptr [esp + 32]
	imul	eax, dword ptr [ecx + 24]
	mov	ecx, dword ptr [esp + 32]
	mov	ecx, dword ptr [ecx + 16]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	_Reducer_reduce1
	mov	dword ptr [esp + 20], eax ## 4-byte Spill
	jmp	LBB1_3
LBB1_2:
	mov	eax, dword ptr [esp + 32]
	mov	eax, dword ptr [eax + 24]
	mov	ecx, dword ptr [esp + 32]
	imul	eax, dword ptr [ecx + 24]
	mov	ecx, dword ptr [esp + 32]
	mov	ecx, dword ptr [ecx + 16]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	_Reducer_reduce2
	mov	dword ptr [esp + 16], eax ## 4-byte Spill
LBB1_3:
	mov	eax, dword ptr [esp + 32]
	mov	dword ptr [eax + 20], 0
	add	esp, 28
	ret
	.cfi_endproc
                                        ## -- End function

.subsections_via_symbols
