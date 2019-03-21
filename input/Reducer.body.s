	.section	__TEXT,__text,regular,pure_instructions
	.macosx_version_min 10, 12
	.intel_syntax noprefix
	.globl	_Reducer_reduce1        ## -- Begin function Reducer_reduce1
	.p2align	4, 0x90
_Reducer_reduce1:                       ## @Reducer_reduce1
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
	mov	dword ptr [edx + 32], eax
	mov	eax, dword ptr [esp + 8]
	mov	dword ptr [eax + 24], 1
	mov	dword ptr [esp + 4], ecx ## 4-byte Spill
	add	esp, 12
	ret
	.cfi_endproc
                                        ## -- End function
	.globl	_Reducer_reduce2        ## -- Begin function Reducer_reduce2
	.p2align	4, 0x90
_Reducer_reduce2:                       ## @Reducer_reduce2
	.cfi_startproc
## BB#0:
	sub	esp, 12
Lcfi1:
	.cfi_def_cfa_offset 16
	mov	eax, dword ptr [esp + 20]
	mov	ecx, dword ptr [esp + 16]
	mov	dword ptr [esp + 8], eax
	mov	eax, dword ptr [esp + 16]
	mov	edx, dword ptr [esp + 8]
	mov	dword ptr [edx + 36], eax
	mov	eax, dword ptr [esp + 8]
	mov	dword ptr [eax + 28], 1
	mov	dword ptr [esp + 4], ecx ## 4-byte Spill
	add	esp, 12
	ret
	.cfi_endproc
                                        ## -- End function
	.globl	_Reducer_doReduce       ## -- Begin function Reducer_doReduce
	.p2align	4, 0x90
_Reducer_doReduce:                      ## @Reducer_doReduce
	.cfi_startproc
## BB#0:
	sub	esp, 12
Lcfi2:
	.cfi_def_cfa_offset 16
	mov	eax, dword ptr [esp + 16]
	mov	ecx, 2
	mov	edx, dword ptr [esp + 16]
	mov	edx, dword ptr [edx + 16]
	mov	dword ptr [esp + 8], eax ## 4-byte Spill
	mov	eax, edx
	cdq
	idiv	ecx
	cmp	edx, 0
	jne	LBB2_2
## BB#1:
	mov	eax, dword ptr [esp + 16]
	mov	eax, dword ptr [eax + 32]
	mov	ecx, dword ptr [esp + 16]
	add	eax, dword ptr [ecx + 36]
	mov	ecx, dword ptr [esp + 16]
	mov	ecx, dword ptr [ecx + 20]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	_Reducer_reduce1
	jmp	LBB2_3
LBB2_2:
	mov	eax, dword ptr [esp + 16]
	mov	eax, dword ptr [eax + 32]
	mov	ecx, dword ptr [esp + 16]
	add	eax, dword ptr [ecx + 36]
	mov	ecx, dword ptr [esp + 16]
	mov	ecx, dword ptr [ecx + 20]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	_Reducer_reduce2
LBB2_3:
	mov	eax, dword ptr [esp + 16]
	mov	dword ptr [eax + 24], 0
	mov	eax, dword ptr [esp + 16]
	mov	dword ptr [eax + 28], 0
	add	esp, 12
	ret
	.cfi_endproc
                                        ## -- End function

.subsections_via_symbols
