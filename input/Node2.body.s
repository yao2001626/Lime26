	.section	__TEXT,__text,regular,pure_instructions
	.macosx_version_min 10, 12
	.intel_syntax noprefix
	.globl	_Node2_add              ## -- Begin function Node2_add
	.p2align	4, 0x90
_Node2_add:                             ## @Node2_add
	.cfi_startproc
## BB#0:
	sub	esp, 28
Lcfi0:
	.cfi_def_cfa_offset 32
	mov	eax, dword ptr [esp + 36]
	mov	ecx, dword ptr [esp + 32]
	mov	dword ptr [esp + 24], eax
	mov	eax, dword ptr [esp + 24]
	cmp	dword ptr [eax + 24], 0
	mov	dword ptr [esp + 20], ecx ## 4-byte Spill
	je	LBB0_5
## BB#1:
	mov	eax, dword ptr [esp + 24]
	mov	dword ptr [eax + 32], 1
	mov	eax, dword ptr [esp + 32]
	mov	ecx, dword ptr [esp + 24]
	mov	dword ptr [ecx + 20], eax
	mov	eax, dword ptr [esp + 24]
	mov	eax, dword ptr [eax + 20]
	mov	ecx, dword ptr [esp + 24]
	cmp	eax, dword ptr [ecx + 16]
	jg	LBB0_3
## BB#2:
	mov	eax, dword ptr [esp + 24]
	mov	eax, dword ptr [eax + 20]
	mov	ecx, dword ptr [esp + 24]
	mov	ecx, dword ptr [ecx + 24]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	_Node2_add
	jmp	LBB0_4
LBB0_3:
	mov	eax, dword ptr [esp + 24]
	mov	eax, dword ptr [eax + 20]
	mov	ecx, dword ptr [esp + 24]
	mov	ecx, dword ptr [ecx + 28]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	_Node2_add
LBB0_4:
	mov	eax, dword ptr [esp + 24]
	mov	dword ptr [eax + 32], 0
	jmp	LBB0_11
LBB0_5:
	mov	eax, dword ptr [esp + 32]
	mov	ecx, dword ptr [esp + 24]
	cmp	eax, dword ptr [ecx + 16]
	jge	LBB0_7
## BB#6:
	mov	eax, dword ptr [esp + 32]
	mov	ecx, esp
	mov	dword ptr [ecx], eax
	call	_Node2_init
	mov	ecx, dword ptr [esp + 24]
	mov	dword ptr [ecx + 24], eax
	mov	eax, dword ptr [esp + 24]
	mov	eax, dword ptr [eax + 16]
	mov	ecx, esp
	mov	dword ptr [ecx], eax
	call	_Node2_init
	mov	ecx, dword ptr [esp + 24]
	mov	dword ptr [ecx + 28], eax
	mov	eax, dword ptr [esp + 32]
	mov	ecx, dword ptr [esp + 24]
	mov	dword ptr [ecx + 16], eax
	jmp	LBB0_10
LBB0_7:
	mov	eax, dword ptr [esp + 32]
	mov	ecx, dword ptr [esp + 24]
	cmp	eax, dword ptr [ecx + 16]
	jle	LBB0_9
## BB#8:
	mov	eax, dword ptr [esp + 24]
	mov	eax, dword ptr [eax + 16]
	mov	ecx, esp
	mov	dword ptr [ecx], eax
	call	_Node2_init
	mov	ecx, dword ptr [esp + 24]
	mov	dword ptr [ecx + 24], eax
	mov	eax, dword ptr [esp + 32]
	mov	ecx, esp
	mov	dword ptr [ecx], eax
	call	_Node2_init
	mov	ecx, dword ptr [esp + 24]
	mov	dword ptr [ecx + 28], eax
LBB0_9:
	jmp	LBB0_10
LBB0_10:
	jmp	LBB0_11
LBB0_11:
	add	esp, 28
	ret
	.cfi_endproc
                                        ## -- End function
	.globl	_Node2_has              ## -- Begin function Node2_has
	.p2align	4, 0x90
_Node2_has:                             ## @Node2_has
	.cfi_startproc
## BB#0:
	sub	esp, 28
Lcfi1:
	.cfi_def_cfa_offset 32
	mov	eax, dword ptr [esp + 36]
	mov	ecx, dword ptr [esp + 32]
	mov	dword ptr [esp + 16], eax
	mov	eax, dword ptr [esp + 16]
	cmp	dword ptr [eax + 24], 0
	mov	dword ptr [esp + 12], ecx ## 4-byte Spill
	jne	LBB1_2
## BB#1:
	mov	eax, dword ptr [esp + 32]
	mov	ecx, dword ptr [esp + 16]
	cmp	eax, dword ptr [ecx + 16]
	sete	dl
	and	dl, 1
	movzx	eax, dl
	mov	dword ptr [esp + 24], eax
	jmp	LBB1_5
LBB1_2:
	mov	eax, dword ptr [esp + 32]
	mov	ecx, dword ptr [esp + 16]
	cmp	eax, dword ptr [ecx + 16]
	jg	LBB1_4
## BB#3:
	mov	eax, dword ptr [esp + 32]
	mov	ecx, dword ptr [esp + 16]
	mov	ecx, dword ptr [ecx + 24]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	_Node2_has
	mov	dword ptr [esp + 24], eax
	jmp	LBB1_5
LBB1_4:
	mov	eax, dword ptr [esp + 32]
	mov	ecx, dword ptr [esp + 16]
	mov	ecx, dword ptr [ecx + 28]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	_Node2_has
	mov	dword ptr [esp + 24], eax
LBB1_5:
	mov	eax, dword ptr [esp + 24]
	add	esp, 28
	ret
	.cfi_endproc
                                        ## -- End function

.subsections_via_symbols
